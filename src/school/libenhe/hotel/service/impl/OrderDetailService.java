package school.libenhe.hotel.service.impl;

import java.util.List;

import school.libenhe.hotel.dao.IOrderDetailDao;
import school.libenhe.hotel.entity.OrderDetail;
import school.libenhe.hotel.factory.BeanFactory;
import school.libenhe.hotel.service.IOrderDetailService;

/**
 * IOrderDetailService接口实现类
 * 
 * @author Li Benhe Email: libenhe919@gmail.com
 * @version 2016-3-7 下午6:01:24
 */
public class OrderDetailService implements IOrderDetailService{

	IOrderDetailDao orderDetailDao = BeanFactory.getInstance("orderDetailDao", IOrderDetailDao.class);
	/* (non-Javadoc)
	 * @see school.libenhe.hotel.service.IOrderDetailService#add(school.libenhe.hotel.entity.OrderDetail)
	 */
	@Override
	public void add(OrderDetail od) {

		orderDetailDao.add(od);
	}

	/* (non-Javadoc)
	 * @see school.libenhe.hotel.service.IOrderDetailService#query()
	 */
	@Override
	public List<OrderDetail> query() {
		return orderDetailDao.query();
	}

	/* (non-Javadoc)
	 * @see school.libenhe.hotel.service.IOrderDetailService#findByOrderId(int)
	 */
	@Override
	public List<OrderDetail> findByOrderId(int id) {
		return orderDetailDao.findByOrderid(id);
	}

}
