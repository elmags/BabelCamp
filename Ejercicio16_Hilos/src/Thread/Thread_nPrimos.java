package Thread;

public class Thread_nPrimos implements Runnable {
	
	private int numero;
	
	public Thread_nPrimos(int numero) {
		this.numero = numero;
	}
	
	@Override
	public void run() {
		if (esPrimo(numero))
			System.out.println(Thread.currentThread().getName() + ": " + 
					"El número " + numero + " es primo");
		else 
			System.out.println(Thread.currentThread().getName() + ": " + 
				"El número " + numero + " no es primo");
	}
	
	private boolean existeDivisor (int a, int b, int n) {
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
	
	private boolean esPrimo(int n) {
		if (n == 1 || n == 0) return false;
		return !existeDivisor (2, n-1, n);
	}
}
