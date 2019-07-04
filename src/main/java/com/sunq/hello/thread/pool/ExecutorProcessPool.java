package com.sunq.hello.thread.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 *@author sunq
 *@date2019/7/4 15:26
 *@Description 线程处理类
 */
public class ExecutorProcessPool {

	private ExecutorService executor;

	private static ExecutorProcessPool pool = new ExecutorProcessPool();

	private final  int threadMax = 10;

	private ExecutorProcessPool(){
		System.out.println("threadMax>>>>>>>>>>" + threadMax);
		executor = ExecutorServiceFactory.getInstance().createFixedThreadPool(threadMax);
	}

	public static ExecutorProcessPool getInstance(){
		return pool;
	}


	/**
	 * 关闭线程池，（调用关闭线程池的方法后，线程会执行完队列中所有的任务才会退出）
	 */
	public void shutdown(){
		executor.shutdown();
	}

	/**
	 * 提交任务到线程池，可以接收线程返回值
	 * @param task
	 * @return
	 */
	public Future<?> submit(Runnable task){
		return executor.submit(task);
	}


	/**
	 * 提交任务到线程池，可以接收线程返回值
	 * @param task
	 * @return
	 */
	public Future<?> submit(Callable task){
		return executor.submit(task);
	}

	/**
	 * 提交任务到线程池，无返回值
	 * @param task
	 * @return
	 */
	public void execute(Runnable task){
		executor.execute(task);
	}


}
