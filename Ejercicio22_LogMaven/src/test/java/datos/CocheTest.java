package datos;

/*
 * Para poder usar AssertEquals(Coche, Coche) en las pruebas, he tenido
 * que sobreescribir el método equals 
 */

public class CocheTest extends Coche {
	
	public CocheTest(String matricula, String marca, String modelo, double km) {
		super(matricula, marca, modelo, km);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		Coche c = (Coche) obj;
		return 	this.getId() == c.getId() &&
				(this.getMatricula().equals(c.getMatricula()) ||
				this.getMatricula() == null && c.getMatricula() == null) &&
				(this.getMarca().equals(c.getMarca()) ||
				this.getMarca() == null && c.getMarca() == null) &&
				(this.getModelo().equals(c.getModelo()) ||
				this.getModelo() == null && c.getModelo() == null) &&
				this.getKm() == (c.getKm());
	}
}
