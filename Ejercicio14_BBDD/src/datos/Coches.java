package datos;

import java.util.ArrayList;
import java.util.List;

public class Coches {
	
	private List<Coche> coches;
	
	public Coches() {
		coches = new ArrayList<>();
	}

	public List<Coche> getCoches() {
		return coches;
	}

	public void setCoches(List<Coche> coches) {
		this.coches = coches;
	}
}
