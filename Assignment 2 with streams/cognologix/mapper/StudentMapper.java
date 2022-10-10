package com.cognologix.mapper;

import com.cognologix.model.Student;

public class StudentMapper implements CSVToPojoMapper<Student> {

	@Override
	public Student map(String[] input) {
        if (input == null || input.length == 0) {
            throw new RuntimeException("Invalid input values");
        }
        Integer id = null;
        String name = null;
        Integer marks = null;
        try {
            id = Integer.parseInt(input[0].trim());
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid Student Id", e);
        }
        name = input[1].trim();
        try {
            marks = Integer.parseInt(input[2].trim());
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid Marks", e);
        }
        Student student = new Student(id, name, marks);
        return student;
    }
}
