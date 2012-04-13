package com.epam.publicenemies.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.epam.publicenemies.dto.FighterDto;
import com.epam.publicenemies.dto.GameDto;
import com.epam.publicenemies.dto.ProfileDto;
import com.epam.publicenemies.dto.StatsDto;
import com.epam.publicenemies.dto.UserDto;
import com.epam.publicenemies.service.IProfileManagerService;
import com.epam.publicenemies.service.IStatsManagerService;
import com.epam.publicenemies.web.memory.FightsHashMap;
import com.epam.publicenemies.web.validators.RegisterUserFormValidator;

@SuppressWarnings("deprecation")
public class NewGameFormController extends SimpleFormController {
	private Logger log = Logger.getLogger(RegisterUserFormValidator.class);
	private FightsHashMap fights;
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


	public void setFights(FightsHashMap fights) {
		this.fights = fights;
	}

	public ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException e)
			throws ServletException {
		HttpSession session = request.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		ProfileDto profile = profileManagerService.getProfileByUser(user);
		StatsDto stats = statsManagerService.getStatsByUser(user);
		GameDto game = new GameDto();
		
		FighterDto fighter = new FighterDto();
		
		fighter.setAvatar(profile.getAvatar());
		fighter.setHealth(stats.getStrength()*20);
		fighter.setId(user.getId());
		fighter.setNickName(profile.getNickName());
		
		game.setName(((GameDto) command).getName());
		game.setFighterFirst(fighter);
		game.setStarted(false);
		
		if(fights.containsKey(game)){
			return new ModelAndView(new RedirectView("newJoinGame.html"));
		}
		
		fights.put(game, null);
		log.info("GAME = " + game.getName() + " SUCCESSFULLY CREATED BY USER = "+fighter.getNickName());
		return new ModelAndView(new RedirectView(getSuccessView()));
	}

	protected Object formBackingObject(HttpServletRequest request)
			throws ServletException {
		GameDto game = new GameDto();
		return game;
	}
}
