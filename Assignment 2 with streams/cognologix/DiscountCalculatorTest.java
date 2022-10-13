package com.cognologix;

import java.util.List;

import com.cognologix.mapper.CustomerMapper;
import com.cognologix.model.Customer;
import com.cognologix.parser.InputParser;
import com.cognologix.services.DiscontCalculatorService;

/*2. Customers who purchased at least one most discounted product

Consider the following data in array of strings

Rajan Patil, Aundh, 1, Phone Cover, Rs 170, Cash
Mohit Gupta, Baner, 1, Samsung Battery, Rs 900, Credit Card
Rajan Patil, Aundh, 3, Samsung Battery, Rs 1000, Cash
Nina Kothari, Baner, 4, Earphones, Rs 500, Credit Card
T Sunitha, Shivajinagar, 5, Earphones, Rs 550, Credit Card
Rohan Gade, Aundh, 10, Motorola Battery, Rs 1000, Credit Card
Rajan Patil, Shivajinagar, 21, Earphones, Rs 550, Credit Card
Rajan Patil, Aundh, 22, USB Cable, Rs 150, UPI
Meena Kothari, Baner, 23, USB Cable, Rs 100, Cash
Nina Kothari, Baner, 24, USB Cable, Rs 200, UPI
Mohit Gupta, Baner, 25, USB Cable, Rs 150, UPI

The data is the sales of products in different stores of a company in the previous month. Each line consists of 6 comma-separated fields. 
The first column is customer name, the second column is store location, the third column is date (just day of the month is captured), 
the fourth column is product name, fifth is price, and sixth is payment type.
Write program to processes the input data, finds out which items have sold for a discount (i.e. there was at least one sale of the item 
at a price lower than the highest price of the item), and then lists the names of customers who have bought at least one item at the most 
discounted price.

Your program should produce the names of the customers on the standard output, one per line. The output should not contain anything else.

For the sample input given above, your program should produce the following output:
Mohit Gupta
Nina Kothari
Meena Kothari
Explanation: For the Samsung Battery, Rs 900 is the most discounted price, and Mohit Gupta bought it. For the Earphones, Rs 500 is the most 
discounted price, and Nina Kothari bought it. For the USB cable, Rs 100 is the most discounted price,  and Meena Kothari bought it. 
Note: For the Phone Cover and the Motorola Battery, there are no discounted prices.*/
public class DiscountCalculatorTest {

	public static void main(String[] args) {
	
		String [] customerInput= {
				"Rajan Patil, Aundh, 1, Phone Cover, Rs 170, Cash",
				"Mohit Gupta, Baner, 1, Samsung Battery, Rs 900, Credit Card",
				"Rajan Patil, Aundh, 3, Samsung Battery, Rs 1000, Cash",
				"Nina Kothari, Baner, 4, Earphones, Rs 500, Credit Card:",
				"T Sunitha, Shivajinagar, 5, Earphones, Rs 550, Credit Card",
				"Rohan Gade, Aundh, 10, Motorola Battery, Rs 1000, Credit Card",
				"Rajan Patil, Shivajinagar, 21, Earphones, Rs 550, Credit Card",
				"Rajan Patil, Aundh, 22, USB Cable, Rs 150, UPI",
				"Meena Kothari, Baner, 23, USB Cable, Rs 100, Cash",
				"Nina Kothari, Baner, 24, USB Cable, Rs 200, UPI",
				"Mohit Gupta, Baner, 25, USB Cable, Rs 150, UPI"
		};
		
		// class for parsing CSV file and Map with ArrayList of customer
		InputParser<Customer> inputParser=new InputParser<Customer>(new CustomerMapper());
		List<Customer> customers=inputParser.parseArray(customerInput);
		// class for calculating discount
		DiscontCalculatorService products =new DiscontCalculatorService(customers);
				
		// method from DiscontedProductCalcolator get most Discounted customer
		final List<String> mostDiscountedCustemerList= products.getMostDiscountedCustomerList();
		mostDiscountedCustemerList.stream().forEach(System.out::println);
	}

}