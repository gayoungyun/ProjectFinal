package admin.controller;

public class ProductTableData {
	private int number;
	private String name;
	private String price;
	private String imageRoot;
	private String category;
	
	public ProductTableData(int number, String name, String price,String imageRoot, String category) {
		this.number = number;
		this.name = name;
		this.price = price;
		this.imageRoot = imageRoot;
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImageRoot() {
		return imageRoot;
	}

	public void setImageRoot(String imageRoot) {
		this.imageRoot = imageRoot;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
