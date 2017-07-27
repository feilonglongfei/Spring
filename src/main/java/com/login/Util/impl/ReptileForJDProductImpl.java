package com.login.Util.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.login.Util.ReptileForJDProduct;

@SuppressWarnings("resource")
@Service("ReptileForJDProduct")
public class ReptileForJDProductImpl implements ReptileForJDProduct {
	
	private static Logger logger = LoggerFactory.getLogger(ReptileForJDProductImpl.class);
	
	private String imgBasePath = "D:\\图集\\和田玉图集"; 
	
	private static ArrayList<String> excludeImgs = new ArrayList<String>();
		
	private String url; 
	private String actionName;
	private String productType;
	private String platform;
	
	static {
		try {// exclude imageNames
			FileReader actionUrlFileReader = new FileReader("D:\\图集\\excludeImages.txt");
			BufferedReader actionUrlBufferedReader = new BufferedReader(actionUrlFileReader);
			String excludeImageName = null;
			while ((excludeImageName = actionUrlBufferedReader.readLine()) != null) {
				excludeImgs.add(excludeImageName);
			}
			actionUrlBufferedReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	ReptileForJDProductImpl(){
		
	}
	
	ReptileForJDProductImpl(String url, String actionName, String productType, String platform){
		this.url = url;
		this.actionName = actionName;
		this.productType = productType;
		this.platform = platform;
		if(this.productType.equals("HETIANYU")){
			imgBasePath = "D:\\图集\\和田玉图集"; 
		} else if(this.productType.equals("jadeite")){
			imgBasePath = "D:\\图集\\翡翠图集"; 
		}
	}
	
	public void getProductDetailsByURL() {
		if(this.platform.equalsIgnoreCase("JD")){
			getProductDetailsByURLForJD();
		} else if(this.platform.equalsIgnoreCase("TB")){
			getProductDetailsByURLForTB();
		}
	}
	
	/**
	 * @param url the product url, suck like https://paimai.jd.com/102998594
	 */
	@SuppressWarnings("resource")
	public void getProductDetailsByURLForJD() {

		logger.info(this.url + ", current thread:" + Thread.currentThread().getId());
		
		if(!this.url.startsWith("http:")){
			this.url = "http:".concat(this.url);
		}

		Document productDoc = null;
		Document productDetailDoc = null;
		String productDetailStr = null;

		try {
			productDoc = Jsoup.connect(this.url).timeout(200000).get();
	
			Element productIDElement = productDoc.getElementById("skuId");
			String productID = productIDElement.attr("value");
			String productDetailURL = "http://paimai.jd.com/json/paimaiProduct/productDesciption?productId=".concat(productID);
			String titleStr = productDoc.getElementsByTag("title").text().replaceFirst("－京东珍品拍卖", "").replaceAll("[*|\"().:\t ]", "");
			String currentProductPath = imgBasePath.concat("\\").concat(this.actionName).concat("\\").concat(titleStr);
			File productFolder = null;
			FileWriter fileWriter = null;

			productFolder = new File(currentProductPath);
			if(!productFolder.exists()){
				productFolder.mkdirs();
			}
			fileWriter = new FileWriter(currentProductPath.concat("\\").concat("readme.txt")); //currentProductPath.concat("\\").concat("readme.txt")
			
			productDetailStr = Jsoup.connect(productDetailURL).timeout(200000).ignoreContentType(true).execute().body().replace("\"", "");//remove " at leading and trailing
			productDetailDoc = Jsoup.parse(productDetailStr);
//			logger.info("----------------------------------------");
//			logger.info(productDetailDoc.html());
//			logger.info("----------------------------------------");
			//get introduction
			Elements elementsByTagSpan = productDetailDoc.getElementsByTag("span");
			if(!elementsByTagSpan.isEmpty()){
				String introductionStr = null;
				introductionStr = elementsByTagSpan.get(0).text().trim();
				fileWriter.write("简介：".concat(introductionStr));
				fileWriter.write("\n");
			}
			
			//get property
			Elements elementsProperty = productDetailDoc.getElementsByTag("td");
			if(!elementsProperty.isEmpty()){
				for(int i=0; i<elementsProperty.size(); i++){
					Element element = elementsProperty.get(i);
//					String propertyValue = element.child(0).text().trim();
					String propertyValue = element.text().trim();
					fileWriter.write(propertyValue);
					if(i%2 != 0){
						fileWriter.write("\n");
					}
				}
			}
			
			//get image
			Elements elementsImg = productDetailDoc.getElementsByTag("img");
			if(!elementsImg.isEmpty()){
				String copyPath = null;
				for (int i=0; i < elementsImg.size() - 4; i++) {
					Element element = elementsImg.get(i);
					String elementSrc = element.attr("src");
					if( elementSrc.startsWith("//img30.360buyimg.com/popWaterMark/jfs") ||
						elementSrc.startsWith("https://img30.360buyimg.com/popWaterMark/jfs")||
						elementSrc.startsWith("//img30.360buyimg.com/popWareDetail/jfs") ||
						elementSrc.startsWith("//img10.360buyimg.com/imgzone/jfs")
							)
							{
						String imgUrl = null;
						if(!elementSrc.startsWith("https:")){
							imgUrl = "https:".concat(elementSrc);
						} else {
							imgUrl = elementSrc;
						}
						String imgName = getImgName(elementSrc);
						if(imgName.endsWith(".jpg") && excludeImgs.indexOf(imgName) == -1){
							copyPath = currentProductPath.concat("\\").concat(imgName);
							
							this.copyFileByUrl(imgUrl, copyPath); //copy image file to local
							
							fileWriter.write(imgUrl);
							fileWriter.write("\n");
						}
						
					}
				}
			}
			
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void getProductDetailsByURLForTB() {

		logger.info(this.url + ", current thread:" + Thread.currentThread().getId());
		
		if(!this.url.startsWith("http")){
			this.url = "http:".concat(this.url);
		}

		Document productDoc = null;
		Document productDetailDoc = null;
		String productDetailStr = null;

		try {
			productDoc = Jsoup.connect(this.url).timeout(200000).get();
	
//			Element productIDElement = productDoc.getElementById("skuId");
//			String productID = productIDElement.attr("value");
			Element productDescElement = productDoc.getElementById("J_desc");
			String productDetailURL = productDescElement.attr("data-from");
			if(!productDetailURL.startsWith("http")){
				productDetailURL = "https:".concat(productDetailURL);
			}
			String titleStr = productDoc.getElementsByTag("title").text().replaceFirst(" - 拍卖", "").replaceAll("[*|\"().:\t ]", "");
			String currentProductPath = imgBasePath.concat("\\").concat(this.actionName).concat("\\").concat(titleStr);
			File productFolder = null;
			FileWriter fileWriter = null;

			productFolder = new File(currentProductPath);
			if(!productFolder.exists()){
				productFolder.mkdirs();
			}
			fileWriter = new FileWriter(currentProductPath.concat("\\").concat("readme.txt")); //currentProductPath.concat("\\").concat("readme.txt")
			
			productDetailDoc = Jsoup.parse(new URL(productDetailURL), 200000);
//			logger.info("----------------------------------------");
//			logger.info(productDetailDoc.html());
//			logger.info("----------------------------------------");
			//get property
			Elements elementsByTabTD = productDetailDoc.getElementsByTag("td");
			if(!elementsByTabTD.isEmpty()){
				for(int i=0; i<elementsByTabTD.size() - 1; i++){
					Element element = elementsByTabTD.get(i);
					String propertyValue = element.text().trim();
					if(i%2 != 0){
						fileWriter.write(propertyValue);
						fileWriter.write("\n");
					} else {
						fileWriter.write(propertyValue.concat(":"));
					}
				}
			}
			
			//get image
			Elements elementsImg = productDetailDoc.getElementsByTag("img");
			if(!elementsImg.isEmpty()){
				String copyPath = null;
				for (int i = 3; i < elementsImg.size() - 3; i++) {
					Element element = elementsImg.get(i);
					String elementSrc = element.attr("src");
					String imgUrl = null;
					if(!elementSrc.startsWith("https:")){
						imgUrl = "https:".concat(elementSrc);
					} else {
						imgUrl = elementSrc;
					}
					String imgName = getImgName(elementSrc);
					if( imgName.endsWith(".jpg") && excludeImgs.indexOf(imgName) == -1){//
						copyPath = currentProductPath.concat("\\").concat(imgName);
						
						this.copyFileByUrl(imgUrl, copyPath); //copy image file to local
						
						fileWriter.write(imgUrl);
						fileWriter.write("\n");
					}
				}
			}
			
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * @param copyPath this parameter format should be like  "D:\\test"
	 */
	public void copyFileByUrl(String url, String copyPath) {

		try {
			UrlResource file = new UrlResource(url);
			if (file.exists()) {
				File copyFile = new File(copyPath);
//				File copyFolder = new File(copyFile.getParent());
				if (copyFile.exists()) {
					logger.info(copyFile.getPath().concat(" exist already"));
				} else {
//					if (!copyFolder.exists()) {
//						copyFolder.mkdirs();
//					}
					OutputStream copyFileOS = new FileOutputStream(copyFile);
					FileCopyUtils.copy(file.getInputStream(), copyFileOS);
				}
			} else {
				logger.info(url.concat(" not exist"));
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	private String getImgName(String elementSrc) {
		if(elementSrc != null){
			String[] strs = elementSrc.split("/");
			return strs[strs.length - 1];
		}
		return null;
	}

	public void run() {
		this.getProductDetailsByURL();
		
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getImgBasePath() {
		return imgBasePath;
	}

	public void setImgBasePath(String imgBasePath) {
		this.imgBasePath = imgBasePath;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	
	
}
