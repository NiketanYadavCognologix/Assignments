package com.cognologix.Day2.Part1.Q2SecondMaximunDiscount.Model;
/*The first column is customer name, the second column is store location, the third column is date (just day of the month is captured), 
the fourth column is product name, fifth is price, and sixth is payment type.*/
public class QSecondClient {

	private String customerName;
	private String storeLocation;
	private String date;
	private String productName;
	private String price;
	private String paymentType;
	public QSecondClient() {}
	public QSecondClient(String customerName, String storeLocation, String date, String productName, String price,
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
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
