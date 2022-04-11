package persistencia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import datos.Coche;
import datos.CocheTest;
import negocio.GestorCoche;

public class DaoCocheMySqlTest {

	@Test
	public void buscarTest1() {
		int id = 1;
		
		CocheTest cEsperado = new CocheTest("1234567", "a", "a", 15.0);
		cEsperado.setId(1);
		
		GestorCoche gc = new GestorCoche();
		Coche c = gc.buscar(id);
		
//		assertEquals(cEsperado.getId(), c.getId());
//		assertEquals(cEsperado.getMatricula(), c.getMatricula());
//		assertEquals(cEsperado.getMarca(), c.getMarca());
//		assertEquals(cEsperado.getModelo(), c.getModelo());
//		assertEquals(cEsperado.getKm(), c.getKm(), 0.01);
		
		assertTrue(cEsperado.equals(c));
	}
	
	@Test
	public void buscarTest2() {
		int id = 5;
		
		GestorCoche gc = new GestorCoche();
		Coche c = gc.buscar(id);
		
		assertEquals(null, c);
	}
}
