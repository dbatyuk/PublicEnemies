package com.epam.publicenemies.web.listeners;

import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.epam.publicenemies.web.CreateTableController;

public class OnContextLoaderListener extends ContextLoaderListener  {

	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
		CreateTableController bean = context.getBean(CreateTableController.class);
		bean.createAllTables();
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		super.contextDestroyed(event);
	}


}
