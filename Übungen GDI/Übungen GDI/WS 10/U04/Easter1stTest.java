package uebung04;

import static gdi.MakeItSimplePrivate.*;

import org.junit.Test;

public class Easter1stTest {

	@Test
	public void thisYear() throws Exception {
		checkCorrectYear(2010,  "4.4.");
	}

	private void checkCorrectYear(int year, String date) {
		supplyReadIntValues(year);
		supplyReadLineValues("");
		
		recordOutput();
		
		Easter.main(null);
		
		assertOutputContains(date);
	}
	
}
