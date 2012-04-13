package com.epam.publicenemies.service.impl;

import com.epam.publicenemies.dao.IUserDao;
import com.epam.publicenemies.domain.User;
import com.epam.publicenemies.dto.UserDto;
import com.epam.publicenemies.service.IUserManagerService;

public class UserManagerServiceImpl implements IUserManagerService {
	private IUserDao userDao;

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	private UserDto makeUserDto(User user) {
		UserDto userDTO = new UserDto();
		userDTO.setId(user.getId());
		userDTO.setEmail(user.getEmail());
		userDTO.setPassword(user.getPassword());
		return userDTO;
	}

	@Override
	public UserDto registerNewUser(UserDto userDTO) {
		User user = new User();
		user.setId(userDTO.getId());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		userDao.registerUser(user);
		return userDTO;
	}

	@Override
	public UserDto getUserByEmailAndPassword(String name, String password) {
		User user = userDao.findUserByEmailAndPassword(name, password);
		if (user == null)
			return null;
		return makeUserDto(user);
	}

	@Override
	public UserDto findUserByEmail(String email) {
		User user = userDao.findUserByEmail(email);
		if (user == null)
			return null;
		return makeUserDto(user);
	}
}
