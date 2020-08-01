package com.ecommerce.shoes.sporty.model;

import java.util.Date;
import com.ecommerce.shoes.sporty.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private Long id;
    private String firstName;
	private String lastName;
	private String email;
	private String mobile;
	private String password;
	private UserType userType;
	private Date createdAt;
	private Date updatedAt;
}
