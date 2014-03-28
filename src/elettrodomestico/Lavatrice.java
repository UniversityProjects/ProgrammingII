package elettrodomestico;

public class Lavatrice extends Elettrodomestico {

	private int programma;
	private boolean detersivo;
		
	
	public Lavatrice(ClasseEnergetica En) {
		
		super(Elettrodomestico.classeEnergeticaTokWh(En), false);
		
		this.programma = 0;
		this.detersivo = false;
	
	}

	
	@Override
	public void accendi() {
		
		if (detersivo) {
			
			this.setAcceso(true);
			
		}

	}

	
	@Override
	public void spegni() {
		
		this.setAcceso(false);
		
		this.detersivo = false;
		
	}

	
	@Override
	public int aziona() {
		
		if (this.isAcceso() && detersivo && programma>0) {
			
			this.programma--;
			
			int consumo = this.getConsumo(1);
			
			if (this.programma == 0) {
				
				this.spegni();
				
			}
			
			return consumo;
			
		} else {
			
			return 0;
			
		}
		
	}

	
	public void caricaDetersivo () {
		
		this.detersivo = true;
		
	}
	
	
	public void setProgramma (int numProgramma) {
		
		if ((numProgramma >= 1) && (numProgramma <= 5)) {
			
			this.programma = numProgramma;
			
			this.accendi();
		
		} else if (numProgramma < 1) {
			
			this.programma = 1;
			
		} else if (numProgramma > 5){
			
			this.programma = 5;
		}
	
	}
	
}
