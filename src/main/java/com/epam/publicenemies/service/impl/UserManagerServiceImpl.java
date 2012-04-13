package com.epam.publicenemies.service.impl;

import com.epam.publicenemies.dao.IUserDao;
import com.epam.publicenemies.domain.User;
import com.epam.publicenemies.dto.UserDTO;
import com.epam.publicenemies.service.IUserManagerService;

public class UserManagerServiceImpl implements IUserManagerService {
	private IUserDao userDao;

	public void setuserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	private UserDTO makeUserDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setEmail(user.getEmail());
		userDTO.setPassword(user.getPassword());
		return userDTO;
	}

	@Override
	public UserDTO registerNewUser(UserDTO userDTO) {
		User user = new User();
		user.setId(userDTO.getId());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		userDao.registerUser(user);
		return userDTO;
	}

	@Override
	public UserDTO getUserByEmailAndPassword(String name, String password) {
		User user = userDao.findUserByEmailAndPassword(name, password);
		if (user == null)
			return null;
		return makeUserDTO(user);
	}

	@Override
	public UserDTO findUserByEmail(String email) {
		User user = userDao.findUserByEmail(email);
		if (user == null)
			return null;
		return makeUserDTO(user);
	}
}
