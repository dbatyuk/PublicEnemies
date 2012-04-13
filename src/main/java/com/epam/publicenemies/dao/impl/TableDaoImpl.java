package com.epam.publicenemies.dao.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.epam.publicenemies.dao.ITableDao;

public class TableDaoImpl implements ITableDao {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void createUserTable() {
		String query = "DROP TABLE IF EXISTS `user`;";
		jdbcTemplate.execute(query);
		query = "CREATE  TABLE `user` (`id` INT NOT NULL AUTO_INCREMENT ,`email` VARCHAR(45) NOT NULL ,`password` VARCHAR(45) NOT NULL ,PRIMARY KEY (`id`));";
		jdbcTemplate.execute(query);
	}

	@Override
	public void createProfileTable() {
		String query = "DROP TABLE IF EXISTS `profile`;";
		jdbcTemplate.execute(query);
		query = "CREATE TABLE `profile` (`id` int(11) NOT NULL AUTO_INCREMENT,`nickName` varchar(45) NOT NULL,`avatar` varchar(45) NOT NULL,`gender` varchar(45) NOT NULL,`proffesion` int(11) NOT NULL,`fightsTotal` int(11) NOT NULL,`fightsWon` int(11) NOT NULL,PRIMARY KEY (`id`));";
		jdbcTemplate.execute(query);
	}

	@Override
	public void createStatsTable() {
		String query = "DROP TABLE IF EXISTS `stats`;";
		jdbcTemplate.execute(query);
		query = "CREATE TABLE `stats` (`id` int(11) NOT NULL AUTO_INCREMENT,`strength` int(11) NOT NULL,`agility` int(11) NOT NULL,`stat3` int(11) NOT NULL,`money` int(11) NOT NULL,`experience` int(11) NOT NULL,`level` int(11) NOT NULL,PRIMARY KEY (`id`));";
		jdbcTemplate.execute(query);
	}

	@Override
	public void createInventoryTable() {
		String query = "DROP TABLE IF EXISTS `inventory`;";
		jdbcTemplate.execute(query);
		query = "CREATE TABLE `inventory` (`id` int(11) NOT NULL AUTO_INCREMENT,`armor` int(11) NOT NULL,`weapon1` int(11) NOT NULL,`weapon2` int(11) NOT NULL,`aid` int(11) NOT NULL,PRIMARY KEY (`id`));";
		jdbcTemplate.execute(query);
	}

	@Override
	public void createTrunkTable() {
		String query = "DROP TABLE IF EXISTS `trunk`;";
		jdbcTemplate.execute(query);
		query = "CREATE TABLE `trunk` (`id` int(11) NOT NULL AUTO_INCREMENT,PRIMARY KEY (`id`));";
		jdbcTemplate.execute(query);
	}

	@Override
	public void createWeaponsTable() {
		String query = "DROP TABLE IF EXISTS `weapons`;";
		jdbcTemplate.execute(query);
		query = "CREATE TABLE `weapons` (`id` int(11) NOT NULL AUTO_INCREMENT,`price` int(11) NOT NULL,`image` varchar(45) NOT NULL,`damage` int(11) NOT NULL,PRIMARY KEY (`id`));";
		jdbcTemplate.execute(query);
	}

	@Override
	public void createArmorsTable() {
		String query = "DROP TABLE IF EXISTS `armors`;";
		jdbcTemplate.execute(query);
		query = " CREATE TABLE `armors` (`id` int(11) NOT NULL AUTO_INCREMENT,`price` int(11) NOT NULL,`image` varchar(45) NOT NULL,`defence` int(11) NOT NULL,PRIMARY KEY (`id`));";
		jdbcTemplate.execute(query);
	}

	@Override
	public void createAidsTable() {
		String query = "DROP TABLE IF EXISTS `aids`;";
		jdbcTemplate.execute(query);
		query = " CREATE TABLE `aids` (`id` int(11) NOT NULL AUTO_INCREMENT,`price` int(11) NOT NULL,`image` varchar(45) NOT NULL,`health` int(11) NOT NULL,PRIMARY KEY (`id`));";
		jdbcTemplate.execute(query);
	}

}
