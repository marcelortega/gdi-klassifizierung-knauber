package contactManager09;

public interface Address {

	/**
	 * Die Methode liefert die im Adressobjekt enthaltene Straße
	 */
	public String getStreet();

	/**
	 * Die Methode liefert die im Adressobjekt enthaltene Hausnummer
	 */
	public int getNumber();

	/**
	 * Die Methode liefert die im Adressobjekt enthaltene Postleitzahl
	 */
	public int getZip();

	/**
	 * Die Methode liefert die im Adressobjekt enthaltene Stadt
	 */
	public String getCity();
	
	/**
	 * Die Methode speichert die im Adressobjekt
	 * enthaltenen Daten in die angegebene Datei.
	 */
	void saveToFile( Object file );

	/**
	 * Die Methode lädt alle Daten für das 
	 * Adressobjekt aus der angegebenen Datei.
	 * Dabei werden die im Objekt 
	 * vorhandenen Daten überschrieben.
	 */
	void loadFromFile( Object file );

	/**
	 * Die Methode fügt alle Daten, die im
	 * Adressobjekt vorliegen, in einen String
	 * zusammen (getrennt durch ein beliebiges
	 * Zeichen) und liefert diesen String zurück.<br>
	 * Beispiel: "Hauptstraße|23|68333|Mannheim"
	 */
	String toText();

}
