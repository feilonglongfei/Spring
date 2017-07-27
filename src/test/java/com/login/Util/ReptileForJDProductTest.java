package com.login.Util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Stack;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysql.cj.jdbc.Blob;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath*:applicationContext.xml" })

public class ReptileForJDProductTest {
	
//	@Autowired
	private ReptileForJDProduct reptileForJDProduct;

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
	public void test() {
//		fail("Not yet implemented");
	}

	@Test
	public void testGetProductDetailsByURLForHETIAN(){
		reptileForJDProduct.setUrl("https://paimai.jd.com/102911404");
		reptileForJDProduct.setImgBasePath("D:\\图集\\和田玉图集");// hetianyu
		reptileForJDProduct.setActionName("典当行和田玉精选拍卖专场");
		reptileForJDProduct.setPlatform("tb");//OR TB
		
		reptileForJDProduct.getProductDetailsByURL();
	}
	
	
	@Test
	public void testGetProductDetailsByURLForJadeite(){
		reptileForJDProduct.setUrl("https://item-paimai.taobao.com/pmp_item/550682459383.htm?s=pmp_detail&spm=a2129.7629195.1998344376.46.vVIvbp");
		reptileForJDProduct.setImgBasePath("D:\\图集\\翡翠图集");// jadeite
		reptileForJDProduct.setActionName("品质之选高端冰种翡翠联合专场");
		reptileForJDProduct.setPlatform("TB");//OR TB
		
		reptileForJDProduct.getProductDetailsByURL();
	}
	
	@Test
	public void testGetProductDetailsByTxt(){
		
		reptileForJDProduct.setImgBasePath("D:\\图集\\");// for timelimit
		reptileForJDProduct.setActionName("京东拍卖 限时拍");
		reptileForJDProduct.setPlatform("JD");//OR TB
		
		FileReader actionUrlFileReader;
		BufferedReader actionUrlBufferedReader;
		
		try {
			actionUrlFileReader = new FileReader("D:\\图集\\actionURL.txt");
			actionUrlBufferedReader = new BufferedReader(actionUrlFileReader);
			String lineStr = null;
			while ((lineStr = actionUrlBufferedReader.readLine()) != null) {
				reptileForJDProduct.setUrl(lineStr);
				reptileForJDProduct.getProductDetailsByURL();
			}
			actionUrlBufferedReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	@Test
//	public void testCopyFileByUrl(){
//		reptileForJD.copyFileByUrl("https://img30.360buyimg.com/popWaterMark/jfs/t3592/185/334260165/344151/c39bc68c/580717b7Nf507e03b.jpg", "D:\\和田玉图集\\580717b7Nf507e03b.jpg");
//	}
	
	
	@Test
	public void testForPattern(){
		String str = "t\\es\tt";
		
		System.out.println(str);
		System.out.println(str.replaceAll("[:\\[/?<>*|\"\\\\\t]", ""));
//		System.out.println(str.replaceAll("\\\\", ""));
		
	}
	
	@Test
	public void testForStack(){
		BigDecimal bigDecimal = new BigDecimal("1000");
		BigDecimal bigDecimal2 = new BigDecimal("100");
		BigDecimal bigDecimal3 = bigDecimal.multiply(bigDecimal2);
		
		int value = 1;
		int value2 = 2;
		int value3 = 3;
		value += value2 *= 3;
		System.out.println(value);
	}
	
	public static void main(String[] args) {
		String str = "t\\es\tt";
		
		System.out.println(str);
		System.out.println(str.replaceAll("[:\\[/?<>*|\"\\\\\t]", ""));
	}
	
}
