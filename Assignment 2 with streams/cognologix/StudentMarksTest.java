package com.cognologix;

import java.util.List;

import com.cognologix.mapper.StudentMapper;
import com.cognologix.model.Student;
import com.cognologix.parser.InputParser;
import com.cognologix.services.StudentService;


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
public class StudentMarksTest {
    public static void main(String[] args) {
        String[] studentsInformation = {
            "22, Data Structures, 45",
            "23, English, 52",
            "22, English, 51",
            "26, Data Structures, 72",
            "23, Data Structures, 61",
            "24, English, 81"
        };
        StudentMapper mapper = new StudentMapper();
        InputParser<Student> parser = new InputParser<>(mapper);
        List<Student> students= parser.parseArray(studentsInformation);

        StudentService service = new StudentService(students);
        
        Student lowestIdStudent=service.getLowestIdStudent();
        Double averageMarks = service.getAverageMarks(lowestIdStudent);
        System.out.println("--- servers ---");
        students.forEach(System.out::println);
        System.out.println("\n---Average Marks for Student Having Lowest Id ---");
        System.out.println(averageMarks);

    }
}
