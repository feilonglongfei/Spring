package com.login.controller;

import java.lang.annotation.Annotation;

import javax.annotation.Resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.login.model.UserInfo;
import com.login.service.LoginService;

@Controller
public class LoginController implements Controller{
	
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping("userInfo.do")
	public ModelAndView userLogin(@RequestParam String userInput, @RequestBody String body){
		logger.info("LoginController.userLogin() be called");
		
		ModelAndView returnView = new ModelAndView();
		//call service
//		UserInfo userInfo = loginService.getUserInfo();
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId("01");
		userInfo.setUserName("01name");
		userInfo.setPassword("01Pwd");
		returnView.setViewName("userInfo");
//		returnView.setView(userInfo);
		returnView.addObject("userInfo", userInfo);
		returnView.addObject("message", "hello world!");
		returnView.addObject("userInput", userInput);
		
		
		return returnView;
	}

	public Class<? extends Annotation> annotationType() {
		// TODO Auto-generated method stub
		return null;
	}

	public String value() {
		// TODO Auto-generated method stub
		return null;
	}

}
