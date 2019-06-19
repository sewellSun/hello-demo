package com.sunq.hello.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *@author sunq
 *@date2019/6/14 11:39
 *@Description
 */
public class SimpleDateFormatUnSafeTest {


	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static void main(String[] args) {

		for (int i=0;i<1000;i++){
				new Thread(()->{
					try {
						synchronized (sdf){
						System.out.println(sdf.parse("2019-06-14 11:44:00"));
						}
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}).start();
			}

		}
	}
