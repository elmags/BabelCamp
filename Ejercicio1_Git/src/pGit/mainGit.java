package pGit;

public class mainGit {

	public static void main(String[] args) {
		// Suma de dos números
		System.out.println("Suma de dos números: 5 + 2 = " + Suma.suma(5, 2));
		System.out.println("Suma de dos números: 12 + 7 = " + Suma.suma(12, 7));
			
		System.out.println();
			
		// Suma acumulada
		System.out.println("Suma acumulada: 5 + 2 = " + Suma.sumaAcumulada(Suma.suma(5, 2)));
		System.out.println("Suma acumulada: 7 + 8 = " + Suma.sumaAcumulada(8));
		
		System.out.println();
		
		// Resta de dos números
		System.out.println("Resta de dos números: 5 - 2 = " + Resta.resta(5, 2));
		System.out.println("Resta de dos números: 12 - 7 = " + Resta.resta(12, 7));
				
		System.out.println();
		
		// Resta acumulada
		System.out.println("Resta acumulada: 0 - 14 = " + Resta.restaAcumulada(Resta.resta(16, 2)));
		System.out.println("Resta acumulada: -14 - 8 = " + Resta.restaAcumulada(8));
	}

}
