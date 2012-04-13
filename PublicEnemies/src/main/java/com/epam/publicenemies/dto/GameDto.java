package com.epam.publicenemies.dto;

public class GameDto {
	private String name;
	private FighterDto fighterFirst;
	private FighterDto fighterSecond;
	private Boolean started = Boolean.FALSE;

	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (other == this)
			return true;
		if (!(other instanceof GameDto))
			return false;
		GameDto otherGameDto = (GameDto) other;
		if (otherGameDto.getName().equals(this.getName()) && otherGameDto.isStarted().equals(this.isStarted()))
			return true;
		else
			return false;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean isStarted() {
		return started;
	}

	public void setStarted(Boolean started) {
		this.started = started;
	}

	public FighterDto getFighterSecond() {
		return fighterSecond;
	}

	public void setFighterSecond(FighterDto fighterSecond) {
		this.fighterSecond = fighterSecond;
	}

	public FighterDto getFighterFirst() {
		return fighterFirst;
	}

	public void setFighterFirst(FighterDto fighterFirst) {
		this.fighterFirst = fighterFirst;
	}

}
