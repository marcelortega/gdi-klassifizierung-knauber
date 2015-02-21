package uebung03;

import static gdi.MakeItSimplePrivate.*;

import org.junit.Test;

public class Wochentagsberechnung1stTest {
	
	@Test
	public void vorabTest() throws Exception {
		supplyReadIntValues(13);
		supplyReadLineValues("");
		supplyReadIntValues(10);
		supplyReadLineValues("");
		supplyReadIntValues(2010);
		supplyReadLineValues("");

		recordOutput();

		Wochentagsberechnung.main(null);
		assertOutputContains("Mittwoch");

		stopRecording();
	}

}
