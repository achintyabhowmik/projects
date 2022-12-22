package com.studentservice.capstone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentservice.capstone.dao.StudentRepo;
import com.studentservice.capstone.exception.StudentAlreadyExistsException;
import com.studentservice.capstone.exception.StudentNotFoundException;
import com.studentservice.capstone.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
@Autowired
	private StudentRepo studentrepo;
	@Override
	public Student addStudent(Student student) throws StudentAlreadyExistsException {
		Optional<Student>studentObj=studentrepo.findByStudentEmailId(student.getStudentEmailId());
		Optional<Student>studentObj1=studentrepo.findBystudentRoll(student.getStudentRoll());
		if(studentObj.isPresent())
		{
			throw new StudentAlreadyExistsException("Student Email Already Exist");
		}
		else if(studentObj1.isPresent())
		{
			throw new StudentAlreadyExistsException("Student Roll Already Exist");
		}
		return studentrepo.save(student);
	}

	@Override
	public List<Student> getAllStudent() {
		return studentrepo.findAll();
	}

	@Override
	public Student updateStudent(Student student) throws StudentNotFoundException   {
		
		Optional<Student>studentObj=studentrepo.findByStudentEmailId(student.getStudentEmailId());
		if(studentObj.isEmpty())
		{
			throw new StudentNotFoundException("Student Not Found");
		}
		student.setStudentId(studentObj.get().getStudentId());
		return studentrepo.save(student);
	
	}

	@Override
	public Boolean deleteStudent(String email) throws StudentNotFoundException {
		Optional<Student>studentObj=studentrepo.findByStudentEmailId(email);
		if(studentObj.isEmpty())
		{
			throw new StudentNotFoundException("Email Dose Not Exist");
		}
		
		 studentrepo.delete(studentObj.get());
		 return true;
		 
	}

	@Override
	public Student findStudent(String email) throws StudentNotFoundException {
		Optional<Student>studentObj=studentrepo.findByStudentEmailId(email);
		if(studentObj.isEmpty())
		{
			throw new StudentNotFoundException("Email Dose Not Exist");
		}
		return studentObj.get();
	}

}
