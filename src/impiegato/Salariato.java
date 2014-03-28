package impiegato;

public class Salariato extends Impiegato {

	private double salario;
	
	public Salariato(String nome, double salario) {
		
		super(nome);
		this.salario = salario;
			
	}

	@Override
	public double paga() {
		
		return salario;
	
	}

	@Override
	public String toString() {
		return "Salariato [salario=" + salario + ", paga()=" + paga()
				+ ", toString()=" + super.toString() + "]";
	}
	
	

}
