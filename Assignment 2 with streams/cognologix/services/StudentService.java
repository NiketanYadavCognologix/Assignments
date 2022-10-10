package com.cognologix.services;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import com.cognologix.model.Student;

public class StudentService {

	List<Student> studentArrayList;

	public StudentService(List<Student> studentArrayList) {
		super();
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
		lowestIdStudent = studentArrayList.stream().min(Comparator.comparing(Student::getStudentId)).get();
		return lowestIdStudent;
	}

	public Double getAverageMarks(Student lowestIdStudent) {
		Double totalMarks = 0.0;
		Integer subjectsCount = (int) studentArrayList.stream()
				.filter(student -> student.getStudentId().equals(lowestIdStudent.getStudentId())).count();

//		for (Student student : studentArrayList) {
//			if (student.getStudentId() == lowestIdStudent.getStudentId()) {
//				totalMarks += student.getMarks();
//			}
//		}

		totalMarks = studentArrayList.stream()
				.filter(student -> student.getStudentId().equals(lowestIdStudent.getStudentId()))
				.mapToDouble(student -> student.getMarks()).sum();

		Double averageMarks = totalMarks / subjectsCount;
		return averageMarks;

	}

}
