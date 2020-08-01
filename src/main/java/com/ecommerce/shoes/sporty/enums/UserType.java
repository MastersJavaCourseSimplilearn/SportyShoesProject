package com.ecommerce.shoes.sporty.enums;

public enum UserType {
    ADMIN,NORMAL;
    
    public static UserType getUserType(String userTypeString) {
    	return UserType.valueOf(userTypeString);
    }
}
