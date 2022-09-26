package com.cognologix.Part1.Q3Library.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cognologix.Part1.Q3Library.Module.Product;
import com.cognologix.Part1.Q3Library.mapper.ProductMapper;

public class ProductInputParser {

	public List<Product> productCSVParser(String inputPath)
	{
		List<Product> productList=new ArrayList<Product>();
		File file=new File(inputPath);
		BufferedReader bufferedReader=null;
		try {
			bufferedReader=new BufferedReader(new FileReader(file));
			String InputProductstring;
			try {
				while((InputProductstring=bufferedReader.readLine())!=null)
				{
					Product product=ProductMapper.map(InputProductstring);
					productList.add(product);
				}
			} catch (IOException ioException) {
				throw new RuntimeException(ioException);
			}
		} catch (FileNotFoundException fileNotFoundException) {
			throw new RuntimeException(fileNotFoundException);
		}
		finally {
			try {
				bufferedReader.close();
			} catch (IOException ioException) {
				throw new RuntimeException(ioException);
			}
		}
		return productList;

	}
}
