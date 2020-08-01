package com.ecommerce.shoes.sporty.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.shoes.sporty.model.User;
import com.ecommerce.shoes.sporty.model.UserDataInput;
import com.ecommerce.shoes.sporty.repository.UserRepository;
import com.ecommerce.shoes.sporty.service.iface.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	public int updateUser(UserDataInput userDataInput) {
		User user = new User();
		user.setFirstName(userDataInput.getFirstName());
		user.setLastName(userDataInput.getLastName());
		user.setPassword(userDataInput.getPassword());
		user.setEmail(userDataInput.getEmail());
		return userRepository.update(user);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public Optional<User> getUserByEmail(UserDataInput userDataInput){
		return userRepository.findByEmail(userDataInput.getEmail());
	}

}
