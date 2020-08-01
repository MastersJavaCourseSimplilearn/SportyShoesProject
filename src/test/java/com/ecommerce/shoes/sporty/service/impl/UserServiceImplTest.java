package com.ecommerce.shoes.sporty.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.util.ReflectionTestUtils;
import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doReturn;
import com.ecommerce.shoes.sporty.model.User;
import com.ecommerce.shoes.sporty.model.UserDataInput;
import com.ecommerce.shoes.sporty.repository.UserRepository;

public class UserServiceImplTest {
	
	@Mock
	UserServiceImpl userServiceImpl;
	
	@InjectMocks
	UserRepository userRepository;
	
	@BeforeEach()
	public void init() {
		userServiceImpl = new UserServiceImpl();
		userRepository = mock(UserRepository.class);
		ReflectionTestUtils.setField(userServiceImpl, "userRepository", userRepository);
	}
	
	@Test
	public void updateUser() {
		doReturn(1).when(userRepository).update(any(User.class));
		assertEquals(1, userServiceImpl.updateUser(getSampleUserDataInput()));
	}
	
	@Test
	public void updateNonExistingUser() {
		doReturn(0).when(userRepository).update(any(User.class));
		assertEquals(0, userServiceImpl.updateUser(getSampleUserDataInput()));
	}
	
	private UserDataInput getSampleUserDataInput() {
		UserDataInput userDataInput = new UserDataInput();
		userDataInput.setEmail("sumitjui@gmail.com");
		userDataInput.setFirstName("sumit");
		userDataInput.setLastName("jui");
		userDataInput.setPassword("2984jsjdflj");
		return userDataInput;
	}
	

}
