package com.epam.publicenemies.dto;

public class ProfileDto {

	private long id;
	private String nickName;
	private String avatar;
	private String gender;
	private int proffesion;
	private int fightsTotal;
	private int fightsWon;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getProffesion() {
		return proffesion;
	}
	public void setProffesion(int proffesion) {
		this.proffesion = proffesion;
	}
	public int getFightsTotal() {
		return fightsTotal;
	}
	public void setFightsTotal(int fightsTotal) {
		this.fightsTotal = fightsTotal;
	}
	public int getFightsWon() {
		return fightsWon;
	}
	public void setFightsWon(int fightsWon) {
		this.fightsWon = fightsWon;
	}

}
