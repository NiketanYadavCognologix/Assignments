package com.cognologix.mapper;

import com.cognologix.model.Customer;

public class CustomerMapper implements CSVToPojoMapper<Customer> {

	@Override
	public Customer map(String[] splittedArray) {

		Customer customer = new Customer();

		customer.setCustomerName(splittedArray[0]);
		customer.setStoreLocation(splittedArray[1]);
		customer.setDate(Integer.parseInt(splittedArray[2].trim()));
		customer.setProductName(splittedArray[3].trim());
		customer.setPrice(Integer.parseInt(splittedArray[4].replace("Rs", "").trim()));
		customer.setPaymentType(splittedArray[5]);
		return customer;
	}
}
