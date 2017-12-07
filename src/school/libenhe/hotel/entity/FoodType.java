package school.libenhe.hotel.entity;

/** 
 * 菜品种类的实体类
 * 
 * @author Li Benhe Email: libenhe919@gmail.com
 * @version 2016-3-1 下午1:07:03
 */
public class FoodType {

	private int id;
	private String typeName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "FoodType [id=" + id + ", typeName=" + typeName + "]";
	}

}
