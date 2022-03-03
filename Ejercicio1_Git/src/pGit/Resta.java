package pGit;

public class Resta {
	private static int acumulado = 0;
	
	public static int resta(int x, int y) {
		return x - y;
	}
	
	public static int restaAcumulada(int x) {
		acumulado = resta(acumulado, x);
		return acumulado;
	}
	
	public static double resta(int x, double y) {
		return (double) x - y;
	}
}
