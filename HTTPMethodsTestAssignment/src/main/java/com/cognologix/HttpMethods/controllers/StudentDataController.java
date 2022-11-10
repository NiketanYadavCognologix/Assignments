package com.cognologix.HttpMethods.controllers;

import java.util.List;

import org.json.JSONObject;
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

	@Autowired															//no need to create object here for using methods of class,But
	StudentOpertionService studentService;								//need to Autowired service class for using methods in service class.

	//get the output and input JSON OR xml format
	@PostMapping(value = "/saveAll",
			consumes = { "application/json", "application/xml" },		//get from UI, mostly used in PostMapping 
			produces = {"application/json", "application/xml" })		//returns in UI, mostly used in GetMapping
	public ResponseEntity<List<Student>> saveAllStudent(@RequestBody List<Student> students) {
		List<Student> StudList = students;
		studentService.saveAllStudent(students);
		return new ResponseEntity<List<Student>>(StudList, HttpStatus.OK); //must create new ResponseEntity.
	}

	@PostMapping(value = "/save", 
			consumes = { "application/json", "application/xml" }) 		//also can use produces here.
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
	public ResponseEntity<Object> getStudentById(@PathVariable Integer id) {
		JSONObject studentJson = new JSONObject();											//for getting String as well as JSON object in return in Postman
		studentJson.put("Student get sucessfully...", studentService.getSudentById(id));

		System.out.println(studentJson);
		return new ResponseEntity<Object>(studentJson.toMap(), HttpStatus.OK);				//toMap() perform mapping of JSON and String for Postman
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudentById(@PathVariable Integer id) {
		studentService.deleteStudent(id);
		return new ResponseEntity<String>("Student deleted sucessfully..", HttpStatus.OK);

	}

	@PutMapping("/update")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {	//only save updated object for updating.
		studentService.saveStudent(student);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

}
