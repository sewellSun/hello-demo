package com.sunq.hello.producer_consumer;

/**
 *@author sunq
 *@date2019/6/17 10:03
 *@Description
 */
abstract class AbstractProducer implements Producer,Runnable{
	@Override
	public void run() {
		while (true){
			try {
				produce();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
