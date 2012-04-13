package com.epam.publicenemies.domain;


public class Inventory {

	private long id;
	private int armor;
	private int weapon1;
	private int weapon2;
	private int aid;

	public Inventory() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public int getWeapon1() {
		return weapon1;
	}

	public void setWeapon1(int weapon1) {
		this.weapon1 = weapon1;
	}

	public int getWeapon2() {
		return weapon2;
	}

	public void setWeapon2(int weapon2) {
		this.weapon2 = weapon2;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

}