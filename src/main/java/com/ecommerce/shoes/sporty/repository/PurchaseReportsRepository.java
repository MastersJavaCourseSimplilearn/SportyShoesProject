package com.ecommerce.shoes.sporty.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.ecommerce.shoes.sporty.enums.ProductCategory;
import com.ecommerce.shoes.sporty.model.PurchaseReports;

@Repository
public class PurchaseReportsRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class PurchaseReportsRowMapper implements RowMapper<PurchaseReports>{
		public PurchaseReports mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
			PurchaseReports purchaseReports = new PurchaseReports();
			purchaseReports.setId(resultSet.getLong("id"));
			purchaseReports.setUserName(resultSet.getString("user_name"));
			purchaseReports.setUserEmail(resultSet.getString("user_email"));
			purchaseReports.setProductName(resultSet.getString("product_name"));
			purchaseReports.setProductDescription(resultSet.getString("product_description"));
			purchaseReports.setProductPrice(resultSet.getInt("product_price"));
			purchaseReports.setProductCategory(ProductCategory.getProductCategory(resultSet.getString("product_category")));
			purchaseReports.setCreatedAt(resultSet.getDate("created_at"));
			purchaseReports.setUpdatedAt(resultSet.getDate("updated_at"));
			return purchaseReports;
		}
	}
	
	public Optional <PurchaseReports> findByCategoryAndCreationDate(Date creationDate, String productCategory){
		return Optional.of(jdbcTemplate.queryForObject("select * from demo.purchase_reports where product_category = ? and created_at >= ?"
				, new Object[] {
					productCategory, creationDate	
				}, new BeanPropertyRowMapper<PurchaseReports> (PurchaseReports.class)));
	}

}
