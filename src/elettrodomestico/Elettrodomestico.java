package elettrodomestico;

public abstract class Elettrodomestico {

	private int kWh;
	private boolean acceso;
	
	
	public Elettrodomestico(int kWh, boolean acceso) {
		this.kWh = kWh;
		this.acceso = acceso;
	}

	
	public abstract void accendi();
	
	
	public abstract void spegni();
	
	
	public boolean isAcceso() {
		return acceso;
	}

	
	public void setAcceso(boolean acceso) {
		this.acceso = acceso;
	}

	
	public void commuta() {
		
		if (acceso) {
			
			this.spegni();
			
		} else {
			
			this.accendi();
			
		}
		
	}
	
	
	public int getConsumo (int ore) {
		
		if (ore > 0 && acceso) {
			
			return kWh*ore;
			
		} else { 
			
			return 0;
		
		}
		
	}
	
	
	public static int classeEnergeticaTokWh (ClasseEnergetica En) {
		
		if (En == ClasseEnergetica.A) {
			
			return 300;
			
		} else if (En == ClasseEnergetica.B) {
			
			return 400;
			
		} else {
			
			return 560;
		}
		
	}
	
	
	public abstract int aziona ();
	
	
}
