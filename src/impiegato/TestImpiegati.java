package impiegato;
import java.util.ArrayList;


public class TestImpiegati {


	public static void main(String[] args) {
		
		ArrayList<Impiegato> arrayImpiegati = new ArrayList<Impiegato>();
		
		arrayImpiegati.add(new Salariato ("Rossi",1200));
		
		arrayImpiegati.add(new Salariato ("Verdi",1000));
		
		arrayImpiegati.add(new AdOre ("Bianchi",1600,10));
		
		arrayImpiegati.add(new AdOre ("Blu",2000,9));
		
		arrayImpiegati.add(new AdOre ("Neri",150,9));
		
		for (Impiegato el : arrayImpiegati) {
			
			System.out.println (el.toString());
		
		}
		

	}

}
