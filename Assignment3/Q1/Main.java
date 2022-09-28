package com.cognologix.Q1;

import java.util.List;
import java.util.Map;

import com.cognologix.Q1.module.Student;
import com.cognologix.Q1.parser.StudentInputParser;
import com.cognologix.Q1.solution.StudentInformationOperation;

/*#1. String[] studentsInformation = {
"22, Rajesh", 
	"23, Dinesh", 
	"22, Aboli", 
	"26, Mayuresh", 
	"25, Sarika", 
	"24, Ketaki"
};
Create a List of Students.
Sort the list by name.
Sort the list by id in descending order.
filter the list of students for studentId > 23.
filter the list of students for studentId > 23
get a list of student names for those having length of name greater than 5.
create a map as follows
key: StudentId
value: Student Object

*/
public class Main {

	public static void main(String[] args) {
		
		// class parsing the input array
		StudentInputParser inputParser=new StudentInputParser();
		String[] studentsInformation = { "22, Rajesh", "23, Dinesh", "22, Aboli", "26, Mayuresh", "25, Sarika", "24, Ketaki" };
		
		// method in class StudentInputParser returns the list of students
		final List<Student> studentsList=inputParser.parseInputArrayOfStudent(studentsInformation);
		
		// class perform operations on student information
		StudentInformationOperation studentInformationOperation=new StudentInformationOperation(studentsList);
		
		System.out.println("*********************sorted Student List By Name*****************************");
		List<Student> sortedStudentListByName=studentInformationOperation.getSortedListByNames();
		
		System.out.println("\n*********************sorted Student List By Id In Descending*****************************");
		List<Student> sortedStudentListByIdInDescending=studentInformationOperation.getSortedByIdInDescending();

		System.out.println("\n**********************students Id Grater Than 23****************************");
		List<Student> studentsIdGraterThan=studentInformationOperation.getStudentsIdGraterThan();
		
		System.out.println("\n***********************students Name Length Is Grater Than 5***************************");
		List<Student> studentsNameLengthIsGraterThan=studentInformationOperation.getStudentsNameLengthIsGraterThan();
		
		System.out.println("\n***********************students Map***************************");
		Map<Integer, Student> studentMap=studentInformationOperation.getStudentsIntoMap();
		

	}

}
