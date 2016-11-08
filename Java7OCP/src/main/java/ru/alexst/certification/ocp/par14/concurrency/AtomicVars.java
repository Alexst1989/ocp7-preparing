/**
 * 
 */
package ru.alexst.certification.ocp.par14.concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntBinaryOperator;

/*
AtomicInteger
 - compareAndSet(1, 5); //If current value is 1, then it will be set to 5 !!!!!!
 - incrementAndGet(); //Increment current value by one
 - decrementAndGet();
 - getAndIncrement();
 - getAndDecrement();
 - getAndAccumulate(x, accumulatorFunction);
 - getAndAdd(delta);
 - getAndSet(newValue)
 - setAndGet(newValue)
 - getAndUpdate(updateFunction)
 - updateAndGet(updateFunction)
 - accumulateAndGet(2, new IntBinaryOperator() {
            
            @Override
            public int applyAsInt(int left, int right) {
                // TODO Auto-generated method stub
                //left is current value in atomicInt
                //right is first parameter in accumulateAndGet()
                return (left+1)*right;
            }
        });
 
*/

/**
 * @author Алексей
 *
 */
public class AtomicVars {

    public static void main(String args[]) throws InterruptedException {

        // Simple
        Counter counter = new SimpleCounter();
        IncrementerThread it1 = new IncrementerThread(counter);
        IncrementerThread it2 = new IncrementerThread(counter);
        it1.start(); // thread 1 increments the count by 10000
        it2.start(); // thread 2 increments the count by 10000
        it1.join(); // wait for thread 1 to finish
        it2.join(); // wait for thread 2 to finish
        System.out.println(counter.getValue()); // rarely 20000
        // lowest 11972

        // Atomic
        counter = new AtomicCounter(); // the shared object
        it1 = new IncrementerThread(counter);
        it2 = new IncrementerThread(counter);
        it1.start();
        it2.start();
        it1.join();
        it2.join();
        System.out.println(counter.getValue()); // rarely 20000

        // to learn
        AtomicInteger atomicInt = new AtomicInteger();
        System.out.println(atomicInt.incrementAndGet());

        
        atomicInt.compareAndSet(1, 5); //If current value is 1, then it will be set to 5 !!!!!!
        System.out.println("compare and set " + atomicInt.intValue());
        atomicInt.accumulateAndGet(2, new IntBinaryOperator() {
            
            @Override
            public int applyAsInt(int left, int right) {
                // TODO Auto-generated method stub
                //left is current value in atomicInt
                //right is first parameter in accumulateAndGet()
                return (left+1)*right;
            }
        });
        System.out.println("accumulate " + atomicInt.intValue());
        //atomicInt.addAndGet(delta);
        atomicInt.decrementAndGet();
        
        System.out.println(atomicInt.intValue());
        Integer i1 = 5;
        Integer i2 = 5;
        // If current value equals eto expected then sets to update value
        boolean isSet = atomicInt.compareAndSet(atomicInt.get(), 5); // main method in the class
        System.out.println(isSet);
        // atomicInt.
        System.out.println(atomicInt.get());
    }

}

class SimpleCounter implements Counter {
    private int count;

    public void increment() {
        count++; // it's a trap!
        // a single "line" is not atomic
    }

    public int getValue() {
        return count;
    }

}

class AtomicCounter implements Counter {

    private AtomicInteger count = new AtomicInteger();

    public void increment() {
        count.getAndIncrement(); // it's a trap!
        // a single "line" is not atomic
    }

    public int getValue() {
        return count.get();
    }

}

class IncrementerThread extends Thread {

    private Counter counter;

    // all instances are passed the same counter
    public IncrementerThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        // "i" is local and thread-safe
        for (int i = 0; i < 10000; i++) {
            counter.increment();
        }
    }

}

interface Counter {
    public void increment();

    public int getValue();
}
