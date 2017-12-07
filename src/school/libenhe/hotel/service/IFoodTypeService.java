package school.libenhe.hotel.service;

import java.util.List;

import school.libenhe.hotel.entity.FoodType;

/**
 * 菜种类Service接口
 * 
 * @author Li Benhe Email: libenhe919@gmail.com
 * @version 2016-3-7 下午5:30:39
 */
public interface IFoodTypeService {


	/**
	 * 增加
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-7 下午5:47:22 
	 * @param foodtype
	 */
	void add(FoodType foodtype);
	
	/**
	 * 删除
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-7 下午5:47:31 
	 * @param id
	 */
	void delete(int id);
	
	/**
	 * 更新
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-7 下午5:47:37 
	 * @param foodtype
	 */
	void updata(FoodType foodtype);
	
	/**
	 * 查询所有
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-7 下午5:47:47 
	 * @return
	 */
	List<FoodType> query();

	/**
	 * 根据id查询
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-7 下午5:48:02 
	 * @param id
	 * @return
	 */
	FoodType findById(int id);

	/**
	 * 搜索
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-7 下午5:48:12 
	 * @param keyword
	 * @return
	 */
	List<FoodType> query(String keyword);
	
	/**
	 * 获得菜种类个数
	 * 
	 * @author: Li Benhe Email: libenhe919@gmail.com
	 * @version: 2016-3-7 下午5:51:34 
	 * @return
	 */
	Integer getFirstType();
}
