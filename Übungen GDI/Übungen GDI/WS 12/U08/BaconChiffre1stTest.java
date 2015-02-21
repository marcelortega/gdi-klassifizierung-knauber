package uebung08;

import static org.junit.Assert.*;

import org.junit.Test;

public class BaconChiffre1stTest {
	
	BaconKodierer kodierer = new BaconKodiererImpl();

	@Test
	public void NOEXTEN_reinigeUrsprungstext_Primitiv() {
		String actual = kodierer.reinigeUrsprungstext("Hallo Welt");
		assertEquals("HALLOWELT", actual);
	}

	@Test
	public void NOEXTEN_kodiereUrsprungstext_Primitiv() {
		String actual = kodierer.kodiereUrsprungstext("HALLOWELT");
		assertEquals("kkgggkkkkkkgkgkkgkgkkggkggkgkkkkgkkkgkgkgkkgk", actual);
	}

	@Test
	public void NOEXTEN_dekodiereUrsprungstextTest_Primitiv() {
		String actual = kodierer.dekodiereUrsprungstext("kkgggkkkkkkgkgkkgkgkkggkggkgkkkkgkkkgkgkgkkgk");
		assertEquals("HALLOWELT", actual);
	}

	@Test
	public void NOEXTEN_versteckeText_Primitiv_2() {
		String actual = kodierer
				.versteckeText(
						"Treffen uns um drei Uhr am Bahnhof!",
						"Mein Name ist Juan Sanchez Villa-Lobos Ramirez, oberster Metallurge am Hofe König Karl V. von Spanien; ich wurde 896 vor Christus in Ägypten geboren und bin unsterblich seit 846 vor Christus.");
		assertEquals(
				"MeiN nAme ist jUan saNcHez ViLla-LoboS RamIreZ, ObERstEr meTAllURgE aM Hofe KÖNig karl V. von SpanIen; ICh wURDE 896 vor christuS iN ÄgyptEn geboreN UNd BIn unsTERbLIcH seIt 846 Vor Christus.",
				actual);
	}

	@Test
	public void NOEXTEN_zeigeText_Primitiv_1() {
		String actual = kodierer
				.zeigeText("es IST trauriG zU deNkEn, dIE nATuR spriCht uNd KeIneR hört zu.");
		assertTrue(actual.startsWith("HALLOWELT"));
	}

}
