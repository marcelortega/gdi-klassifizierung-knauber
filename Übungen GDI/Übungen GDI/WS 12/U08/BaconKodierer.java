package uebung08;

public interface BaconKodierer {
	
	/**
	 * Beschreibung siehe Übungsblatt 8, Aufgabe 1a
	 */
	String reinigeUrsprungstext(String text);
	
	/**
	 * Beschreibung siehe Übungsblatt 8, Aufgabe 1b
	 */
	String kodiereUrsprungstext(String text);
	
	/**
	 * Beschreibung siehe Übungsblatt 8, Aufgabe 1c
	 */
	String dekodiereUrsprungstext(String binaerCode);
	
	/**
	 * Beschreibung siehe Übungsblatt 8, Aufgabe 1d
	 */
	String versteckeText(String ursprungsText, String mediumText);
	
	/**
	 * Beschreibung siehe Übungsblatt 8, Aufgabe 1e
	 */
	String zeigeText(String steganogramm);

}
