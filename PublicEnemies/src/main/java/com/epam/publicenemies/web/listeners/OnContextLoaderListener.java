package com.epam.publicenemies.web.listeners;

import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;

public class OnContextLoaderListener extends ContextLoaderListener  {

	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		
//		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
//		CreateTableController bean = context.getBean(CreateTableController.class);
//		bean.createAllTables();
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		super.contextDestroyed(event);
	}
}
