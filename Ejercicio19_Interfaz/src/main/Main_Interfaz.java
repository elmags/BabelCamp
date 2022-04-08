package main;

interface Interfaz<T> { public T operacion(T n1, T n2); }
interface InterfazMix<T,U,R> { public R operacion(T n1, U n2); }

public class Main_Interfaz {

	public static void main(String[] args) {
		
		/* Operaciones con dos número enteros */
		Interfaz<Integer> iSuma = ( n1, n2 ) -> n1 + n2;
		Interfaz<Integer> iResta = ( n1, n2 ) -> n1 - n2;
		Interfaz<Integer> iMult = ( n1, n2 ) -> n1 * n2;
		Interfaz<Integer> iDiv = ( n1, n2 ) -> n1 / n2;
		Interfaz<Integer> iPotencia = ( n1, p ) -> {
			if (n1 > 0 && p == 0) return n1;
			else if (n1 == 0 && p >= 0) return 0;
			else {
				int res = 1;
				while (p > 0) {
					res *= n1;
					p--;
				}
				return res;
			}
		};
		
		/* Operaciones con dos número double */
		Interfaz<Double> dSuma = ( n1, n2 ) -> n1 + n2;
		Interfaz<Double> dResta = ( n1, n2 ) -> n1 - n2;
		Interfaz<Double> dMult = ( n1, n2 ) -> n1 * n2;
		Interfaz<Double> dDiv = ( n1, n2 ) -> n1 / n2;
		Interfaz<Double> dPotencia = ( n1, p ) -> Math.pow(n1, p);
		
		/* Operaciones con un número entero y un double */
		InterfazMix<Integer, Double, Double> idSuma = ( n1, n2 ) -> n1 + n2;
		InterfazMix<Integer, Double, Double> idResta = ( n1, n2 ) -> n1 - n2;
		InterfazMix<Integer, Double, Double> idMult = ( n1, n2 ) -> n1 * n2;
		InterfazMix<Integer, Double, Double> idDiv = ( n1, n2 ) -> n1 / n2;
		InterfazMix<Integer, Double, Double> idPotencia = ( n1, p ) -> Math.pow(n1, p);		
		
		System.out.println("iSuma: " + iSuma.operacion(4, 2));
		System.out.println("iResta: " + iResta.operacion(4, 2));
		System.out.println("iMult: " + iMult.operacion(4, 2));
		System.out.println("iDiv: " + iDiv.operacion(4, 2));
		System.out.println("iPotencia: " + iPotencia.operacion(4, 2) + "\n");
		
		System.out.println("dSuma: " + dSuma.operacion(4.0, 2.5));
		System.out.println("dResta: " + dResta.operacion(4.0, 2.5));
		System.out.println("dMult: " + dMult.operacion(4.2, 2.5));
		System.out.println("dDiv: " + dDiv.operacion(5.0, 2.5));
		System.out.println("dPotencia: " + dPotencia.operacion(4.5, 2.0) + "\n");
		
		System.out.println("idSuma: " + idSuma.operacion(4, 2.5));
		System.out.println("idResta: " + idResta.operacion(4, 2.5));
		System.out.println("idMult: " + idMult.operacion(4, 2.5));
		System.out.println("idDiv: " + idDiv.operacion(4, 2.5));
		System.out.println("idPotencia: " + idPotencia.operacion(4, 2.5));
	}

}
