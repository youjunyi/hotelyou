package school.libenhe.hotel.service;

import java.util.List;

import school.libenhe.hotel.entity.OrderDetail;

/**
 * 订单详情Service接口
 * 
 * @author Li Benhe Email: libenhe919@gmail.com
 * @version 2016-3-7 下午5:31:35
 */
public interface IOrderDetailService {

	/**
	 * 增加
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-7 下午5:55:38
	 * @param od
	 */
	void add(OrderDetail od);

	/**
	 * 查询所有
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-7 下午5:55:41
	 * @return
	 */
	List<OrderDetail> query();

	/**
	 * 根据id查询
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-7 下午5:55:47
	 * @param id
	 * @return
	 */
	List<OrderDetail> findByOrderId(int id);
}
