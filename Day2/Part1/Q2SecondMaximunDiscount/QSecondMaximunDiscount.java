package com.cognologix.Day2.Part1.Q2SecondMaximunDiscount;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*    2. Customers who purchased at least one most discounted product

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
public class QSecondMaximunDiscount {

	 List<QSecondClient> clientArrayList = new ArrayList<QSecondClient>();

	 Set<String> productNameTreeSet = new TreeSet<String>();

	public static void main(String[] args) {
		String[] input = { "Rajan Patil, Aundh, 1, Phone Cover, RS 170, Cash",
				"Mohit Gupta, Baner, 1, Samsung Battery, RS 900, Credit Card",
				"Rajan Patil, Aundh, 3, Samsung Battery, RS 1000, Cash",
				"Nina Kothari, Baner, 4, Earphones, RS 500, Credit Card",
				"T Sunitha, Shivajinagar, 5, Earphones, RS 550, Credit Card",
				"Rohan Gade, Aundh, 10, Motorola Battery, RS 1000, Credit Card",
				"Rajan Patil, Shivajinagar, 21, Earphones, RS 550, Credit Card",
				"Rajan Patil, Aundh, 22, USB Cable,150, UPI", "Meena Kothari, Baner, 23, USB Cable, RS 100, Cash",
				"Nina Kothari, Baner, 24, USB Cable,200, UPI", "Mohit Gupta, Baner, 25, USB Cable, RS 150, UPI" };

		QSecondMaximunDiscount object=new QSecondMaximunDiscount();
		/* Getting input in arrayList */
		object.inputInModule(input);

		/* Getting unique products into treeSet */
		object.getUniqueProducts();

		/* Getting Final Result */
		object.finalResultCaomparing();

	}

	private  void finalResultCaomparing() {
		for (String set : productNameTreeSet) {

			if (set.contentEquals(" Phone Cover") || set.contentEquals(" Motorola Battery")) {
			} else {
				Integer minPrice = Integer.MAX_VALUE;
				QSecondClient maxDiscontGettingClient = null;

				for (int i = 0; i < clientArrayList.size(); i++) {

					if (set.contentEquals(clientArrayList.get(i).getProductName())) {

						String priceString = clientArrayList.get(i).getPrice();
						String finalPriceString = "";
						for (int j = 0; j < priceString.length(); j++) {
							if (priceString.charAt(j) >= 48 && priceString.charAt(j) <= 57)
								finalPriceString += (char) (priceString.charAt(j));

						}
						Integer productPrice = Integer.valueOf(finalPriceString);

						if (productPrice < minPrice) {
							minPrice = productPrice;
							maxDiscontGettingClient = clientArrayList.get(i);
						}
					}
				}
				System.out.println(minPrice + " --> " + maxDiscontGettingClient.getCustomerName());
			}
		}
	}

	private void getUniqueProducts() {
		for (QSecondClient client : clientArrayList) {

			productNameTreeSet.add(client.getProductName());
		}

		// ********* You can also use iterator********************
		/*
		 * Iterator<QSecondClient> it = clientArrayList.iterator();
		 * 
		 * while (it.hasNext()) { QSecondClient client = it.next();
		 * productNameTreeSet.add(client.getProductName()); }
		 */

	}

	private void inputInModule(String[] input) {
		for (int i = 0; i < input.length; i++) {
			String inputOneString = input[i];
			String[] splittedArray = inputOneString.split(",");

			QSecondClient client = new QSecondClient();

			client.setCustomerName(splittedArray[0]);
			client.setStoreLocation(splittedArray[1]);
			client.setDate(splittedArray[2].trim());
			client.setProductName(splittedArray[3]);
			client.setPrice(splittedArray[4]);
			client.setPaymentType(splittedArray[5]);

			clientArrayList.add(client);
		}

	}

}
