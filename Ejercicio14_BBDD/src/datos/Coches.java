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

	@Override
	public String toString() {
		String str = "Coches [coches=\n";
		for(Coche c : coches) {
		str +=  "        Coche [id=" + c.getId() + ", matricula=" + c.getMatricula() + 
				", marca=" + c.getMarca() + ", modelo=" + c.getModelo() + 
				", km=" + c.getKm() + "]\n";
		}
		return str + "       ]";
	}
}
