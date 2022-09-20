package com.cognologix.Day2.Part1.Q4Student.Solution;

import java.util.ArrayList;
import java.util.List;

import com.cognologix.Day2.Part1.Q4Student.Model.QFourthStudent;

public class QFourthSolution {

	List<QFourthStudent> studentArrayList = new ArrayList<QFourthStudent>();
	Double averageMarks = 0.0;
	Integer sumOfMarks = 0;
	
	public QFourthStudent lowestIdStudent;
	
	public void printResult() {
		averageMarks = (double) (sumOfMarks / studentArrayList.size());

		System.out.println("lowest Id Student is ---> " + lowestIdStudent.getStudentId() + " have marks --> "
				+ lowestIdStudent.getMarks());
		System.out.println("Avarage Marks ---> " + averageMarks);

	}

	public QFourthStudent gettingAverageMarks() {
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

	public void inputReading(String[] input) {
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
