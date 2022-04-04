package Main;

import java.util.Scanner;

import Thread.Thread_nPrimos;

public class Main_nPrimos {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("------ NÚMEROS PRIMOS ------");
		System.out.print("Introduzca tres números: ");
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		
		Runnable n1 = new Thread_nPrimos(num1);
		Thread t1 = new Thread(n1);
		t1.setName("Thread1");
		t1.start();
		
		
		Runnable n2 = new Thread_nPrimos(num2);
		Thread t2 = new Thread(n2);
		t2.setName("Thread2");
		t2.start();
		
		
		Runnable n3 = new Thread_nPrimos(num3);
		Thread t3 = new Thread(n3);
		t3.setName("Thread3");
		t3.start();
	}

}
