package school.libenhe.hotel.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import school.libenhe.hotel.dao.IOrdersDao;
import school.libenhe.hotel.entity.Orders;
import school.libenhe.hotel.utils.JdbcUtils;
import school.libenhe.hotel.utils.PageBean;

/**
 * IOrdersDao接口实现类
 * 
 * @author Li Benhe Email: libenhe919@gmail.com
 * @version 2016-3-4 下午10:47:40
 */
public class OrdersDao implements IOrdersDao{

	QueryRunner qr = JdbcUtils.getQueryRunner();
	/* (non-Javadoc)
	 * @see school.libenhe.hotel.dao.IOrdersDao#add(school.libenhe.hotel.entity.Orders)
	 */
	@Override
	public void add(Orders orders) {
	
		String sql =" INSERT orders(table_id,orderDate,totalPrice) VALUES(?,?,?)";
		try {
			qr.update(sql,orders.getTable_id(),orders.getOrderDate(),orders.getTotalPrice());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	/* (non-Javadoc)
	 * @see school.libenhe.hotel.dao.IOrdersDao#update(school.libenhe.hotel.entity.Orders)
	 */
	@Override
	public void update(Orders orders) {
		
		String sql = "UPDATE orders SET orderStatus =? WHERE id=?";
		try {
			qr.update(sql,orders.getOrderStatus(),orders.getId());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	/* (non-Javadoc)
	 * @see school.libenhe.hotel.dao.IOrdersDao#query()
	 */
	@Override
	public List<Orders> query() {
	
		String sql = "SELECT * FROM orders";
		try {
			return qr.query(sql, new BeanListHandler<Orders>(Orders.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/* (non-Javadoc)
	 * @see school.libenhe.hotel.dao.IOrdersDao#getCount()
	 */
	@Override
	public int getCount() {
		
		String sql ="select count(*) from orders";
		try {
			Long count = qr.query(sql, new ScalarHandler<Long>());
			return count.intValue();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/* (non-Javadoc)
	 * @see school.libenhe.hotel.dao.IOrdersDao#getTotalCount()
	 */
	@Override
	public int getTotalCount() {

		String sql ="select count(*) from orders";
		try {
			Long count = qr.query(sql, new ScalarHandler<Long>());
			return count.intValue();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/* (non-Javadoc)
	 * @see school.libenhe.hotel.dao.IOrdersDao#getAll(school.libenhe.hotel.utils.PageBean)
	 */
	@Override
	public void getAll(PageBean<Orders> pb) {
		//总记录数到pb中
		int totalCount = this.getTotalCount();
		pb.setTotalCount(totalCount);
		
		/**
		 * 如果当前页 <= 0;       当前页设置当前页为1;
		 * 如果当前页 > 最大页数；  当前页设置为最大页数;
		 */
		
		if (pb.getCurrentPage() <= 0) {
			pb.setCurrentPage(1);
		} else if (pb.getCurrentPage() > pb.getTotalPage()) {
			pb.setCurrentPage(pb.getTotalPage());
		}
	}
	

}
