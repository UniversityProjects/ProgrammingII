package biblioteca;
import junit.framework.TestCase;


public class TestBiblio extends TestCase {

	public void TestTutto() {
	
		Utente ut1 = new Utente ("Mario Rossi", 600);
	
	
		Libro book1 = new Libro ("La Compagnia Dell'Anello", 150);
	
	
		Libro book2 = new Libro ("Le Due Torri", 170);
	
	
		Libro book3 = new Libro ("Il Ritorno Del Re", 250);
	
	
		Libro rivista = new Rivista ("Gianni", 90, 800);
	
	
		assertEquals(true, ut1.prendiInPrestito(book1));
		
		assertEquals(true, ut1.prendiInPrestito(book2));
		
		assertEquals(true, ut1.prendiInPrestito(book3));
		
		assertEquals(false, ut1.prendiInPrestito(rivista));
	
	
	}	
}
