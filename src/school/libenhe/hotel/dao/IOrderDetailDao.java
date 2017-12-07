package school.libenhe.hotel.dao;

import java.util.List;

import school.libenhe.hotel.entity.OrderDetail;

/**
 * 订单详情Dao接口
 * 
 * @author Li Benhe Email: libenhe919@gmail.com
 * @version 2016-3-1 下午2:43:17
 */
public interface IOrderDetailDao {

/**
 * 增加
 * 
 * @author: Li Benhe Email: libenhe919@gmail.com
 * @version: 2016-3-6 下午9:45:24 
 * @param od
 */
void add(OrderDetail od);
	
	/**
	 * 查询所有
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-6 下午9:45:29 
	 * @return
	 */
	List<OrderDetail> query();
	
	/**
	 * 根据id查询
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-6 下午9:45:36 
	 * @param id
	 * @return
	 */
	List<OrderDetail> findByOrderid(int id);
}
