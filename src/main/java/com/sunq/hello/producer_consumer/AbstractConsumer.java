package com.sunq.hello.producer_consumer;

/**
 *@author sunq
 *@date2019/6/17 10:01
 *@Description
 */
abstract class AbstractConsumer implements Consumer,Runnable{
	@Override
	public void run() {
		while (true){
			try {
				consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
	}
}
