package com.epam.publicenemies.service;

import com.epam.publicenemies.dto.UserDTO;

public interface IUserManagerService {
	UserDTO registerNewUser(UserDTO userDTO);

	UserDTO findUserByEmail(String email);

	UserDTO getUserByEmailAndPassword(String name, String password);
}
