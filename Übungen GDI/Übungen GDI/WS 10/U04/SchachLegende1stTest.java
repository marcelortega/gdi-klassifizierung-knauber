package uebung04;

import static gdi.MakeItSimplePrivate.*;

import org.junit.Test;

public class SchachLegende1stTest {
	
	@Test
	public void vorabTest() throws Exception {
		supplyReadIntValues(1);

		recordOutput();

		SchachLegende.main(null);
		assertOutputContains("1");

		stopRecording();
	}

	
	@Test
	public void vorabTest2() throws Exception {
		supplyReadIntValues(5);

		recordOutput();

		SchachLegende.main(null);
		assertOutputContains("31");

		stopRecording();
	}
	
	
}
	

