package com.epam.publicenemies.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.epam.publicenemies.dto.GameDto;
import com.epam.publicenemies.dto.UserDto;
import com.epam.publicenemies.web.memory.FightsHashMap;
import com.epam.publicenemies.web.validators.RegisterUserFormValidator;

public class FightPageFormController extends AbstractController {
	private Logger log = Logger.getLogger(RegisterUserFormValidator.class);
	private FightsHashMap fights;

	public void setFights(FightsHashMap fights) {
		this.fights = fights;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (CheckUserInSession.isUserInSession(request) == false) {
			return new ModelAndView("index");
		}
		GameDto game = new GameDto();
		UserDto user = new UserDto();

		HttpSession session = request.getSession();
		user = (UserDto) session.getAttribute("user");

		game = fights.getGame(user.getId());
		
		Map<String, String> model = new HashMap<String, String>();
		model.put("fighter1_nickName", game.getFighterFirst().getNickName());
		model.put("fighter1_avatar", game.getFighterFirst().getAvatar());
		model.put("fighter1_health", String.valueOf(game.getFighterFirst().getHealth()));
		model.put("fighter2_nickName", game.getFighterSecond().getNickName());
		model.put("fighter2_avatar", game.getFighterSecond().getAvatar());
		model.put("fighter2_health", String.valueOf(game.getFighterSecond().getHealth()));
		log.info("FIGHT PAGE CREATED IN GAME = "+game.getName()+" FOR " + user.getEmail());
		return new ModelAndView("fightPage",model);
	}
}