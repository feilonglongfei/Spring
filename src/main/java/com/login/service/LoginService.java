package com.login.service;

import java.util.List;

import com.login.model.UserInfo;

public interface LoginService {
	
	public UserInfo getUserInfo();
	
	public List<String> getAllUserName();
	
	public UserInfo getUserInfobyUserID(String userId);
	
	public void saveUserInfo(UserInfo userInfo);
	
	public void addUserInfo(UserInfo userInfo);
	
	public void throwException() throws Exception;

}
