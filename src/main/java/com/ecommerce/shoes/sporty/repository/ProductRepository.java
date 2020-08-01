package com.ecommerce.shoes.sporty.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.ecommerce.shoes.sporty.enums.ProductCategory;
import com.ecommerce.shoes.sporty.model.Product;

@Repository
public class ProductRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class ProductRowMapper implements RowMapper<Product>{
		public Product mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
			Product product = new Product();
			product.setId(resultSet.getLong("id"));
			product.setName(resultSet.getString("name"));
			product.setDescription(resultSet.getString("description"));
			product.setPrice(resultSet.getInt("price"));
			product.setProductCategory(ProductCategory.getProductCategory(resultSet.getString("category")));
			product.setCreatedAt(resultSet.getDate("created_at"));
			product.setUpdatedAt(resultSet.getDate("updated_at"));
			return product;
		}
	}
	
	public int update(Product product) {
		return jdbcTemplate.update("Update product " + "set name = ?, description = ?, price = ? , category = ?" + "where id = ?",
				new Object[] {
						product.getName(), product.getDescription(), product.getPrice(), product.getProductCategory().toString(), 
						product.getId()
				});
	}

}
