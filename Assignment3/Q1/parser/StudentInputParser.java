package com.cognologix.Q1.parser;

import java.util.ArrayList;
import java.util.List;

import com.cognologix.Q1.mapper.StudentInputMapper;
import com.cognologix.Q1.module.Student;

public class StudentInputParser {
	
	public List<Student> parseInputArrayOfStudent(String [] inputStudentArray)
	{
		List<Student> studentsList=new ArrayList<Student>();
		for (String inputStudentString : inputStudentArray) {
			Student student=StudentInputMapper.map(inputStudentString);
			studentsList.add(student);
		}
		return studentsList;
	}
}
