package school.libenhe.hotel.service;

import java.util.List;

import school.libenhe.hotel.entity.Food;
import school.libenhe.hotel.utils.PageBean;

/**
 * 菜Service接口
 * 
 * @author Li Benhe Email: libenhe919@gmail.com
 * @version 2016-3-7 下午5:30:17
 */
public interface IFoodService {

	/**
	 * 增加
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-7 下午5:43:18 
	 * @param food
	 */
	void add(Food food);
	
	/**
	 * 删除
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-7 下午5:42:57 
	 * @param id
	 */
	void delete(int id);
	
	/**
	 * 更新
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-7 下午5:43:28 
	 * @param food
	 */
	void updata(Food food);
	
	/**
	 * 查询所有
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-7 下午5:43:37 
	 * @return
	 */
	List<Food> query();

	/**
	 * 根据id查询
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-7 下午5:43:57 
	 * @param id
	 * @return
	 */
	Food findById(int id);

	/**
	 * 搜索
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-7 下午5:44:09 
	 * @param keyword
	 * @return
	 */
	List<Food> query(String keyword);
	
	/**
	 * 分页查询
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-7 下午5:45:09 
	 * @param pb
	 */
	public void getAll(PageBean<Food> pb);
	
	/**
	 * 根据种类查询
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-7 下午5:44:35 
	 * @param type
	 * @return
	 */
	List<Food> findByType(int type);
	
}
