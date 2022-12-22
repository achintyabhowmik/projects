package com.stackroute.userservice.controller;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.userservice.model.User;
import com.stackroute.userservice.services.SecurityTokenGenerator;
import com.stackroute.userservice.services.UserServiceImpl;

@TestInstance(Lifecycle.PER_CLASS)

@WebMvcTest(UserController.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserControllerTest {


	private transient MockMvc mockMvc;

	@MockBean
	private transient UserServiceImpl userServiceImpl;

	@MockBean
	private SecurityTokenGenerator securityTokenGenerator;
	@Autowired
	private  User user;

	@InjectMocks
	private UserController controller;

	@Before(value = "")
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		user = new User("nantu1234", "Aruangshu", "sinha", "98765", new Date());
	}

	@Test
	public void testRegisterUser() throws Exception {
		when(userServiceImpl.saveUser(user)).thenReturn(true);
		mockMvc.perform(post("/api/v1/userservice/register").contentType(MediaType.APPLICATION_JSON)
				.content(jsonToString(user))).andExpect(status()
						.isCreated()).andDo(print());
		verify(userServiceImpl, times(1)).saveUser(Mockito.any(User.class));
		verifyNoMoreInteractions(userServiceImpl);
	}

	@Test
	public void testLoginUser() throws Exception {
		when(userServiceImpl.findByUserIdAndPassword(user.getUserId(),user.getPassword())).thenReturn(user);

		mockMvc.perform(post("/api/v1/userservice/login").contentType(MediaType.APPLICATION_JSON)
				.content(jsonToString(user))).andExpect(status().isOk());

		verify(userServiceImpl, times(1)).findByUserIdAndPassword(user.getUserId(), user.getPassword());
		verifyNoMoreInteractions(userServiceImpl);
	}
@Test
	private String jsonToString(final Object object) {
		String result;
		try {
			final ObjectMapper mapper = new ObjectMapper();
			result = mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			result = "Json processing error";
		}
		return result;
	}
}
