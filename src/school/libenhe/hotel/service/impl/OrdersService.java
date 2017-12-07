package school.libenhe.hotel.service.impl;

import java.util.List;

import school.libenhe.hotel.dao.IOrdersDao;
import school.libenhe.hotel.entity.Orders;
import school.libenhe.hotel.factory.BeanFactory;
import school.libenhe.hotel.service.IOrdersService;
import school.libenhe.hotel.utils.PageBean;

/**
 * IOrdersService接口实现类
 * 
 * @author Li Benhe Email: libenhe919@gmail.com
 * @version 2016-3-7 下午6:01:01
 */
public class OrdersService implements IOrdersService {

	IOrdersDao ordersDao = BeanFactory.getInstance("ordersDao",
			IOrdersDao.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * school.libenhe.hotel.service.IOrdersService#update(school.libenhe.hotel
	 * .entity.Orders)
	 */
	@Override
	public void update(Orders orders) {

		ordersDao.update(orders);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see school.libenhe.hotel.service.IOrdersService#query()
	 */
	@Override
	public List<Orders> query() {
		return ordersDao.query();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * school.libenhe.hotel.service.IOrdersService#add(school.libenhe.hotel.
	 * entity.Orders)
	 */
	@Override
	public void add(Orders orders) {

		ordersDao.add(orders);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see school.libenhe.hotel.service.IOrdersService#getCount()
	 */
	@Override
	public int getCount() {
		return ordersDao.getCount();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * school.libenhe.hotel.service.IOrdersService#getAll(school.libenhe.hotel
	 * .utils.PageBean)
	 */
	@Override
	public void getAll(PageBean<Orders> pb) {

		ordersDao.getAll(pb);
	}

}
