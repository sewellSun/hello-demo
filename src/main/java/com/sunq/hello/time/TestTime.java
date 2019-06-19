package com.sunq.hello.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *@author sunq
 *@date2019/6/8 11:04
 *@Description
 */
public class TestTime {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("HHmm");// 时:分
		int hour = Integer.parseInt(sdf.format(new Date()));
		System.out.println(hour);

		long nowTime = new SimpleDateFormat("HH:mm:ss").parse(new SimpleDateFormat("HH:mm:ss").format(new Date())).getTime() / 1000;

		System.out.println(nowTime);
	}
}
