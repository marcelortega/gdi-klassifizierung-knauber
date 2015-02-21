package uebung06;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringExtensions1stTest {

	@Test
	public void testStrToUpper() {
		assertEquals("GDI IST EINE ABKÜRZUNG FÜR GRUNDLAGEN DER INFORMATIK.", StringExtensionsRecursive.strToUpper("GDI ist eine Abkürzung für Grundlagen der Informatik."));
	}
	
////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testStrExplode() {
		assertArrayEquals(new String[]{"Banane","Apfel","Birne"}, StringExtensionsRecursive.strExplode("Banane,Apfel,Birne", ','));
	}
	
}
