package datos;

public class Coche {
	
	private int id;
	private String matricula;
	private String marca;
	private String modelo;
	private double km;
	
	public Coche() {}
	
	public Coche(String matricula, String marca, String modelo, double km) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.km = km;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}
}
