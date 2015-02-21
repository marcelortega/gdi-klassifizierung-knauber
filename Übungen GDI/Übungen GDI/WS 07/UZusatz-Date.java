package date;

import java.util.GregorianCalendar;


public interface Date {
	
	/**
	 * Diese Konstante enth�lt den aktuellen Tag im Monat.
	 */
	static final int CURRENT_DAY = GregorianCalendar.getInstance().get(GregorianCalendar.DAY_OF_MONTH);
	
	/**
	 * Diese Konstante enth�lt den aktuellen Monat.
	 */
	static final int CURRENT_MONTH = GregorianCalendar.getInstance().get(GregorianCalendar.MONTH) + 1;
	
	/**
	 * Diese Konstante enth�lt das aktuelle Jahr.
	 */
	static final int CURRENT_YEAR = GregorianCalendar.getInstance().get(GregorianCalendar.YEAR);
	
	/**
	 * Wenn es sich um ein g�ltiges Datum handelt, liefert 
	 * diese Methoden den Tag des angegebenen Datums als 
	 * int-Wert; im Falle eines ung�ltigen Datums liefert
	 * sie -1.
	 */
	int getDay();
	
	/**
	 * Wenn es sich um ein g�ltiges Datum handelt, liefert 
	 * diese Methoden den Monat des angegebenen Datums als 
	 * int-Wert; im Falle eines ung�ltigen Datums liefert
	 * sie -1.
	 */
	int getMonth();
	
	/**
	 * Wenn es sich um ein g�ltiges Datum handelt, liefert 
	 * diese Methoden das Jahr des angegebenen Datums als 
	 * int-Wert; im Falle eines ung�ltigen Datums liefert
	 * sie -1.
	 */
	int getYear();
	
	/**
	 * Diese Methode liefert genau dann true, wenn das Objekt
	 * mit einem g�ltigen Datum (in Bezug auf den 
	 * Gregorianischen Kalender) initialisiert wurde, sonst 
	 * false.
	 */
	boolean isValid();
	
	/**
	 * Die Methode liefert genau dann true, wenn das vorliegende
	 * und das als Parameter �bergebene Datum g�ltig sind und
	 * das vorliegende Datum gr��er ist als das �bergebene
	 * Datum, sonst false.
	 */
	boolean isLaterThan( Date d2 );
	
	/**
	 * Die Methode liefert den Wochentag zu einem g�ltigen
	 * Datum (in Bezug auf den Gregorianischen Kalender) bzw.
	 * null, wenn es sich nicht um ein g�ltiges Datum handelt.
	 */
	Weekday getWeekday();
	
	/**
	 * Die Methode subtrahiert das durch den Parameter 
	 * angegebene Datum vom vorliegenden Datum und liefert die 
	 * Differenz der beiden (g�ltigen!) Datumsangaben in Tagen 
	 * als ganze Zahl.<br>
	 * Voraussetzung: Beide Daten sind g�ltig und das 
	 * vorliegende Datum ist gr��er als das �bergebene Datum, 
	 * sonst ist das Ergebnis -1.
	 */
	int subtract( Date d2 );
	
	/**
	 * Die Methode speichert alle zu einem
	 * Datum geh�renden Daten in die Datei, 
	 * die durch den angegebenen Parameter repr�sentiert 
	 * wird (Ergebnis von openOutputFile(...)).
	 */
	void saveToFile( Object file );
	
	/**
	 * Die Methode l�dt alle zu einem Datum geh�renden 
	 * Daten aus der Datei, die durch den
	 * angegebenen Parameter repr�sentiert wird
	 * (Ergebnis von openInputFile(...)),
	 * in das Datumsobjekt.
	 */
	void loadFromFile( Object file );
	
}
