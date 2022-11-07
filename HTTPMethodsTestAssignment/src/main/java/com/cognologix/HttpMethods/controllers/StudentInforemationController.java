package com.cognologix.HttpMethods.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognologix.HttpMethods.modules.Student;

@RestController
@RequestMapping
public class StudentInforemationController {

	List<Student> students=new ArrayList<>();
	
	@GetMapping("/get{studentId}")
	public List<Student> getStudent(@PathVariable Integer studentId)
	{
		return students.stream().filter(student -> student.getId()==studentId).collect(Collectors.toList());
		
	}
	
	@GetMapping("/getAll")
	public List<Student> getAllStudent()
	{
		return students;
		
	}
	
	@PostMapping("/add")
	public String postStudent(@RequestBody List<Student> studentsList)
	{
		students=studentsList;
//		System.out.println("niketan--->"+id);
		return "POST : HTTP method....Student added successfully";
	}
	@PutMapping("/update{id}")
	public List<Student> putStudent(@PathVariable Integer id,@RequestBody Student updatedStudent)
	{
		students=students.stream().filter(student -> student.getId()!=id ).collect(Collectors.toList());
		students.add(updatedStudent);
		return students;
		
	}
	@DeleteMapping("/delete")
	public ResponseEntity<List<Student>> deleteStudent(@PathParam(value = "id") Integer id)
	{
		students=students.stream().filter(student -> student.getId()!=id).collect(Collectors.toList());		
		return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
	}
}
