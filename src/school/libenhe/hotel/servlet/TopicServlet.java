package school.libenhe.hotel.servlet;

import school.libenhe.hotel.entity.Topic;
import school.libenhe.hotel.factory.BeanFactory;
import school.libenhe.hotel.service.ITopicService;
import school.libenhe.hotel.utils.PageBean;
import school.libenhe.hotel.utils.WebUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TopicServlet extends HttpServlet {
    private ITopicService service = BeanFactory.getInstance("topicService",
            ITopicService.class);

    // ÉùÃ÷Â·¾¶
    private Object uri;
    @Override
    public void init(ServletConfig config) throws ServletException {

        super.init(config);
        PageBean<Topic> pageBean = new PageBean<Topic>();
        pageBean.setPageCount(6);
        service.getAll(pageBean);
        List<Topic> list = service.query();
        config.getServletContext().setAttribute("food", list);
        config.getServletContext().setAttribute("pb", pageBean);

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String method = request.getParameter("method");

        if ("add".equals(method)) {
            //add(request, response);
        } else if ("list".equals(method)) {
            //list(request, response);
        } else if ("update".equals(method)) {
            // update(request, response);
        } else if ("delete".equals(method)) {
            //delete(request, response);
        } else if ("search".equals(method)) {
            //search(request, response);
        } else if ("showSysuser".equals(method)) {

            uri = request.getRequestDispatcher("/sys/sysuser/sysuserSave.jsp");
            WebUtils.goTo(request, response, uri);
        } else if ("show".equals(method)) {
           // show(request, response);
        } else if ("getMenu".equals(method)) {
            //  getMenu(request, response);
        }

    }
}
