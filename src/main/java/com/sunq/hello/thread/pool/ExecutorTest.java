package com.sunq.hello.thread.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 *@author sunq
 *@date2019/7/4 15:35
 *@Description
 */
public class ExecutorTest {


	public static void main(String[] args) {

		ExecutorProcessPool pool = ExecutorProcessPool.getInstance();

		for (int i = 0;i < 50;i++){
			Future<?> future = pool.submit(new ExecuteTask1(i+""));
			try {
				// 如果接收线程返回值，future.get() 会阻塞，如果这样写就是一个线程一个线程执行，
				//System.out.println(future.get());
			}catch (Exception e){
				e.printStackTrace();
			}
		}


		for (int i = 0;i < 50;i++){
			pool.execute(new ExecuteTask2(i+""));
		}

		//关闭线程池，如果是需要长期运行的 线程池，不调用此方法
		//监听程序退出的时候最好执行一次
		pool.shutdown();


	}


	/**
	 * 执行任务1，实现callable方式
	 */
	static class ExecuteTask1 implements Callable<String> {
		private String taskName;

		public ExecuteTask1(String taskName){
			this.taskName = taskName;
		}

		@Override
		public String call() throws Exception{
			try {
				// java 6/7 最佳的休眠方法为 TimeUnitMICROSECONDS.sleep()
				TimeUnit.MICROSECONDS.sleep((int)Math.random() * 1000); //1000毫米以内的随机数，模拟业务处理
			}catch (Exception e){
				e.printStackTrace();
			}
			System.out.println("------------这执行业务逻辑，callable TaskName = " + taskName + "---------------");
			return ">>>>>>>>>>>>>>线程返回值，callable taskName = " + taskName + "<<<<<<<<<<<<<<<";
		}
	}


	/**
	 * 执行任务2，实现Runable
	 */
	static class ExecuteTask2 implements Runnable {
		private String taskName;

		public ExecuteTask2(String taskName){
			this.taskName = taskName;
		}

		@Override
		public void run() {
			try {
				TimeUnit.MICROSECONDS.sleep((int)Math.random() * 1000); //1000毫米以内的随机数，模拟业务处理
			}catch (Exception e){
				e.printStackTrace();
			}
			System.out.println("------------这类执行业务逻辑，runable TaskName = " + taskName + "---------------");
		}
	}

}
