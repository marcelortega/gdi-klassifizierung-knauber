package uebung03;

import static gdi.MakeItSimplePrivate.*;

import org.junit.Test;

public class Teiler1stTest {
	
	@Test
	public void vorabTest() throws Exception {
		supplyReadIntValues(6);
		supplyReadLineValues("");

		recordOutput();

		Teiler.main(null);
		assertOutputContains("1");
		assertOutputContains("2");
		assertOutputContains("3");
		assertOutputContains("6");

		stopRecording();
	}

}
