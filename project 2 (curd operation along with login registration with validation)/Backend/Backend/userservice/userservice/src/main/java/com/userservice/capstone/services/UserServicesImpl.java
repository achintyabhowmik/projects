package com.userservice.capstone.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userservice.capstone.dao.UserRepo;
import com.userservice.capstone.exception.UserAlreadyExistsException;
import com.userservice.capstone.exception.UserNotFoundException;
import com.userservice.capstone.model.User;

@Service
public class UserServicesImpl implements UserServices {
@Autowired
	private UserRepo userrepo;
	@Override
	public Boolean saveUser(User user) throws UserAlreadyExistsException {
		
		Optional<User>userObj=userrepo.findByuserEmail(user.getUserEmail());
		if(userObj.isPresent())
		{
			throw new UserAlreadyExistsException("User Already Exist");
			
		}
		userrepo.save(user);
		return true;
	}

	@Override
	public User findByUserIdAndPassword(User user) throws UserNotFoundException {
		User user1;
		Optional<User>userObj=userrepo.findByuserEmail(user.getUserEmail());
		if(userObj.isEmpty())
		{
			throw new UserNotFoundException("User Not Found");
		}
		else
		{
			user1=userObj.get();
		}
		if(!(user.getUserPassword().equals(user1.getUserPassword())))
		{
			throw new  UserNotFoundException("Password Mismatch");
		}
		return userObj.get();
	   
	}

	

}
