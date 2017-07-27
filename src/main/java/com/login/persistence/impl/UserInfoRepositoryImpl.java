package com.login.persistence.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.login.model.UserInfo;
import com.login.persistence.UserInfoRepository;

@Repository("UserInfoRepository")
//@EnableCaching
public class UserInfoRepositoryImpl implements UserInfoRepository {
	
	private static Logger logger = LoggerFactory.getLogger(UserInfoRepositoryImpl.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	HibernateTemplate hibernateTemplate;

	/**
	 * test jdbcTemplate
	 */
	public UserInfo getUserInfoById(String userId) {
		logger.info("UserInfoRepositoryImpl.getUserInfoById() be called");
		
		String updateUserInfo = "update user_info set PASSWORD = 'updated' where user_id = 'user00'";
		int result = jdbcTemplate.update(updateUserInfo);
		logger.info(new Integer(result).toString());
		return null;
	}
	
	/**
	 * test namedParameterJdbcTemplate
	 */
	public List<String> getAllUserName() {
		logger.info("UserInfoRepositoryImpl.getUserInfoByName() be called");
		
		String selectUserInfo = "SELECT USER_Name FROM USER_INFO";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<String> userNames = namedParameterJdbcTemplate.queryForList(selectUserInfo, paramMap, String.class);
		return userNames;
	}
	
	
	/**
	 * test hibernateTemplate
	 */
//	@Cacheable(value="userInfos")
	public UserInfo getUserInfobyUserID(String userId){
		logger.info("UserInfoRepositoryImpl.getUserInfobyID() be called");
		
		UserInfo userInfo = hibernateTemplate.get(UserInfo.class, userId);
		
		return userInfo;
	}

	public void saveUserInfo(UserInfo userInfo) {
		logger.info("UserInfoRepositoryImpl.saveUserInfo() be called");
		
		String userId = (String) hibernateTemplate.save(userInfo);
		
		logger.info("below user info be saved into db: " + userId);
	}
	
	public void saveUserInfo_1(UserInfo userInfo) {
		logger.info("UserInfoRepositoryImpl.saveUserInfo() be called");
		
		String userId = (String) hibernateTemplate.save(userInfo);
		
		logger.info("below user info be saved into db: " + userId);
		
	}
	
	public void addUserInfo(UserInfo userInfo){
		logger.info("UserInfoRepositoryImpl.addUserInfo() be called");
		
//		String userId = (String) hibernateTemplate.save(userInfo);
		
		jdbcTemplate.execute("INSERT INTO USER_INFO VALUES('userNameForAdd', 'userNameForAdd', 'userNameForAdd')");
		
		throw new RuntimeException();
		
	}

}
