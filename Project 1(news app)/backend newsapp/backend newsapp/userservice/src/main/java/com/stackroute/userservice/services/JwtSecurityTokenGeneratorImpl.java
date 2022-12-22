
package com.stackroute.userservice.services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.stackroute.userservice.model.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Service
public class JwtSecurityTokenGeneratorImpl implements SecurityTokenGenerator {

	@Override
	public Map<String, String> generateToken(User user) {
		String uname=user.getFirstName().substring(0,1).toUpperCase()+user.getFirstName().substring(1,user.getFirstName().length())+" "+user.getLastName().substring(0,1).toUpperCase()+user.getLastName().substring(1,user.getLastName().length());
		String jwtToken = "";
		jwtToken = Jwts.builder().setSubject(user.getUserId()).setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS384, "secretkey").compact();
		Map<String, String> map = new HashMap<>();
		map.put("token", jwtToken);
		map.put("message", "User successfully logged in");
		map.put("uname", uname);
		
		return map;
	}

}
