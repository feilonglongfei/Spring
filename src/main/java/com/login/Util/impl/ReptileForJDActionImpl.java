package com.login.Util.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.concurrent.Task;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.login.Util.ReptileForJDAction;

@Service("ReptileForJDAction")
public class ReptileForJDActionImpl implements ReptileForJDAction {
	
	private static Logger logger = LoggerFactory.getLogger(ReptileForJDActionImpl.class);
	
	private String txtPath = null; 
	
	@Autowired
	ThreadPoolTaskExecutor taskExecutor;
	
	public void getProductDetailsByTxt(String productType) {
		String platform = null;
		FileReader actionUrlFileReader;
		BufferedReader actionUrlBufferedReader;
		try {
			actionUrlFileReader = new FileReader(txtPath);
			actionUrlBufferedReader = new BufferedReader(actionUrlFileReader);
			String lineStr = null;
			String actionName = null;
			ArrayList<String> productList = new ArrayList<String>();
			while ((lineStr = actionUrlBufferedReader.readLine()) != null) {
				if(lineStr.contains("paimai.jd.com")){
					platform = "JD";
				} else if(lineStr.contains("paimai.taobao.com")){
					platform = "TB";
				}
				Document actionDoc = null;
				actionDoc = Jsoup.connect(lineStr).timeout(200000).get();//get actiondoc
				actionName = getActionName(actionDoc, platform);//get actionName
				productList = getActionProductUrls(actionDoc, platform);//get product list
				for (String producturl : productList) {
//				for (int i=0; i < 5; i++) {//for test
//					String producturl = productList.get(i);
					ReptileForJDProductImpl ReptileForJDProductImpl = new ReptileForJDProductImpl("http:".concat(producturl), actionName, productType, platform);
					taskExecutor.execute(ReptileForJDProductImpl);
				}
			}
			while(taskExecutor.getActiveCount() > 0){
				logger.info("thread sleep 20 s, current active thread : ".concat(String.valueOf(taskExecutor.getActiveCount())));
				Thread.sleep(20000);
			}
			actionUrlBufferedReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
		}
		

	}

	private ArrayList<String> getActionProductUrls(Document actionDoc, String platform) {
		ArrayList<String> productList = new ArrayList<String>();
		Elements elements = null;

		if(platform.equalsIgnoreCase("JD")){
			elements = actionDoc.getElementsByClass("p-img");
		} else if(platform.equalsIgnoreCase("TB")){
			elements = actionDoc.getElementsByClass("img-wrap");
		}
		if(!elements.isEmpty()){
			for (Element element : elements) {
				productList.add(element.attr("href"));
			}
		}
		
		return productList;
	}
	
	private String getActionName(Document actionDoc, String platform){
		String actionName = null;
		Elements elementTitle = actionDoc.getElementsByTag("title");
		if(!elementTitle.isEmpty() && !elementTitle.text().isEmpty()){
			if(platform.equalsIgnoreCase("JD")){
				actionName = elementTitle.text().replaceAll("_珍品拍卖 - 拍卖专场 - 京东拍卖", "");
			} else if(platform.equalsIgnoreCase("TB")){
				actionName = elementTitle.text().replaceAll("_珍品拍卖 - 拍卖专场 - 闲鱼拍卖", "");
			}
		}
		return actionName;
	}

	public String getTxtPath() {
		return this.txtPath;
	}

	public void setTxtPath(String txtPath) {
		this.txtPath = txtPath;
	}

}
