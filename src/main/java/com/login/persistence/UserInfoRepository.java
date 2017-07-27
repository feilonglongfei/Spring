package com.login.persistence;

import java.util.List;

import com.login.model.UserInfo;

public interface UserInfoRepository {
	
	public UserInfo getUserInfoById(String userId);
	
	public List<String> getAllUserName();
	
	public UserInfo getUserInfobyUserID(String userId);
	
	public void saveUserInfo(UserInfo userInfo);
	
	public void saveUserInfo_1(UserInfo userInfo);
	
	public void addUserInfo(UserInfo userInfo);

}
