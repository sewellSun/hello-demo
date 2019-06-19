package com.sunq.hello.hellodemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class HelloController {

	@Value("${sunq}")
	private String testStr;

    @GetMapping("/hello")
    public String sayHello(){
       String [] ss =  testStr.split(" ");
		System.out.println(Arrays.toString(testStr.toCharArray()));
		for (String s:ss
			 ) {
			System.out.println(s);
		}

    	return testStr;
    }

}
