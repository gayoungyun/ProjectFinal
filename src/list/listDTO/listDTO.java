package list.listDTO;

public class listDTO 
{
	private int productNumber;
	private String productName;
	private String productPrice;
	private String productIamgeRoot;
	private String productCategory;
	

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public listDTO(int productNumber, String productName, String productPrice, String productIamgeRoot, String productCategory )
	{
		this.productNumber = productNumber;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productIamgeRoot = productIamgeRoot;
		this.productCategory = productCategory;
	}
	
	public String getProductIamgeRoot() {
		return productIamgeRoot;
	}
	
	public void setProductIamgeRoot(String productIamgeRoot) {
		this.productIamgeRoot = productIamgeRoot;
	}
	
	public int getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
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
}
