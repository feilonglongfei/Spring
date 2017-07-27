package com.login.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.login.model.UserInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath*:applicationContext.xml" })
public class LoginServiceTest {

	@Autowired
	LoginService loginService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetUserInfo() {
		loginService.getUserInfo();
	}

	@Test
	public void testGetAllUserName() {
		List<String> userNames = loginService.getAllUserName();
		assertEquals(2, userNames.size());
	}

	@Test
	public void testGetUserInfobyUserID() {
		String userId = new String("user00");
		UserInfo userInfo = loginService.getUserInfobyUserID(userId);
		assertEquals("user00", userInfo.getUserName());
	}
	
	@Test
	public void testGetUserInfobyUserIDForConcurrentMapCache() {
		String userId = new String("user00");
		UserInfo userInfo = loginService.getUserInfobyUserID(userId);
		userInfo = loginService.getUserInfobyUserID(userId);
		assertEquals("user00", userInfo.getUserName());
	}
	
	@Test
	public void testGetUserInfobyUserIDForSpringEHCache() {
		String userId = new String("user00");
		UserInfo userInfo = loginService.getUserInfobyUserID(userId);
		userInfo = loginService.getUserInfobyUserID(userId);
		assertEquals("user00", userInfo.getUserName());
	}

	@Test
	public void testSaveUserInfo() {
		UserInfo userInfo = new UserInfo("userNameForSave", "userNameForSave","userPWDForSave");
		loginService.saveUserInfo(userInfo);
	}
	
	@Test
	public void testAddUserInfo(){
		UserInfo userInfo = new UserInfo("userNameForAdd", "userNameForAdd","userNameForAdd");
		loginService.addUserInfo(userInfo);
	}
	
	@Test
	public void testQuartzFunction(){
		try {
			Thread.sleep(300000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * try to test spring AOP after-throwing 
	 * @throws Exception
	 */
	@Test
	public void testThrowException() throws Exception{
			loginService.throwException();
	}

}
