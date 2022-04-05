package Main;

import java.util.Scanner;

public class Main_nPrimos {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("------ NÚMEROS PRIMOS ------");
		System.out.print("Introduzca tres números: ");
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		
		Runnable n1 = () -> {
			if (esPrimo(num1))
				System.out.println(Thread.currentThread().getName() + ": " + 
						"El número " + num1 + " es primo");
			else 
				System.out.println(Thread.currentThread().getName() + ": " + 
						"El número " + num1 + " no es primo");
		};
		
		Runnable n2 = () -> {
			if (esPrimo(num2))
				System.out.println(Thread.currentThread().getName() + ": " + 
						"El número " + num2 + " es primo");
			else 
				System.out.println(Thread.currentThread().getName() + ": " + 
					"El número " + num2 + " no es primo");
		};
		
		Runnable n3 = () -> {
				if (esPrimo(num3))
					System.out.println(Thread.currentThread().getName() + ": " + 
							"El número " + num3 + " es primo");
				else 
					System.out.println(Thread.currentThread().getName() + ": " + 
						"El número " + num3 + " no es primo");
		};
		
		Thread t1 = new Thread(n1);
		Thread t2 = new Thread(n2);
		Thread t3 = new Thread(n3);
		
		t1.setName("Thread1");
		t2.setName("Thread2");
		t3.setName("Thread3");		
		
		t1.start();
		t2.start();
		t3.start();
	}
	
	// Métodos auxiliares	
	private static boolean existeDivisor (int a, int b, int n) {
		boolean resultado = false;
	    int i = a;
	    while (i <= b && !resultado){
	      if (n % i == 0)
	        resultado = true;
	      else
	        i = i+1;
	    } 
	    return resultado;
	}
	
	private static boolean esPrimo(int n) {
		if (n == 1 || n == 0) return false;
		return !existeDivisor (2, n-1, n);
	}

}
