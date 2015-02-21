package aufgabe2;

import static org.junit.Assert.*;

import org.junit.Test;

public class PiBerechnungTest {

	@Test
	public void testBerechnePiDieErstenZehnStellen() {
		assertEquals(PiBerechnung.berechnePi(0), 0, 0);
		assertEquals(PiBerechnung.berechnePi(1), 2.0, 0);
		assertEquals(PiBerechnung.berechnePi(2), 4.0, 0);
		assertEquals(PiBerechnung.berechnePi(3), 2.6666666666666665, 0);
		assertEquals(PiBerechnung.berechnePi(4), 3.5555555555555554, 0);
		assertEquals(PiBerechnung.berechnePi(5), 2.8444444444444446, 0);
		assertEquals(PiBerechnung.berechnePi(6), 3.4133333333333336, 0);
		assertEquals(PiBerechnung.berechnePi(7), 2.9257142857142857, 0);
		assertEquals(PiBerechnung.berechnePi(8), 3.343673469387755, 0);
		assertEquals(PiBerechnung.berechnePi(9), 2.9721541950113375, 0);
		assertEquals(PiBerechnung.berechnePi(10), 3.302393550012597, 0);
	}

}
