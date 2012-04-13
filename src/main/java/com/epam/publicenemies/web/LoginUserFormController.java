package com.epam.publicenemies.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.epam.publicenemies.dto.UserDTO;
import com.epam.publicenemies.service.IUserManagerService;
import com.epam.publicenemies.web.validators.RegisterUserFormValidator;

@SuppressWarnings("deprecation")
public class LoginUserFormController extends SimpleFormController
{
	private Logger				log	= Logger.getLogger(RegisterUserFormValidator.class);
	private IUserManagerService	userManagerService;
	public void setUserManagerService(IUserManagerService userManagerService)
	{
		this.userManagerService = userManagerService;
	}
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException e)
			throws ServletException
	{
		String name = ((UserDTO) command).getEmail();
		String password = ((UserDTO) command).getPassword();
		UserDTO user = userManagerService.getUserByEmailAndPassword(name, password);
		log.info("USER = " + user.getEmail() + " SUCCESSFULLY LOGGED");
		request.getSession().setAttribute("user", user);
		return new ModelAndView(new RedirectView(getSuccessView()));
	}
	protected Object formBackingObject(HttpServletRequest request) throws ServletException
	{
		UserDTO user = new UserDTO();
		return user;
	}
}
