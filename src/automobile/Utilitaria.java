package automobile;

public class Utilitaria extends Automobile {

	public Utilitaria(String marca, String modello, int cilindrata, double velocita, Persona proprietario) {
		super(marca, modello, cilindrata, velocita, proprietario);
		
	}

	@Override
	public void accelera() {
		
		if (this.getVelocita() == 0) {
			
			this.setVelocita(1.0);
			
		} else {
			
			if (this.getCilindrata() < 1200) {
				
				this.setVelocita(this.getVelocita()*(1.10));
				
			} else {
				
				this.setVelocita(this.getVelocita()*(1.50));
				
			}
			
		}

	}

	@Override
	public void cambiaProprieta(Persona nuovoProprietario) {

		if (nuovoProprietario != null) {
			
			this.setProprietario(nuovoProprietario);
			
		}

	}

}
