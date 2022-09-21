package com.cognologix.Part1.Q4Student.Model;

public class Student {

	private Integer StudentId;
	private String Name;
	private Integer marks;
	public Student() {}
	public Student(int studentId, String name, int marks) {
		StudentId = studentId;
		Name = name;
		this.marks = marks;
	}
	public Integer getStudentId() {
		return StudentId;
	}
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Integer getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "QFourthStudent [StudentId=" + StudentId + ", Name=" + Name + ", marks=" + marks + "]";
	}
}
