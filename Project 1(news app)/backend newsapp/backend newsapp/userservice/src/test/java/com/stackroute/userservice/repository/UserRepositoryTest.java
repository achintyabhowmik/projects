package com.stackroute.userservice.repository;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.stackroute.userservice.model.User;





@SpringBootTest

public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private User user;
	@Before
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Before
	public void  setUp() throws Exception {
		user = new User("John", "John Jeny", "Bob", "123456", new Date());
	}

	@Test
	public void testRegisterUserSuccess() {
		userRepository.save(user);
		Optional<User> object = userRepository.findById(user.getUserId());
		assertThat(object.get().equals(user));
	}
}
