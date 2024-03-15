package basket.basketDTO;

public class BasketDTO 
{
	private int userNumber;
	private int productNumber;
	private int productListNumber;
	private String productName;
	private String productPrice;
	private String productImageRoot;
	private String productCategory;
	
	public int getProductListNumber() {
		return productListNumber;
	}
	public void setProductListNumber(int productListNumber) {
		this.productListNumber = productListNumber;
	}
	public int getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}
	
	public BasketDTO(int userNumber, int productNumber,  int productListNumber, String productName, String productPrice, String productImageRoot, String productCategory)
	{
		this.userNumber = userNumber;
		this.productNumber = productNumber;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productImageRoot = productImageRoot;
		this.productCategory = productCategory; 
		this.productListNumber = productListNumber;
	}
	
	public int getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(int userId) {
		this.userNumber = userId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductImageRoot() {
		return productImageRoot;
	}
	public void setProductImageRoot(String productImageRoot) {
		this.productImageRoot = productImageRoot;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String prodcutCategory) {
		this.productCategory = prodcutCategory;
	}
	
	
}
