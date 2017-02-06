package mvc;

public class Beer {

	String bname;
	String brand;
	String price;
	
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Beer [bname=" + bname + ", brand=" + brand + ", price=" + price + "]";
	}

}
