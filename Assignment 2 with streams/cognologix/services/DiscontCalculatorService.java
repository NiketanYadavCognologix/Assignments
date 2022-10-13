package com.cognologix.services;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.cognologix.model.Customer;

public class DiscontCalculatorService {

	List<Customer> customers;

	public DiscontCalculatorService(List<Customer> customers) {
		this.customers = customers;
	}

	public List<String> getMostDiscountedCustomerList() {

		List<String> mostDiscountedCustomerList = new ArrayList<>();
		Map<String, Customer> highestPrice = customers.stream()
				.collect(groupingBy(customers -> customers.getProductName(),
						collectingAndThen(maxBy(comparingInt(c -> c.getPrice())), Optional::get)));

		Map<String, Customer> lowestPrize = customers.stream()
				.collect(groupingBy(customers -> customers.getProductName(),
						collectingAndThen(minBy(comparingInt(c -> c.getPrice())), Optional::get)));

		highestPrice.keySet().stream().filter(lowestPrize::containsKey)
				.filter(key -> highestPrice.get(key) != lowestPrize.get(key))
				.forEach(key -> mostDiscountedCustomerList.add(lowestPrize.get(key).getCustomerName()));
		return mostDiscountedCustomerList;
	}

}
