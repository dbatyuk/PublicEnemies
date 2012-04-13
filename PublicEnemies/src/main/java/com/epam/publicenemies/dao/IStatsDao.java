package com.epam.publicenemies.dao;

import com.epam.publicenemies.domain.Stats;
import com.epam.publicenemies.domain.User;

public interface IStatsDao {
	void saveStats(Stats stats,User user);
	
	Stats getStatsByUser(User user);

	void updateStats(Stats stats);
	
	void deleteStats(Stats stats);

}
