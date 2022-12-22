package com.studentservice.capstone.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentservice.capstone.exception.StudentAlreadyExistsException;
import com.studentservice.capstone.exception.StudentNotFoundException;
import com.studentservice.capstone.model.Student;
import com.studentservice.capstone.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentController {
	@Autowired
	private StudentService servic;
	@PostMapping("/add")
	public ResponseEntity<?>addStudent(@RequestBody Student student)
	{
	
		
		try {
			servic.addStudent(student);
			return new ResponseEntity<String>("Student added",HttpStatus.CREATED);
		} catch (StudentAlreadyExistsException e) {
			
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
		
	}
	@GetMapping("/all")
	public ResponseEntity<?>getAllStudent()
	{
		
		
		List<Student>studentList=	servic.getAllStudent();
			return new ResponseEntity<List<Student>>(studentList,HttpStatus.OK);

	}
	@PutMapping("/update")
	public ResponseEntity<?>updateStudent(@RequestBody Student student)
	{
		
		try {
			servic.updateStudent(student);
			return new ResponseEntity<String>("Student updated Sucessfully",HttpStatus.CREATED);
		} catch (StudentNotFoundException e) {
			
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
		
	}
	@PostMapping("/find/{email}")
	public ResponseEntity<?>findStudent(@PathVariable("email") String email)
	{
		
		try {
			Student student=servic.findStudent(email);
			return new ResponseEntity<Student>(student,HttpStatus.OK);
		} catch (StudentNotFoundException e) {
			
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
		
	}
	@DeleteMapping("/find/{email}")
	public ResponseEntity<?>deleteStudent(@PathVariable("email") String email)
	{
		
		try {
			servic.deleteStudent(email);
			return new ResponseEntity<String>("Student Deleted",HttpStatus.OK);
		} catch (StudentNotFoundException e) {
			
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
		
	}
	

}
