package elettrodomestico;

public class Televisore extends Elettrodomestico {

	private int timer;
	
	
	public Televisore(int consumo) {
		
		super(consumo, false);
		this.timer = 0;
		
	}

	@Override
	public void accendi() {
		
		this.setAcceso(true);

	}

	@Override
	public void spegni() {
		
		this.setAcceso(false);
		this.timer = 0;

	}

	@Override
	public int aziona() {
		
		if (this.isAcceso()) {
			
			int consumo = this.getConsumo(1);
			
			if (this.timer > 0) {
				
				this.timer--;
				
				
				if (this.timer == 0) {
					
					this.spegni();
					
				}
				
			}
			
			
			
			return consumo;
			
		} else {
			
			return 0;
			
		}
		
	}

	public int getTimer() {
		return timer;
	}

	public void setTimer(int timer) {
		if(timer < 0)
			timer = 1;
		else if(timer > 10)
			timer = 10;
		this.timer = timer;
	}
	
	

}
