package com.cognologix.Day2.Part1.Q4Student.Model;

public class QFourthStudent {

	private Integer StudentId;
	private String Name;
	private Integer marks;
	public QFourthStudent() {}
	public QFourthStudent(int studentId, String name, int marks) {
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
