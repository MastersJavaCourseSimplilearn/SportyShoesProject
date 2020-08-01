package com.ecommerce.shoes.sporty.model;

import java.util.Date;

import com.ecommerce.shoes.sporty.enums.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	private Long id;
	private String name;
	private String description;
	private Integer price;
	private ProductCategory productCategory;
	private Date createdAt;
	private Date updatedAt;
}
