package peristencia.interfaces;

import datos.Coche;
import datos.Coches;

public interface DaoCoche {

	public boolean alta(Coche c);
	public boolean baja(int id);
	public boolean modificar(Coche c);
	public Coche buscar(int id);
	public Coche buscar_matricula(String matricula);
	public Coches buscar_marca(String marca);
	public Coches buscar_modelo(String modelo);
	public Coches get();
}
