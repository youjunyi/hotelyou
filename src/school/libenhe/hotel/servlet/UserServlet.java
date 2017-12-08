package school.libenhe.hotel.servlet;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import school.libenhe.hotel.entity.User;
import school.libenhe.hotel.factory.BeanFactory;
import school.libenhe.hotel.service.IUserService;
import school.libenhe.hotel.utils.PageBean;
import school.libenhe.hotel.utils.WebUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserServlet extends HttpServlet {
    // 创建service
    private IUserService service = BeanFactory.getInstance("userService",
            IUserService.class);

    // 声明路径
    private Object uri;
    @Override
    public void init(ServletConfig config) throws ServletException {

        super.init(config);
        PageBean<User> pageBean = new PageBean<User>();
        pageBean.setPageCount(6);
        service.getAll(pageBean);
        List<User> list = service.query();
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
        } else if ("showUser".equals(method)) {
            
            uri = request.getRequestDispatcher("/sys/user/userSave.jsp");
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
            upload.setFileSizeMax(10 * 1024 * 1024); // 单个文件大小限制
            upload.setSizeMax(50 * 1024 * 1024); // 总文件大小限制
            upload.setHeaderEncoding("UTF-8"); // 对中文文件编码处理

            if (upload.isMultipartContent(request)) {

                User user = new User();
                List<FileItem> list = upload.parseRequest(request);
                for (FileItem item : list) {

                    if (item.isFormField()) {// 普通本文内容
                        String name = item.getFieldName();
                        // 获取值
                        String value = item.getString();
                        value = new String(value.getBytes("ISO-8859-1"),
                                "UTF-8");
                        BeanUtils.setProperty(user, name, value);
                    } 
                }
                service.updata(user);

            } else {

            }
            list(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            uri = "/error/error.jsp";
            WebUtils.goTo(request, response, uri);
        }
    }






    private void search(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String keyword = request.getParameter("keyword");
            if (keyword != null) {
                List<User> list = service.query(keyword);
                request.setAttribute("list", list);
                uri = request.getRequestDispatcher("/sys/user/user.jsp");
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
    //在菜系更新中显示菜系对应的类型的名称
    private void show(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String id = request.getParameter("id");
            User user = service.findById(Integer.parseInt(id));
            request.setAttribute("user", user);
            uri = request.getRequestDispatcher("/sys/user/userUpdate.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            uri="/error/error.jsp";
        }finally {
            WebUtils.goTo(request, response, uri);
        }
    }
    private void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setFileSizeMax(10 * 1024 * 1024); // 单个文件大小限制
            upload.setSizeMax(50 * 1024 * 1024); // 总文件大小限制
            upload.setHeaderEncoding("UTF-8"); // 对中文文件编码处理

            if (upload.isMultipartContent(request)) {

                User user = new User();
                List<FileItem> list = upload.parseRequest(request);
                for (FileItem item : list) {

                    if (item.isFormField()) {// 普通本文内容
                        String name = item.getFieldName();
                        // 获取值
                        String value = item.getString();
                        value = new String(value.getBytes("ISO-8859-1"),
                                "UTF-8");
                        BeanUtils.setProperty(user, name, value);
                    }
                }
                service.add(user);

            } else {

            }
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
            // 获取“当前页”参数； (第一次访问当前页为null)
            String currPage = request.getParameter("currentPage");
            // 判断
            if (currPage == null || "".equals(currPage.trim())) {
                currPage = "1"; // 第一次访问，设置当前页为1;
            }
            // 转换
            int currentPage = Integer.parseInt(currPage);

            // 创建PageBean对象，设置当前页参数； 传入service方法参数
            PageBean<User> pageBean = new PageBean<User>();
            pageBean.setCurrentPage(currentPage);

            // 调用service
            service.getAll(pageBean); // 【pageBean已经被dao填充了数据】
            // 保存pageBean对象，到request域中

            List<User> list = pageBean.getPageData();

            request.setAttribute("pageBean", pageBean);
            request.setAttribute("list", list);
            uri = request.getRequestDispatcher("/sys/user/user.jsp");
        } catch (Exception e) {
            e.printStackTrace(); // 测试使用
            // 出现错误，跳转到错误页面
            uri = "/error/error.jsp";
        }
        WebUtils.goTo(request, response, uri);

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        this.doGet(request, response);

    }

}
