package com.epam.publicenemies.service.impl;

import com.epam.publicenemies.dao.IStatsDao;
import com.epam.publicenemies.domain.Stats;
import com.epam.publicenemies.domain.User;
import com.epam.publicenemies.dto.StatsDto;
import com.epam.publicenemies.dto.UserDto;
import com.epam.publicenemies.service.IStatsManagerService;

public class StatsManagerServiceImpl implements IStatsManagerService{


	private IStatsDao statsDao;

	public void setStatsDao(IStatsDao statsDao) {
		this.statsDao = statsDao;
	}

	private StatsDto makeStatsDTO(Stats stats) {
		StatsDto statsDTO = new StatsDto();
		statsDTO.setId(stats.getId());
		statsDTO.setStrength(stats.getStrength());
		statsDTO.setAgility(stats.getAgility());
		statsDTO.setSTAT3(stats.getSTAT3());
		statsDTO.setMoney(stats.getMoney());
		statsDTO.setExperience(stats.getExperience());
		statsDTO.setLevel(stats.getLevel());
		return statsDTO;
	}

	
	@Override
	public StatsDto saveStats(StatsDto statsDto, UserDto userDto) {
		Stats stats = new Stats();
		User user = new User();
		
		stats.setId(statsDto.getId());
		stats.setStrength(3);
		stats.setAgility(3);
		stats.setSTAT3(3);
		
		user.setId(userDto.getId());
		statsDao.saveStats(stats, user);
		return statsDto;
	}

	@Override
	public StatsDto getStatsByUser(UserDto userDto) {
		User user = new User();
		user.setId(userDto.getId());
		
		Stats stats = statsDao.getStatsByUser(user);
		if (stats == null)
			return null;
		return makeStatsDTO(stats);
	}
}
