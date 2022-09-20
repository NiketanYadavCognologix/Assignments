package com.cognologix.Assignment2.Part1.Q4Student.Solution;

import java.util.ArrayList;
import java.util.List;

import com.cognologix.Assignment2.Part1.Q4Student.Mapper.StudentMapper;
import com.cognologix.Assignment2.Part1.Q4Student.Model.Student;

public class AvarageMarksCalculator {
	
	public List<Student> mapInputArrayToList(String[] input) {

		List<Student> studentArrayList = new ArrayList<Student>();

		for (int i = 0; i < input.length; i++) {
			Student student=StudentMapper.map(input[i]);
			studentArrayList.add(student);
		}
		return studentArrayList;

	}

	public Student getLowestIdStudent(List<Student> students) {
		Student lowestIdStudent = new Student();
		Integer lowestId = Integer.MAX_VALUE;
		for (Student student : students) {
			if (student.getStudentId() < lowestId) {
				lowestId = student.getStudentId();
				lowestIdStudent = student;
			}
		}
		return lowestIdStudent;
	}
	public Double getAverageMarks(Student lowestIdStudent, List<Student> students) {

		Double averageMarks=0.0;
		Double totalMarks=0.0;
		Integer subjectsCount=0;
		
		for (Student student : students) {
			if(student.getStudentId()==lowestIdStudent.getStudentId())
			{
				totalMarks+=student.getMarks();
				subjectsCount++;
			}
		}
		averageMarks=totalMarks/subjectsCount;
		return averageMarks;
	}

	public void printResult(Double avarageMarks, Student lowestIdStudent) {
		System.out.println("lowest Id Student is ---> " + lowestIdStudent.getStudentId() + " have  average marks --> "
				+ avarageMarks);
	}

	
}
