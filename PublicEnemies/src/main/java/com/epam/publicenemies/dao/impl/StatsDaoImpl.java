package com.epam.publicenemies.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.epam.publicenemies.dao.IStatsDao;
import com.epam.publicenemies.domain.Stats;
import com.epam.publicenemies.domain.User;

public class StatsDaoImpl implements IStatsDao {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveStats(Stats stats, User user) {
		String query = "INSERT INTO stats (id,strength,agility,stat3,userId) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(
				query,
				new Object[] { 0,stats.getStrength(), stats.getAgility(),
						stats.getSTAT3(), user.getId() });
	}

	@Override
	public Stats getStatsByUser(User user) {
		String query = "SELECT strength,agility,stat3,money,experience,level,userId FROM stats WHERE userId = ?";
		List<Stats> list = jdbcTemplate.query(query,
				new Object[] { user.getId() },
				new BeanPropertyRowMapper<Stats>(Stats.class));
		if (list.isEmpty())
			return null;
		return list.get(0);
	}

	@Override
	public void updateStats(Stats stats) {
		String query = "UPDATE profile SET strength=?,agility=?,stat3=?,money=?,experience=?,level=? WHERE id = ?";
		jdbcTemplate.update(
				query,
				new Object[] { stats.getStrength(), stats.getAgility(),
						stats.getSTAT3(), stats.getMoney(),
						stats.getExperience(), stats.getLevel() });
	}

	@Override
	public void deleteStats(Stats stats) {
		String query = "DELETE FROM stats WHERE id = ?";
		jdbcTemplate.update(query, new Object[] { stats.getId() });
	}

}
