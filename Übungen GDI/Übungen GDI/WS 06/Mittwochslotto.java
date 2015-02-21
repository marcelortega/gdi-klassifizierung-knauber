package slideTests;

import static gdi.MakeItSimple.*;

public class Mittwochslotto {
	
	static final int ZAHLEN_PRO_ZIEHUNG = 6;
	static final int ANZAHL_LOTTOZAHLEN = 49;

	/* Erkl�rung wie in der Vorlesung besprochen:
	 * Die beiden Programmteile zu "Ziehung A" und
	 * "Ziehung B" sind abgesehen von "A" und "B" 
	 * vollst�ndig redundant zueinander.
	 */
	static void ziehungMitDoppeltemCode () {
		int z�hler, zufallsZahl;
		println( "Ziehungsger�t in ordnungsgem��em Zustand" );
		
		print( "\nZiehung A: " );
		// Es werden sechs Zufallszahlen gezogen;
		// Achtung: doppelte Zahlen sind m�glich!
		z�hler = 0;
		while ( z�hler < ZAHLEN_PRO_ZIEHUNG ) {
			/* Die Funktion random() erzeugt eine Zufallszahl
			 * im Bereich [0..1[, die durch die Multiplikation
			 * und die Addition auf den Bereich [1..50[ gestreckt
			 * und verschoben wird und durch den Cast nach int
			 * in eine ganze Zahl im Bereich [1..49] umgewandelt
			 * wird.
			 */
			zufallsZahl = (int) (Math.random() * ANZAHL_LOTTOZAHLEN) + 1;
			print( zufallsZahl + "  " );
			z�hler++;
		}
		
		print( "\nZiehung B: " );
		z�hler = 0;
		while ( z�hler < ZAHLEN_PRO_ZIEHUNG ) {
			zufallsZahl = (int) (Math.random() * ANZAHL_LOTTOZAHLEN) + 1;
			print( zufallsZahl + "  " );
			z�hler++;
		}
		
		println( "\n\nDie Gewinner werden benachrichtigt" );
	}

	/**
	 * In dieser Variante ist die Redundanz beseitigt, indem
	 * eine zus�tzliche Schleife f�r zwei Ziehungen sorgt.
	 * Der Name der Ziehung (A oder B) wird durch Rechnen
	 * mit dem Zeichentyp char bestimmt und ausgegeben.
	 * Prinzipiell h�tte man auch eine Hilfsmethode mit
	 * entsprechendem Parameter einf�hren k�nnen, vergleiche
	 * die Methode ziehungMitHilfsmethode weiter unten!
	 */
	static void ziehungOhneRedundantenCode () {
		int z�hler, zufallsZahl;
		int ziehung = 0;
		println( "Ziehungsger�t in ordnungsgem��em Zustand" );
		
		// Es finden zwei "Ziehungen" A und B statt,...
		while ( ziehung < 2 ) {
			print( "\nZiehung " + (char) ('A' + ziehung) + ": " );
			// ...in denen jeweils sechs Kugeln gezogen werden
			z�hler = 0;
			while ( z�hler < ZAHLEN_PRO_ZIEHUNG ) {
				zufallsZahl = (int) (Math.random() * ANZAHL_LOTTOZAHLEN) + 1;
				print( zufallsZahl + "  " );
				z�hler++;
			}
			ziehung++;
		}

		println( "\n\nDie Gewinner werden benachrichtigt" );
	}

	/**
	 * In dieser Variante sind die while-Schleifen durch
	 * hier besser geeignete for-Schleifen ersetzt; der
	 * Code wird hierdurch nochmal k�rzer.
	 */
	static void ziehungMitSinnvollenSchleifen () {
		println( "Ziehungsger�t in ordnungsgem��em Zustand" );
		
		for (int ziehung = 0; ziehung < 2; ziehung++) {
			print( "\nZiehung " + (char) ('A' + ziehung) + ": " );
			for (int z�hler = 0; z�hler < ZAHLEN_PRO_ZIEHUNG; z�hler++ ) {
				int zufallsZahl = (int) (Math.random() * ANZAHL_LOTTOZAHLEN) + 1;
				print( zufallsZahl + "  " );
			}
		}

		println( "\n\nDie Gewinner werden benachrichtigt" );
	}

	/**
	 * In dieser Variante sorgt ein Boole'sches Array daf�r,
	 * dass keine Zahl doppelt "gezogen" wird. Alternativ
	 * h�tte man auch die gezogenen Zahlen in ein int-Array
	 * schreiben k�nnen; dann h�tte ich gerne eine Hilfsmethode
	 * zur Pr�fung, ob die neu gezogene Zahl dort schon drin ist.
	 */
	static void ziehungOhneDoppelteZahlen () {
		/* Im folgenden Array werden die bereits gezogenen
		 * Zahlen markiert. Default-Initialisierung f�r alle
		 * Boole'schen Arrays ist (jedesmal) false an allen 
		 * Positionen! Man kann das Array aber auch einmalig
		 * anlegen und wieder auf false setzen...
		 */
		boolean[] gezogen;
		int zufallsZahl;
		println( "Ziehungsger�t in ordnungsgem��em Zustand" );
		
		for (int ziehung = 0; ziehung < 2; ziehung++) {
			print( "\nZiehung " + (char) ('A' + ziehung) + ": " );
			gezogen = new boolean[ANZAHL_LOTTOZAHLEN + 1];
			for (int z�hler = 0; z�hler < ZAHLEN_PRO_ZIEHUNG; z�hler++ ) {
				do {
					zufallsZahl = (int) (Math.random() * ANZAHL_LOTTOZAHLEN) + 1;
				} while (gezogen[zufallsZahl]);
				gezogen[zufallsZahl] = true;
				print( zufallsZahl + "  " );
			}
		}

		println( "\n\nDie Gewinner werden benachrichtigt" );
	}
	
	/**
	 * Die folgenden drei Methoden zeigen die vermutlich 
	 * beste L�sung: eine Methode steuert die beiden 
	 * Ziehungen und die Ausgabe der gezogenen Zahlen,
	 * eine zweite f�hrt eine Ziehung durch und liefert
	 * die gezogenen Zahlen und eine dritte �bernimmt
	 * (mit dem Ziehungsnamen parametrisiert) die Ausgabe.
	 */
	static void ziehungMitHilfsmethode() {
		println( "Ziehungsger�t in ordnungsgem��em Zustand" );
		
		printZiehung(berechneZiehung(), 'A');
		printZiehung(berechneZiehung(), 'B');

		println( "\n\nDie Gewinner werden benachrichtigt" );
	}
	
	/**
	 * Diese Hilfsmethode berechnet die Zahlen einer Ziehung,
	 * wobei Doppelte vermieden werden. In dieser L�sung liegen
	 * die Zahlen (als Ergebnis dieser Methode) explizit vor,
	 * bevor sie ausgegeben werden: Das ist eine gute 
	 * Ausgangsbasis f�r den Test des Programms, weil dieser
	 * Teil des Algorithmus (= diese Methode) recht einfach 
	 * getestet werden kann (z.B. darauf ob das Vermeiden von 
	 * doppelt gezogenen Zahlen gelungen ist).
	 */
	static int[] berechneZiehung() {
		// Hier werden die gezogenen Zahlen gespeichert bevor sie
		// also Ergebnis der Methode zur�ckgegeben werden
		int[] gezogeneZahlen = new int[ZAHLEN_PRO_ZIEHUNG];
		// Das Array wird verwendet wie in ziehungOhneDoppelteZahlen beschrieben
		boolean[] gezogen = new boolean[ANZAHL_LOTTOZAHLEN + 1];
		
		// Auch die Schleife funktioniert wie in ziehungOhneDoppelteZahlen beschrieben
		for (int z�hler = 0; z�hler < ZAHLEN_PRO_ZIEHUNG; z�hler++ ) {
			do {
				gezogeneZahlen[z�hler] = (int) (Math.random() * ANZAHL_LOTTOZAHLEN) + 1;
			} while (gezogen[gezogeneZahlen[z�hler]]);
			gezogen[gezogeneZahlen[z�hler]] = true;
		}
		return gezogeneZahlen;
	}
	
	static void printZiehung( int[] gezogeneZahlen, char ziehungsname ) {
		print( "\nZiehung " + ziehungsname + ": " );
		for (int zahl : gezogeneZahlen)
			print( zahl + "  " );
	}
	
	
	public static void main(String[] args) {
		ziehungMitDoppeltemCode();
		ziehungOhneRedundantenCode();
		ziehungMitSinnvollenSchleifen();
		ziehungOhneDoppelteZahlen();
		ziehungMitHilfsmethode();
	}
}
