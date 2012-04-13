package com.epam.publicenemies.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.epam.publicenemies.dto.UserDto;
import com.epam.publicenemies.service.IUserManagerService;

@SuppressWarnings("deprecation")
public class RegisterUserFormController extends SimpleFormController
{
	private Logger	log	= Logger.getLogger(RegisterUserFormController.class);
	private IUserManagerService	userManagerService;
	public void setUserManagerService(IUserManagerService userManagerService)
	{
		this.userManagerService = userManagerService;
	}
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors)
			throws Exception
	{
		UserDto user = userManagerService.registerNewUser((UserDto) command);
		user = userManagerService.findUserByEmail(user.getEmail());
		request.getSession().setAttribute("user", user);
		log.info("NEW USER REGISTERED: EMAIL:" + user.getEmail() + " PASS:" + user.getPassword());
		return new ModelAndView(new RedirectView(getSuccessView()));
	}
	@Override
	protected Object formBackingObject(HttpServletRequest request) throws Exception
	{
		return new UserDto();
	}
}
