package com.ecommerce.shoes.sporty.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.ecommerce.shoes.sporty.enums.UserType;
import com.ecommerce.shoes.sporty.model.User;

@Repository
public class UserRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class UserRowMapper implements RowMapper<User>{
		public User mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
			User user = new User();
			user.setId(resultSet.getLong("id"));
			user.setFirstName(resultSet.getString("first_name"));
			user.setLastName(resultSet.getString("last_name"));
			user.setEmail(resultSet.getString("email"));
			user.setMobile(resultSet.getString("mobile"));
			user.setUserType(UserType.getUserType(resultSet.getString("user_type")));
			user.setPassword(resultSet.getString("password"));
			user.setCreatedAt(resultSet.getDate("created_at"));
			user.setUpdatedAt(resultSet.getDate("updated_at"));
			return user;
		}
	}
	
	public List<User> findAll(){
		return jdbcTemplate.query("select * from users", new UserRowMapper());
	}
	
	public Optional<User> findByEmail(String email){
		return Optional.of(jdbcTemplate.queryForObject("select * from users where email=?", new Object[] {
			email	
		}, new BeanPropertyRowMapper<User>(User.class)));
	}
	
	public int deleteByMail(String email) {
		return jdbcTemplate.update("delete from users where email=?", new Object[] {
				email
		});
	}
	
	public int insert(User user) {
		return jdbcTemplate.update("insert into users (id, first_name, last_name, email, password, mobile, user_type) " + "values(?,?,?,?,?,?,?)",
				new Object[] {
					user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getMobile(), user.getUserType().toString()
				});
	}
	
	public int update(User user) {
		return jdbcTemplate.update("Update users " + "set first_name = ?, last_name = ?, password = ? " + "where email = ?",
				new Object[] {
					user.getFirstName(), user.getLastName(), user.getPassword(), user.getEmail()
				});
	}
	
}
