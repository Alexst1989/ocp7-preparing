package ru.alexst.certification.ocp.par14.concurrency.collections;

import java.util.concurrent.ArrayBlockingQueue;

/*
 ■ ArrayBlockingQueue
■ LinkedBlockingDeque
■ LinkedBlockingQueue
■ PriorityBlockingQueue
■ DelayQueue
■ LinkedTransferQueue
■ SynchronousQueue

Method              General Purpose             Unique Behavior

add(E e)            Insert an object.       Returns true if object added, false if
                                            duplicate objects are not allowed. Throws
                                            an IllegalStateException if the
                                            queue is bounded and full.
                                        
offer(E e)           Insert an object.      Returns true if object added, false if the
                                            queue is bounded and full.
                                        
put(E e)             Insert an object.      Returns void. If needed, will block until
                                            space in the queue becomes available.
offer(E e, long          
timeout, TimeUnit
unit)                Insert an object.        Returns false if the object was not able
                                            to be inserted before the time indicated
                                            by the second and third parameters.
                                            
remove(Object o)     Remove an object.         Returns true if an equal object was
                                            found in the queue and removed;
                                            otherwise, returns false.
poll(long timeout,
TimeUnit unit)        Remove an object.         Removes the first object in the queue
                                            (the head) and returns it. If the timeout
                                            expires before an object can be removed
                                            because the queue is empty, a null will be
                                            returned.
                                            
take()                 Remove an object.         Removes the first object in the queue (the
                                            head) and returns it, blocking if needed
                                            until an object becomes available.
                                            
poll()                 Remove an object.         Removes the first object in the queue (the
                                            head) and returns it or returns null if the
                                            queue is empty.
 */

public class BlockingQueues {

    public static void main(String[] args) {
        ArrayBlockingQueue<Task> queue = new ArrayBlockingQueue<Task>(3, true);
        Executor executor = new Executor(queue);
        TaskCreator taskCreator = new TaskCreator(queue);

        Thread t1 = new Thread(executor);
        Thread t2 = new Thread(taskCreator);
        t1.start();
        t2.start();
        try {
            Thread.sleep(80000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.finish();
        taskCreator.finish();

        System.out.println("The programm is stopped");
    }

}

interface Task {
    void execute();
}

class SimpleTask implements Task {

    private String name;

    public SimpleTask(String name) {
        this.name = name;
    }

    @Override
    public void execute() {
        System.out.println(String.format("Starting Task %s", name));
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("Task %s finished", name));

    }

    public static Task getTask(String name) {
        return new SimpleTask(name);
    }

}

class Executor implements Runnable {

    private ArrayBlockingQueue<Task> queue;

    private boolean doWork = true;

    public Executor(ArrayBlockingQueue<Task> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (doWork) {
            Task task = null;
            try {
                task = queue.take();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
            task.execute();
        }
    }

    public void finish() {
        doWork = false;
    }

}

class TaskCreator implements Runnable {

    private ArrayBlockingQueue<Task> queue;

    private boolean doWork = true;

    public TaskCreator(ArrayBlockingQueue<Task> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int counter = 0;
        while (doWork) {
            boolean added = queue.offer(SimpleTask.getTask("Task number " + ++counter));
            if (added) {
                System.out.println(String.format("New task added with number %s. Number of tasks in queue - %s",
                        counter, queue.size()));
            } else {
                System.out.println(String.format("Queue is full. Task with number %s is lost. Queue tasks number - %s",
                        counter, queue.size()));

            }
            try {
                Thread.sleep((int) (Math.random() * 8) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void finish() {
        doWork = false;
    }
}
