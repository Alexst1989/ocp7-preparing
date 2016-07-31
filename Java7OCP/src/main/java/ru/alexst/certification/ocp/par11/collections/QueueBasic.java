/**
 * 
 */
package ru.alexst.certification.ocp.par11.collections;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 
 
 Inserts the specified element into this queue if it is possible to do so
 immediately without violating capacity restrictions, returning
 {@code true} upon success and throwing an {@code IllegalStateException}
 if no space is currently available.
     *
     * @param e the element to add
     * @return {@code true} (as specified by {@link Collection#add})
     * @throws IllegalStateException if the element cannot be added at this
     *         time due to capacity restrictions
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this queue
     * @throws NullPointerException if the specified element is null and
     *         this queue does not permit null elements
     * @throws IllegalArgumentException if some property of this element
     *         prevents it from being added to this queue
    
    boolean add(E e);

    
     * Inserts the specified element into this queue if it is possible to do
     * so immediately without violating capacity restrictions.
     * When using a capacity-restricted queue, this method is generally
     * preferable to {@link #add}, which can fail to insert an element only
     * by throwing an exception.
     *
     * @param e the element to add
     * @return {@code true} if the element was added to this queue, else
     *         {@code false}
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this queue
     * @throws NullPointerException if the specified element is null and
     *         this queue does not permit null elements
     * @throws IllegalArgumentException if some property of this element
     *         prevents it from being added to this queue
    
    boolean offer(E e);

    
     * Retrieves and removes the head of this queue.  This method differs
     * from {@link #poll poll} only in that it throws an exception if this
     * queue is empty.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
    
    E remove();

    
     * Retrieves and removes the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     
    E poll();

     *
     * Retrieves, but does not remove, the head of this queue.  This method
     * differs from {@link #peek peek} only in that it throws an exception
     * if this queue is empty.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     *
    E element();

    /*
     * Retrieves, but does not remove, the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     *
    E peek();

 
 */
public class QueueBasic {

    public static void main(String args[]) {

        Queue<String> queueList = new LinkedList<String>();
        Queue<String> queuePriority = new PriorityQueue<String>(4);
        addQueue(queueList);
        addQueue(queuePriority);

        offerQueue(queueList);
        offerQueue(queuePriority);
    }

    public static void addQueue(Queue<String> q) {
        q.clear();
        q.add("One");
        q.add("Two");
        q.add("Three");
        q.add("Four");
        q.add("Five");
        printQueue(q);
    }

    public static void offerQueue(Queue<String> q) {
        q.clear();
        q.offer("One");
        q.offer("Two");
        q.offer("Three");
        q.offer("Four");
        q.offer("Five");
        printQueue(q);
    }

    public static void printQueue(Queue<?> q) {
        System.out.println("=========== Start =============");
        for (Object o : q) {
            System.out.println(o);
        }
        System.out.println("============ End ==============");
    }

}
