package school.libenhe.hotel.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import school.libenhe.hotel.dao.IFoodDao;
import school.libenhe.hotel.entity.Food;
import school.libenhe.hotel.utils.Condition;
import school.libenhe.hotel.utils.JdbcUtils;
import school.libenhe.hotel.utils.PageBean;

/**
 * 菜接口实现类
 * 
 * @author Li Benhe Email: libenhe919@gmail.com
 * @version 2016-3-2 下午12:52:14
 */
public class FoodDao implements IFoodDao {

	private QueryRunner qr = JdbcUtils.getQueryRunner();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * school.libenhe.hotel.dao.IFoodDao#add(school.libenhe.hotel.entity.Food)
	 */
	@Override
	public void add(Food food) {

		String sql = " INSERT food(foodName,foodType_id,price,mprice,remark,img) VALUES(?,?,?,?,?,?);";
		try {
			qr.update(sql, food.getFoodName(), food.getFoodType_id(),
					food.getPrice(), food.getMprice(), food.getRemark(),
					food.getImg());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see school.libenhe.hotel.dao.IFoodDao#delete(int)
	 */
	@Override
	public void delete(int id) {

		String sql = "DELETE FROM food WHERE id=?";
		try {
			qr.update(sql, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * school.libenhe.hotel.dao.IFoodDao#updata(school.libenhe.hotel.entity.
	 * Food)
	 */
	@Override
	public void updata(Food food) {

		String sql = "UPDATE food SET foodName=?,foodType_id=?,price=?,mprice=?,remark=?,img=? WHERE id =?";
		try {
			qr.update(sql, food.getFoodName(), food.getFoodType_id(),
					food.getPrice(), food.getMprice(), food.getRemark(),
					food.getImg(), food.getId());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see school.libenhe.hotel.dao.IFoodDao#query()
	 */
	@Override
	public List<Food> query() {

		String sql = "SELECT * FROM food";
		try {
			return qr.query(sql, new BeanListHandler<Food>(Food.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see school.libenhe.hotel.dao.IFoodDao#findById(int)
	 */
	@Override
	public Food findById(int id) {

		String sql = "SELECT * FROM food where id =?";
		try {
			return qr.query(sql, new BeanHandler<Food>(Food.class), id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see school.libenhe.hotel.dao.IFoodDao#query(java.lang.String)
	 */
	@Override
	public List<Food> query(String keyword) {

		String sql = "SELECT * FROM food WHERE foodName LIKE ?";
		try {
			return qr.query(sql, new BeanListHandler<Food>(Food.class), "%"
					+ keyword + "%");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see school.libenhe.hotel.dao.IFoodDao#findByType(int)
	 */
	@Override
	public List<Food> findByType(int type) {

		try {
			String sql = "SELECT * FROM food WHERE foodType_id =?";
			return qr.query(sql, new BeanListHandler<Food>(Food.class), type);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * school.libenhe.hotel.dao.IFoodDao#getAll(school.libenhe.hotel.utils.PageBean
	 * )
	 */
	@Override
	public void getAll(PageBean<Food> pb) {

		int totalCount = this.getTotalCount(pb);
		pb.setTotalCount(totalCount);

		List<Object> list = new ArrayList<Object>();

		if (pb.getCurrentPage() <= 0) {
			pb.setCurrentPage(1); // 把当前页设置为1
		} else if (pb.getCurrentPage() > pb.getTotalPage()) {
			pb.setCurrentPage(pb.getTotalPage()); // 把当前页设置为最大页数
		}

		// 获取当前页： 计算查询的起始行、返回的行数
		int currentPage = pb.getCurrentPage();
		int index = (currentPage - 1) * pb.getPageCount(); // 查询的起始行
		int count = pb.getPageCount(); // 查询返回的行数

		Condition condition = pb.getCondition();

		// 分页查询数据; 把查询到的数据设置到pb对象中
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT");
		sb.append("     	f.id,");
		sb.append("     	f.foodName,");
		sb.append("     	f.foodType_id,");
		sb.append("     	f.price,");
		sb.append("     	f.mprice,");
		sb.append("     	f.remark,");
		sb.append("     	f.img,");
		sb.append("     	ft.typeName");
		sb.append(" FROM ");
		sb.append("     	food f,");
		sb.append("     	foodtype ft");
		sb.append(" WHERE 	1=1 ");
		sb.append("     	AND f.foodType_id=ft.id");

		// 判断
		if (condition != null) {
			String foodName = condition.getFoodName();
			if (foodName != null && !foodName.isEmpty()) {
				sb.append("  AND f.foodName LIKE ? ");
				list.add("%" + foodName + "%");
			}

			int type_id = condition.getFoodType_id();
			if (type_id > 0) {
				sb.append(" AND f.foodType_id=? ");
				list.add(type_id);
			}
		}
		sb.append(" limit ?,? ");
		list.add(index);
		list.add(count);
		try {
			// 根据当前页，查询当前页数据(一页数据)
			if (index >= 0) {
				List<Food> pageData = qr.query(sb.toString(),
						new BeanListHandler<Food>(Food.class), list.toArray());
				// 设置到pb对象中
				pb.setPageData(pageData);
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * school.libenhe.hotel.dao.IFoodDao#getTotalCount(school.libenhe.hotel.
	 * utils.PageBean)
	 */
	@Override
	public int getTotalCount(PageBean<Food> pb) {
		StringBuilder sb = new StringBuilder();
		List<Object> list = new ArrayList<Object>();
		sb.append(" SELECT");
		sb.append("   count(*) ");
		sb.append(" FROM ");
		sb.append("     	food f,");
		sb.append("     	foodtype ft");
		sb.append(" WHERE 	1=1 ");
		sb.append("     	AND f.foodType_id=ft.id");

		Condition condition = pb.getCondition();
		// 判断
		if (condition != null) {
			String foodName = condition.getFoodName();
			if (foodName != null && !foodName.isEmpty()) {
				sb.append("  AND f.foodName LIKE ? ");
				list.add("%" + foodName + "%");
			}

			int type_id = condition.getFoodType_id();
			if (type_id > 0) {
				sb.append(" AND f.foodType_id=? ");
				list.add(type_id);
			}
		}
		try {
			// 执行查询， 返回结果的第一行的第一列
			Long count = qr.query(sb.toString(), new ScalarHandler<Long>(),
					list.toArray());
			return count.intValue();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}