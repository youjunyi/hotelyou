package school.libenhe.hotel.dao;

import java.util.List;

import school.libenhe.hotel.entity.FoodType;

/**
 * 菜种类Dao接口
 * @author Li Benhe Email: libenhe919@gmail.com
 * @version 2016-3-1 下午2:42:57
 */
public interface IFoodTypeDao {


	/**
	 * 增加菜系
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-2 下午7:34:48 
	 * @param foodtype
	 */
	void add(FoodType foodtype);
	
	/**
	 * 删除菜系
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-2 下午7:35:12 
	 * @param id
	 */
	void delete(int id);
	
	/**
	 * 更新菜系
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-2 下午7:35:24 
	 * @param foodtype
	 */
	void updata(FoodType foodtype);
	
	/**
	 * 查询所有菜系
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-2 下午7:36:14 
	 * @return
	 */
	List<FoodType> query();

	/**
	 * 根据id查找
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-2 下午7:35:52 
	 * @param id
	 * @return
	 */
	FoodType findById(int id);

	/**
	 * 搜索菜系
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-2 下午7:36:38 
	 * @param keyword
	 * @return
	 */
	List<FoodType> query(String keyword);
	
	/**
	 * 获得菜系种类数
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-7 下午5:51:00 
	 * @return
	 */
	Integer getFirstType();
}
