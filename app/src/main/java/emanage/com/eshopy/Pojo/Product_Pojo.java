package emanage.com.eshopy.Pojo;

public class Product_Pojo {
	String title;
	String detils;
	String price;
	int Image;

	public Product_Pojo() {
	}

	public Product_Pojo(String title, String detils, String price, int image) {
		this.title = title;
		this.detils = detils;
		this.price=price;
		Image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetils() {
		return detils;
	}

	public void setDetils(String detils) {
		this.detils = detils;
	}

	public int getImage() {
		return Image;
	}

	public void setImage(int image) {
		Image = image;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}
