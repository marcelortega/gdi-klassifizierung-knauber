package uebung07;

import static org.junit.Assert.*;

import org.junit.Test;

public class PoissonRätsel1stTest {

	@Test
	public void testeKrugUmfüllen() {
		boolean[] krugA = { true, true, false };
		boolean[] krugB = { true, true, false, false, false };

		boolean[] krugDanachA = { false, false, false };
		boolean[] krugDanachB = { true, true, true, true, false };

		PoissonRätsel.fülleKrugUm(krugA, krugB);

		for (int i = 0; i < krugA.length; i++) {
			assertEquals(krugA[i], krugDanachA[i]);
		}

		for (int i = 0; i < krugB.length; i++) {
			assertEquals(krugB[i], krugDanachB[i]);
		}
	}
	
}
