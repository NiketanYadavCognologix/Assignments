package com.cognologix.Assignment2.Part1.Q4Student;

import java.util.List;

import com.cognologix.Assignment2.Part1.Q4Student.Model.Student;
import com.cognologix.Assignment2.Part1.Q4Student.Solution.AvarageMarksCalculator;

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
		String[] input = { "22, Data Structures,45", "23, English,52", "22, English,51", "26, Data Structures,72",
				"23, Data Structures,61", "24, English,81" };
		
		AvarageMarksCalculator student=new AvarageMarksCalculator();
		/* String array reading method */
		List<Student> studentsList = student.mapInputArrayToList(input);

		/*Getting the lowest id student*/
		Student lowestIdStudent=student.getLowestIdStudent(studentsList);
				
		/*Average marks scored across all subjects by the student with the lowest ID*/
		 Double avarageMarks= student.getAverageMarks(lowestIdStudent,studentsList);

		/* Printing the Result */
		student.printResult(avarageMarks,lowestIdStudent);
	}
}
