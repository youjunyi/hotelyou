package school.libenhe.hotel.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import school.libenhe.hotel.dao.IDinnerTableDao;
import school.libenhe.hotel.entity.DinnerTable;
import school.libenhe.hotel.utils.JdbcUtils;

/**
 * IDinnerTableDao接口实现类
 * 
 * @author Li Benhe Email: libenhe919@gmail.com
 * @version 2016-3-2 上午10:57:47
 */
public class DinnerTableDao implements IDinnerTableDao {

	private QueryRunner qr = JdbcUtils.getQueryRunner();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * school.libenhe.hotel.dao.IDinnerTableDao#add(school.libenhe.hotel.entity
	 * .DinnerTable)
	 */
	@Override
	public void add(DinnerTable dt) {

		String sql = "INSERT dinnertable(tableName) VALUES(?)";
		try {
			qr.update(sql, dt.getTableName());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see school.libenhe.hotel.dao.IDinnerTableDao#delete(int)
	 */
	@Override
	public void delete(int id) {
	
		String sql = "delete from dinnertable where id=?";
		try {
			qr.update(sql, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * school.libenhe.hotel.dao.IDinnerTableDao#updata(school.libenhe.hotel.
	 * entity.DinnerTable)
	 */
	@Override
	public void updata(DinnerTable dt) {
	
		String sql = "UPDATE dinnertable SET tableStatus=?,orderDate=? WHERE id=?";
		Date date = dt.getOrderDate();
		try {
			JdbcUtils.getQueryRunner().update(sql, dt.getTableStatus(),date,dt.getId());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see school.libenhe.hotel.dao.IDinnerTableDao#query()
	 */
	@Override
	public List<DinnerTable> query() {
		
		String sql = "select * from dinnertable";
		try {
			return qr.query(sql, new BeanListHandler<DinnerTable>(DinnerTable.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see school.libenhe.hotel.dao.IDinnerTableDao#findById(int)
	 */
	@Override
	public DinnerTable findById(int id) {
		
		String sql = "select * from dinnertable where id=?";
		try {
			return qr.query(sql, new BeanHandler<DinnerTable>(DinnerTable.class),id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see school.libenhe.hotel.dao.IDinnerTableDao#query(java.lang.String)
	 */
	@Override
	public List<DinnerTable> query(String keyword) {

		String sql = "SELECT * FROM dinnertable WHERE tableName LIKE ?";
		try {
			return qr.query(sql, new BeanListHandler<DinnerTable>(DinnerTable.class),"%"+keyword +"%");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see school.libenhe.hotel.dao.IDinnerTableDao#quitTable(int)
	 */
	@Override
	public void quitTable(int id) {
		
		String sql = "UPDATE dinnertable SET tableStatus=?,orderDate=? WHERE id=?";
		try {
			JdbcUtils.getQueryRunner().update(sql,0,null,id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
