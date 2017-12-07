package school.libenhe.hotel.dao;

import java.util.List;

import school.libenhe.hotel.entity.Food;
import school.libenhe.hotel.utils.PageBean;

/**
 * 菜Dao接口
 * 
 * @author Li Benhe Email: libenhe919@gmail.com
 * @version 2016-3-1 下午2:42:35
 */
public interface IFoodDao {

	/**
	 * 增加菜
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-2 下午12:52:35
	 * @param food
	 */
	void add(Food food);

	/**
	 * 删除菜
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-2 下午12:52:51
	 * @param id
	 */
	void delete(int id);

	/**
	 * 更新菜
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-2 下午12:53:02
	 * @param food
	 */
	void updata(Food food);

	/**
	 * 查询所有菜
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-2 下午12:53:22
	 * @return
	 */
	List<Food> query();

	/**
	 * 根据id查找菜
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-2 下午12:53:45
	 * @param id
	 * @return
	 */
	Food findById(int id);

	/**
	 * 搜索菜
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-2 下午12:54:15
	 * @param keyword
	 * @return
	 */
	List<Food> query(String keyword);

	/**
	 * 根据菜种类查找菜
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-2 下午12:54:25
	 * @param type
	 * @return
	 */
	List<Food> findByType(int type);

	/**
	 * 分页查询数据
	 */
	void getAll(PageBean<Food> pb);

	/**
	 * 查询总记录数
	 */
	int getTotalCount(PageBean<Food> pb);

}
