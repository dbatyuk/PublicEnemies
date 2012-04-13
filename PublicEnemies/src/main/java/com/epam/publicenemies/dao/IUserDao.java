package com.epam.publicenemies.dao;

import java.util.List;

import com.epam.publicenemies.domain.User;

public interface IUserDao {
	void registerUser(User user);

	User findUserById(long id);

	User findUserByEmailAndPassword(String email, String password);

	User findUserByEmail(String email);

	void updateUserEmailAndPassword(User user);

	void deleteUser(User user);

	List<User> findAllUsers();
}
