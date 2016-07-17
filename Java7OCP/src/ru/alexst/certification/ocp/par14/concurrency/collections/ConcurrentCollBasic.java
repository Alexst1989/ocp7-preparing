package ru.alexst.certification.ocp.par14.concurrency.collections;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

/*
■ ConcurrentHashMap
■ ConcurrentLinkedDeque
■ ConcurrentLinkedQueue
■ ConcurrentSkipListMap
■ ConcurrentSkipListSet

ConcurrentSkipListMap and ConcurrentSkipListSet are sorted.
ConcurrentSkipListMap keys and ConcurrentSkipListSet elements require the
use of the Comparable or Comparator interfaces to enable ordering.

 Be aware that an Iterator for a concurrent collection is weakly consistent; it
can return elements from the point in time the Iterator was created or later.


 
 */
public class ConcurrentCollBasic {
	
	public static void main(String args[]) {
		ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
		
		concurrentHashMap.put("1", 123321);
		System.out.println(String.format("Size = %s", concurrentHashMap.size()));
		System.out.println(String.format("Integer with key 1 = %s", concurrentHashMap.get("1")));
		concurrentHashMap.putIfAbsent("1", 666666);
		System.out.println(String.format("Integer with key 1 = %s", concurrentHashMap.get("1")));

		
		ConcurrentLinkedDeque<String> ConcurrentLinkedDeque = new ConcurrentLinkedDeque<String>();
		ConcurrentLinkedDeque.offer("5"); //First in queue
		ConcurrentLinkedDeque.offer("15");
		ConcurrentLinkedDeque.offer("10");
		System.out.println(String.format("Next = %s", ConcurrentLinkedDeque.poll())); //retreives and removes the head of the queue
		

		System.out.println();
		
		for (String s : ConcurrentLinkedDeque) {
			System.out.println(s);
		}
	}
	
}
