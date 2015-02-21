package stringUebung;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Testklasse für die "Herr der Strings" Übungsaufgabe in GDI.
 * 
 * @author Tim Maas (Matrkl. Nr.: 822070)
 *
 */
public class HerrDerStringsTest {
	
	/**
	 * Tests für die Aufgabe 1
	 */
	@Test
	public void macheGrossbuchstabenKleinScharfS() {

		assertEquals("ß", HerrDerStrings.macheGrossbuchstabenKlein("ß"));
	}
	
	@Test
	public void macheGrossbuchstabenKleinLeerstring() {

		assertEquals("", HerrDerStrings.macheGrossbuchstabenKlein(""));
	}
	
	@Test
	public void macheGrossbuchstabenKleinKomplettesAlphabet() {
		
		assertEquals("abcdefghijklmnopqrstuvwxyzöüä", HerrDerStrings.macheGrossbuchstabenKlein("ABCDEFGHIJKLMNOPQRSTUVWXYZÖÜÄ"));
	}
	
	@Test
	public void macheGrossbuchstabenKleinKomplettesAlphabetPlusSonderzeichen() {
		
		assertEquals(" _-#?,.:;/()=!abcdefghijklmnopqrstuvwxyzöüä _ ", HerrDerStrings.macheGrossbuchstabenKlein(" _-#?,.:;/()=!ABCDEFGHIJKLMNOPQRSTUVWXYZÖÜÄ _ "));
	}
	
	/**
	 * Tests für die Aufgabe 2
	 */
	@Test
	public void findeGollumInGroß() {
		assertEquals(true, HerrDerStrings.findeGollum("GOLLUM"));
	}
	@Test
	public void findeGollumInKlein() {
		assertEquals(true, HerrDerStrings.findeGollum("gollum"));
	}
	@Test
	public void findeGollumInGroßundKleinGemischt() {
		assertEquals(true, HerrDerStrings.findeGollum("GoLlUm"));
	}
	@Test
	public void findeGollumInSonderzeichen() {
		assertEquals(true, HerrDerStrings.findeGollum("´`g)_ ?o #'L/&%l§//u§²³m"));
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
		assertEquals(false, HerrDerStrings.findeGollum("_.,';:*+?=§%$!"));
	}
	
	/**
	 * Tests für die Aufgabe 3
	 */
	@Test
	public void zähleDieRingeZweiZwischenZahlenEinerSpiegelverkehrt() {
		assertArrayEquals(new String[]{"2*Ring","1R2i3n4g5g6n7i8R9"}, HerrDerStrings.zähleDieRinge("1R2i3n4g5g6n7i8R9"));
	}
	
	@Test
	public void zähleDieRingeFünfHintereinander() {
		assertArrayEquals(new String[]{"5*Ring","RingRingRingRingRing"}, HerrDerStrings.zähleDieRinge("RingRingRingRingRing"));
	}
	
	@Test
	public void zähleDieRingeDreiNachBuchstabenSortiert() {
		assertArrayEquals(new String[]{"3*Ring","RRRIIINNNGGG !RIN!"}, HerrDerStrings.zähleDieRinge("RRRIIINNNGGG !RIN!"));
	}
	
	@Test
	public void zähleDieRingeKeinenWeilRsFehlen() {
		assertArrayEquals(new String[]{"0*Ring","INGINGINGINGINGING.,45%%§5"}, HerrDerStrings.zähleDieRinge("INGINGINGINGINGING.,45%%§5"));
	}
	
	@Test
	public void zähleDieRingeKeinenWeilIsFehlen() {
		assertArrayEquals(new String[]{"0*Ring","RNGRNGRNGRNGRNG.,45%%§5"}, HerrDerStrings.zähleDieRinge("RNGRNGRNGRNGRNG.,45%%§5"));
	}
	
	@Test
	public void zähleDieRingeKeinenWeilNsFehlen() {
		assertArrayEquals(new String[]{"0*Ring","RIGRIGRIGrigrig.,45%%§5"}, HerrDerStrings.zähleDieRinge("RIGRIGRIGrigrig.,45%%§5"));
	}
	
	@Test
	public void zähleDieRingeKeinenWeilGsFehlen() {
		assertArrayEquals(new String[]{"0*Ring","rinrinRiNrinRIN.,45%%§5"}, HerrDerStrings.zähleDieRinge("rinrinRiNrinRIN.,45%%§5"));
	}
	
	@Test
	public void zähleDieRingeKeinenLeerstring() {
		assertArrayEquals(new String[]{"0*Ring",""}, HerrDerStrings.zähleDieRinge(""));
	}
	
	@Test
	public void zähleDieRingeSiebenImZeichenchaos() {
		assertArrayEquals(new String[]{"7*Ring","if3dngiFrirgr34)g/$8ngriridrnnirngRinInNG§83r4?=ßng"},
				HerrDerStrings.zähleDieRinge("if3dngiFrirgr34)g/$8ngriridrnnirngRinInNG§83r4?=ßng"));
	}
}
