package uebung08;

/**
 * Die Klasse stellt Datumsangaben f�r den Gregorianischen Kalender 
 * zur Verf�gung.
 */
public interface Date {

	/**
	 * Die Methode liefert das Datum im gewohnten Format TT.MM.YYYY;
	 * die Tage und Monate werden immer zweistellig ausgegeben
	 */
	String toString();
	
	/**
	 * Die Methode liefert genau dann true, wenn das im Datumsobjekt 
	 * enthaltene Datum (Tag und Monat) 0 bis 7 Tage (inklusive) 
	 * vor dem als Parameter �bergebenen Datum liegt, sonst false. 
	 * Hinweis zur Verwendung:<br>
	 * Mit dieser Methode kann ein Kalender-Programm bestimmen, 
	 * ob es Zeit ist, den Kalenderbesitzer an ein j�hrlich 
	 * wiederkehrendes Datum (Geburtstage, Hochzeitstag etc.) zu 
	 * erinnern. F�r diesen Vergleich spielt das Jahr keine Rolle, 
	 * daher wird keine Jahreszahl angegeben. 
	 */
	boolean isWeekBefore( int day, int month );
	
	/**
	 * Die Methode speichert die im Datumsobjekt enthaltenen Daten 
	 * in die angegebene Datei.
	 * @param ein Objekt, das eine mit openOutputFile zum Schreiben
	 * ge�ffnete Datei repr�sentiert (kein Dateiname!)
	 */
	void saveToFile( Object file );

	/**
	 * Die Methode l�dt alle Daten f�r das Datumsobjekt aus der 
	 * angegebenen Datei.
	 * Dabei wird die bisherige Datumsangabe �berschrieben.
	 * @param ein Objekt, das eine mit openInputFile zum Lesen
	 * ge�ffnete Datei repr�sentiert (kein Dateiname!)
	 */
	void loadFromFile( Object file );

}
