package com.cognologix.HttpMethods.modules;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@XmlRootElement
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String marks;
//	public Student() {}
//	public Student(int id, String name, String marks) {
//		this.id = id;
//		this.name = name;
//		this.marks = marks;
//	}
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getMarks() {
//		return marks;
//	}
//	public void setMarks(String marks) {
//		this.marks = marks;
//	}
//	@Override
//	public String toString() {
//		return String.format("Student [id=%d, name=%-20s, marks=%-3s]", id, name, marks);
//	}
	
}
