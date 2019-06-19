package com.sunq.hello.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *@author sunq
 *@date2019/6/3 16:45
 *@Description
 */
public class TestOutOfMemory {

	public static void main(String[] args) {

		//线程1
		new Thread(()->{
			List<byte[]> list = new ArrayList<>();
			while (true){
				System.out.println(new Date().toString()+Thread.currentThread()+"=="+Thread.currentThread().getName());
				byte[] b = new byte[1024*1024*1];
				list.add(b);
				try {
					Thread.sleep(1000);
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		}).start();

		//线程2
		new Thread(()->{
			List<byte[]> list = new ArrayList<>();
			while (true){
				System.out.println(new Date().toString()+Thread.currentThread()+"=="+Thread.currentThread().getName());
				byte[] b = new byte[1024*1024*1];
				list.add(b);
				try {
					Thread.sleep(1000);
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		}).start();
	}

}
