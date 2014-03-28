package miniera;

public abstract class Miniera {

	private int riserva;
	
	public Miniera (int riserva) {
		
		this.riserva = riserva;
		
	}
	
	protected abstract int getValore();
	
	public int estraiEVendi(int quantita) {
		
		int value = 0;
		
		if (quantita > this.riserva) {
			
			quantita = riserva;
			
			this.riserva = 0;
			
			value = quantita*this.getValore();
			
		} else {
			
			value = quantita*this.getValore();
			
			riserva -= quantita;
			
		}
		
		return value;
		
	}
	
	
}
