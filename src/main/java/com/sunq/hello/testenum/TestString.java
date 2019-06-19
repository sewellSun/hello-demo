package com.sunq.hello.testenum;

import org.springframework.beans.factory.annotation.Value;

public class TestString {

	@Value("${sunq}")
	public  String testString;



	public String testStr(){
		 return testString;
	}



}
