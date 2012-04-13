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

import com.epam.publicenemies.dto.GameDto;
import com.epam.publicenemies.dto.HitDto;
import com.epam.publicenemies.dto.UserDto;
import com.epam.publicenemies.web.memory.FightsHashMap;
import com.epam.publicenemies.web.validators.RegisterUserFormValidator;

@SuppressWarnings("deprecation")
public class FightHitController extends SimpleFormController {
	private Logger log = Logger.getLogger(RegisterUserFormValidator.class);
	private FightsHashMap fights;
	private HitDto firstHit;

	public void setFights(FightsHashMap fights) {
		this.fights = fights;
	}

	public ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException e)
			throws ServletException {
		GameDto game = new GameDto();
		UserDto user = new UserDto();
		HitDto hit = new HitDto();

		HttpSession session = request.getSession();
		user = (UserDto) session.getAttribute("user");

		game = fights.getGame(user.getId());

		hit.setToBlock(((HitDto) command).getToBlock());
		hit.setToHit(((HitDto) command).getToBlock());
		hit.setUserId(user.getId());

		firstHit = fights.get(game);

		if (firstHit == null) {
			if (hit.getUserId() == game.getFighterFirst().getId()) {
				log.info("FIRST HIT IN GAME = " + game.getName()
						+ " MADE BY = " + game.getFighterFirst().getNickName());

			} else {
				log.info("FIRST HIT IN GAME = " + game.getName()
						+ " MADE BY = " + game.getFighterFirst().getNickName());

			}
			GameDto key = fights.removeKey(game);
			fights.put(key, hit);
			log.info(fights.get(key).getUserId());
			return new ModelAndView(new RedirectView("waitingForOponent.html"));
		} else if (firstHit != null) {
			if (hit.getUserId() == game.getFighterFirst().getId()) {
				log.info("SECOND HIT IN GAME = " + game.getName()
						+ " MADE BY = " + game.getFighterFirst().getNickName());

			} else {
				log.info("SECOND HIT IN GAME = " + game.getName()
						+ " MADE BY = " + game.getFighterFirst().getNickName());
			}

			if (firstHit.getToBlock() == hit.getToHit()) {
				log.info("FIRST HIT IN GAME = " + game.getName()
						+ " WAS BLOCKED");
			} else if (firstHit.getToBlock() != hit.getToHit()) {
				if (firstHit.getUserId() == game.getFighterFirst().getId()) {
					int health = game.getFighterFirst().getHealth();
					game.getFighterFirst().setHealth(health - 5);
				} else {
					int health = game.getFighterFirst().getHealth();
					game.getFighterSecond().setHealth(health - 5);
				}
				log.info("FIRST HIT IN GAME = " + game.getName()
						+ " WASN`T BLOCKED");
			}

			if (firstHit.getToHit() == hit.getToBlock()) {
				log.info("SECOND HIT IN GAME = " + game.getName()
						+ " WAS BLOCKED");
			} else if (firstHit.getToHit() != hit.getToBlock()) {
				if (hit.getUserId() == game.getFighterFirst().getId()) {
					int health = game.getFighterFirst().getHealth();
					game.getFighterFirst().setHealth(health - 5);
				} else {
					int health = game.getFighterFirst().getHealth();
					game.getFighterSecond().setHealth(health - 5);
				}
				log.info("SECOND HIT IN GAME = " + game.getName()
						+ " WASN`T BLOCKED");
			}
			GameDto key = fights.removeKey(game);
			fights.put(key, null);
		}
		return new ModelAndView(new RedirectView(getSuccessView()));
	}

	protected Object formBackingObject(HttpServletRequest request)
			throws ServletException {
		HitDto hit = new HitDto();
		return hit;
	}

}
