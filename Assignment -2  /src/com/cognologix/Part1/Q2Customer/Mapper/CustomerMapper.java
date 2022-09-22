package com.cognologix.Part1.Q2Customer.Mapper;

import com.cognologix.Part1.Q2Customer.model.Customer;

public class CustomerMapper {
	public static Customer map(String data)
	{
		String[] splittedArray = data.split(",");

		Customer customer = new Customer();

		customer.setCustomerName(splittedArray[0]);
		customer.setStoreLocation(splittedArray[1]);
		customer.setDate(splittedArray[2].trim());
		customer.setProductName(splittedArray[3]);
		customer.setPrice(splittedArray[4]);
		customer.setPaymentType(splittedArray[5]);

		return customer;
	}
}
