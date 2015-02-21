package aufgabe1;

import static gdi.MakeItSimple.*; //Verwendet zur Ausgabe auf der Konsole (println)

/**
 * Dieses Programm erlaubt es Zahlen einzugeben, die Eingabe mit einer negativen Zahl
 * zu beenden und dann das Maximum der eingegebenen auszugeben.
 * Der Schwierigkeitsgrad ist sehr leicht. Man muss nur auf die Idee kommen, wie man 
 * sich neue Maxima merkt.
 */
public class SucheMaximum {
	
	
	/**
	 * main Methode zur wiederholten Abfrage der Benutzereingabe. Einfach per do-while
	 * oder while zu realisieren. Es wird nach jeder Benutzereingabe die Methode
	 * verarbeiteEingabe(int eingabe) aufgerufen. Zum Schluss wird das Maximum aus
	 * gegeben indem man die Methode public static int holeMaximum() nutzt.
	 * @param args
	 */
	public static void main(String[] args) {
		
		int eingabe = 0;
		/*
		 * Variable welche sich das Maximum merkt indem es mit dem kleinsten möglichen
		 * Integer Wert initialisiert wird.
		 */
		int maxZahl = Integer.MIN_VALUE; //maxZahl mit MIN_VALUE initialisieren, zum hochzählen
		
		do {
			print("Bitte geben Sie die nächste Zahl ein (oder eine negative Zahl zum Beenden): ");
			eingabe = readInt();
			maxZahl = verarbeiteEingabe(eingabe, maxZahl);		
		} while (eingabe >= 0);
		print("Das Maximum der eingegebenen Zahlen war: " + maxZahl);	
		
	}//public static void main(String[] args)
	
	
	/**
	 * verarbeiteEingabe Methode zum erkennen und speichern des Maximums.
	 * @param eingabe, maxZahl
	 */
	public static int verarbeiteEingabe(int eingabe, int maxZahl) {
		if(eingabe >= 0 && eingabe > maxZahl) {
			maxZahl = eingabe;
		}
		return maxZahl; //die (eventuell neue) maxZahl wird zurück gegeben
	}//public static void verarbeiteEingabe(int eingabe)
	
	
}//public class SucheMaximum
