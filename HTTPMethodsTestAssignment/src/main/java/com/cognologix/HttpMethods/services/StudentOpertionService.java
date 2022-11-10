package com.cognologix.HttpMethods.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognologix.HttpMethods.dao.StudentRepository;
import com.cognologix.HttpMethods.exceptions.IdNotFoundException;
import com.cognologix.HttpMethods.modules.Student;

@Service
public class StudentOpertionService {

	@Autowired
	private StudentRepository studentRepository;

	public void saveAllStudent(List<Student> students) {
		studentRepository.saveAll(students);
	}

	public Integer saveStudent(Student student) {
		if (student != null) {
			studentRepository.save(student);
			return 1;
		}
		return 0;
	}

	public List<Student> getAll() {
		return studentRepository.findAll();
	}

	public Student getSudentById(Integer id) {

		Optional<Student> stuOptional = studentRepository.findById(id);
		if (stuOptional.isPresent()) {
			return stuOptional.get();
		}
		throw new IdNotFoundException("This id student is not found...");
	}

	public Integer deleteStudent(Integer id) {
		if (id != null) {
			studentRepository.deleteById(id);
			return 1;
		}
		return 0;
	}

	public Integer updateStudent(@RequestBody Student student) {
		if (student != null) {
			studentRepository.save(student);
			return 1;
		}
		return 0;
	}

}
