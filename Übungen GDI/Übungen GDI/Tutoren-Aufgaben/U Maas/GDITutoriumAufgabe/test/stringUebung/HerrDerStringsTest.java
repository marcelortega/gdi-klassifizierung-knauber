package stringUebung;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Testklasse f�r die "Herr der Strings" �bungsaufgabe in GDI.
 * 
 * @author Tim Maas (Matrkl. Nr.: 822070)
 *
 */
public class HerrDerStringsTest {
	
	/**
	 * Tests f�r die Aufgabe 1
	 */
	@Test
	public void macheGrossbuchstabenKleinScharfS() {

		assertEquals("�", HerrDerStrings.macheGrossbuchstabenKlein("�"));
	}
	
	@Test
	public void macheGrossbuchstabenKleinLeerstring() {

		assertEquals("", HerrDerStrings.macheGrossbuchstabenKlein(""));
	}
	
	@Test
	public void macheGrossbuchstabenKleinKomplettesAlphabet() {
		
		assertEquals("abcdefghijklmnopqrstuvwxyz���", HerrDerStrings.macheGrossbuchstabenKlein("ABCDEFGHIJKLMNOPQRSTUVWXYZ���"));
	}
	
	@Test
	public void macheGrossbuchstabenKleinKomplettesAlphabetPlusSonderzeichen() {
		
		assertEquals(" _-#?,.:;/()=!abcdefghijklmnopqrstuvwxyz��� _ ", HerrDerStrings.macheGrossbuchstabenKlein(" _-#?,.:;/()=!ABCDEFGHIJKLMNOPQRSTUVWXYZ��� _ "));
	}
	
	/**
	 * Tests f�r die Aufgabe 2
	 */
	@Test
	public void findeGollumInGro�() {
		assertEquals(true, HerrDerStrings.findeGollum("GOLLUM"));
	}
	@Test
	public void findeGollumInKlein() {
		assertEquals(true, HerrDerStrings.findeGollum("gollum"));
	}
	@Test
	public void findeGollumInGro�undKleinGemischt() {
		assertEquals(true, HerrDerStrings.findeGollum("GoLlUm"));
	}
	@Test
	public void findeGollumInSonderzeichen() {
		assertEquals(true, HerrDerStrings.findeGollum("�`g)_ ?o #'L/&%l�//u���m"));
	}
	@Test
	public void findeGollumInZahlen() {
		assertEquals(true, HerrDerStrings.findeGollum("2Gol5l4l834u993m3"));
	}
	@Test
	public void findeGollumInMehrerenGollums() {
		assertEquals(true, HerrDerStrings.findeGollum("g_.O,goll,.uM'l;:l*+?U=mgolluMd"));
	}
	
	
	@Test
	public void findeGollumNichtUmgekehrt() {
		assertEquals(false, HerrDerStrings.findeGollum("mullog"));
	}
	@Test
	public void findeGollumNichtMitNurEinemL() {
		assertEquals(false, HerrDerStrings.findeGollum("golum"));
	}
	@Test
	public void findeGollumNichtLeerstring() {
		assertEquals(false, HerrDerStrings.findeGollum(""));
	}
	@Test
	public void findeGollumNichtNurSonderzeichen() {
		assertEquals(false, HerrDerStrings.findeGollum("_.,';:*+?=�%$!"));
	}
	
	/**
	 * Tests f�r die Aufgabe 3
	 */
	@Test
	public void z�hleDieRingeZweiZwischenZahlenEinerSpiegelverkehrt() {
		assertArrayEquals(new String[]{"2*Ring","1R2i3n4g5g6n7i8R9"}, HerrDerStrings.z�hleDieRinge("1R2i3n4g5g6n7i8R9"));
	}
	
	@Test
	public void z�hleDieRingeF�nfHintereinander() {
		assertArrayEquals(new String[]{"5*Ring","RingRingRingRingRing"}, HerrDerStrings.z�hleDieRinge("RingRingRingRingRing"));
	}
	
	@Test
	public void z�hleDieRingeDreiNachBuchstabenSortiert() {
		assertArrayEquals(new String[]{"3*Ring","RRRIIINNNGGG !RIN!"}, HerrDerStrings.z�hleDieRinge("RRRIIINNNGGG !RIN!"));
	}
	
	@Test
	public void z�hleDieRingeKeinenWeilRsFehlen() {
		assertArrayEquals(new String[]{"0*Ring","INGINGINGINGINGING.,45%%�5"}, HerrDerStrings.z�hleDieRinge("INGINGINGINGINGING.,45%%�5"));
	}
	
	@Test
	public void z�hleDieRingeKeinenWeilIsFehlen() {
		assertArrayEquals(new String[]{"0*Ring","RNGRNGRNGRNGRNG.,45%%�5"}, HerrDerStrings.z�hleDieRinge("RNGRNGRNGRNGRNG.,45%%�5"));
	}
	
	@Test
	public void z�hleDieRingeKeinenWeilNsFehlen() {
		assertArrayEquals(new String[]{"0*Ring","RIGRIGRIGrigrig.,45%%�5"}, HerrDerStrings.z�hleDieRinge("RIGRIGRIGrigrig.,45%%�5"));
	}
	
	@Test
	public void z�hleDieRingeKeinenWeilGsFehlen() {
		assertArrayEquals(new String[]{"0*Ring","rinrinRiNrinRIN.,45%%�5"}, HerrDerStrings.z�hleDieRinge("rinrinRiNrinRIN.,45%%�5"));
	}
	
	@Test
	public void z�hleDieRingeKeinenLeerstring() {
		assertArrayEquals(new String[]{"0*Ring",""}, HerrDerStrings.z�hleDieRinge(""));
	}
	
	@Test
	public void z�hleDieRingeSiebenImZeichenchaos() {
		assertArrayEquals(new String[]{"7*Ring","if3dngiFrirgr34)g/$8ngriridrnnirngRinInNG�83r4?=�ng"},
				HerrDerStrings.z�hleDieRinge("if3dngiFrirgr34)g/$8ngriridrnnirngRinInNG�83r4?=�ng"));
	}
}
