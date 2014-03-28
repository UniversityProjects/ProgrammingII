package elettrodomestico;
import java.util.ArrayList;


public class ImpiantoDomotico {

	private int contratto;
	
	private ArrayList<Elettrodomestico> el;
	
	public ImpiantoDomotico (int contratto, int numElettro) {
		
		this.contratto = contratto;
		
		this.el = new ArrayList<Elettrodomestico>(numElettro);
		
	}
	
	
	public ImpiantoDomotico (int contratto) {
		
		this(contratto,0);
		
	}


	public ImpiantoDomotico () {
	
		this(10000,0);
	
	}
	
	public void addElettrodomestico(Elettrodomestico newElettro) {
		
		el.add(newElettro);
		
	}
	
	
	public int azionaTutto () {
		
		int consumoTot = 0;
		
		for (Elettrodomestico elect: el) {
			
			consumoTot += elect.aziona();
			System.out.println (consumoTot);
		}
		
		int cons = consumoTot;
		
		int i = 0;
		
		while (consumoTot > this.contratto && i<el.size()) {
			
			if (el.get(i).isAcceso()) {
			
				consumoTot -=el.get(i).getConsumo(1);
			
				el.get(i).spegni();
			
			}
			
			i++;
			
		}
		
		return cons;
		
	}


	public int getContratto() {
		return contratto;
	}


	public void setContratto(int contratto) {
		this.contratto = contratto;
	}


	public ArrayList<Elettrodomestico> getElettrodomestici() {
		return el;
	}

	
	
	
	
}
