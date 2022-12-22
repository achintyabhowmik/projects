package com.stackroute.userservice;

import org.junit.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit4.SpringRunner;
@TestInstance(Lifecycle.PER_CLASS)

@RunWith(SpringRunner.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)

public class UserServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

}

