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
public class PurchaseReports {
	private Long id;
	private String userName;
	private String userEmail;
	private String productName;
	private String productDescription;
	private Integer productPrice;
	private ProductCategory productCategory;
	private Date createdAt;
	private Date updatedAt;
}

