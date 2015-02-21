package studentenStatistikV4;

import static gdi.MakeItSimple.*;

/**
 * Die Klasse benutzt die Hilfsklasse Student, die 
 * einen geeigneten Konstruktor anbietet.
 */
class StudentenStatistik {
	
	/**
	 * In dieser Methode werden alle Elemente des Arrays
	 * studenten mit neuen Student-Objekten belegt, deren 
	 * Daten hier von der Konsole eingelesen werden.
	 */
	static void liesAlleStudentenEin( Student[] studenten ) {
		String vorname, nachname;
		int punkte;
		for (int i = 0; i < studenten.length; i++) {
			print("Geben Sie den Vornamen ein: ");
			vorname = readLine();
			print("Geben Sie den Nachnamen ein: ");
			nachname = readLine();
			print("Geben Sie die Punktzahl ein: ");
			punkte = readInt();
			readLine();				// Weglesen von <return>
			studenten[i] = new Student(vorname, nachname, punkte);
		}
	}
	
	/**
	 * Diese Methode gibt alle Daten eines Studenten aus.
	 */
	static void gibStudentAus( Student student ) {
		println("  Der Student " + student.vorname + " " 
				+ student.nachname + " erreichte " 
				+ student.punkte + " Punkte.");
	}
	
	/**
	 * Diese Methode dient der Berechnung und Ausgabe der schlechtesten,
	 * der besten und der Durchschnittspunktzahl und sie gibt den
	 * schlechtesten und den besten Studenten aus.
	 */
	static void gibStatistikAus( Student[] studenten ) {
		// Annahme: der Student an Position 0 ist der Schlechteste,
		// aber auch der Beste:
		int schlechtester = 0;
		int bester = 0;
		
		// Gibt es einen Studenten mit einer schlechteren/besseren
		// Punktzahl, wird deren Position im Array gemerkt
		for (int i = 1; i < studenten.length; i++) {
			if (studenten[i].punkte > studenten[bester].punkte)
				bester = i;
			if (studenten[i].punkte < studenten[schlechtester].punkte)
				schlechtester = i;
		}
		
		// Berechnung der Summe aller Punktzahlen
		int summe = 0;
		for (Student s : studenten)
			summe += s.punkte;
		
		// Ausgabe der "Statistik"
		println("Schlechtester Student:");
		gibStudentAus(studenten[schlechtester]);
		println("Bester Student:");
		gibStudentAus(studenten[bester]);
		println("Durchschnittspunktzahl: " + summe / studenten.length);
	}

	public static void main( String[] args ) {
		// so viele Studenten sollen verwaltet werden
		int anzahl;
		Student[] studenten;
		
		// Abfrage der Studentenzahl mit Fehlerprüfung
		do {
			print("Geben Sie die Anzahl der Studenten ein: ");
			anzahl = readInt();
			readLine();				// Weglesen von <return>
		} while (anzahl <= 0);
		studenten = new Student[anzahl];
		
		// Einlesen aller Studenten (dieser Kommentar ist überflüssig!)
		liesAlleStudentenEin(studenten);
		
		// Ausgeben aller eingelesenen Studenten
		for (Student s : studenten) {
			gibStudentAus(s);
		}
		
		// Ausgeben der Statistik (dieser Kommentar ist überflüssig!)
		gibStatistikAus(studenten);
	}
	
}
