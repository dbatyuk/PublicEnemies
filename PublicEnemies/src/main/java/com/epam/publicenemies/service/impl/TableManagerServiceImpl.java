package com.epam.publicenemies.service.impl;

import com.epam.publicenemies.dao.ITableDao;
import com.epam.publicenemies.service.ITableManagerService;

public class TableManagerServiceImpl implements ITableManagerService {
	private ITableDao tableDao;

	public void setTableDao(ITableDao tableDao) {
		this.tableDao = tableDao;
	}

	@Override
	public void createUserTable() {
		tableDao.createUserTable();
	}

	@Override
	public void createProfileTable() {
		tableDao.createProfileTable();
	}

	@Override
	public void createStatsTable() {
		tableDao.createStatsTable();
	}

	@Override
	public void createInventoryTable() {
		tableDao.createInventoryTable();
	}

	@Override
	public void createTrunkTable() {
		tableDao.createTrunkTable();
	}

	@Override
	public void createWeaponsTable() {
		tableDao.createWeaponsTable();
	}

	@Override
	public void createArmorsTable() {
		tableDao.createArmorsTable();
	}

	@Override
	public void createAidsTable() {
		tableDao.createAidsTable();
	}

}
