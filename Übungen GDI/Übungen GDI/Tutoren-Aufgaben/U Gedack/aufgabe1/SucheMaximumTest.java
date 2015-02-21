package aufgabe1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SucheMaximumTest {

	@Before
	public void setUp() {
		SucheMaximum.maxZahl = Integer.MIN_VALUE;
	}
	
	@Test
	public void testVerarbeiteEingabeUntererRandwert() {
		SucheMaximum.verarbeiteEingabe(Integer.MIN_VALUE);
		assertTrue(SucheMaximum.holeMaximum()==Integer.MIN_VALUE);
	}
	
	@Test
	public void testVerarbeiteEingabeObererRandwert() {
		SucheMaximum.verarbeiteEingabe(Integer.MAX_VALUE);
		assertTrue(SucheMaximum.holeMaximum()==Integer.MAX_VALUE);
	}

	@Test
	public void testVerarbeiteEingabeNull() {
		SucheMaximum.verarbeiteEingabe(11);
		assertEquals(11, SucheMaximum.holeMaximum());
	}
	
	@Test
	public void testVerarbeiteEingaben() {
		SucheMaximum.verarbeiteEingabe(1);
		assertEquals(1, SucheMaximum.holeMaximum());
		SucheMaximum.verarbeiteEingabe(11);
		assertEquals(11, SucheMaximum.holeMaximum());
		SucheMaximum.verarbeiteEingabe(2222);
		assertEquals(2222, SucheMaximum.holeMaximum());
		SucheMaximum.verarbeiteEingabe(333);
		assertEquals(2222, SucheMaximum.holeMaximum());
		SucheMaximum.verarbeiteEingabe(44);
		assertEquals(2222, SucheMaximum.holeMaximum());
		SucheMaximum.verarbeiteEingabe(-55555);
		assertEquals(2222, SucheMaximum.holeMaximum());
	}

}
