package Voli;

import junit.framework.TestCase;


public class TestCompitino extends TestCase {

	private Volo v;
	
	/** Verifica la corretta istanziazione di un volo diretto */
	public void testVoloDiretto() throws VoloNonValidoException{
		v = new VoloDiretto("LIN", "FCO", 45);
		assertEquals("FCO", v.getAeroportoArrivo());
		assertEquals("LIN", v.getAeroportoPartenza());
		assertEquals(45, v.getDurataInMinuti());
		assertEquals(1, v.getNumeroTratte(), 1);
	}
	
	/** Verifica la gestione degli errori in fase di costruzione di un volo diretto */
	public void testGestioneErroriVoloDiretto() {
		try {
			v = new VoloDiretto("AAA", "FCO", 45);
			fail();
		} catch (VoloNonValidoException e) { /*OK*/}
		try {
			v = new VoloDiretto("FCO", null, 45);
			fail();
		} catch (VoloNonValidoException e) { /*OK*/}
		try {
			v = new VoloDiretto("LIN", "FCO", 0);
			fail();
		} catch (VoloNonValidoException e) { /*OK*/}
	}

	/** Verifica il toString per un volo diretto */
	public void testToStringVoloDiretto() throws VoloNonValidoException{
		Volo v = new VoloDiretto("LIN", "FCO", 45);
		assertTrue(v.toString().indexOf("FCO") >= 0);
		assertTrue(v.toString().indexOf("LIN") >= 0);
		assertTrue(v.toString().indexOf("45") >= 0);
		assertTrue(v.toString().indexOf("1") >= 0);
	}

	/** Verifica la corretta istanziazione di un volo multi tratta */
	public void testVoloMultiTratta() throws VoloNonValidoException{
		VoloDiretto v1 = new VoloDiretto("MXP", "LIN", 20);
		VoloDiretto v2 = new VoloDiretto("LIN", "FCO", 60);
		VoloDiretto v3 = new VoloDiretto("FCO", "SFO", 665);
		VoloDiretto vv[] = {v1, v2, v3};
		VoloMultiTratta v = new VoloMultiTratta(vv);
		assertEquals("SFO", v.getAeroportoArrivo());
		assertEquals("MXP", v.getAeroportoPartenza());
		assertEquals(745, v.getDurataInMinuti());
		assertEquals(3, v.getNumeroTratte());
	}

	/** Verifica la gestione degli errori in fase di costruzione di un volo multi tratta */
	public void testGestioneErroriVoloMultiTratta() throws VoloNonValidoException {
		VoloDiretto v1 = new VoloDiretto("MXP", "LIN", 60);
		VoloDiretto v2 = new VoloDiretto("LIN", "FCO", 60);
		
		try {
			VoloDiretto vv[] = {v1};
			v = new VoloMultiTratta(vv);
			fail();
		} catch (VoloNonValidoException e) { /*OK*/}
		try {
			VoloDiretto vv[] = {v1, v2, v2};
			v = new VoloMultiTratta(vv);
			fail();
		} catch (VoloNonValidoException e) { /*OK*/}
	}

	/** Verifica il toString per un volo multi tratta */
	public void testToStringVoloMultiTratta() throws VoloNonValidoException{
		VoloDiretto v1 = new VoloDiretto("LIN", "FCO", 60);
		VoloDiretto v2 = new VoloDiretto("FCO", "SFO", 665);
		VoloDiretto vv[] = {v1, v2};
		VoloMultiTratta v = new VoloMultiTratta(vv);
		assertTrue(v.toString().indexOf("SFO") >= 0);
		assertTrue(v.toString().indexOf("LIN") >= 0);
		assertTrue(v.toString().indexOf("725") >= 0);
		assertTrue(v.toString().indexOf("2") >= 0);
	}
	
	/** Verifica il metodo aggiungiVolo(codice, Volo) della classe RegistroVoli */
	public void testRegistroAgggiungiVolo() throws VoloNonValidoException{
		VoloDiretto v1 = new VoloDiretto("MXP", "LIN", 20);
		VoloDiretto v2 = new VoloDiretto("LIN", "FCO", 60);
		VoloDiretto v3 = new VoloDiretto("FCO", "SFO", 665);
		VoloDiretto vv[] = {v1, v2, v3};
		VoloMultiTratta v = new VoloMultiTratta(vv);
		RegistroVoli reg = new RegistroVoli();
		assertFalse(reg.aggiungiVolo("AB1", v1)); //codice non ha 5 caratteri
		assertTrue(reg.aggiungiVolo("P2A01", v1)); //aggiunge un volo diretto 
		assertTrue(reg.aggiungiVolo("P2A02", v));  //aggiunge un volo multi tratta
	}	

	/** Verifica il metodo aggiungiVolo(codice, aeroporto...) della classe RegistroVoli */
	public void testRegistroAggiungiNuovoVoloDiretto() throws VoloNonValidoException{
		RegistroVoli reg = new RegistroVoli();
		assertFalse(reg.aggiungiVolo("P2A03", "LIN", "AAA", 660));  //aeroporto arrivo non esistente
		assertTrue(reg.aggiungiVolo("P2A03", "LIN", "FCO", 660));  //aggiunge un altro volo diretto	
	}	
	
	/** Verifica il metodo getListaCodiciDeiVoli della classe RegistroVoli */
	public void testRegistroGetListaCodiciDeiVoli() throws VoloNonValidoException{
		VoloDiretto v1 = new VoloDiretto("MXP", "LIN", 20);
		RegistroVoli reg = new RegistroVoli();
		reg.aggiungiVolo("P2A01", v1);
		reg.aggiungiVolo("P2A03", "LIN", "FCO", 660);
		String codici[] = reg.getListaCodiciDeiVoli();
		assertEquals(2, codici.length);
		String s = codici[0] + codici[1];
		assertTrue(s.indexOf("P2A01") >= 0);
		assertTrue(s.indexOf("P2A03") >= 0);
	}	
	
	/** Verifica il metodo getVolo della classe RegistroVoli */
	public void testRegistroGetVolo() throws VoloNonValidoException{
		VoloDiretto v1 = new VoloDiretto("MXP", "LIN", 20);
		RegistroVoli reg = new RegistroVoli();
		reg.aggiungiVolo("P2A01", v1);
		reg.aggiungiVolo("P2A03", "LIN", "FCO", 660);
		Volo v = reg.getVolo("P2A03");
		assertEquals(660, v.getDurataInMinuti());
		v = reg.getVolo("P2A02");
		assertNull(v);
	}	
}
