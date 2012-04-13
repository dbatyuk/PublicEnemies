package com.epam.publicenemies.dao;

import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.domain.User;

public interface IProfileDao {
	void saveProfile(Profile profile,User user);
	
	Profile getProfileByUser(User user);

	void updateProfile(Profile profile);
	
	void deleteProfile(Profile profile);
}
