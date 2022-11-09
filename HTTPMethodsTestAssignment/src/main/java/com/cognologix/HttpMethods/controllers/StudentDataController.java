package com.cognologix.HttpMethods.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognologix.HttpMethods.modules.Student;
import com.cognologix.HttpMethods.services.StudentOpertionService;

@RestController
@RequestMapping("/studentData")
public class StudentDataController {

	@Autowired
	StudentOpertionService studentService;

	@PostMapping(value = "/saveAll", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	public ResponseEntity<List<Student>> saveAllStudent(@RequestBody List<Student> students) {
		List<Student> StudList = students;
		studentService.saveAllStudent(students);
		return new ResponseEntity<List<Student>>(StudList, HttpStatus.OK);
	}

	@PostMapping(value = "/save", produces = { "application/json", "application/xml" })
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		studentService.saveStudent(student);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

	@GetMapping(value = "/getAll", produces = { "application/json", "application/xml" })
	public ResponseEntity<List<Student>> getAllStudents() {
		return new ResponseEntity<List<Student>>(studentService.getAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/getByID/{id}",
			produces = { "application/json", "application/xml" })
	public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
		return new ResponseEntity<Student>(studentService.getSudentById(id),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudentById(@PathVariable Integer id)
	{
		studentService.deleteStudent(id);
		return new ResponseEntity<String>("Student deleted sucessfully..",HttpStatus.OK);
		
	}
	@PutMapping("/update")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student)
	{
		studentService.saveStudent(student);
		return new ResponseEntity<Student>(student,HttpStatus.OK);
	}
	

}
