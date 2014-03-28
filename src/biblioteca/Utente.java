package biblioteca;
import java.util.ArrayList;


public class Utente {
	
	private String nome;
	private int massimoPaginePrestito;
	private ArrayList<Libro> libriArr;
	
	
	public Utente(String nome, int massimoPaginePrestito) {
		
		this.nome = nome;
		
		this.massimoPaginePrestito = massimoPaginePrestito;
		
		this.libriArr = new ArrayList<Libro>();
	
	}


	public boolean prendiInPrestito (Libro I) {
		
		if ((I.getNumeroPagine() + this.contaPagineInPrestito()) < this.massimoPaginePrestito) {
			
			libriArr.add(I);
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
	
	public int contaPagineInPrestito() {
		
		int numPagine = 0;
		
		for (Libro lib : libriArr) {
			
			numPagine += lib.getNumeroPagine();
			
		}
		
		return numPagine;
		
		
	}
	
	
	public Libro restituisciLibro() {
		
		if (this.libriArr.size() == 0) {
			
			return null;
			
		} else {
			
			return libriArr.remove(0);
			
		}
		
	}

	

	public String getNome() {
	
		return nome;
	
	}
	


	public int getMassimoPaginePrestito() {
	
		return massimoPaginePrestito;
	
	}


	
	
	public ArrayList<Libro> getLibriArr() {
	
		return libriArr;
	
	}


	
	
	@Override
	public String toString() {
		return "Utente [nome=" + nome + ", massimoPaginePrestito="
				+ massimoPaginePrestito + ", libriArr=" + libriArr
				+ ", contaPagineInPrestito()=" + contaPagineInPrestito() + "]";
	}
	
	
	

}
