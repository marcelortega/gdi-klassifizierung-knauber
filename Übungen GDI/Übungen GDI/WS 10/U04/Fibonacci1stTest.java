package uebung04;

import static gdi.MakeItSimplePrivate.*;

import org.junit.Test;

public class Fibonacci1stTest {
	
	@Test
	public void vorabTest() throws Exception {
		supplyReadIntValues(0);

		recordOutput();

		Fibonacci.main(null);
		assertOutputContains("0");

		stopRecording();
	}

	
	@Test
	public void vorabTest2() throws Exception {
		supplyReadIntValues(4);
		
		recordOutput();

		Fibonacci.main(null);
		assertOutputContains("0, 1, 1, 2, 3");

		stopRecording();
	}

	
}
