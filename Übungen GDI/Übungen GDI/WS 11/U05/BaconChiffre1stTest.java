package uebung05;

import static org.junit.Assert.*;

import org.junit.Test;

public class BaconChiffre1stTest {

	@Test
	public void NOEXTEN_reinigeUrsprungstext_Primitiv() {
		String actual = BaconChiffre.reinigeUrsprungstext("Hallo Welt");
		assertEquals("HALLOWELT", actual);
	}

	@Test
	public void NOEXTEN_kodiereUrsprungstext_Primitiv() {
		// BaconChiffre.setExtendedBacon(false);
		String actual = BaconChiffre.kodiereUrsprungstext("HALLOWELT");
		assertEquals("kkgggkkkkkkgkgkkgkgkkggkggkgkkkkgkkkgkgkgkkgk", actual);
	}

	@Test
	public void NOEXTEN_dekodiereUrsprungstextTest_Primitiv() {
		// BaconChiffre.setExtendedBacon(false);
		String actual = BaconChiffre.dekodiereUrsprungstext("kkgggkkkkkkgkgkkgkgkkggkggkgkkkkgkkkgkgkgkkgk");
		assertEquals("HALLOWELT", actual);
	}

	@Test
	public void NOEXTEN_versteckeText_Primitiv_2() {
		// BaconChiffre.setExtendedBacon(false);
		// BaconChiffre.setCropMediumText(false);
		// Aufgabe 6
		String actual = BaconChiffre
				.versteckeText(
						"Treffen uns um drei Uhr am Bahnhof!",
						"Am Anfang schuf Gott Himmel und Erde. Und die Erde war wüst und leer, und es war finster auf der Tiefe; und der Geist Gottes schwebte auf dem Wasser. Und Gott sprach: Es werde Licht! und es ward Licht.");
		assertEquals(
				"Am aNfAng schuF gott HiMmeL uNd eRde. uND diE erDE wAR wüSt unD LeeR, UnD eS War fINSter auf Der tIefe; Und DEr gEIST gottes schwEbTE auf dEm wasser. UND gOTt sprACH: eS WeRde LiCht! und es ward Licht.",
				actual);
	}

	@Test
	public void NOEXTEN_zeigeText_Primitiv_1() {
		// BaconChiffre.setExtendedBacon(false);
		String actual = BaconChiffre
				.zeigeText("es IST trauriG zU deNkEn, dIE nATuR spriCht uNd KeIneR hört zu.");
		assertTrue(actual.startsWith("HALLOWELT"));
	}

}
