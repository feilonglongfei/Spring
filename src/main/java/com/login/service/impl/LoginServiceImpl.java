package com.login.service.impl;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.model.UserInfo;
import com.login.persistence.UserInfoRepository;
import com.login.service.LoginService;

@Service("LoginService")
public class LoginServiceImpl implements LoginService {

	private static Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Autowired
	UserInfoRepository userInfoRepository;
	
	public UserInfo getUserInfo() {
		logger.info("LoginServiceImpl.getUserInfo() be called.");
		UserInfo userInfo = new UserInfo("user01", "password01");
		userInfoRepository.getUserInfoById("user01");
		return userInfo;
	}

	public List<String> getAllUserName() {
		logger.info("LoginServiceImpl.getAllUserName() be called.");
		return userInfoRepository.getAllUserName();
	}
	
	public UserInfo getUserInfobyUserID(String userId){
		logger.info("LoginServiceImpl.getUserInfobyID() be called.");
		return userInfoRepository.getUserInfobyUserID(userId);
	}
	
	public void saveUserInfo(UserInfo userInfo) {
		logger.info("LoginServiceImpl.saveUserInfo() be called.");
		userInfoRepository.saveUserInfo(userInfo);
		userInfoRepository.saveUserInfo_1(new UserInfo("userSave1", "userSave1", "userSave1"));
	}
	
	public void addUserInfo(UserInfo userInfo){
		logger.info("LoginServiceImpl.addUserInfo() be called.");
		userInfoRepository.addUserInfo(userInfo);
	}
	
	public void throwException() throws Exception{
//		throw new RuntimeException("throw runtime exception at LoginServiceImpl.throwException()...");
//		throw new Exception("throw runtime exception at LoginServiceImpl.throwException()...");
//		throw new Error("throw Error at LoginServiceImpl.throwException()...");
		throw new RuntimeErrorException(new Error("this is an error throw..."));
	}
	
}
