package com.ecommerce.shoes.sporty.service.iface;

import java.util.List;
import java.util.Optional;
import com.ecommerce.shoes.sporty.model.User;
import com.ecommerce.shoes.sporty.model.UserDataInput;

public interface UserService {
    public int updateUser(UserDataInput userDataInput);
	public List<User> getAllUsers();
	public Optional<User> getUserByEmail(UserDataInput userDataInput);
}
