package ru.alexst.certification.ocp.par14.concurrency.executors;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import ru.alexst.integral.functions.SinFunction;
import ru.alexst.integral.thread.AtomicVarsIntegralThread;
import ru.alexst.integral.thread.result.AtomicVarsIntegralResult;

public class ExecutorsCommon {

	public static void main(String[] args) {

		/** fixed thread pool **/
		/*
		 * A fixed thread pool is constructed using a numeric argument (4 in the
		 * preceding example) that specifies the number of threads used to
		 * execute tasks. This type of pool will probably be the one you use the
		 * most because it prevents an application from overloading a system
		 * with too many threads. Tasks that cannot be executed immediately are
		 * placed on an unbounded queue for later execution.
		 */
		ExecutorService ex1 = Executors.newFixedThreadPool(10);

		/** cached thread pool **/
		/*
		 * A cached thread pool will create new threads as they are needed and
		 * reuse threads that have become free. Threads that have been idle for
		 * 60 seconds are removed from the pool. Watch out! Without some type of
		 * external limitation, a cached thread pool may be used to create more
		 * threads than your system can handle.
		 */

		ExecutorService ex2 = Executors.newCachedThreadPool();

		/** ThreadPoolExecutor **/
		/*
		 * Both Executors.newCachedThreadPool() and Executors
		 * .newFixedThreadPool(4) return objects of type java.util.concurrent
		 * .ThreadPoolExecutor (which implements ExecutorService and Executor).
		 * You will typically use the Executors factory methods instead of
		 * creating ThreadPoolExecutor instances directly, but you can cast the
		 * fixed or cached thread pool ExecutorService references if you need
		 * access to the additional methods. The following example shows how you
		 * could dynamically adjust the thread count of a pool at runtime:
		 */

		ThreadPoolExecutor ex3 = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
		ex3.setCorePoolSize(8);
		ex3.setMaximumPoolSize(8);

		/** single thread pool **/
		/*
		 * A single thread pool uses a single thread to execute tasks. Tasks
		 * that cannot be executed immediately are placed on an unbounded queue
		 * for later execution. Unlike a fixed thread pool executor with a size
		 * of 1, a single thread executor prevents any adjustments to the number
		 * of threads in the pool.
		 */

		ExecutorService ex4 = Executors.newSingleThreadExecutor();

		/** Scheduled Thread Pool **/
		/*
		 * In addition to the three basic ExecutorService behaviors outlined
		 * already, the Executors class has factory methods to produce a
		 * ScheduledThreadPoolExecutor. A ScheduledThreadPoolExecutor enables
		 * tasks to be executed after a delay or at repeating intervals.
		 */
		ScheduledExecutorService ftses = Executors.newScheduledThreadPool(4); // multi-threaded
		// version
		Runnable r = new AtomicVarsIntegralThread(new SinFunction(), 0D, Math.PI, new AtomicVarsIntegralResult());
		ftses.schedule(r, 5, TimeUnit.SECONDS); // run once after
		// a delay
		ftses.scheduleAtFixedRate(r, 2, 5, TimeUnit.SECONDS); // begin after a
		// 2sec delay
		// and begin again every 5 seconds
		ftses.scheduleWithFixedDelay(r, 2, 5, TimeUnit.SECONDS); // begin after
		// 2sec delay
		// and begin again 5 seconds *after* completing the last execution

		ex1.shutdown();
		ex2.shutdown();
		ex3.shutdown();
		ex4.shutdown();
		ftses.shutdown();

		ex1.shutdown(); // no more new tasks
		// but finish existing tasks
		try {
			boolean term = ex1.awaitTermination(2, TimeUnit.SECONDS);
			// wait 2 seconds for running tasks to finish
		} catch (InterruptedException excep) {
			// did not wait the full 2 seconds
		} finally {
			if (!ex1.isTerminated()) // are all tasks done?
			{
				List<Runnable> unfinished = ex1.shutdownNow();
				// a collection of the unfinished tasks
			}
		}
	}

}
