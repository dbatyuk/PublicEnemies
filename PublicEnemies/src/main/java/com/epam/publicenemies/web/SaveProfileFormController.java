package com.epam.publicenemies.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.epam.publicenemies.dto.ProfileDto;
import com.epam.publicenemies.dto.StatsDto;
import com.epam.publicenemies.dto.UserDto;
import com.epam.publicenemies.service.IProfileManagerService;
import com.epam.publicenemies.service.IStatsManagerService;

@SuppressWarnings("deprecation")
public class SaveProfileFormController extends SimpleFormController {

	private Logger log = Logger.getLogger(SaveProfileFormController.class);
	private IProfileManagerService profileManagerService;
	private IStatsManagerService statsManagerService;

	public void setProfileManagerService(
			IProfileManagerService profileManagerService) {
		this.profileManagerService = profileManagerService;
	}
	
	public void setStatsManagerService(
			IStatsManagerService statsManagerService) {
		this.statsManagerService = statsManagerService;
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		HttpSession session = request.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		
		ProfileDto profile = profileManagerService.saveProfile(((ProfileDto) command), user);
		statsManagerService.saveStats(new StatsDto(), user);
		log.info("NEW PROFILE SAVED: NICKNAME = " + profile.getNickName());
		return new ModelAndView(new RedirectView(getSuccessView()));
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		return new ProfileDto();
	}

}
