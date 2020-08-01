package com.ecommerce.shoes.sporty.model;

import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.ecommerce.shoes.sporty.enums.UserType;

public class UserTest {
	
	@Test
	public void user() {
		Date createdAt = new Date();
		Date updatedAt = new Date();
		User user = new User();
		user.setId(1L);
		user.setFirstName("Sumit");
		user.setLastName("Jui");
		user.setMobile("2938798274");
		user.setUserType(UserType.ADMIN);
		user.setCreatedAt(createdAt);
		user.setUpdatedAt(updatedAt);
		assertEquals(1L, user.getId());
		assertEquals("Sumit", user.getFirstName());
		assertEquals("Jui", user.getLastName());
		assertEquals("2938798274", user.getMobile());
		assertEquals(UserType.ADMIN, user.getUserType());
		assertEquals(createdAt, user.getCreatedAt());
		assertEquals(updatedAt, user.getUpdatedAt());
	}

}
