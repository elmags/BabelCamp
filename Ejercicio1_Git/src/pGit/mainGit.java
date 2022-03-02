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
	}

}
