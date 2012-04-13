package com.epam.publicenemies.service.impl;

import com.epam.publicenemies.dao.IProfileDao;
import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.domain.User;
import com.epam.publicenemies.dto.ProfileDto;
import com.epam.publicenemies.dto.UserDto;
import com.epam.publicenemies.service.IProfileManagerService;

public class ProfileManagerServiceImpl implements IProfileManagerService {

	private IProfileDao profileDao;

	public void setProfileDao(IProfileDao profileDao) {
		this.profileDao = profileDao;
	}

	private ProfileDto makeProfileDTO(Profile profile) {
		ProfileDto profileDTO = new ProfileDto();
		profileDTO.setId(profile.getId());
		profileDTO.setAvatar(profile.getAvatar());
		profileDTO.setNickName(profile.getNickName());
		profileDTO.setProffesion(profile.getProffesion());
		profileDTO.setGender(profile.getGender());
		profileDTO.setFightsTotal(profile.getFightsTotal());
		profileDTO.setFightsWon(profile.getFightsWon());
		return profileDTO;
	}

	@Override
	public ProfileDto saveProfile(ProfileDto profileDto, UserDto userDto) {
		Profile profile = new Profile();
		User user = new User();

		user.setId(userDto.getId());

		profile.setId(profileDto.getId());
		profile.setAvatar(profileDto.getAvatar());
		profile.setGender(profileDto.getGender());
		profile.setNickName(profileDto.getNickName());
		profile.setProffesion(profileDto.getProffesion());

		profileDao.saveProfile(profile, user);
		return profileDto;
	}

	@Override
	public ProfileDto getProfileByUser(UserDto userDto) {
		User user = new User();
		user.setId(userDto.getId());

		Profile profile = profileDao.getProfileByUser(user);
		if (profile == null)
			return null;
		return makeProfileDTO(profile);
	}
}
