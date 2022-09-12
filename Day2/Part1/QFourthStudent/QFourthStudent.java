package com.cognologix.Day2.Part1.QFourthStudent;

public class QFourthStudent {

	private int StudentId;
	private String Name;
	private int marks;
	public QFourthStudent() {}
	public QFourthStudent(int studentId, String name, int marks) {
		StudentId = studentId;
		Name = name;
		this.marks = marks;
	}
	public int getStudentId() {
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
	public int getMarks() {
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
