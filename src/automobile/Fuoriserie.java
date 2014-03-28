package automobile;

public class Fuoriserie extends Automobile {

	public Fuoriserie(String marca, String modello, int cilindrata, double velocita, Persona proprietario) {
		super(marca, modello, cilindrata, velocita, proprietario);
		
	}

	@Override
	public void accelera() {
		
		if (this.getVelocita() == 0) {
			
			this.setVelocita(1.0);
			
		} else {
			
			this.setVelocita(this.getVelocita()*2);
				
		}
		
	}

	@Override
	public void cambiaProprieta(Persona nuovoProprietario) {
		
		if (nuovoProprietario != null) {
			
			if (nuovoProprietario.getStipendio() > 10000) {
				
				this.setProprietario(nuovoProprietario);
			
			}
			
		}

	}

}
