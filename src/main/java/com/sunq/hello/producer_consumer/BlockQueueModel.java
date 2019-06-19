package com.sunq.hello.producer_consumer;

import com.sunq.hello.producer_consumer.Model;
import com.sunq.hello.producer_consumer.Task;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *@author sunq
 *@date2019/6/17 10:08
 *@Description
 */
public class BlockQueueModel implements Model {
	private final BlockingQueue<Task> queue;
	private final AtomicInteger increTaskNo = new AtomicInteger(0);

	public BlockQueueModel(int cap){
		this.queue = new LinkedBlockingQueue<>(cap);
	}

	@Override
	public Runnable newRunnableProducer() {
		return new ProducerImpl();
	}

	@Override
	public Runnable newRunnableConsumer() {
		return new ConsumerImpl();
	}

	private class ProducerImpl extends AbstractProducer implements Producer,Runnable{
		@Override
		public void produce() throws InterruptedException {
			Thread.sleep((long)(Math.random()*1000));
			Task task = new Task(increTaskNo.getAndIncrement());
			queue.put(task);
			System.out.println("produce："+task.no);
		}
	}

	private class ConsumerImpl extends AbstractConsumer implements  Consumer,Runnable{

		@Override
		public void consume() throws InterruptedException {
			Task task = queue.take();
			Thread.sleep(500+(long)(Math.random()*500));
			System.out.println("consumer："+task.no);
		}
	}

	public static void main(String[] args) {

		Model model = new BlockQueueModel(3);
		for (int i = 0;i < 2;i++){
			new Thread(model.newRunnableConsumer()).start();
		}
		for (int i = 0;i < 5;i++){
			new Thread(model.newRunnableProducer()).start();
		}
	}
}
