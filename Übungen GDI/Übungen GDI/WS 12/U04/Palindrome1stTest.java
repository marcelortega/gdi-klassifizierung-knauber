package uebung03;

import static org.junit.Assert.*;

import org.junit.Test;

public class Palindrome1stTest {

	@Test
	public void vorabTest() throws Exception {
		assertTrue(Palindrome.isPalindrome("aba"));
		assertTrue(Palindrome.isPalindrome("abba"));
		assertFalse(Palindrome.isPalindrome("abb"));
	}

}
