package com.userservice.capstone.services;



import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.userservice.capstone.model.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Service
public class JwtToken {
	public Map<String, String> jwtToken(User user)
{     
	Map<String,String>map=new HashMap<>();
	String uname=user.getFirstName().substring(0,1).toUpperCase()+user.getFirstName().substring(1,user.getFirstName().length())+" "+user.getLastName().substring(0,1).toUpperCase()+user.getLastName().substring(1,user.getLastName().length());
			String token =Jwts.builder()
			.setIssuedAt(new  Date())
			.setSubject(user.getUserEmail())
			.signWith(SignatureAlgorithm.HS256, "crashcourceproject")
			 .compact();
			map.put("token", token);
			map.put("user", uname);
			return map;
}
}
