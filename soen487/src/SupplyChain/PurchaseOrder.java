package SupplyChain;

public class PurchaseOrder {
	private String orderNum;
	private String customerRef;
	private Product product;
	private int quantity;
	private float unitPrice;
	
	public PurchaseOrder(String orderNum, String customerRef, Product product, int quantity, float unitPrice){
		this.orderNum = orderNum;
		this.customerRef = customerRef;
		this.product = product;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		
		
	}
}
