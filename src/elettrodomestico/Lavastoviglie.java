package elettrodomestico;

public class Lavastoviglie extends Elettrodomestico {

	private int programma;
	private boolean detersivo;
	private int sale;
	
	
	public Lavastoviglie(ClasseEnergetica En) {
		
		super(Elettrodomestico.classeEnergeticaTokWh(En), false);
		
		this.programma = 0;
		this.detersivo = false;
		this.sale = 0;
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
		
		if (this.isAcceso() && detersivo && sale>0 && programma>0) {
			
			this.programma--;
			
			this.sale--;
			
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
	
	
	public void caricaSale () {
		
		this.sale = 10;
		
	}
	
	
	public void setProgramma (int numProgramma) {
		
		if ((numProgramma >= 1) && (numProgramma <= 7)) {
			
			this.programma = numProgramma;
			
			this.accendi();
		
		} else if (numProgramma < 1) {
			
			this.programma = 1;
			
		} else if (numProgramma > 7){
			
			this.programma = 7;
		}
	
	}
	
}
