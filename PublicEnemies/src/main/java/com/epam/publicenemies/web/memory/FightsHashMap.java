package com.epam.publicenemies.web.memory;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import com.epam.publicenemies.dto.GameDto;
import com.epam.publicenemies.dto.HitDto;

public class FightsHashMap extends HashMap<GameDto, HitDto> {
	private static final long serialVersionUID = -1071171793057015824L;

	@Override
	public boolean containsKey(Object key) {
		Set<GameDto> keys = (Set<GameDto>) this.keySet();
		for (GameDto i : keys) {
			if (i.equals(key))
				return true;
		}
		return false;
	}

	@Override
	public HitDto get(Object key) {
		Set<Entry<GameDto, HitDto>> entry = this.entrySet();
		for (Entry<GameDto, HitDto> e : entry) {
			if (e.getKey().equals(key)) {
				return e.getValue();
			}
		}
		return null;
	}

	public GameDto removeKey(Object key) {
		Set<Entry<GameDto, HitDto>> entry = this.entrySet();
		GameDto keySaved = new GameDto();
		for (Entry<GameDto, HitDto> e : entry) {
			if (e.getKey().equals(key)) {
				keySaved = e.getKey();
				entry.remove(e);
				return keySaved;
			}
		}
		return null;
	}

	public GameDto getGame(long id) {
		Set<GameDto> keys = (Set<GameDto>) this.keySet();
		for (GameDto key : keys) {
			if (key.getFighterFirst().getId() == id	|| key.getFighterSecond().getId() == id)
				return key;
		}
		return null;
	}
}
