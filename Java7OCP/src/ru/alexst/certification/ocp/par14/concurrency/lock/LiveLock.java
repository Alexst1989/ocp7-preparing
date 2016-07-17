package ru.alexst.certification.ocp.par14.concurrency.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 It is remotely possible that this example could lead to livelock. Imagine if
thread A always acquires lock1 at the same time that thread B acquires
lock2. Each thread's attempt to acquire the second lock would always fail,
and you'd end up repeating forever, or at least until you were lucky enough to
have one thread fall behind the other. You can avoid livelock in this scenario
by introducing a short random delay with Thread.sleep(int) any time you
fail to acquire both locks.
 
 
 */

public class LiveLock {
	
	public static void main(String argsp[]) {
		Lock l1 = new ReentrantLock();
		Lock l2 = new ReentrantLock();
		Thread t1 = new Thread(new Locker2(l1, l2));
		Thread t2 = new Thread(new Locker2(l1, l2));
		t1.start();
		t2.start();
	}

}

class Locker2 implements Runnable {

	private Lock l1;
	private Lock l2;
	
	public Locker2(Lock l1, Lock l2) {
		this.l1 = l1;
		this.l2 = l2;
	}
	
	@Override
	public void run() {
	loop2:
		while (true) {
			boolean aq2 = l2.tryLock();
			boolean aq1 = l1.tryLock();
			try {
				if (aq1 && aq2) {
					// work
					break loop2;
				}
			} finally {
				if (aq2) l2.unlock();
				if (aq1) l1.unlock();
			}
		}
	}
	
}
