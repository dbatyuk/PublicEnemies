package com.epam.publicenemies.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * @author Alexander Ivanov
 * @since 11 квіт. 2012
 */
public class SessionFilter implements Filter
{
	Logger	log	= Logger.getLogger(SessionFilter.class);
	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException
	{
		HttpSession session = ((HttpServletRequest) request).getSession();
		if (session.getAttribute("user") != null)
		{
			log.info("USER IS LOGGED FROM FILTER");
			chain.doFilter(request, response);
		}
		else
		{
			log.info("USER IS NOT LOGGED  -  REDIRECT FROM FILTER");
			((HttpServletResponse) response).sendRedirect("userLogin.html");
		}
	}
	@Override
	public void destroy()
	{
	}
}
