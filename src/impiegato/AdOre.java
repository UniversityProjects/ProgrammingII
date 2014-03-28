package impiegato;

public class AdOre extends Impiegato {

	private double pagaOraria;
	private double ore;
	
	public AdOre(String nome, int ore, int pagaOraria) {
		
		super(nome);
		this.ore = ore;
		this.pagaOraria = pagaOraria;
		
	}
	
	@Override
	public double paga() {

		return pagaOraria*ore;
		
	}

	@Override
	public String toString() {
		return "AdOre [pagaOraria=" + pagaOraria + ", ore=" + ore + ", paga()="
				+ paga() + ", toString()=" + super.toString() + "]";
	}

	
	
	

}
