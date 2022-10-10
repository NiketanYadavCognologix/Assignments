package com.cognologix.model;

public class Student {

	private Integer studentId;
	private String name;
	private Integer marks;
	public Student() {}
	public Student(int studentId, String name, int marks) {
		this.studentId = studentId;
		this.name = name;
		this.marks = marks;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getMarks() {
		return marks;
	}
	public void setMarks(Integer marks) {
		this.marks = marks;
	}
	@Override
    public String toString() {
        String placeHolder = "StudentId: {0}, name: {1}, marks: {2}";
        return java.text.MessageFormat.format(placeHolder, studentId, name, marks);
    }
}
