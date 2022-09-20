package com.cognologix.Day2.Part1.Q2SecondMaximunDiscount.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.cognologix.Day2.Part1.Q2SecondMaximunDiscount.Model.QSecondClient;

public class Q2SecondMaxSolution {

	 List<QSecondClient> clientArrayList = new ArrayList<QSecondClient>();

	 Set<String> productNameTreeSet = new TreeSet<String>();
	 
	 public  void finalResultCaomparing() {
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

	public void getUniqueProducts() {
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

	public void inputInModule(String[] input) {
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
