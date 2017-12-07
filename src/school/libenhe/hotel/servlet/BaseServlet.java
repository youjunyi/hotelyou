package school.libenhe.hotel.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import school.libenhe.hotel.factory.BeanFactory;
import school.libenhe.hotel.service.IDinnerTableService;
import school.libenhe.hotel.service.IFoodService;
import school.libenhe.hotel.service.IFoodTypeService;
import school.libenhe.hotel.service.IOrderDetailService;
import school.libenhe.hotel.service.IOrdersService;
import school.libenhe.hotel.utils.WebUtils;

/**
 * 通用的servlet，servlet继承此类
 * 
 * @author Li Benhe Email: libenhe919@gmail.com
 * @version 2016-3-8 下午7:35:33
 */
public abstract class BaseServlet extends HttpServlet {

	// 创建Service
	protected IDinnerTableService tableService = BeanFactory.getInstance(
			"dinnerTableService", IDinnerTableService.class);

	protected IFoodTypeService foodTypeService = BeanFactory.getInstance(
			"foodTypeService", IFoodTypeService.class);
	protected IFoodService foodService = BeanFactory.getInstance("foodService",
			IFoodService.class);
	protected IOrdersService ordersService = BeanFactory.getInstance(
			"ordersService", IOrdersService.class);
	protected IOrderDetailService orderDetailService = BeanFactory.getInstance(
			"orderDetailService", IOrderDetailService.class);

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 用于保存跳转资源
		Object returnValue = null;

		// 操作类型的值,对应servlet中的方法名称
		String methodName = request.getParameter("method");

		try {
			// 获取当前运行类的字节码
			Class clazz = this.getClass();

			// 获取当前执行的方法的Method类型
			Method method = clazz.getDeclaredMethod(methodName,
					HttpServletRequest.class, HttpServletResponse.class);

			// 执行
			returnValue = method.invoke(this, request, response);
		} catch (Exception e) {

			e.printStackTrace();
			// 跳转到错误页面
			returnValue = "/error/error.jsp";
		}

		// 跳转
		WebUtils.goTo(request, response, returnValue);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}
}
