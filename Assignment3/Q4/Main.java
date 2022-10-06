package com.cognologix.Part1.Q4Student;

import java.util.List;

import com.cognologix.Part1.Q4Student.Model.Student;
import com.cognologix.Part1.Q4Student.Solution.AvarageMarksCalculator;
import com.cognologix.Part1.Q4Student.parser.StudentInputParser;

/*    4. Average marks scored across all subjects by the student with the lowest ID
Consider the following data
22, Data Structures, 45
23, English, 52
22, English, 51
26, Data Structures, 72
23, Data Structures, 61
24, English, 81

Each string consists of three fields: "Student ID," "Subject," and "Marks." "Student ID" and "Marks" are integers 
and "Subject" is a string that does not contain commas or newlines. There can be any number of students and up to 6 subjects.

Write a program to compute the average marks scored across all subjects by the student with the lowest ID.*/
public class Main {

	public static void main(String[] args) {
		//  class to parse file input into list
		StudentInputParser inputParser=new StudentInputParser();						
		
		String pathOfFile="/home/niketanyadav/eclipse-workspace/Testing/Q4 AvarageMarksCalculator/src/com/cognologix/Part1/Q4Student/files/input.csv";
		
		// method in StudentInputParser return the student array list
		final List<Student> studentsList=inputParser.parseCSVFile(pathOfFile);
		
		// class calculate average marks
		AvarageMarksCalculator student=new AvarageMarksCalculator(studentsList);		// class contains studentList as parameter
		
		// method in AvarageMarksCalculator returns lowest id student
		final Student lowestIdStudent=student.getLowestIdStudent();
				
		//  method in AvarageMarksCalculator calculate average marks of given student
		student.getAverageMarks(lowestIdStudent);

	}
}
