package com.epam.publicenemies.service;

import com.epam.publicenemies.dto.ProfileDto;
import com.epam.publicenemies.dto.UserDto;

public interface IProfileManagerService {
	ProfileDto saveProfile(ProfileDto profileDto,UserDto userDto);

	ProfileDto getProfileByUser(UserDto userDto);

}
