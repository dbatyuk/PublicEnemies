package com.epam.publicenemies.web;

import org.apache.log4j.Logger;

import com.epam.publicenemies.service.ITableManagerService;
import com.epam.publicenemies.web.listeners.OnContextLoaderListener;

public class CreateTableController {
	private Logger log = Logger.getLogger(OnContextLoaderListener.class);
	private ITableManagerService tableManagerService;

	public void setTableManagerService(ITableManagerService tableManagerService) {
		this.tableManagerService = tableManagerService;
	}

	public void createAllTables() {
		tableManagerService.createUserTable();
		log.info("TABLE = user SUCCESSFULLY ADDED");

		tableManagerService.createProfileTable();
		log.info("TABLE = profile SUCCESSFULLY ADDED");

		tableManagerService.createStatsTable();
		log.info("TABLE = stats SUCCESSFULLY ADDED");

		tableManagerService.createInventoryTable();
		log.info("TABLE = inventory SUCCESSFULLY ADDED");

		tableManagerService.createTrunkTable();
		log.info("TABLE = trunk SUCCESSFULLY ADDED");

		tableManagerService.createWeaponsTable();
		log.info("TABLE = weapons SUCCESSFULLY ADDED");
		
		tableManagerService.createArmorsTable();
		log.info("TABLE = armors SUCCESSFULLY ADDED");
		
		tableManagerService.createAidsTable();
		log.info("TABLE = aids SUCCESSFULLY ADDED");
	}
}
