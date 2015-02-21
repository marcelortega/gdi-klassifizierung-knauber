package uebung04;

import static org.junit.Assert.*;

import org.junit.Test;

public class ByteburgTarifRechner1stTest {

	@Test
	public final void prüfe() {
		assertEquals("Fahrt von 11 nach 12: ", 1, ByteburgTarifRechner.ermittleFahrtkosten(11, 12));
		assertEquals("Fahrt von 53 nach 23: ", 2, ByteburgTarifRechner.ermittleFahrtkosten(53, 23));
	}

}
