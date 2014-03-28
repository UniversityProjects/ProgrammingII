package automobile;

public abstract class Automobile {

	private String marca;
		
	private String modello;
		
	private int cilindrata;
		
	private double velocita;
		
	protected Persona proprietario;

	
	public Automobile(String marca, String modello, int cilindrata, double velocita, Persona proprietario) {
	
		this.marca = marca;
		
		this.modello = modello;
		
		this.cilindrata = cilindrata;
		
		this.velocita = velocita;
		
		this.proprietario = proprietario;
	
	}

	public abstract void accelera();
		
	public abstract void cambiaProprieta (Persona nuovoProrietario);

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public int getCilindrata() {
		return cilindrata;
	}

	public void setCilindrata(int cilindrata) {
		this.cilindrata = cilindrata;
	}

	public double getVelocita() {
		return velocita;
	}

	public void setVelocita(double velocita) {
		this.velocita = velocita;
	}

	public Persona getProprietario() {
		return proprietario;
	}

	public void setProprietario(Persona proprietario) {
		this.proprietario = proprietario;
	}
		
	
	
}
