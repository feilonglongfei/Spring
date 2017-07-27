package com.login.Util;


public interface CopyFile {
	
	/**
	 * @param url
	 * @param path
	 * @return
	 */
//	public void copyFileByUrl(String url, String path, String imgName);
	
	public void copyFilesByTxt(String txtPath);
	
	public void copyFileByUrl(String url, String copyPath);
}
