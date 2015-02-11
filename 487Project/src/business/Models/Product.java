package business.Models;

public class Product {
	
	
	
	private ProductType productType;
	private String manufacturerName;
	private float unitPrice;
	
	public Product(ProductType productType, String manufacturerName, float unitPrice){
		this.productType = productType;
		this.manufacturerName = manufacturerName;
		this.unitPrice = unitPrice;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}
	
	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	
}
