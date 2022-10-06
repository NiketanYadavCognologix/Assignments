package com.cognologix.Part1.Q4Student.Solution;

import java.util.Comparator;
import java.util.List;

import com.cognologix.Part1.Q4Student.Model.Student;

public class AvarageMarksCalculator {

	List<Student> studentArrayList;

	public AvarageMarksCalculator(List<Student> studentArrayList) {

		this.studentArrayList = studentArrayList;
	}

	public Student getLowestIdStudent() {
		Student lowestIdStudent = new Student();
//		Integer lowestId = Integer.MAX_VALUE;
//		for (Student student : studentArrayList) {
//			if (student.getStudentId() < lowestId) {
//				lowestId = student.getStudentId();
//				lowestIdStudent = student;
//			}
//		}
		lowestIdStudent=studentArrayList.stream()
				.min(Comparator.comparing(Student::getStudentId))
				.get();
		return lowestIdStudent;
	}

	public void getAverageMarks(Student lowestIdStudent) {
		Double totalMarks = 0.0;
		Integer subjectsCount = (int) studentArrayList.stream()
												.filter(student -> student.getStudentId().equals(lowestIdStudent.getStudentId()))
												.count();

//		for (Student student : studentArrayList) {
//			if (student.getStudentId() == lowestIdStudent.getStudentId()) {
//				totalMarks += student.getMarks();
//			}
//		}
		
		totalMarks=studentArrayList.stream()
				.filter(student -> student.getStudentId().equals(lowestIdStudent.getStudentId()))
				.mapToDouble(student -> student.getMarks())
				.sum();
		
		Double averageMarks=totalMarks / subjectsCount;
		printResult(averageMarks,lowestIdStudent);

	}

	public void printResult(Double avarageMarks, Student lowestIdStudent) {
		System.out.println("lowest Id Student is ---> " + lowestIdStudent.getStudentId() + " have  average marks --> "
				+ avarageMarks);
	}

}
