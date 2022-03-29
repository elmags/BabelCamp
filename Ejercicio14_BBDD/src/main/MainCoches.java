package main;

import datos.Coche;
import persistencia.DaoCocheMySql;

public class MainCoches {

	public static void main(String[] args) {
		Coche c = new Coche();
		DaoCocheMySql dm = new DaoCocheMySql();
		dm.alta(c);

	}

}
