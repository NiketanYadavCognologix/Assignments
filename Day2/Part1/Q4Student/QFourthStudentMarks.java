package com.cognologix.Day2.Part1.Q4Student;

import com.cognologix.Day2.Part1.Q4Student.Solution.QFourthSolution;

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
public class QFourthStudentMarks {

	public static void main(String[] args) {
		String[] input = { "22, Data Structures,45", "23, English,52", "22, English,51", "26, Data Structures,72",
				"23, Data Structures,61", "24, English,81" };
		
		QFourthSolution object=new QFourthSolution();
		/* String array reading method */
		object.inputReading(input);

		/* Getting lowest marks student */
		object.lowestIdStudent = object.gettingAverageMarks();

		/* Printing the Result */
		object.printResult();

	}
}
