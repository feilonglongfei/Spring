package com.login.test.demo;

public class Demo17 {
	
	private boolean i;
	private int intvalue;
	private char charvalue;
	private String strvalue;
	private float floatvalue;
	private long longvalue;
	

	public static void main(String[] args) {
		
//		boolean flat;
//		System.out.println(flat);
		
		
//		char c;
//		System.out.println(c);
		
//		int i;
//		System.out.println(i);
		
//		Boolean flag;
//		if(flag){
//			System.out.println("");
//		} 

		Demo17 demo17 = new Demo17();
		System.out.println("getI():  " + demo17.getI());
		System.out.println("getIntvalue():  " + demo17.getIntvalue());
		System.out.println("getStrvalue():  " + demo17.getStrvalue());
		System.out.println("getCharvalue():  " + demo17.getCharvalue());
		System.out.println("getFloatvalue():  " + demo17.getFloatvalue());
		System.out.println("getLongvalue():  " + demo17.getLongvalue());
		
	}


	public boolean getI() {
		return i;
	}


	public void setI(boolean i) {
		this.i = i;
	}


	public int getIntvalue() {
		return intvalue;
	}


	public void setIntvalue(int intvalue) {
		this.intvalue = intvalue;
	}


	public char getCharvalue() {
		return charvalue;
	}


	public void setCharvalue(char charvalue) {
		this.charvalue = charvalue;
	}


	public String getStrvalue() {
		return strvalue;
	}


	public void setStrvalue(String strvalue) {
		this.strvalue = strvalue;
	}


	public float getFloatvalue() {
		return floatvalue;
	}


	public void setFloatvalue(float floatvalue) {
		this.floatvalue = floatvalue;
	}


	public long getLongvalue() {
		return longvalue;
	}


	public void setLongvalue(long longvalue) {
		this.longvalue = longvalue;
	}

}
