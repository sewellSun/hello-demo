package com.sunq.hello.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *@author sunq
 *@date2019/7/4 11:46
 *@Description 线程池构造工厂
 */
public class ExecutorServiceFactory {

	private static ExecutorServiceFactory executorFactory = new ExecutorServiceFactory();

	/**
	 * 定时任务线程池
	 */
	private ExecutorService executors;

	private ExecutorServiceFactory(){

	}


	/**
	 * 获取线程池工厂实例
	 * @return
	 */
	public static ExecutorServiceFactory getInstance(){
		return  executorFactory;
	}


	/**
	 * 创建 定时任务线程池
	 * @return
	 */
	public ExecutorService createScheduleThreadPool(){
		//cpu 个数
		int availableProcessors= Runtime.getRuntime().availableProcessors();
		//创建
		executors = Executors.newScheduledThreadPool(availableProcessors * 10,getThreadFactory());
		return executors;
	}

	/**
	 *  创建一个使用单个 worker 线程
	 *  Executor 已无界队列方式来运行该线程，（如果因为在关闭前的执行期间出现失败而终止这个线程，则如果需要会有个新
	 *  	线程代替它执行后续的任务），从而保证顺序地执行各个任务，并且在任意给定的时间不会有多个线程活动，
	 *  与其newFixedThreadPool(1)不同，可以保证不需要重新配置此方法返回的执行程序就可以使用其他线程
	 *
	 *  翻译过来就是：这个是个工作线程，叫worker，它只有一个人做事情，如果它在执行期间因为失败而终止了，那么会有个人出来
	 *  继续顶替它的工作，不需要重新配置就可以继续运行，默认完美无缝的接管前一个死掉的线程所有的工作
	 *
	 * @return
	 */
	public ExecutorService createSingleThreadExecutor(){

		executors = Executors.newSingleThreadExecutor(getThreadFactory());
		return executors;
	}

	/**
	 * 创建一个可以根据需要创建新线程的线程池，但之前构造的线程可用时将复用他们，
	 * 		对于执行很多短期 异步的程序而言这些线程池也可以提高性能
	 * 	调用execute 将复用之前构造的线程，如果当前没有线程可用，就会新建一个线程并添加到线程池中，
	 * 		同时终止并从缓存中移除那些已有60秒未被使用的线程
	 * 	因此，长时间保持空闲的线程池不会使用任何资源，
	 * 	可以使用ThreadPoolExecutor构造方法创建具有类似属性但 细节（例如超时参数）不同的线程池
	 * @return
	 */
	public ExecutorService createCachedThreadPool(){
		executors = Executors.newCachedThreadPool(getThreadFactory());
		return executors;
	}

	/**
	 * 创建一个可重复使用固定线程数的线程池，以共享的无界队列来运行这些线程。
	 * 在任意点，大多数的 线程会处于处理任务的活动状态，
	 * 如果在所有线程处于活动状态时提交附加任务，在有可用线程之前 附加任务将会在队列中等待
	 * 如果在关闭前的执行期间由于失败而导致任何线程终止，那么一个新的线程将代替它执行后续的任务
	 * 在某个线程显示的被关闭之前，池中的线程将一直存在
	 * @param count
	 * @return
	 */
	public ExecutorService createFixedThreadPool(int count){
		executors = Executors.newFixedThreadPool(count,getThreadFactory());
		return executors;
	}


	/**
	 * 创建线程池工厂
	 * @return
	 */
	private ThreadFactory getThreadFactory(){

		return new ThreadFactory() {
			AtomicInteger sn = new AtomicInteger();
			@Override
			public Thread newThread(Runnable r) {
				SecurityManager s = System.getSecurityManager();
				ThreadGroup group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
				Thread t = new Thread(group,r);
				t.setName("任务线程 - " + sn.incrementAndGet());
				return t;
			}
		};
	}

}
