package Voli;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;


public class RegistroVoli {
	private Map<String, Volo> voli;

	public RegistroVoli(){
		voli = new  Hashtable<String, Volo>();
	}
	
	public Volo getVolo(String codice){
		return voli.get(codice);
	}

	public boolean aggiungiVolo(String codice, Volo volo){
		if(codice.length() == 5){
			voli.put(codice, volo);
			return true;
		}
		else return false;
	}
	
	public boolean aggiungiVolo(String codice, String aeroportoPartenza, String aeroportoArrivo, int durata){
		try {
			return aggiungiVolo(codice, new VoloDiretto(aeroportoPartenza, aeroportoArrivo, durata));
		} catch (VoloNonValidoException e) {
			return false;
		}
	}
	
	public String[] getListaCodiciDeiVoli(){
		Set<String> codiciSet = voli.keySet();
		String[] ret = (String[]) codiciSet.toArray();
		return ret;
	}

}
