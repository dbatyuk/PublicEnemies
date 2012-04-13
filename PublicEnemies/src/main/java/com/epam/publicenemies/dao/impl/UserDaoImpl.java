package com.epam.publicenemies.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.epam.publicenemies.dao.IUserDao;
import com.epam.publicenemies.domain.User;

public class UserDaoImpl implements IUserDao {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void registerUser(User user) {
		String query = "INSERT INTO user (id,email,password) VALUES (?,?,?)";
		jdbcTemplate.update(query,
				new Object[] {0, user.getEmail(), user.getPassword() });
	}

	public User findUserById(long id) {
		String query = "SELECT id,email,password FROM user WHERE id=?";

		List<User> list = jdbcTemplate.query(query, new Object[] { id },
				new BeanPropertyRowMapper<User>(User.class));
		if (list.isEmpty())
			return null;
		return list.get(0);
	}

	public void updateUserEmailAndPassword(User user) {
		String query = "UPDATE user SET email=?, password=? WHERE id = ?";
		jdbcTemplate.update(
				query,
				new Object[] { user.getEmail(), user.getPassword(),
						user.getId() });

	}

	public void deleteUser(User user) {
		String query = "DELETE FROM user WHERE id = ?";
		jdbcTemplate.update(query, new Object[] { user.getId() });
	}

	public User findUserByEmailAndPassword(String email, String password) {
		String query = "SELECT id,email,password FROM user WHERE email=? AND password=?";

		List<User> list = jdbcTemplate.query(query, new Object[] { email,
				password }, new BeanPropertyRowMapper<User>(User.class));
		if (list.isEmpty())
			return null;
		return list.get(0);
	}

	public List<User> findAllUsers() {
		String query = "SELECT id,email,password FROM user";

		return jdbcTemplate.query(query, new RowMapper<User>() {
			public User mapRow(ResultSet resultSet, int rowNum)
					throws SQLException {
				return new User(resultSet.getLong("ID"), resultSet
						.getString("EMAIL"), resultSet.getString("PASSWORD"));
			}
		});
	}

	@Override
	public User findUserByEmail(String email) {
		String query = "SELECT id,email,password FROM user WHERE email=?";
		List<User> list = jdbcTemplate.query(query, new Object[] { email },
				new BeanPropertyRowMapper<User>(User.class));
		if (list.isEmpty())
			return null;
		return list.get(0);
	}
}