package pGit;

public class Suma {
	private static int acumulado = 0;
	
	public static int suma(int x, int y) {
		return x + y;
	}
	
	public static int sumaAcumulada(int x) {
		acumulado = suma(acumulado, x);
		return acumulado;
	}
	
	public static double suma(int x, double y) {
		return (double) x + y;
	}
}
