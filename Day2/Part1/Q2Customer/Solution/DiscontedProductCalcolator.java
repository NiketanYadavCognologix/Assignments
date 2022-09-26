package com.cognologix.Part1.Q2Customer.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.cognologix.Part1.Q2Customer.model.Customer;

public class DiscontedProductCalcolator {

	List<Customer> customerList;

	public DiscontedProductCalcolator(List<Customer> customerList) {
		this.customerList = customerList;
	}

	public Set<String> getProducts() {

		Set<String> allProductNamesSet = new TreeSet<String>();

		for (Customer customer : customerList) {
			allProductNamesSet.add(customer.getProductName());
		}
		return allProductNamesSet;
	}

	public List<Customer> getMostDiscountedCustomerList(Set<String> productsSet) {

		List<Customer> mostDiscountedCustomerList = new ArrayList<Customer>();
		for (String productName : productsSet) {

			if (productName.trim().contentEquals("Phone Cover")
					|| productName.trim().contentEquals("Motorola Battery")) {
			} else {
				Integer minPrice = Integer.MAX_VALUE;
				Customer maxDiscontGettingCustomer = null;

				for (int i = 0; i < customerList.size(); i++) {

					if (productName.contentEquals(customerList.get(i).getProductName())) {

						Integer productPrice = customerList.get(i).getPrice();
						
						if (productPrice < minPrice) {
							minPrice = productPrice;
							maxDiscontGettingCustomer = customerList.get(i);
						}
					}
				}
				mostDiscountedCustomerList.add(maxDiscontGettingCustomer);
			}
		}

		return mostDiscountedCustomerList;
	}

	public void printResults(List<Customer> mostDiscountedCustemerList) {
		for (Customer customer : mostDiscountedCustemerList) {
			System.out.println(customer.getPrice() + " --> " + customer.getCustomerName());

		}
	}
}
