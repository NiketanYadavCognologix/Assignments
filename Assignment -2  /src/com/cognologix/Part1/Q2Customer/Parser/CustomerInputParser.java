package com.cognologix.Part1.Q2Customer.Parser;

import java.io.BufferedReader;
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

		try (FileReader fileReader=new FileReader(filePath)){
			BufferedReader bufferedReader= new BufferedReader(fileReader);
			String inputString;
			while((inputString=bufferedReader.readLine())!=null)
			{
				Customer customer=CustomerMapper.map(inputString);
				customersList.add(customer);
			}
			
		} catch (FileNotFoundException fileNotFoundException) {
			throw new RuntimeException(fileNotFoundException);
		} catch (IOException ioException) {
			throw new RuntimeException(ioException);
		}
		return customersList;
	}
}
