package uebung03;

import static org.junit.Assert.*;

import org.junit.Test;

public class Conversion1stTest {

	@Test
	public void vorabTest() throws Exception {
		assertEquals(123, Conversion.convert("123"));
		assertEquals(3, Conversion.convert("3"));
		assertEquals(0, Conversion.convert("0"));
		assertEquals(0, Conversion.convert("x"));
	}

}
