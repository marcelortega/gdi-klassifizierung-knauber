package aufgabe1;

import static gdi.MakeItSimple.*; //Verwendet zur Ausgabe auf der Konsole (println)

/**
 * Dieses Programm erlaubt es Zahlen einzugeben, die Eingabe mit einer negativen Zahl
 * zu beenden und dann das Maximum der eingegebenen auszugeben.
 * Der Schwierigkeitsgrad ist sehr leicht. Man muss nur auf die Idee kommen, wie man 
 * sich neue Maxima merkt.
 */
public class SucheMaximum {

	
	/*
	 * Globale Variable welche sich das Maximum merkt indem es mit dem kleinsten möglichen
	 * Integer Wert initialisiert wird.
	 */
	static int maxZahl = Integer.MIN_VALUE; //maxZahl mit MIN_VALUE initialisieren, zum hochzählen

	
	/**
	 * main Methode zur wiederholten Abfrage der Benutzereingabe. Einfach per do-while
	 * oder while zu realisieren. Es wird nach jeder Benutzereingabe die Methode
	 * verarbeiteEingabe(int eingabe) aufgerufen. Zum Schluss wird das Maximum aus
	 * gegeben indem man die Methode public static int holeMaximum() nutzt.
	 * @param args
	 */
	public static void main(String[] args) {
		
		int eingabe = 0;
		do {
			print("Bitte geben Sie die nächste Zahl ein (oder eine negative Zahl zum Beenden): ");
			eingabe = readInt();
			verarbeiteEingabe(eingabe);
		} while (eingabe >= 0);
		print("Das Maximum der eingegebenen Zahlen war: " + holeMaximum());	
		
	}//public static void main(String[] args)
	
	
	/**
	 * verarbeiteEingabe Methode zum erkennen und speichern des Maximums.
	 * @param eingabe
	 */
	public static void verarbeiteEingabe(int eingabe) {
		if(eingabe >= 0 && eingabe > maxZahl) {
			maxZahl = eingabe;
		}
	}//public static void verarbeiteEingabe(int eingabe)
	
	
	/**
	 * Einfacher getter des Maximums.
	 * @return maxZahl
	 */
	public static int holeMaximum() {
		return maxZahl;
	}

	
}//public class SucheMaximum
