package com.sunq.hello.hellodemo;

import java.util.HashMap;
import java.util.Map;

/**
 *@author sunq
 *@date2019/7/2 12:18
 *@Description
 */
public class TestMap {

	public static void main(String[] args) {

		Map<Integer,String> map = new HashMap<>();


		map.put(1,"11111");
		map.put(7,"22222");
		map.put(2,"33333");
		map.put(5,"44444");
		map.put(6,"55555");
		map.put(3,"66666");
		map.put(4,"77777");

		for (Integer i:map.keySet()) {
			System.out.println(map.get(i));
		}



	}
}
