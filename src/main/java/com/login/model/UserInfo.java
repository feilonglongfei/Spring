package com.login.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="USER_INFO")
public class UserInfo {
	
	@Id
	@Column(name="USER_ID")
	private String userId;

	@Column(name="USER_NAME")
	private String userName;

	@Column(name="PASSWORD")
	private String password;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public UserInfo() {

	}
	
	public UserInfo(String userId, String userName, String password) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}

	public UserInfo(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
