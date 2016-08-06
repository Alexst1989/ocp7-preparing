package ru.alexst.certification.ocp.par14.concurrency.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionBasic {

    public static Lock lock = new ReentrantLock();

    public static void main(String argsp[]) {
        BetweenThreads between = new BetweenThreads("0");

        Thread t1 = new Thread(new Locker(between));
        Thread t2 = new Thread(new Locker(between));
        // Thread t3 = new Thread(new Summator(between));

        t1.start();
        t2.start();
        // t3.start();

        System.out.println();
    }

}

class BetweenThreads {

    private long i;
    private Lock lock = new ReentrantLock();
    private Condition poolA = lock.newCondition();
    private Condition poolB = lock.newCondition();

    private String info;

    public long getI() {
        return i;
    }

    public void setI(long i) {
        this.i = i;
    }

    public Condition getPoolA() {
        return poolA;
    }

    public Condition getPoolB() {
        return poolB;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public BetweenThreads(String info) {
        this.info = info;
    }

    public Lock getLock() {
        return lock;
    }

}

class Locker implements Runnable {

    private BetweenThreads between;
    private static final int N = 5;
    private int counter;

    public Locker(BetweenThreads between) {
        this.between = between;
    }

    @Override
    public void run() {
        System.out.println(String.format("Thread id = %s starts", Thread.currentThread().getId()));
        while (counter < N) {
            between.getLock().lock();
            try {
                if (between.getI() == Thread.currentThread().getId()) {
                    if (counter != N - 1)
                        between.getPoolA().await();
                } else {
                    System.out.println(String.format("Current thread number is %s. Counter = %s",
                            Thread.currentThread().getId(), counter));
                    counter++;
                    between.setI(Thread.currentThread().getId());
                    between.getPoolA().signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                between.getLock().unlock();
            }
        }
        System.out.println(String.format("Thread id = %s ends", Thread.currentThread().getId()));
    }

}

class Summator implements Runnable {

    private BetweenThreads between;

    public Summator(BetweenThreads between) {
        this.between = between;
    }

    @Override
    public void run() {
        System.out.println(String.format("Thread Summator starts", Thread.currentThread().getId()));
        boolean work = true;
        while (work) {
            between.getLock().lock();
            try {

            } finally {
                between.getLock().unlock();
            }
        }
        System.out.println(String.format("Thread Summator ends", Thread.currentThread().getId()));
    }

}
