/**
 * 
 */
package ru.alexst.certification.ocp.par13.threads;

/**
 * @author Алексей
 *
 */
public class ThreadsBasic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object lock = new Object();
		Thread t = new Thread(new TestThread(lock));
		new Thread(new TestThread(lock));
		t.start();
		
		//Methods throwing InterruptedException
		try {
			t.join(); // Also will throw IlligalMonitorStateExcwption
			//release lock
			t.wait(); // Also will throw IlligalMonitorStateExcwption
			Thread.sleep(10000); //Dont release lock !!!!!!!!
		} catch (InterruptedException e) {}
		
		//Methods must be placed in synchronized block
		synchronized(lock) {
			try {
				lock.wait();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lock.notify();
		}
		
		
		//static methods of Thread 
		try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Thread.yield();
		
		//Object methods
		try {
		lock.wait();
		}catch(InterruptedException e) {}
		lock.notify();
		lock.notifyAll();
		
		//non-static methods of Thread
		Thread tt = new Thread() {
			/* (non-Javadoc)
			 * @see java.lang.Thread#run()
			 */
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getId());
			}
		};
		tt.run();
		tt.start();
		
		
		
		//
	}

}

class TestThread implements Runnable {
	
	private Object lock;
	
	public TestThread(Object lock) {
		this.lock = lock;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		
		System.out.println(Thread.currentThread().getId());
		
		
	}
	
}
