package school.libenhe.hotel.service;

import java.util.List;

import school.libenhe.hotel.entity.Orders;
import school.libenhe.hotel.utils.PageBean;

/**
 * 订单Service接口
 * 
 * @author Li Benhe Email: libenhe919@gmail.com
 * @version 2016-3-7 下午5:32:12
 */
public interface IOrdersService {

	/**
	 * 更新
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-7 下午5:52:15 
	 * @param orders
	 */
	void update(Orders orders);

	/**
	 * 查询所有
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-7 下午5:52:18 
	 * @return
	 */
	List<Orders> query();

	/**
	 * 增加
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-7 下午5:52:22 
	 * @param orders
	 */
	void add(Orders orders);
	
	/**
	 * 订单记录数
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-7 下午5:52:26 
	 * @return
	 */
	int getCount();
	
	/**
	 *  获得所有(分页用)
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-7 下午5:52:29 
	 * @param pb
	 */
	public void getAll(PageBean<Orders> pb);
}
