package com.cognologix.Part1.Q4Student.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cognologix.Part1.Q4Student.Mapper.StudentMapper;
import com.cognologix.Part1.Q4Student.Model.Student;

public class StudentInputParser {

	public List<Student> parseArray(String[] inputData)
	{
		List<Student> studentList=new ArrayList<Student>();
		
		for (String studentdata : inputData) {
			Student student=StudentMapper.map(studentdata);
			studentList.add(student);
		}
		return studentList;
		
	}

	public List<Student> parseCSVFile(String filePath) {
		List<Student> studentList = new ArrayList<Student>();
		File file = new File(filePath);
		try {
			BufferedReader bufferRead = new BufferedReader(new FileReader(file));
			String string1;

			try {
				while ((string1 = bufferRead.readLine()) != null) {
					Student student = StudentMapper.map(string1);
					studentList.add(student);
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		return studentList;
	}
}
