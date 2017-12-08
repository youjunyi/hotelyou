package school.libenhe.hotel.servlet;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import school.libenhe.hotel.entity.Sysuser;
import school.libenhe.hotel.entity.User;
import school.libenhe.hotel.factory.BeanFactory;
import school.libenhe.hotel.service.ISysuserStrvice;
import school.libenhe.hotel.utils.PageBean;
import school.libenhe.hotel.utils.WebUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SysUserServlet extends HttpServlet {

    private ISysuserStrvice service = BeanFactory.getInstance("sysuserService",
            ISysuserStrvice.class);

    // ����·��
    private Object uri;
    @Override
    public void init(ServletConfig config) throws ServletException {

        super.init(config);
        PageBean<Sysuser> pageBean = new PageBean<Sysuser>();
        pageBean.setPageCount(6);
        service.getAll(pageBean);
        List<Sysuser> list = service.query();
        config.getServletContext().setAttribute("food", list);
        config.getServletContext().setAttribute("pb", pageBean);

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String method = request.getParameter("method");

        if ("add".equals(method)) {
            add(request, response);
        } else if ("list".equals(method)) {
            list(request, response);
        } else if ("update".equals(method)) {
            update(request, response);
        } else if ("delete".equals(method)) {
            delete(request, response);
        } else if ("search".equals(method)) {
            search(request, response);
        } else if ("showSysuser".equals(method)) {

            uri = request.getRequestDispatcher("/sys/sysuser/sysuserSave.jsp");
            WebUtils.goTo(request, response, uri);
        } else if ("show".equals(method)) {
            show(request, response);
        } else if ("getMenu".equals(method)) {
            //  getMenu(request, response);
        }

    }
    private void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setFileSizeMax(10 * 1024 * 1024); // �����ļ���С����
            upload.setSizeMax(50 * 1024 * 1024); // ���ļ���С����
            upload.setHeaderEncoding("UTF-8"); // �������ļ����봦��

            if (upload.isMultipartContent(request)) {

                Sysuser sysuser = new Sysuser();
                List<FileItem> list = upload.parseRequest(request);
                for (FileItem item : list) {

                    if (item.isFormField()) {// ��ͨ��������
                        String name = item.getFieldName();
                        // ��ȡֵ
                        String value = item.getString();
                        value = new String(value.getBytes("ISO-8859-1"),
                                "UTF-8");
                        BeanUtils.setProperty(sysuser, name, value);
                    }
                }
                service.updata(sysuser);

            } else {

            }
            list(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            uri = "/error/error.jsp";
            WebUtils.goTo(request, response, uri);
        }
    }

    private void show(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String id = request.getParameter("id");
            Sysuser sysuser = service.findById(Integer.parseInt(id));
            request.setAttribute("sysuser", sysuser);
            uri = request.getRequestDispatcher("/sys/user/sysuserUpdate.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            uri="/error/error.jsp";
        }finally {
            WebUtils.goTo(request, response, uri);
        }
    }
    
    private void search(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String keyword = request.getParameter("keyword");
            if (keyword != null) {
                List<Sysuser> list = service.query(keyword);
                request.setAttribute("list", list);
                uri = request.getRequestDispatcher("/sys/sysuser/sysuser.jsp");
            }
        } catch (Exception e) {
            uri = "/error/error.jsp";
            e.printStackTrace();
        }
        WebUtils.goTo(request, response, uri);
    }
    private void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String id = request.getParameter("id");
            service.delete(Integer.parseInt(id));
            list(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            uri = "/error/error.jsp";
            WebUtils.goTo(request, response, uri);
        }
    }
    private void list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // ��ȡ����ǰҳ�������� (��һ�η��ʵ�ǰҳΪnull)
            String currPage = request.getParameter("currentPage");
            // �ж�
            if (currPage == null || "".equals(currPage.trim())) {
                currPage = "1"; // ��һ�η��ʣ����õ�ǰҳΪ1;
            }
            // ת��
            int currentPage = Integer.parseInt(currPage);

            // ����PageBean�������õ�ǰҳ������ ����service��������
            PageBean<Sysuser> pageBean = new PageBean<Sysuser>();
            pageBean.setCurrentPage(currentPage);

            // ����service
            service.getAll(pageBean); // ��pageBean�Ѿ���dao��������ݡ�
            // ����pageBean���󣬵�request����

            List<Sysuser> list = pageBean.getPageData();

            request.setAttribute("pageBean", pageBean);
            request.setAttribute("list", list);
            uri = request.getRequestDispatcher("/sys/sysuser/sysuser.jsp");
        } catch (Exception e) {
            e.printStackTrace(); // ����ʹ��
            // ���ִ�����ת������ҳ��
            uri = "/error/error.jsp";
        }
        WebUtils.goTo(request, response, uri);

    }
    private void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setFileSizeMax(10 * 1024 * 1024); // �����ļ���С����
            upload.setSizeMax(50 * 1024 * 1024); // ���ļ���С����
            upload.setHeaderEncoding("UTF-8"); // �������ļ����봦��

            if (upload.isMultipartContent(request)) {

                Sysuser sysuser = new Sysuser();
                List<FileItem> list = upload.parseRequest(request);
                for (FileItem item : list) {

                    if (item.isFormField()) {// ��ͨ��������
                        String name = item.getFieldName();
                        // ��ȡֵ
                        String value = item.getString();
                        value = new String(value.getBytes("ISO-8859-1"),
                                "UTF-8");
                        BeanUtils.setProperty(sysuser, name, value);
                    }
                }
                service.add(sysuser);

            } else {

            }
            list(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            uri = "/error/error.jsp";
            WebUtils.goTo(request, response, uri);
        }
    }

    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        this.doGet(request, response);

    }
    
}
