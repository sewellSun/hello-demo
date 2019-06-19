package com.sunq.hello.testenum;

/**
 *@author sunq
 *@date2019/6/17 16:06
 *@Description
 */
public class NULL {

	public static void sayHelloWorld(){
		System.out.println("hello world");
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		((NULL)null).sayHelloWorld();
	}



}
