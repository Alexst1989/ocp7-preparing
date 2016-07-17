package ru.alexst.certification.ocp.par14.concurrency.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

public class FutureExecutorsAndCallable {

	public static void main(String[] args) {
		Callable<Integer> c = new MyCallable();
		ExecutorService ex = Executors.newCachedThreadPool();
		Future<Integer> f = ex.submit(c); // finishes in the future
		try {
			Integer v = f.get(); // blocks until done
			System.out.println("Ran:" + v);
		} catch (InterruptedException | ExecutionException iex) {
			System.out.println("Failed");
		}
	}

}

class MyCallable implements Callable<Integer> {
	@Override
	public Integer call() {
		// Obtain a random number from 1 to 10
		int count = ThreadLocalRandom.current().nextInt(1, 110);
		for (int i = 1; i <= count; i++) {
			System.out.println("Running..." + i);
		}
		return count;
	}
}
