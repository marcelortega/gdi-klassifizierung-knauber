package date;

import java.util.GregorianCalendar;


public interface Date {
	
	/**
	 * Diese Konstante enthält den aktuellen Tag im Monat.
	 */
	static final int CURRENT_DAY = GregorianCalendar.getInstance().get(GregorianCalendar.DAY_OF_MONTH);
	
	/**
	 * Diese Konstante enthält den aktuellen Monat.
	 */
	static final int CURRENT_MONTH = GregorianCalendar.getInstance().get(GregorianCalendar.MONTH) + 1;
	
	/**
	 * Diese Konstante enthält das aktuelle Jahr.
	 */
	static final int CURRENT_YEAR = GregorianCalendar.getInstance().get(GregorianCalendar.YEAR);
	
	/**
	 * Wenn es sich um ein gültiges Datum handelt, liefert 
	 * diese Methoden den Tag des angegebenen Datums als 
	 * int-Wert; im Falle eines ungültigen Datums liefert
	 * sie -1.
	 */
	int getDay();
	
	/**
	 * Wenn es sich um ein gültiges Datum handelt, liefert 
	 * diese Methoden den Monat des angegebenen Datums als 
	 * int-Wert; im Falle eines ungültigen Datums liefert
	 * sie -1.
	 */
	int getMonth();
	
	/**
	 * Wenn es sich um ein gültiges Datum handelt, liefert 
	 * diese Methoden das Jahr des angegebenen Datums als 
	 * int-Wert; im Falle eines ungültigen Datums liefert
	 * sie -1.
	 */
	int getYear();
	
	/**
	 * Diese Methode liefert genau dann true, wenn das Objekt
	 * mit einem gültigen Datum (in Bezug auf den 
	 * Gregorianischen Kalender) initialisiert wurde, sonst 
	 * false.
	 */
	boolean isValid();
	
	/**
	 * Die Methode liefert genau dann true, wenn das vorliegende
	 * und das als Parameter übergebene Datum gültig sind und
	 * das vorliegende Datum größer ist als das übergebene
	 * Datum, sonst false.
	 */
	boolean isLaterThan( Date d2 );
	
	/**
	 * Die Methode liefert den Wochentag zu einem gültigen
	 * Datum (in Bezug auf den Gregorianischen Kalender) bzw.
	 * null, wenn es sich nicht um ein gültiges Datum handelt.
	 */
	Weekday getWeekday();
	
	/**
	 * Die Methode subtrahiert das durch den Parameter 
	 * angegebene Datum vom vorliegenden Datum und liefert die 
	 * Differenz der beiden (gültigen!) Datumsangaben in Tagen 
	 * als ganze Zahl.<br>
	 * Voraussetzung: Beide Daten sind gültig und das 
	 * vorliegende Datum ist größer als das übergebene Datum, 
	 * sonst ist das Ergebnis -1.
	 */
	int subtract( Date d2 );
	
	/**
	 * Die Methode speichert alle zu einem
	 * Datum gehörenden Daten in die Datei, 
	 * die durch den angegebenen Parameter repräsentiert 
	 * wird (Ergebnis von openOutputFile(...)).
	 */
	void saveToFile( Object file );
	
	/**
	 * Die Methode lädt alle zu einem Datum gehörenden 
	 * Daten aus der Datei, die durch den
	 * angegebenen Parameter repräsentiert wird
	 * (Ergebnis von openInputFile(...)),
	 * in das Datumsobjekt.
	 */
	void loadFromFile( Object file );
	
}
