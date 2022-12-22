package com.studentservice.capstone.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Student {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
private int studentId;
private int studentRoll;
private String studentName;
private String studentDept;
private String studentPhoneNo;
private String studentEmailId;
@OneToOne(cascade = CascadeType.ALL)
private Address address;

}
