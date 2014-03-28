package biblioteca;
public class Libro {
	
	private String titolo;
	private int pagine;
	
	public Libro(String titolo, int pagine){
		
		this.titolo = titolo;
		
		if(pagine > 0) { 
			
			this.pagine = pagine;
		
		} else { 
			
			this.pagine = 0;
		
		}
	
	}
	
	public int getNumeroPagine(){
		
		return pagine;
	
	}
	
	public String toString(){
		
		String s;
		
		s = "Titolo del volume: " + this.titolo;
		
		s += ", numero di pagine: " + this.pagine;
		
		return s;
	
	}

}