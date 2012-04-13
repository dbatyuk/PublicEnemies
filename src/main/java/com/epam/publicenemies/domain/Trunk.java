package com.epam.publicenemies.domain;

import java.util.List;

public class Trunk {

	private long id;
	private List<Long> items;

	public Trunk() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Long> getItems() {
		return items;
	}

	public void setItems(List<Long> items) {
		this.items = items;
	}

}
