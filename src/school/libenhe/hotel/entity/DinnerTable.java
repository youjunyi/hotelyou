package school.libenhe.hotel.entity;

import java.util.Date;

/**
 *  餐桌管理实体类
 *   
 * @author Li Benhe  Email: libenhe919@gmail.com
 * @version 2016-3-1 下午12:53:16
 */
public class DinnerTable {

	private int id;
	private String tableName;
	private int tableStatus;
	private Date orderDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public int getTableStatus() {
		return tableStatus;
	}

	public void setTableStatus(int tableStatus) {
		this.tableStatus = tableStatus;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "DinnerTable [id=" + id + ", tableName=" + tableName
				+ ", tableStatus=" + tableStatus + ", orderDate=" + orderDate
				+ "]";
	}

}
