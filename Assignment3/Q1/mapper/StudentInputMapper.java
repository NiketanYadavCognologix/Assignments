package com.cognologix.Q1.mapper;

import com.cognologix.Q1.module.Student;

public class StudentInputMapper {

	public static Student map(String inputStudentString)
	{
		String [] inputSplittedString=inputStudentString.split(",");
		Student student=new Student();
		
		student.setStudentId(Integer.parseInt(inputSplittedString[0].trim()));
		student.setStudentName(inputSplittedString[1]);
		
		return student;
	}
}
