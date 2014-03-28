package impiegato;

public abstract class Impiegato {

	private String nome;
	
	public Impiegato (String nome) {
		
		this.nome = nome;
		
	}
	
	public abstract double paga();

	@Override
	public String toString() {
		return "Impiegato [nome=" + nome + "]";
	}
	
	
	
	
}
