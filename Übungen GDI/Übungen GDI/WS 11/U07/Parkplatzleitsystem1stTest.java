package uebung07;

import static org.junit.Assert.*;

import org.junit.Test;

public class Parkplatzleitsystem1stTest {

	/* Hier stehen die möglichen Datentypen für die Arrays.
	 * Entfernen Sie einfach den Kommentar für Ihren Datentyp
	 * vom verwendeten Array und lassen Sie die anderen auskommentiert.
	 */
	
//	int[] parkplätze = new int[100];
//	char[] parkplätze[] = new char[100];
//	boolean parkplätze[] = new boolean[100];
//	String[] parkplätze[] = new String[100];
	

	// //////////////////////////////////////////////////////

	@Test
	public void testFindeFreieStelle() {
		assertEquals(1, Parkplatzleitsystem.findeFreieStelle(parkplätze));
	}

	@Test
	public void testZaehleFreieStellen() {
		assertEquals(100, Parkplatzleitsystem.zähleFreieStellen(parkplätze));
	}

	@Test
	public void testAutoFaehrtAufParkplatz() {
		Parkplatzleitsystem.autoFährtAufParkplatz(parkplätze);

		assertEquals(99, Parkplatzleitsystem.zähleFreieStellen(parkplätze));
	}

	@Test
	public void testAutoFaehrtVomParkplatz() {
		Parkplatzleitsystem.autoFährtAufParkplatz(parkplätze);
		Parkplatzleitsystem.autoFährtVomParkplatz(parkplätze);

		assertEquals(100, Parkplatzleitsystem.zähleFreieStellen(parkplätze));
	}
	
}
