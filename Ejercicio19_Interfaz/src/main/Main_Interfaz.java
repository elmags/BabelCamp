package main;

interface Interfaz<T> { public T operacion(T n1, T n2); }

public class Main_Interfaz {

	public static void main(String[] args) {
		
		Interfaz<Integer> iSuma = ( n1, n2 ) -> n1 + n2;
		Interfaz<Integer> iResta = ( n1, n2 ) -> n1 - n2;
		Interfaz<Integer> iMult = ( n1, n2 ) -> n1 * n2;
		Interfaz<Integer> iDiv = ( n1, n2 ) -> n1 / n2;
		Interfaz<Integer> iPotencia = ( n1, n2 ) -> {
			int res = 1;
			while (n2 > 0) {
				res *= n1;
				n2--;
			}
			return res;
		};
		
		Interfaz<Double> dSuma = ( n1, n2 ) -> n1 + n2;
		Interfaz<Double> dResta = ( n1, n2 ) -> n1 - n2;
		Interfaz<Double> dMult = ( n1, n2 ) -> n1 * n2;
		Interfaz<Double> dDiv = ( n1, n2 ) -> n1 / n2;
		Interfaz<Double> dPotencia = ( n1, n2 ) -> {
			double res = 1;
			while (n2 > 0) {
				res *= n1;
				n2--;
			}
			return res;
		};
		
		System.out.println("iSuma: " + iSuma.operacion(4, 2));
		System.out.println("iResta: " + iResta.operacion(4, 2));
		System.out.println("iMult: " + iMult.operacion(4, 2));
		System.out.println("iDiv: " + iDiv.operacion(4, 2));
		System.out.println("iPotencia: " + iPotencia.operacion(4, 2) + "\n");
		
		System.out.println("dSuma: " + dSuma.operacion(4.0, 2.5));
		System.out.println("dResta: " + dResta.operacion(4.0, 2.5));
		System.out.println("dMult: " + dMult.operacion(4.2, 2.5));
		System.out.println("dDiv: " + dDiv.operacion(5.0, 2.5));
		System.out.println("dPotencia: " + dPotencia.operacion(4.5, 2.0));
	}

}
