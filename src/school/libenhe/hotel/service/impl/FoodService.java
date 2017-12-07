package school.libenhe.hotel.service.impl;

import java.util.List;

import school.libenhe.hotel.dao.IFoodDao;
import school.libenhe.hotel.entity.Food;
import school.libenhe.hotel.factory.BeanFactory;
import school.libenhe.hotel.service.IFoodService;
import school.libenhe.hotel.utils.PageBean;

/**
 * IFoodService接口实现类
 * 
 * @author Li Benhe Email: libenhe919@gmail.com
 * @version 2016-3-7 下午5:59:20
 */
public class FoodService implements IFoodService {

	IFoodDao foodDao = BeanFactory.getInstance("foodDao", IFoodDao.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * school.libenhe.hotel.service.IFoodService#add(school.libenhe.hotel.entity
	 * .Food)
	 */
	@Override
	public void add(Food food) {

		foodDao.add(food);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see school.libenhe.hotel.service.IFoodService#delete(int)
	 */
	@Override
	public void delete(int id) {

		foodDao.delete(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * school.libenhe.hotel.service.IFoodService#updata(school.libenhe.hotel
	 * .entity.Food)
	 */
	@Override
	public void updata(Food food) {

		foodDao.updata(food);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see school.libenhe.hotel.service.IFoodService#query()
	 */
	@Override
	public List<Food> query() {

		return foodDao.query();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see school.libenhe.hotel.service.IFoodService#findById(int)
	 */
	@Override
	public Food findById(int id) {
		return foodDao.findById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see school.libenhe.hotel.service.IFoodService#query(java.lang.String)
	 */
	@Override
	public List<Food> query(String keyword) {
		return foodDao.query(keyword);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * school.libenhe.hotel.service.IFoodService#getAll(school.libenhe.hotel
	 * .utils.PageBean)
	 */
	@Override
	public void getAll(PageBean<Food> pb) {

		foodDao.getAll(pb);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see school.libenhe.hotel.service.IFoodService#findByType(int)
	 */
	@Override
	public List<Food> findByType(int type) {
		return foodDao.findByType(type);
	}

}
