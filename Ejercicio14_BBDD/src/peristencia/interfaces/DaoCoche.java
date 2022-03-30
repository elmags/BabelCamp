package peristencia.interfaces;

import java.util.List;

import datos.Coche;
import datos.Coches;

public interface DaoCoche {

	public boolean alta(Coche c);
	public boolean baja(int id);
	public boolean modificar(Coche c);
	public Coche buscar(int id);
	public Coche buscar_matricula(String matricula);
	public Coche buscar_marca(String marca);
	public Coche buscar_modelo(String modelo);
	public Coches get();
}
