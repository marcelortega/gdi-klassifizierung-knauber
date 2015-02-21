package uebung03;

import static gdi.MakeItSimplePrivate.*;

import org.junit.Test;

public class Palindrome1stTest {

	@Test
	public void vorabTest1() throws Exception {
		supplyReadLineValues("aba");

		recordOutput();

		Palindrome.main(null);
		assertOutputContains("Palindrom erkannt");

		stopRecording();
	}

	@Test
	public void vorabTest2() throws Exception {
		supplyReadLineValues("abba");

		recordOutput();

		Palindrome.main(null);
		assertOutputContains("Palindrom erkannt");

		stopRecording();
	}
	
	@Test
	public void vorabTest3() throws Exception {
		supplyReadLineValues("abb");

		recordOutput();

		Palindrome.main(null);
		assertOutputContains("Kein Palindrom");

		stopRecording();
	}
	
}
