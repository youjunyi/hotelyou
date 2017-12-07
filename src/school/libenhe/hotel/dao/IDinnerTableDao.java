package school.libenhe.hotel.dao;

import java.util.List;

import school.libenhe.hotel.entity.DinnerTable;

/**
 * 餐桌Dao接口设计
 * 
 * @author Li Benhe Email: libenhe919@gmail.com
 * @version 2016-3-1 下午2:42:11
 */
public interface IDinnerTableDao {

	/**
	 * 增加餐桌
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-2 上午11:03:45
	 * @param dt
	 */
	void add(DinnerTable dt);

	/**
	 * 删除
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-2 上午11:04:58
	 * @param id
	 */
	void delete(int id);

	/**
	 * 更新
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-2 上午11:05:04
	 * @param dt
	 */
	void updata(DinnerTable dt);

	/**
	 * 查询所有餐桌
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-2 上午11:05:46
	 * @return
	 */
	List<DinnerTable> query();

	/**
	 * 根据id查询
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-2 上午11:05:50
	 * @param id
	 * @return
	 */
	DinnerTable findById(int id);

	/**
	 * 根据keyword搜索餐桌
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-2 上午11:05:53
	 * @param keyword
	 * @return
	 */
	List<DinnerTable> query(String keyword);

	/**
	 * 退桌
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-2 上午11:06:00
	 * @param id
	 */
	void quitTable(int id);
}
