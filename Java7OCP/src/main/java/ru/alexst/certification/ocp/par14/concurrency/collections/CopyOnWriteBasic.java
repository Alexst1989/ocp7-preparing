package ru.alexst.certification.ocp.par14.concurrency.collections;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/*
 
 for(Object o : collection) {} // use this
for(int i = 0; i < collection.size(); i++) {} // not this
 
 */

public class CopyOnWriteBasic {
	
	public static void main(String args[]) {
		//Remember two classes
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
		CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>();
		
		Thread t1 = new Thread(new Reader(list));
		Thread t2 = new Thread(new Writer(list));

		t2.start();
		t1.start();
		
	}

}
class Reader implements Runnable {
	
	private static final int N = 3;

	
	CopyOnWriteArrayList<String> list;
	
	public Reader(CopyOnWriteArrayList<String> list) {
		this.list = list;
	}
	
	@Override
	public void run() {
		int counter = 0;
		while (counter < N) {
			//DON'T USE LIKE THIS:
			for (int i = 0; i < list.size(); i++) {
				//Could be index out of bounds
				System.out.println(String.format("reading = %s.%s", counter, list.get(i))); 
			}
			
			//USE THIS
			for (String s : list) {
				
			}
			/*try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
			System.out.println();
			counter++;
		}
	}
	
}

class Writer implements Runnable {

	CopyOnWriteArrayList<String> list;
	
	private static final int N = 3;
	
	public Writer(CopyOnWriteArrayList<String> list) {
		this.list = list;
	}
	
	@Override
	public void run() {
		int counter = 0;
		while (counter < N) {
			list.add(String.valueOf(counter * 2));
			counter++;
			System.out.println(String.format("Add value = %s", list.get(list.size()-1)));
			/*try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		}
		counter = 0;
		while (counter < N) {
			System.out.println(String.format("removed value = %s", list.get(list.size()-1)));
			list.remove(list.size()-1);
			counter++;
			
		}
	}
	
}