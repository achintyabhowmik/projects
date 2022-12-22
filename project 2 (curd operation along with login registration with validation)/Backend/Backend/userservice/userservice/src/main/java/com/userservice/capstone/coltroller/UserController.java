package com.userservice.capstone.coltroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.capstone.exception.UserAlreadyExistsException;
import com.userservice.capstone.exception.UserNotFoundException;
import com.userservice.capstone.model.User;
import com.userservice.capstone.services.JwtToken;
import com.userservice.capstone.services.UserServices;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserServices service;
	@Autowired
	JwtToken jwtToken;
	
	@PostMapping("/register")
	public ResponseEntity<?> RegisterUser(@RequestBody User user)
	{
		
		ResponseEntity<String> entity=new ResponseEntity<String>("Filed Empty",HttpStatus.BAD_REQUEST);
	   if(user.getUserEmail()!=null&&user.getFirstName()!=null&&user.getLastName()!=null&&user.getUserPassword()!=null)
	   {
		   try
		   {
			   service.saveUser(user);
			   return new ResponseEntity<String>("User registered successfully", HttpStatus.CREATED);
		   }
		   catch(UserAlreadyExistsException e)
		   {
			   return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		   }
	   }
	   return  entity;
	}
	@PostMapping("/login")
	public ResponseEntity<?> LoginUser(@RequestBody User user)
	{
		
		ResponseEntity<String> entity=new ResponseEntity<String>("User email or password Empty",HttpStatus.BAD_REQUEST);
	   if(user.getUserEmail()!=null&&user.getUserPassword()!=null)
	   {
		   try
		   {
			  User userobj= service.findByUserIdAndPassword(user);
			  Map<String,String>map=jwtToken.jwtToken(userobj);
			   return new ResponseEntity<Map<String,String>>(map, HttpStatus.ACCEPTED);
		   }
		   catch(UserNotFoundException e)
		   {
			   return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		   }
	   }
	   return  entity;
	}

}
