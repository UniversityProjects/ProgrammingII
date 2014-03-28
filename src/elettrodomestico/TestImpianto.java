package elettrodomestico;
import junit.framework.TestCase;


public class TestImpianto extends TestCase {

	public void testTutto()
	{
		ImpiantoDomotico impianto = new ImpiantoDomotico(400);
		impianto.addElettrodomestico(new Lavatrice(ClasseEnergetica.B));
		impianto.addElettrodomestico(new Lavastoviglie(ClasseEnergetica.A));
		impianto.addElettrodomestico(new Televisore(78));

		((Lavatrice)impianto.getElettrodomestici().get(0)).caricaDetersivo();
		assertEquals(0, impianto.azionaTutto());

		impianto.getElettrodomestici().get(0).accendi();
		assertEquals(0, impianto.azionaTutto());
		
		impianto.getElettrodomestici().get(1).accendi();
		assertEquals(0, impianto.azionaTutto());
		
		impianto.getElettrodomestici().get(2).accendi();
		assertEquals(78, impianto.azionaTutto());
		
		((Televisore)impianto.getElettrodomestici().get(2)).setTimer(4);
		assertEquals(78, impianto.azionaTutto());
		assertEquals(78, impianto.azionaTutto());
		assertEquals(78, impianto.azionaTutto());
		assertEquals(78, impianto.azionaTutto());
		assertEquals(0, impianto.azionaTutto());
		
		System.out.println ("Tv: " + impianto.getElettrodomestici().get(2).isAcceso());
		impianto.getElettrodomestici().get(2).commuta();
		System.out.println ("Tv: " + impianto.getElettrodomestici().get(2).isAcceso());
		assertEquals(78, impianto.azionaTutto());
		System.out.println ("Tv: " + impianto.getElettrodomestici().get(2).isAcceso());
		System.out.println ();
		
		((Lavatrice)impianto.getElettrodomestici().get(0)).setProgramma(7);
		System.out.println ("Lavatrice: " + impianto.getElettrodomestici().get(0).isAcceso());
		System.out.println ("Lavastoviglie: " + impianto.getElettrodomestici().get(1).isAcceso());
		System.out.println ("Tv: " + impianto.getElettrodomestici().get(2).isAcceso());
		assertEquals(478, impianto.azionaTutto());
		assertEquals(78, impianto.azionaTutto());

		((Televisore)impianto.getElettrodomestici().get(2)).setTimer(3);
		((Lavastoviglie)impianto.getElettrodomestici().get(1)).caricaDetersivo();
		assertEquals(78, impianto.azionaTutto());
		assertFalse(impianto.getElettrodomestici().get(0).isAcceso());
		assertFalse(impianto.getElettrodomestici().get(1).isAcceso());
		assertTrue(impianto.getElettrodomestici().get(2).isAcceso());
		assertEquals(78, impianto.azionaTutto());

		((Lavastoviglie)impianto.getElettrodomestici().get(1)).caricaSale();
		((Lavastoviglie)impianto.getElettrodomestici().get(1)).setProgramma(3);
		impianto.getElettrodomestici().get(1).accendi();
		assertEquals(378, impianto.azionaTutto());
		impianto.getElettrodomestici().get(2).spegni();
		assertEquals(300, impianto.azionaTutto());
		assertEquals(300, impianto.azionaTutto());
		assertEquals(0, impianto.azionaTutto());
		assertEquals(0, impianto.azionaTutto());
		assertEquals(0, impianto.azionaTutto());	
	}
}