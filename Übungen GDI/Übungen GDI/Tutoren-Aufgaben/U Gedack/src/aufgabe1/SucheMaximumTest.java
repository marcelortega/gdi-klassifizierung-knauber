package aufgabe1;

import static org.junit.Assert.*;
import org.junit.Test;

public class SucheMaximumTest {

	@Test
	public void testVerarbeiteEingabeUntererRandwert() {
		int maxZahl = Integer.MIN_VALUE;
		assertTrue(SucheMaximum.verarbeiteEingabe(Integer.MIN_VALUE, maxZahl)==Integer.MIN_VALUE);
	}
	
	@Test
	public void testVerarbeiteEingabeObererRandwert() {
		int maxZahl = Integer.MIN_VALUE;
		assertTrue(SucheMaximum.verarbeiteEingabe(Integer.MAX_VALUE, maxZahl)==Integer.MAX_VALUE);
	}

	@Test
	public void testVerarbeiteEingabeNull() {
		int maxZahl = Integer.MIN_VALUE;
		SucheMaximum.verarbeiteEingabe(11, maxZahl);
		assertEquals(11, SucheMaximum.verarbeiteEingabe(11, maxZahl));
	}
	
	@Test
	public void testVerarbeiteEingaben() {
		int maxZahl = Integer.MIN_VALUE;
		maxZahl = SucheMaximum.verarbeiteEingabe(1, maxZahl);
		assertEquals(1, maxZahl);
		maxZahl = SucheMaximum.verarbeiteEingabe(11, maxZahl);
		assertEquals(11, maxZahl);
		maxZahl = SucheMaximum.verarbeiteEingabe(2222, maxZahl);
		assertEquals(2222, maxZahl);
		maxZahl = SucheMaximum.verarbeiteEingabe(333, maxZahl);
		assertEquals(2222, maxZahl);
		maxZahl = SucheMaximum.verarbeiteEingabe(44, maxZahl);
		assertEquals(2222, maxZahl);
		maxZahl = SucheMaximum.verarbeiteEingabe(-55555, maxZahl);
		assertEquals(2222, maxZahl);
	}

}
