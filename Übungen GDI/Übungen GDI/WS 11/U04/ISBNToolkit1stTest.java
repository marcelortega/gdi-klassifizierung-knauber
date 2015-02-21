package uebung04;

import static org.junit.Assert.*;
import org.junit.Test;

public class ISBNToolkit1stTest {
	
	@Test
	public void testComputation() {
		assertEquals(8, ISBNToolkit.computeISBN13CheckDigit("978-3-7657-2781-"));
	}
	
////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testValidation() {
		assertTrue(ISBNToolkit.isISBN13Valid("978-3-7657-2781-8"));
	}
	
}
