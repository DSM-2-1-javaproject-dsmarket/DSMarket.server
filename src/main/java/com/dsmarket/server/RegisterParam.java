package com.dsmarket.server;

public class RegisterParam
{
	String id, pw, nickname, email;

	public String getId() 
	{
		return id;
	}
	public void setId(String id) 
	{
		this.id = id;
	}

	public String getPw() 
	{
		return pw;
	}
	public void setPw(String pw) 
	{
		this.pw = pw;
	}

	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}