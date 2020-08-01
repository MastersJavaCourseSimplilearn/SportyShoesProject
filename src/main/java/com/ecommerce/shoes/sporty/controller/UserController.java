package com.ecommerce.shoes.sporty.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.shoes.sporty.model.User;
import com.ecommerce.shoes.sporty.model.UserDataInput;
import com.ecommerce.shoes.sporty.service.iface.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
   
	@Autowired
	UserService userService;
	
	@PutMapping(value = "updateUser")
	public int updateUser(@RequestBody UserDataInput userDataInput) {
		return userService.updateUser(userDataInput);
	}
	
	@GetMapping(value = "getUser")
	public User getUser(String authToken){
		return new User();
	}
	
	@GetMapping(value = "getAllUsers")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping(value = "healthCheck")
	public String healthCheck(){
		return "Ok!";
	}
	
	@GetMapping(value = "/getUserByEmail")
	public Optional<User> getUserByEmail(@RequestBody UserDataInput userDataInput){
		return userService.getUserByEmail(userDataInput);
	}
}
