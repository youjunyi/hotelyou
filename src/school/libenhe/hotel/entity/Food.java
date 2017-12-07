package school.libenhe.hotel.entity;

/**
 * 菜品列表实体类
 * 
 * @author Li Benhe Email: libenhe919@gmail.com
 * @version 2016-3-1 下午12:55:10
 */
public class Food {

	private int id;
	private String foodName;
	private int foodType_id;
	private double price;
	private double mprice;
	private String remark;
	private String img;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getMprice() {
		return mprice;
	}
	public void setMprice(double mprice) {
		this.mprice = mprice;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public int hashCode() {
		return this.id;
	}
	@Override
	public boolean equals(Object obj) {
		Food food = (Food)obj;
		return food.getId() == this.id;
	}
	
	
	
}
