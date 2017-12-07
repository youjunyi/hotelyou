package school.libenhe.hotel.servlet;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import school.libenhe.hotel.entity.Food;
import school.libenhe.hotel.entity.FoodType;
import school.libenhe.hotel.utils.Condition;
import school.libenhe.hotel.utils.PageBean;


/**
 * @author Li Benhe Email: libenhe919@gmail.com
 * @version 2016-3-8 下午6:50:37
 */
public class IndexServlet extends BaseServlet {

	public Object getMenu(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Object uri = null;
		HttpSession session = request.getSession();// 用于存储订单信息
		// 获取session里的值
		Object obj = session.getAttribute("table_id");

		String table_id = request.getParameter("table_id");// 桌的id
		if (table_id != null) {
			tableService.changeState(Integer.parseInt(table_id));
			if (obj == null) {
				session.setAttribute("table_id", table_id);// 存放桌id以备订单用
			}
		}

		// 查询菜系信息
		List<FoodType> foodtypes = foodTypeService.query();
		request.setAttribute("foodtypes", foodtypes);

		// 获取菜单页面信息
		PageBean<Food> pb = new PageBean<Food>();

		Condition con = new Condition();
		// 获取页面得到的参数
		String foodtype = request.getParameter("foodtype");
		String foodName = request.getParameter("foodName");
		if (foodtype != null && !foodtype.isEmpty()) {
			con.setFoodType_id(Integer.parseInt(foodtype));
			pb.setCondition(con);
		}
		if (foodName != null && !foodName.isEmpty()) {
			con.setFoodName(foodName);
			pb.setCondition(con);
		}

		pb.setPageCount(6);
		String curPage = request.getParameter("currentPage");// 获取当前页
		if (curPage == null || curPage.isEmpty()) {
			pb.setCurrentPage(1);
		}
		if (curPage != null && !curPage.isEmpty()) {
			int currentPage = Integer.parseInt(curPage);
			pb.setCurrentPage(currentPage);
		}

		foodService.getAll(pb);

		request.setAttribute("pageBean", pb);
		// 跳转
		uri = request.getRequestDispatcher("/app/detail/caidan.jsp");

		return uri;
	}

	public Object searchFood(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Object uri=null;
		
		PageBean<Food> pb = new PageBean<Food>();
		Condition condition = new Condition();
		
		String keyword = request.getParameter("keyword");//设置关键词
		if(keyword!=null && !keyword.isEmpty()){
			condition.setFoodName(keyword);
		}
		if(condition!=null){
			pb.setCondition(condition);
		}
		
		pb.setCondition(condition);
		
		foodService.getAll(pb);

		request.setAttribute("pageBean", pb);
		// 跳转
		uri = request.getRequestDispatcher("/app/detail/caidan.jsp");

		return uri;
	}

	
	public Object getFoodDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object uri =null;
		String id = request.getParameter("food");//获取食物id
		Food food = foodService.findById(Integer.parseInt(id));
		List<FoodType> foodtypes = foodTypeService.query();
		request.setAttribute("food", food);
		request.setAttribute("foodtypes", foodtypes);
		uri = request.getRequestDispatcher("/app/detail/caixiangxi.jsp");
		
		return uri;
	}

}
