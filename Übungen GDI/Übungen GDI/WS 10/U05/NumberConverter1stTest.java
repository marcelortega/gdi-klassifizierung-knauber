package uebung05;

import static org.junit.Assert.*;
import org.junit.Test;

public class NumberConverter1stTest {
	
	@Test
	public void testConverter() {
		assertEquals("A5C9F", NumberConverter.convertDecToHex(679071));
	}
}
