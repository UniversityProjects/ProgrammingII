package Voli;


public class VoloMultiTratta extends Volo{
	private VoloDiretto[] tratte;

	public VoloMultiTratta(VoloDiretto[] tratte) throws VoloNonValidoException{
		super(tratte[0].getAeroportoPartenza(), tratte[tratte.length - 1].getAeroportoArrivo());
		if(tratte.length < 2) throw new VoloNonValidoException();
		for(int i = 0; i < tratte.length - 1; i++){
			if(tratte[i+1] == null || !tratte[i].getAeroportoArrivo().equals(tratte[i+1].getAeroportoPartenza()))
				throw new VoloNonValidoException();
		}
		this.tratte = tratte;
	}

	@Override
	public int getDurataInMinuti() {
		int durata = 0;
		for(int i = 0; i < tratte.length; i++)
			durata += tratte[i].getDurataInMinuti();
		return durata;
	}

	@Override
	public int getNumeroTratte() {
		return tratte.length;
	}
}
