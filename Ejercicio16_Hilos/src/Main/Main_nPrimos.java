package Main;

import Thread.Thread_nPrimos;

public class Main_nPrimos {

	public static void main(String[] args) {
		
		Runnable n1 = new Thread_nPrimos(5);
		Thread t1 = new Thread(n1);
		t1.setName("Thread1");
		t1.start();
		
		Runnable n2 = new Thread_nPrimos(10);
		Thread t2 = new Thread(n2);
		t2.setName("Thread2");
		t2.start();
		
		Runnable n3 = new Thread_nPrimos(15);
		Thread t3 = new Thread(n3);
		t3.setName("Thread3");
		t3.start();
	}

}
