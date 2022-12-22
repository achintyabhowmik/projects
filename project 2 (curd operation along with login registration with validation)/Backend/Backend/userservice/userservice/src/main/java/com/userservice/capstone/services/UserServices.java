package com.userservice.capstone.services;

import org.springframework.stereotype.Service;

import com.userservice.capstone.exception.UserAlreadyExistsException;
import com.userservice.capstone.exception.UserNotFoundException;
import com.userservice.capstone.model.User;

@Service
public interface UserServices {

	public Boolean saveUser(User user) throws UserAlreadyExistsException;
	public User findByUserIdAndPassword(User user) throws UserNotFoundException;
	
}
