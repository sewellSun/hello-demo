package com.sunq.hello.producer_consumer;

/**
 *@author sunq
 *@date2019/6/17 10:06
 *@Description
 */
public interface Model {
	Runnable newRunnableProducer();
	Runnable newRunnableConsumer();
}
