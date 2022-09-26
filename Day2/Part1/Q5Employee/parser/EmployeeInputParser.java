package com.cognologix.Part1.Q5Employee.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cognologix.Part1.Q5Employee.Mapper.EmployeeMapper;
import com.cognologix.Part1.Q5Employee.Model.Employee;

public class EmployeeInputParser {

	public List<Employee> employeeCSVParser(String inputFilePath) {
		List<Employee> employeesList = new ArrayList<Employee>();
		File file = new File(inputFilePath);
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
			String inputString;
			try {
				while ((inputString = bufferedReader.readLine()) != null) {
					Employee employee = EmployeeMapper.map(inputString);
					if (employee != null)
						employeesList.add(employee);
				}
			} catch (IOException ioException) {
				throw new RuntimeException(ioException);
			}

		} catch (FileNotFoundException fileNotFoundException) {
			throw new RuntimeException(fileNotFoundException);
		}finally {
			try {
				bufferedReader.close();
			} catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		}
		return employeesList;
	}

}
