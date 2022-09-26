package com.cognologix.Part1.Q4Student.Mapper;

import com.cognologix.Part1.Q4Student.Model.Student;

public class StudentMapper {

	public static Student map(String data)
	{
		String inputOneString = data;
		String[] splittedString = inputOneString.split(",");

		Student student = new Student();
		
		Integer studentId = Integer.parseInt(splittedString[0].trim());
		Integer studentMarks = Integer.parseInt(splittedString[2].trim());

		student.setStudentId(studentId);
		student.setName(splittedString[1]);
		student.setMarks(studentMarks);
		return student;
		
	}
}
