package com.ecommerce.shoes.sporty.enums;

public enum ProductCategory {
    RUNNING,TENNIS,BADMINTON,FOOTBALL,CRICKET;
    
    public static ProductCategory getProductCategory(String productCategoryString) {
    	return ProductCategory.valueOf(productCategoryString);
    }
}
