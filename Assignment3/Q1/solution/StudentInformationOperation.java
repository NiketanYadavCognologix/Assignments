package com.cognologix.Q1.solution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.cognologix.Q1.module.Student;

public class StudentInformationOperation {

	List<Student> studentsList;
	public StudentInformationOperation(List<Student> studentsList) {
		this.studentsList=studentsList;
	}
	public List<Student> getSortedListByNames() {

		List<Student> studentsSortedByName=new ArrayList<Student>();
		studentsSortedByName=(List<Student>) studentsList.stream()
							.sorted(Comparator.comparing(Student::getStudentName))
							.collect(Collectors.toList());
		printResult(studentsSortedByName);
		return studentsSortedByName;
	}
	public List<Student> getSortedByIdInDescending() {
		List<Student> studentsSortedById=new ArrayList<Student>();
		studentsSortedById=(List<Student>) studentsList.stream()
				.sorted(Comparator.comparing(Student::getStudentId).reversed())
				.collect(Collectors.toList());
		printResult(studentsSortedById);
		return studentsSortedById;
	}
	public List<Student> getStudentsIdGraterThan() {
		List<Student> studentsIdGraterThan=new ArrayList<Student>();
		studentsIdGraterThan=studentsList.stream()
											.filter(student -> student.getStudentId()>23)
											.collect(Collectors.toList());
		printResult(studentsIdGraterThan);
		return studentsIdGraterThan;
	}
	public List<Student> getStudentsNameLengthIsGraterThan() {
		List<Student> studentsNameLengthIsGraterThan=new ArrayList<Student>();
		studentsNameLengthIsGraterThan=studentsList.stream()
													.filter(student -> student.getStudentName().length()>5)
													.collect(Collectors.toList());
		printResult(studentsNameLengthIsGraterThan);
		return studentsNameLengthIsGraterThan;
	}
	public void printResult(List<Student> resultList) {

		for (Student student : resultList) {
			System.out.println(student.getStudentId()+" ---> "+student.getStudentName());
		}
	}
	public Map<Integer, Student> getStudentsIntoMap() {
		Map<Integer, Student> studentsMap=new HashMap<Integer, Student>();

		studentsMap =studentsList.stream()
		.collect(Collectors.toMap(Student::getStudentId,
									(student) -> student,
									(oldStudentName, newStudentName) -> newStudentName));

		printMyMap(studentsMap);
		return studentsMap;
	}
	private void printMyMap(Map<Integer, Student> studentsMap) {
		System.out.println(studentsMap);
		
	}

}
