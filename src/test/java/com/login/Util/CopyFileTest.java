package com.login.Util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath*:applicationContext.xml" })

public class CopyFileTest {
	
	@Autowired
	CopyFile copyFile;

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

//	@Test
//	public void testCopyFileByUrl() {
//		String url = "http://img.moteban.com/Pics/2016/0716/10/02.jpg";
//		String copyPath = "C:\\Users\\Administrator\\Desktop\\";
//		String imgName = "002.jpg";
//		copyFile.copyFileByUrl(url, copyPath, imgName);
//	}
	
	@Test
	public void testCopyFilesByTxt(){
		copyFile.copyFilesByTxt("C:\\Users\\Administrator\\Desktop\\temp.txt");
	}

}
