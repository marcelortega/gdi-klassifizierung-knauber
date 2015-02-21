package uebung07;

import static org.junit.Assert.*;

import org.junit.Test;

public class PoissonR�tsel1stTest {

	@Test
	public void testeKrugUmf�llen() {
		boolean[] krugA = { true, true, false };
		boolean[] krugB = { true, true, false, false, false };

		boolean[] krugDanachA = { false, false, false };
		boolean[] krugDanachB = { true, true, true, true, false };

		PoissonR�tsel.f�lleKrugUm(krugA, krugB);

		for (int i = 0; i < krugA.length; i++) {
			assertEquals(krugA[i], krugDanachA[i]);
		}

		for (int i = 0; i < krugB.length; i++) {
			assertEquals(krugB[i], krugDanachB[i]);
		}
	}
	
}
