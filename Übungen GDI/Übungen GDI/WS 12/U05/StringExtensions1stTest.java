package uebung05;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringExtensions1stTest {

	@Test
	public void testStrToUpper() {
		assertEquals("GDI IST EINE ABKÜRZUNG FÜR GRUNDLAGEN DER INFORMATIK.", StringExtensions.strToUpper("GDI ist eine Abkürzung für Grundlagen der Informatik."));
	}
	
////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testStrExplode() {
		assertArrayEquals(new String[]{"Banane","Apfel","Birne"}, StringExtensions.strExplode("Banane,Apfel,Birne", ','));
	}
	
////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testStrScan() {
		assertEquals(4, StringExtensions.strScan("abcdefghi", "efg"));
	}
}
