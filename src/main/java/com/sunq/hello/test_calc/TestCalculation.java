package com.sunq.hello.test_calc;

import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *@author sunq
 *@date2019/6/17 13:51
 *@Description
 */
public class TestCalculation {

	private final static Lock lock = new ReentrantLock();

	public static void main(String[] args) {

		float a = 1.0f - 0.9f;
		float b = 0.9f - 0.8f;
		if (a == b) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		Float a2 = Float.valueOf(1.0f - 0.9f);
		Float b2 = Float.valueOf(0.9f - 0.8f);
		if (a2.equals(b2)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}

//		String param = null;
//		switch (param) {
//			case "null":
//				System.out.println("null");
//				break;
//			default:
//				System.out.println("default");
//		}

		BigDecimal a3 = new BigDecimal(0.1);
		System.out.println(a3);
		BigDecimal b3 = new BigDecimal("0.1");
		System.out.println(b3);


		String aa = new BigDecimal(1.0f).subtract(new BigDecimal(0.9f)).toString();
		String bb = new BigDecimal(0.9f).subtract(new BigDecimal(0.8f)).toString();
		//		System.out.println(aa);
		//		System.out.println(bb);


	}
}
