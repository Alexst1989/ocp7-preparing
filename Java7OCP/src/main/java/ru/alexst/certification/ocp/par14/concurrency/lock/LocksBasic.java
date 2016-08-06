package ru.alexst.certification.ocp.par14.concurrency.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LocksBasic {

    public static Lock lock = new ReentrantLock();

    public static void main(String argsp[]) {
        Lock lock = new ReentrantLock();

        lock.unlock(); // If lock doesn't acquired, the IllegalMonitorStateException will be thrown

        lock.lock(); // Acquires the lock;
        lock.tryLock();
        try {
            lock.tryLock(15, TimeUnit.SECONDS); // Must be surrounded with try-catch
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        lock.unlock(); // Release the lock;

        Thread t1 = new Thread(new Locker(lock));
        Thread t2 = new Thread(new Locker(lock));
        t1.start();
        t2.start();
        System.out.println();
    }

}

class Locker implements Runnable {

    private Lock lock;

    public Locker(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        System.out.println(String.format("Thread id = %s starts", Thread.currentThread().getId()));
        lock.lock();
        lock.unlock();
        System.out.println(String.format("Thread id = %s ends", Thread.currentThread().getId()));
    }

}
