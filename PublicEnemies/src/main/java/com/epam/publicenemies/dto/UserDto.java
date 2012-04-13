package com.epam.publicenemies.dto;

import java.io.Serializable;

public class UserDto implements Serializable
{
	private static final long	serialVersionUID	= -5337809704733811878L;
	private long				id;
	private String				email;
	private String				password;
	public long getId()
	{
		return id;
	}
	public String getEmail()
	{
		return email;
	}
	public String getPassword()
	{
		return password;
	}
	public void setId(long id)
	{
		this.id = id;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
}
