package contactManager09;

public interface Address {

	/**
	 * Die Methode liefert die im Adressobjekt enthaltene Stra�e
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
	 * Die Methode l�dt alle Daten f�r das 
	 * Adressobjekt aus der angegebenen Datei.
	 * Dabei werden die im Objekt 
	 * vorhandenen Daten �berschrieben.
	 */
	void loadFromFile( Object file );

	/**
	 * Die Methode f�gt alle Daten, die im
	 * Adressobjekt vorliegen, in einen String
	 * zusammen (getrennt durch ein beliebiges
	 * Zeichen) und liefert diesen String zur�ck.<br>
	 * Beispiel: "Hauptstra�e|23|68333|Mannheim"
	 */
	String toText();

}
