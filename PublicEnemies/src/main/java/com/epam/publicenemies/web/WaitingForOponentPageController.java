package com.epam.publicenemies.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.view.RedirectView;

import com.epam.publicenemies.dto.GameDto;
import com.epam.publicenemies.dto.UserDto;
import com.epam.publicenemies.web.memory.FightsHashMap;
import com.epam.publicenemies.web.validators.RegisterUserFormValidator;

public class WaitingForOponentPageController extends AbstractController {
	private Logger log = Logger.getLogger(RegisterUserFormValidator.class);
	private FightsHashMap fights;

	public void setFights(FightsHashMap fights) {
		this.fights = fights;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		GameDto game = new GameDto();
		UserDto user = new UserDto();

		HttpSession session = request.getSession();
		user = (UserDto) session.getAttribute("user");

		game = fights.getGame(user.getId());
		log.info(game.getFighterFirst().getNickName() + " WAITS FOR OPONENT!");
		if (game.isStarted()) {
			while (true)
				if (fights.get(game) == null)
					return new ModelAndView(new RedirectView("fightPage.html"));
		} else {
			while (true)
				if (game.getFighterSecond() != null)
					return new ModelAndView(new RedirectView("fightPage.html"));
		}
	}

}
