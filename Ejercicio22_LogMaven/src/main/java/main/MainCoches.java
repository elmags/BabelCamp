package main;

import java.util.Scanner;

import datos.Coche;
import datos.Coches;
import negocio.GestorCoche;

public class MainCoches {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Bienvenido\n");
		GestorCoche gc = new GestorCoche();
		boolean validado = false;
		
		for(int intento = 1; intento < 4 && !validado; intento++) {
			System.out.print(" Usuario: ");
			String username = sc.next();
			System.out.print(" Contraseña: ");
			String password = sc.next();
			System.out.println();
			validado = gc.validar(username, password);
			if (intento == 3 && !validado) System.out.println(" Se han acabado los intentos");
			if (!validado && intento < 3) System.out.println(" Quedan " + (3 - intento) + " intentos\n");
		}
		
		if (validado) {
			boolean salir = false;
			int accion;			

			while (!salir) {
				System.out.println("------- MENÚ -------");
				System.out.println("1. Dar de alta un coche");
				System.out.println("2. Dar de baja un coche");
				System.out.println("3. Modificar un coche");
				System.out.println("4. Buscar coche / coches");
				System.out.println("5. Obtener lista de coches");
				System.out.println("6. Exportar lista de coches");
				System.out.println("7. Salir");
				System.out.println("---------------------");
				System.out.println();
				System.out.print("Introduzca la acción que quiere realizar: ");
				accion = sc.nextInt();
				System.out.println();

				switch (accion) {
				case 1:
					Coche c_alta = datosCoche(sc);
					int alta = gc.alta(c_alta);
					if (alta == 0)
						System.out.println("El coche se ha dado de alta");
					else if (alta == 1)
						System.out.println("La matrícula " + c_alta.getMatricula() + " ya se encuentra en la BBDD");
					else if (alta == 2)
						System.out.println("No se ha podido establecer la conexión con la BBDD");
					else if (alta == 3)
						System.out.println("La matrícula debe tener longitud 7");
					else if (alta == 4)
						System.out.println("El número de kilometros no puede ser negativo");
					System.out.println();
					break;
				case 2:
					System.out.print("Introduzca el id del coche que desea dar de baja: ");
					int id = sc.nextInt();
					boolean baja = gc.baja(id);
					if (baja)
						System.out.println("El coche se ha dado de baja");
					else
						System.out.println("No se ha podido establecer la conexión con la BBDD");
					System.out.println();
					break;
				case 3:
					System.out.print("Introduzca el id del coche que desea modificar: ");
					int id_mod = sc.nextInt();
					System.out.println();

					Coche c_encontrado = gc.buscar(id_mod);
					if (c_encontrado != null)
						System.out.println("El coche se encuentra en la BBDD");
					else {
						System.out.println();
						break;
					}

					Coche c_mod = datosCoche(sc);
					c_mod.setId(id_mod);
					int modificado = gc.modificar(c_mod);
					if (modificado == 0)
						System.out.println("El coche ha sido modificado");
					else if (modificado == 1)
						System.out.println("La matrícula " + c_mod.getMatricula() + " ya se encuentra en la BBDD");
					else if (modificado == 2)
						System.out.println("No se ha podido establecer la conexión con la BBDD");
					else if (modificado == 3)
						System.out.println("La matrícula debe tener longitud 7");
					else if (modificado == 4)
						System.out.println("El número de kilometros no puede ser negativo");
					System.out.println();
					break;
				case 4:
					buscar(sc, gc);
					System.out.println();
					break;
				case 5:
					Coches cs = gc.get();
					if (cs != null)
						System.out.println(cs.toString());
					System.out.println();
					break;
				case 6:
					exportar(sc, gc);
					break;
				case 7:
					salir = true;
					break;
				}
			}
		}
	}

	// Métodos auxiliares
	private static Coche datosCoche(Scanner sc) {
		System.out.println("Introduzca los datos del coche: ");
		System.out.print("	 Matrícula: ");
		String matricula = sc.next();
		System.out.print("	     Marca: ");
		String marca = sc.next();
		System.out.print("	    Modelo: ");
		String modelo = sc.next();
		System.out.print("	Kilometros: ");
		double km = sc.nextDouble();
		System.out.println();

		return new Coche(matricula, marca, modelo, km);
	}

	private static void buscar(Scanner sc, GestorCoche gc) {
		System.out.println("---------------------");
		System.out.println("1. Id");
		System.out.println("2. Matrícula");
		System.out.println("3. Marca");
		System.out.println("4. Modelo");
		System.out.println("---------------------");
		System.out.println();
		System.out.print("Introduzca como quiere realizar la busqueda: ");
		int aux_accion = sc.nextInt();
		System.out.println();

		switch (aux_accion) {
		case 1:
			System.out.print("Introduzca el id: ");
			int id = sc.nextInt();
			Coche c_id = gc.buscar(id);
			if (c_id != null)
				System.out.println(c_id.toString());
			break;
		case 2:
			System.out.print("Introduzca la matrícula: ");
			String matricula = sc.next();
			Coche c_matricula = gc.buscar_matricula(matricula);
			if (c_matricula != null)
				System.out.println(c_matricula.toString());
			break;
		case 3:
			System.out.print("Introduzca la marca: ");
			String marca = sc.next();
			Coches cs_marca = gc.buscar_marca(marca);
			if (!cs_marca.getCoches().isEmpty())
				System.out.println(cs_marca.getCoches().toString());
			else
				System.out.println("No se han encontrado coches con marca " + marca);
			break;
		case 4:
			System.out.print("Introduzca el modelo: ");
			String modelo = sc.next();
			Coches cs_modelo = gc.buscar_modelo(modelo);
			if (!cs_modelo.getCoches().isEmpty())
				System.out.println(cs_modelo.getCoches().toString());
			else
				System.out.println("No se han encontrado coches con modelo " + modelo);
			break;
		}
	}

	private static void exportar(Scanner sc, GestorCoche gc) {
		System.out.println("------- FORMATOS -------");
		System.out.println("1. JSON");
		System.out.println("2. PDF");
		System.out.println("3. EXCEL");
		System.out.println("---------------------");
		System.out.println();
		System.out.print("Introduzca como quiere exportar el listado: ");
		int aux_accion = sc.nextInt();
		System.out.println();
		Coches cs = gc.get();

		switch (aux_accion) {
		case 1:
			gc.ficheroJson(cs);
			break;
		case 2:
			gc.ficheroPdf(cs);
			break;
		case 3:
			gc.ficheroExcel(cs);
			break;
		}
	}
}
