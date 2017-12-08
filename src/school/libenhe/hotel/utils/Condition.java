package school.libenhe.hotel.utils;

/**
 * @author Li Benhe Email: libenhe919@gmail.com
 * @version 2016-3-1 下午2:40:09
 */
public class Condition {

	private String foodName;
	private int foodType_id;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getFoodType_id() {
		return foodType_id;
	}

	public void setFoodType_id(int foodType_id) {
		this.foodType_id = foodType_id;
	}

	@Override
	public String toString() {
		return "Condition{" +
				"foodName='" + foodName + '\'' +
				", foodType_id=" + foodType_id +
				", name='" + name + '\'' +
				'}';
	}
}
