package school.libenhe.hotel.service.impl;

import java.util.List;

import school.libenhe.hotel.dao.IFoodTypeDao;
import school.libenhe.hotel.entity.FoodType;
import school.libenhe.hotel.factory.BeanFactory;
import school.libenhe.hotel.service.IFoodTypeService;

/**
 * IFoodTypeService接口实现类
 * 
 * @author Li Benhe Email: libenhe919@gmail.com
 * @version 2016-3-7 下午5:59:46
 */
public class FoodTypeService implements IFoodTypeService{

	IFoodTypeDao foodTypeDao = BeanFactory.getInstance("foodTypeDao", IFoodTypeDao.class);
	/* (non-Javadoc)
	 * @see school.libenhe.hotel.service.IFoodTypeService#add(school.libenhe.hotel.entity.FoodType)
	 */
	@Override
	public void add(FoodType foodtype) {

		foodTypeDao.add(foodtype);
	}

	/* (non-Javadoc)
	 * @see school.libenhe.hotel.service.IFoodTypeService#delete(int)
	 */
	@Override
	public void delete(int id) {

		foodTypeDao.delete(id);
	}

	/* (non-Javadoc)
	 * @see school.libenhe.hotel.service.IFoodTypeService#updata(school.libenhe.hotel.entity.FoodType)
	 */
	@Override
	public void updata(FoodType foodtype) {

		foodTypeDao.updata(foodtype);
	}

	/* (non-Javadoc)
	 * @see school.libenhe.hotel.service.IFoodTypeService#query()
	 */
	@Override
	public List<FoodType> query() {
		return foodTypeDao.query();
	}

	/* (non-Javadoc)
	 * @see school.libenhe.hotel.service.IFoodTypeService#findById(int)
	 */
	@Override
	public FoodType findById(int id) {
		return foodTypeDao.findById(id);
	}

	/* (non-Javadoc)
	 * @see school.libenhe.hotel.service.IFoodTypeService#query(java.lang.String)
	 */
	@Override
	public List<FoodType> query(String keyword) {
		return foodTypeDao.query(keyword);
	}

	/* (non-Javadoc)
	 * @see school.libenhe.hotel.service.IFoodTypeService#getFirstType()
	 */
	@Override
	public Integer getFirstType() {
		return foodTypeDao.getFirstType();
	}

}
