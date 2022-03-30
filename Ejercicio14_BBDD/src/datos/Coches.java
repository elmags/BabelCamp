package datos;

import java.util.ArrayList;
import java.util.List;

public class Coches {
	
	private List<Coche> coches;
	
	public Coches() {
		coches = new ArrayList<>();
	}
	
	public void addCoche(Coche coche) {
		this.coches.add(coche);
	}

	public List<Coche> getCoches() {
		return coches;
	}

	public void setCoches(List<Coche> coches) {
		this.coches = coches;
	}
}
