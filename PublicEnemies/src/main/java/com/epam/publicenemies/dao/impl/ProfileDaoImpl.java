package com.epam.publicenemies.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.epam.publicenemies.dao.IProfileDao;
import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.domain.User;

public class ProfileDaoImpl implements IProfileDao {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveProfile(Profile profile,User user) {
		String query = "INSERT INTO profile (id,nickName,avatar,gender,proffesion,userId) VALUES (?,?,?,?,?,?)";
		jdbcTemplate.update(query,
				new Object[] {0, profile.getNickName(), profile.getAvatar(),
						profile.getGender(), profile.getProffesion(),user.getId() });
	}

	@Override
	public Profile getProfileByUser(User user) {
		String query = "SELECT nickName,avatar,gender,proffesion,fightsTotal,fightsWon,userId FROM profile WHERE userId = ?";
		List<Profile> list = jdbcTemplate.query(query, new Object[] { user.getId() },
				new BeanPropertyRowMapper<Profile>(Profile.class));
		if (list.isEmpty())
			return null;
		return list.get(0);
	}

	@Override
	public void updateProfile(Profile profile) {
		String query = "UPDATE profile SET nickName=?,avatar=?,gender=?,proffesion=?,fightsTotal=?,fightsWon=? WHERE id = ?";
		jdbcTemplate.update(
				query,
				new Object[] { profile.getNickName(), profile.getAvatar(),
						profile.getGender(), profile.getProffesion(),
						profile.getFightsTotal(), profile.getFightsWon() });

	}

	@Override
	public void deleteProfile(Profile profile) {
		String query = "DELETE FROM profile WHERE id = ?";
		jdbcTemplate.update(query, new Object[] { profile.getId() });
	}

}
