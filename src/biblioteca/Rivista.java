package biblioteca;

public class Rivista extends Libro {

	private int numero;
	
	
	public Rivista(String titolo, int pagine, int numero) {
		
		super(titolo, pagine);
		
		this.numero = numero;
		
	}

	
	@Override
	public String toString() {
		return "Rivista [numero=" + numero + ", getNumeroPagine()="
				+ getNumeroPagine() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	

}
