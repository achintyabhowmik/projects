package com.userservice.capstone.dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.userservice.capstone.model.User;
@Repository
@Transactional
public interface UserRepo extends JpaRepository<User, Integer> {
	public Optional<User>  findByuserEmail(String emailId);
}
