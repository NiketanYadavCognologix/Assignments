package com.cognologix.Part1.Q2Customer.Parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cognologix.Part1.Q2Customer.Mapper.CustomerMapper;
import com.cognologix.Part1.Q2Customer.model.Customer;

public class CustomerInputParser {
	
	public List<Customer> customerCSVParser(String filePath)
	{
		List<Customer> customersList=new ArrayList<Customer>();
		File file=new File(filePath);
		try {
			BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
			String inputString;
			try {
				while((inputString=bufferedReader.readLine())!=null)
				{
					Customer customer=CustomerMapper.map(inputString);
					customersList.add(customer);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return customersList;
	}
}
