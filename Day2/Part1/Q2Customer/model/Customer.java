package com.cognologix.Part1.Q2Customer.model;

/*The first column is customer name, the second column is store location, the third column is date (just day of the month is captured), 
the fourth column is product name, fifth is price, and sixth is payment type.*/
public class Customer {

	private String customerName;
	private String storeLocation;
	private Integer date;
	private String productName;
	private Integer price;
	private String paymentType;
	public Customer() {}
	public Customer(String customerName, String storeLocation, Integer date, String productName, Integer price,
			String paymentType) {
		this.customerName = customerName;
		this.storeLocation = storeLocation;
		this.date = date;
		this.productName = productName;
		this.price = price;
		this.paymentType = paymentType;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getStoreLocation() {
		return storeLocation;
	}
	public void setStoreLocation(String storeLocation) {
		this.storeLocation = storeLocation;
	}
	public Integer getDate() {
		return date;
	}
	public void setDate(Integer date) {
		this.date = date;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	@Override
	public String toString() {
		return java.text.MessageFormat.format("customerName : {0} | storeLocation : {1} | date : {2} | "
				+ "productName : {3} | price : {4} | paymentType : {5}", customerName,storeLocation,date,
				productName,price,paymentType);
	}
	
}
