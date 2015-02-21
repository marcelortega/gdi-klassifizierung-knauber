import static org.junit.Assert.*;
import org.junit.Test;

public class GTINToolkitTest {
	//computeCheckDigit
	@Test
	public void testEmptyStringForComputation() {
		assertEquals(-1, GTINToolkit.computeGTINCheckDigit(""));
	}
	
	@Test
	public void testLessThanTwelveDigitsForComputation() {
		assertEquals(-1, GTINToolkit.computeGTINCheckDigit("12345678901"));
		assertEquals(-1, GTINToolkit.computeGTINCheckDigit("-1-6735-6"));
		assertEquals(-1, GTINToolkit.computeGTINCheckDigit("123-456-78-90-1"));
		assertEquals(-1, GTINToolkit.computeGTINCheckDigit("-1-"));
	}
	
	@Test
	public void testMoreThanTwelveDigitsForComputation() {
		assertEquals(-1, GTINToolkit.computeGTINCheckDigit("1234567890123"));
		assertEquals(-1, GTINToolkit.computeGTINCheckDigit("-1-6735-6-556-687789"));
		assertEquals(-1, GTINToolkit.computeGTINCheckDigit("123-456-78-90-1-223-556"));
	}
	
	@Test
	public void testValidCheckDigits() {
		assertEquals(3, GTINToolkit.computeGTINCheckDigit("123-24242-4489"));
		assertEquals(5, GTINToolkit.computeGTINCheckDigit("5-38582236236"));
		assertEquals(7, GTINToolkit.computeGTINCheckDigit("637895231560"));
		assertEquals(5, GTINToolkit.computeGTINCheckDigit("553377-666555"));
		assertEquals(4, GTINToolkit.computeGTINCheckDigit("612-375454-544"));
	}
	
	@Test
	public void testValidCheckDigitsWithSpaces() {
		assertEquals(3, GTINToolkit.computeGTINCheckDigit("123 24242 4489"));
		assertEquals(5, GTINToolkit.computeGTINCheckDigit("5-38582 236236"));
		assertEquals(7, GTINToolkit.computeGTINCheckDigit("637 89523156 0"));
		assertEquals(5, GTINToolkit.computeGTINCheckDigit("5 53377-666 555"));
		assertEquals(4, GTINToolkit.computeGTINCheckDigit(" 612-375454-544 "));
	}
	
////////////////////////////////////////////////////////////////////////////////////
	
	//isGTINValid
	@Test
	public void testEmptyStringForValidation() {
		assertFalse(GTINToolkit.isGTINValid(""));
	}
	
	@Test
	public void testLessThanTwelveDigitsForValidation() {
		assertFalse(GTINToolkit.isGTINValid("-1-6735-6"));
		assertFalse(GTINToolkit.isGTINValid("123-456-78-90-1"));
		assertFalse(GTINToolkit.isGTINValid("-1-"));
	}
	
	@Test
	public void testMoreThanTwelveDigitsForValidation() {
		assertFalse(GTINToolkit.isGTINValid("-1-6735-6-556-687789"));
		assertFalse(GTINToolkit.isGTINValid("123-456-78-90-1-223-556"));
	}
	
	@Test
	public void testValidGTINs() {
		assertTrue(GTINToolkit.isGTINValid("123-2424244893"));
		assertTrue(GTINToolkit.isGTINValid("5-385822362365"));
		assertTrue(GTINToolkit.isGTINValid("6378952315607"));
		assertTrue(GTINToolkit.isGTINValid("612-375454-5444"));
	}
	
	@Test
	public void testValidGTINsWithSpaces() {
		assertTrue(GTINToolkit.isGTINValid("123-242 4244893"));
		assertTrue(GTINToolkit.isGTINValid("5-38 5822362 365"));
		assertTrue(GTINToolkit.isGTINValid("63 789523 15607"));
		assertTrue(GTINToolkit.isGTINValid(" 6 12-37545 4-5444"));
	}
	
	@Test
	public void testInvalidGTINs() {
		assertFalse(GTINToolkit.isGTINValid("123-2424244895"));
		assertFalse(GTINToolkit.isGTINValid("5-385822362369"));
		assertFalse(GTINToolkit.isGTINValid("63 789523 15601"));
		assertFalse(GTINToolkit.isGTINValid("6 12-37545 4-5446"));
	}
}