package com.cognologix.Day2.Part1.QFourthStudent;

import java.util.ArrayList;
import java.util.Iterator;
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

	static List<QFourthStudent> studentArrayList=new ArrayList<QFourthStudent>();
	public static void main(String[] args) {
		String [] input= {"22, Data Structures,45",
							"23, English,52",
							"22, English,51",
							"26, Data Structures,72",
							"23, Data Structures,61",
							"24, English,81"};
		
		for (int i = 0; i < input.length; i++)
		{
			String inputOneString=input[i];
			String[] splittedString=inputOneString.split(",");
			
			QFourthStudent student=new QFourthStudent();
			
			int StudId=Integer.parseInt(splittedString[0]);
			int marks=Integer.parseInt(splittedString[2]);

			student.setStudentId(StudId);
			student.setName(splittedString[1]);
			student.setMarks(marks);
			
			studentArrayList.add(student);
		}
		
		int lowestID=Integer.MAX_VALUE;
		QFourthStudent lowestIdStudent=null;
		float averageMarks=0;
		int sumOfMarks=0;
		
		
		Iterator<QFourthStudent> it=studentArrayList.iterator();
		
		while(it.hasNext())
		{
			QFourthStudent student=it.next();
			if(lowestID>student.getStudentId())
			{
				lowestID=student.getStudentId();
				lowestIdStudent=student;
			}
			sumOfMarks+=student.getMarks();
		}
		averageMarks=sumOfMarks/input.length ;
		
		System.out.println("lowest Id Student is ---> "+lowestIdStudent.getStudentId()+" have marks --> "+lowestIdStudent.getMarks());
		System.out.println("Avarage Marks ---> "+averageMarks);
		
	}
}
