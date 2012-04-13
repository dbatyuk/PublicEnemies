package com.epam.publicenemies.web.validators;

import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.epam.publicenemies.dto.UserDTO;
import com.epam.publicenemies.service.IUserManagerService;

public class RegisterUserFormValidator implements Validator
{
	private Logger				log	= Logger.getLogger(RegisterUserFormValidator.class);
	private IUserManagerService	userManagerService;
	public void setUserManagerService(IUserManagerService userManagerService)
	{
		this.userManagerService = userManagerService;
	}
	public boolean supports(Class<?> clazz)
	{
		return clazz.equals(UserDTO.class);
	}
	public void validate(Object obj, Errors errors)
	{
		log.info("VALIDATING...");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty");
		UserDTO user = (UserDTO) obj;
		UserDTO userDTO = userManagerService.findUserByEmail(user.getEmail());
		if (userDTO != null)
		{
			log.error("USER WITH EMAIL: " + user.getEmail() + " ALREADY EXISTS");
			errors.rejectValue("email", "user.exist");
		}
	}
}
