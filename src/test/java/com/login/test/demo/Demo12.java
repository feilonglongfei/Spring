package com.login.test.demo;

public class Demo12 {
	
    String str = new String("good");

    char[] ch = { 'a', 'b', 'c' };

    public static void main(String args[]) {

    	Demo12 ex = new Demo12();

        ex.change(ex.str, ex.ch);

        System.out.print(ex.str + " and ");

        System.out.print(ex.ch);

    }

    public void change(String str, char ch[]) {

//        str = new String("test ok");
    	str = "test str";
    	
        System.out.println(this.str == str);

        ch[0] = 'g';

    }

}
