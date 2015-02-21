package uebung04;

import static gdi.MakeItSimplePrivate.*;

import org.junit.Before;
import org.junit.Test;

public class AdressRegister1stTest {
	
	@Before
	public void setup() throws Exception {
		init();
	}
	
	@Test
	public void vorabTest() throws Exception {
		supplyReadIntValues(3);
		supplyReadLineValues("");

		recordOutput();

		AdressRegister.main(null);
		assertOutputContains("Andreas, Bernd, Carsten, Dennis, Emil; 5");

		stopRecording();
	}

	@Test
	public void vorabTest2() throws Exception {
		supplyReadIntValues(1);
		supplyReadIntValues(3);
		supplyReadLineValues("", "");

		recordOutput();

		AdressRegister.main(null);
		assertOutputContains("Andreas, Bernd, Dennis, Emil; 4");

		stopRecording();
	}
	
	@Test
	public void vorabTest3() throws Exception {
		supplyReadIntValues(2);
		supplyReadIntValues(4);
		supplyReadLineValues("", "");
		supplyReadLineValues("Jack");

		recordOutput();

		AdressRegister.main(null);
		assertOutputContains("Andreas, Bernd, Carsten, Jack, Dennis, Emil; 6");

		stopRecording();
	}

	
}
