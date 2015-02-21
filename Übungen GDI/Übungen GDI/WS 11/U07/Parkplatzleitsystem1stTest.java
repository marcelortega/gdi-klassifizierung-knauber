package uebung07;

import static org.junit.Assert.*;

import org.junit.Test;

public class Parkplatzleitsystem1stTest {

	/* Hier stehen die m�glichen Datentypen f�r die Arrays.
	 * Entfernen Sie einfach den Kommentar f�r Ihren Datentyp
	 * vom verwendeten Array und lassen Sie die anderen auskommentiert.
	 */
	
//	int[] parkpl�tze = new int[100];
//	char[] parkpl�tze[] = new char[100];
//	boolean parkpl�tze[] = new boolean[100];
//	String[] parkpl�tze[] = new String[100];
	

	// //////////////////////////////////////////////////////

	@Test
	public void testFindeFreieStelle() {
		assertEquals(1, Parkplatzleitsystem.findeFreieStelle(parkpl�tze));
	}

	@Test
	public void testZaehleFreieStellen() {
		assertEquals(100, Parkplatzleitsystem.z�hleFreieStellen(parkpl�tze));
	}

	@Test
	public void testAutoFaehrtAufParkplatz() {
		Parkplatzleitsystem.autoF�hrtAufParkplatz(parkpl�tze);

		assertEquals(99, Parkplatzleitsystem.z�hleFreieStellen(parkpl�tze));
	}

	@Test
	public void testAutoFaehrtVomParkplatz() {
		Parkplatzleitsystem.autoF�hrtAufParkplatz(parkpl�tze);
		Parkplatzleitsystem.autoF�hrtVomParkplatz(parkpl�tze);

		assertEquals(100, Parkplatzleitsystem.z�hleFreieStellen(parkpl�tze));
	}
	
}
