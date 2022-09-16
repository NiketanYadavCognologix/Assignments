package com.cognologix.Day2.Part1.Q4Student;

import java.util.ArrayList;
import java.util.List;

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

	List<QFourthStudent> studentArrayList = new ArrayList<QFourthStudent>();
	Double averageMarks = 0.0;
	Integer sumOfMarks = 0;
	QFourthStudent lowestIdStudent;

	public static void main(String[] args) {
		String[] input = { "22, Data Structures,45", "23, English,52", "22, English,51", "26, Data Structures,72",
				"23, Data Structures,61", "24, English,81" };
		
		QFourthStudentMarks object=new QFourthStudentMarks();
		/* String array reading method */
		object.inputReading(input);

		/* Getting lowest marks student */
		object.lowestIdStudent = object.gettingAverageMarks();

		/* Printing the Result */
		object.printResult();

			}

	private void printResult() {
		averageMarks = (double) (sumOfMarks / studentArrayList.size());

		System.out.println("lowest Id Student is ---> " + lowestIdStudent.getStudentId() + " have marks --> "
				+ lowestIdStudent.getMarks());
		System.out.println("Avarage Marks ---> " + averageMarks);

	}

	private QFourthStudent gettingAverageMarks() {
		Integer lowestID = Integer.MAX_VALUE;
		lowestIdStudent = null;

		for (QFourthStudent student : studentArrayList) {
			if (lowestID > student.getStudentId()) {
				lowestID = student.getStudentId();
				lowestIdStudent = student;
			}
			sumOfMarks += student.getMarks();
		}
		
//**********we can also use the iterator*****************
		/*
		 * Iterator<QFourthStudent> it=studentArrayList.iterator();
		 * 
		 * while(it.hasNext()) { QFourthStudent student=it.next();
		 * if(lowestID>student.getStudentId()) { lowestID=student.getStudentId();
		 * lowestIdStudent=student; } sumOfMarks+=student.getMarks(); }
		 */
		
		return lowestIdStudent;
	}

	private void inputReading(String[] input) {
		for (int i = 0; i < input.length; i++) {
			String inputOneString = input[i];
			String[] splittedString = inputOneString.split(",");

			QFourthStudent student = new QFourthStudent();

			Integer StudId = Integer.parseInt(splittedString[0]);
			Integer marks = Integer.parseInt(splittedString[2]);

			student.setStudentId(StudId);
			student.setName(splittedString[1]);
			student.setMarks(marks);

			studentArrayList.add(student);
		}

	}
}
