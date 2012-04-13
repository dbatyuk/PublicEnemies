package com.epam.publicenemies.dto;

public class HitDto {
	private long userId;
	private int toHit;
	private int toBlock;
	public int getToHit() {
		return toHit;
	}
	public void setToHit(int toHit) {
		this.toHit = toHit;
	}
	public int getToBlock() {
		return toBlock;
	}
	public void setToBlock(int toBlock) {
		this.toBlock = toBlock;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
}
