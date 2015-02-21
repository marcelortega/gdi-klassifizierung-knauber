package primzahlen;

import static gdi.MakeItSimple.*;

class SiebDesEratosthenes {

	public static void main( String[] args ) {
		// bis zu dieser Zahl, die von der Konsole eingelesen wird,
		// sollen Primzahlen berechnet werden:
		int max;
		// in diesem Array werden Primzahlen mit true markiert:
		boolean[] prim;
		// Multiplikator und Produkt für die Berechnung von Primzahl-Vielfachen
		int multiplikator, produkt;
		
		// Obergrenze für die Primzahlen einlesen
		do {
			print("Geben Sie die maximale Zahl ein: ");
			max = readInt();
			readLine();		// <return> weglesen
			if (max < 2)
				println("Fehlerhafte Eingabe: Primzahlen müssen >= 2 sein!");
		} while (ioError() || max < 2);
		
		// alle Primzahlen <= max sollen berechnet werden
		prim = new boolean[max + 1];
		// wir nehmen erstmal an, alle Zahlen seien prim
		for (int i = 2; i <= max; i++)
			prim[i] = true;
		
		/* Prinzip des Algorithmus:
		 * Die betrachteteZahl wird bei jedem Schleifendurchlauf erhöht;
		 * genau dann, wenn sie eine Primzahl ist (dann
		 * ist prim[betrachteteZahl] == true), werden alle ihre 
		 * Vielfachen (gespeichert in der Variablen produkt) als 
		 * nicht-prim markiert.
		 */
		for (int betrachteteZahl = 2; betrachteteZahl < max; betrachteteZahl++) { //  (* 1)
			if (prim[betrachteteZahl]) { //  Vielfache von Nicht-Primzahlen interessieren nicht
				
				 // Die Variable multiplikator braucht erst
				 // bei betrachteteZahl loszulaufen, da alle kleineren
				 // Produkte bereits berechnet sind.
				multiplikator = betrachteteZahl;
				produkt = betrachteteZahl * multiplikator;
				while (produkt <= max) { // (* 2)
					prim[produkt] = false;
					multiplikator++;
					produkt = betrachteteZahl * multiplikator;
				}
			}
		}
		
		// alle Einträge >= 2, die noch true sind,
		// markieren Primzahlen und werden daher ausgegeben
		for (int i = 2; i <= max; i++) {
			if (prim[i])
				println(i);
		}
		/* Optimierungspotenzial:
		 * (* 1) Eigentlich muss die Schleife nur bis zur Wurzel
		 * (oder der Hälfte) von max laufen...
		 * (* 2) Die innere Schleife (eigentlich: die
		 * Multiplikation) muss nur durchgeführt werden,
		 * wenn multiplikator eine Primzahl ist.
		 */
	}

}
