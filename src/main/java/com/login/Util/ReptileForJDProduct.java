package com.login.Util;

public interface ReptileForJDProduct extends Runnable {
	
	String url = null; 
	String actionName = null;
	
	void getProductDetailsByURL();
	
	public String getUrl();

	public void setUrl(String url);

	public String getActionName();

	public void setActionName(String actionName);
	
	public String getImgBasePath();
	
	public void setImgBasePath(String imgBasePath) ;
	
	public String getPlatform();

	public void setPlatform(String platform);

}
