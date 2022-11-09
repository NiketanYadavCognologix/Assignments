package com.cognologix.HttpMethods.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognologix.HttpMethods.modules.Student;

@Repository
//@Component("StudentReposi")
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
