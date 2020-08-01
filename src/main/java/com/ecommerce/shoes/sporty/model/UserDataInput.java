package com.ecommerce.shoes.sporty.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDataInput {
	private String firstName;
	private String lastName;
	private String password;
	private String email;
}
