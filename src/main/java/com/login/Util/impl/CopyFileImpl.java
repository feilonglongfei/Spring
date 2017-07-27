package com.login.Util.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import antlr.StringUtils;

import com.login.Util.CopyFile;

@Service("CopyFile")
public class CopyFileImpl implements CopyFile {
	
	private static Logger logger = LoggerFactory.getLogger(CopyFileImpl.class);
	
	@Autowired
	ThreadPoolTaskExecutor taskExecutor;

	public void copyFilesByTxt(String txtPath) {
		FileReader templateTxt;
		BufferedReader reader;
		try {
			templateTxt = new FileReader(txtPath);
			reader = new BufferedReader(templateTxt);
			String lineStr = null;
			while ((lineStr = reader.readLine()) != null) {
				CopyFilesByLineStr copyFilesByLineStr = new CopyFilesByLineStr(lineStr);
				taskExecutor.execute(copyFilesByLineStr);
			}
			while(taskExecutor.getActiveCount() > 0){
				logger.info("thread sleep 20 s, current active thread : ".concat(String.valueOf(taskExecutor.getActiveCount())));
				Thread.sleep(20000);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
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
				File copyFolder = new File(copyFile.getParent());
				if (copyFile.exists()) {
					logger.info(copyFile.getPath().concat(" exist already"));
				} else {
					if (!copyFolder.exists()) {
						copyFolder.mkdirs();
					}
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
	
	// task class for copy file by line string

	@SuppressWarnings("unused")
	private class CopyFilesByLineStr implements Runnable {
		
		private String lineStr = null;

		CopyFilesByLineStr(String lineStr) {
			this.lineStr = lineStr;
		}

//		public void copyFileByUrl(String url, String copyName) {
//
//			try {
//				UrlResource file = new UrlResource(url);
//				if (file.exists()) {
//					File copyFile = new File(copyName);
//					File copyFolder = new File(copyFile.getParent());
//					if (copyFile.exists()) {
//						logger.info(copyFile.getPath().concat(" exist already"));
//					} else {
//						if (!copyFolder.exists()) {
//							copyFolder.mkdirs();
//						}
//						OutputStream copyFileOS = new FileOutputStream(copyFile);
//						FileCopyUtils.copy(file.getInputStream(), copyFileOS);
//					}
//				} else {
//					logger.info(url.concat(" not exist"));
//				}
//			} catch (MalformedURLException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//
//		}

		private void copyFiles(String lineStr) {
			String[] strs = lineStr.split(" ");
			int imgCount = Integer.valueOf(strs[1]);
			String urlTemplate = strs[0];
			String baseURL = urlTemplate.substring(0, 41);
			for (int i = 0; i <= imgCount; i++) {
				String imgName = String.format("%02d", i).concat(".jpg");
//				String imgName = i + ".jpg";
				String url = baseURL.concat(imgName);
				String copyPath = "G:\\\\image\\\\".concat(
						baseURL.substring(baseURL.length() - 13,
								baseURL.length())).replace("/", "\\\\");// String.valueOf(File.separatorChar)
				String copyName = copyPath.concat(imgName);
				
				copyFileByUrl(url, copyName);
			}
			logger.info(lineStr.concat(" download already "));
		}
		
		// for Rentiyishu123 site copy
		private void copyFilesForRentiyishu123(String lineStr) {
			String[] strs = lineStr.split(" ");
			int imgCount = Integer.valueOf(strs[1]);
			String urlTemplate = strs[0];
			String baseURL = urlTemplate.substring(0, urlTemplate.lastIndexOf("/")+1);
			String[] strsForBaseURL = baseURL.split("/");
			for (int i = 0; i <= imgCount; i++) {
//				String imgName = String.format("%02d", i).concat(".jpg");
				String imgName = i + ".jpg";
				String url = baseURL.concat(imgName);
				String copyPath = "G:\\\\image\\\\sorenti\\\\"+ strsForBaseURL[3] +"\\\\pics\\\\".concat(strsForBaseURL[strsForBaseURL.length -1]).concat("\\\\");
				String copyName = copyPath.concat(imgName);
				
				copyFileByUrl(url, copyName);
			}
			logger.info(lineStr.concat(" download already "));
		}

		public void run() {
			String threadName = Thread.currentThread().getName();
			long threadID = Thread.currentThread().getId();
			logger.info(" start: ".concat(this.lineStr).concat(" , ").concat(threadName).concat(" , ").concat(String.valueOf(threadID)));
//			copyFiles(this.lineStr);
			copyFilesForRentiyishu123(this.lineStr);
			logger.info(" end  : ".concat(this.lineStr).concat(" , ").concat(threadName).concat(" , ").concat(String.valueOf(threadID)));
		}

		public String getLineStr() {
			return lineStr;
		}

		public void setLineStr(String lineStr) {
			this.lineStr = lineStr;
		}
	}
}
