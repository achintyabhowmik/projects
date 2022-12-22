package com.studentservice.capstone.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.studentservice.capstone.exception.StudentAlreadyExistsException;
import com.studentservice.capstone.exception.StudentNotFoundException;
import com.studentservice.capstone.model.Student;

@Service
public interface StudentService {
public Student addStudent(Student student) throws StudentAlreadyExistsException;
public List<Student>getAllStudent();
public Student updateStudent(Student student) throws StudentNotFoundException  ;
public Boolean deleteStudent(String email) throws StudentNotFoundException;
Student findStudent(String email) throws StudentNotFoundException;

}
