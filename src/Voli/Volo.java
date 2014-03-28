package Voli;


public abstract class Volo {
	private String aeroportoPartenza;
	private String aeroportoArrivo;
	
	public Volo(String aeroportoPartenza, String aeroportoArrivo) throws VoloNonValidoException {
		if(!Aeroporti.aeroportoValido(aeroportoPartenza)) throw new VoloNonValidoException();
		if(!Aeroporti.aeroportoValido(aeroportoArrivo)) throw new VoloNonValidoException();
		this.aeroportoPartenza = aeroportoPartenza;
		this.aeroportoArrivo = aeroportoArrivo;
	}
	
	public String getAeroportoPartenza(){
		return aeroportoPartenza;
	}
	
	public String getAeroportoArrivo(){
		return aeroportoArrivo;
	}

	public abstract int getNumeroTratte();

	public abstract int getDurataInMinuti();

	public String toString(){
		return "Volo da " + getAeroportoPartenza() + " a " + getAeroportoArrivo() + " - tratte " + getNumeroTratte() + " - durata minuti " + getDurataInMinuti();
	}
}
