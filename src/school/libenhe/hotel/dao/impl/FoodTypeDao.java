package school.libenhe.hotel.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import school.libenhe.hotel.dao.IFoodTypeDao;
import school.libenhe.hotel.entity.FoodType;
import school.libenhe.hotel.utils.JdbcUtils;

/**
 * IFoodTypeDao接口实现类
 * 
 * @author Li Benhe Email: libenhe919@gmail.com
 * @version 2016-3-2 下午7:25:19
 */
public class FoodTypeDao implements IFoodTypeDao{

	QueryRunner qr = JdbcUtils.getQueryRunner();
	/* (non-Javadoc)
	 * @see school.libenhe.hotel.dao.IFoodTypeDao#add(school.libenhe.hotel.entity.FoodType)
	 */
	@Override
	public void add(FoodType foodtype) {

		String sql ="INSERT INTO foodtype(typeName) VALUES(?);";
		try {
			qr.update(sql, foodtype.getTypeName());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/* (non-Javadoc)
	 * @see school.libenhe.hotel.dao.IFoodTypeDao#delete(int)
	 */
	@Override
	public void delete(int id) {

		String sql ="DELETE FROM foodtype WHERE id=?";
		try {
			qr.update(sql,id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/* (non-Javadoc)
	 * @see school.libenhe.hotel.dao.IFoodTypeDao#updata(school.libenhe.hotel.entity.FoodType)
	 */
	@Override
	public void updata(FoodType foodtype) {
	
		String sql ="UPDATE foodtype SET typeName=? WHERE id =?";
		try {
			qr.update(sql,foodtype.getTypeName(),foodtype.getId());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	/* (non-Javadoc)
	 * @see school.libenhe.hotel.dao.IFoodTypeDao#query()
	 */
	@Override
	public List<FoodType> query() {

		String sql ="SELECT * FROM foodtype";
		try {
			return  qr.query(sql,new BeanListHandler<FoodType>(FoodType.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/* (non-Javadoc)
	 * @see school.libenhe.hotel.dao.IFoodTypeDao#findById(int)
	 */
	@Override
	public FoodType findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see school.libenhe.hotel.dao.IFoodTypeDao#query(java.lang.String)
	 */
	@Override
	public List<FoodType> query(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see school.libenhe.hotel.dao.IFoodTypeDao#getFirstType()
	 */
	@Override
	public Integer getFirstType() {
		try {
			String sql = "select * from foodtype";
			return qr.query(sql, new ScalarHandler<Integer>());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
