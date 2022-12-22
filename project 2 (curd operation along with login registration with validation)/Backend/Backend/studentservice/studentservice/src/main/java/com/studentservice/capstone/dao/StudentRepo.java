package com.studentservice.capstone.dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentservice.capstone.model.Student;

@Repository
@Transactional
public interface StudentRepo extends JpaRepository<Student, Integer> {
	public Optional<Student>  findByStudentEmailId(String emailId);
	public Optional<Student>  findBystudentRoll(int roll);

}
