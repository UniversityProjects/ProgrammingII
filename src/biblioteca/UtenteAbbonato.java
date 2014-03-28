package biblioteca;

public class UtenteAbbonato extends Utente {

	public UtenteAbbonato(String nome, int massimoPaginePrestito) {
		
		super(nome, massimoPaginePrestito);
		
	}
	
	@Override
	public boolean prendiInPrestito (Libro I) {
		
		if (!(I instanceof Rivista)) {
			
			int numPagine = 0;
		
			for (Libro lib : this.getLibriArr()) {
			
				if (!(lib instanceof Rivista)) {
			
					numPagine += lib.getNumeroPagine();
			
				}
				
			}
			
			if ((numPagine + I.getNumeroPagine()) < this.getMassimoPaginePrestito()) {
				
				this.getLibriArr().add(I);
				
				return true;
				
			} else {
				
				return false;
				
			}
		
		} else {
			
			this.getLibriArr().add(I);
			
			return true;
			
		}
	
	}
	
}
