package contactManager09;

public interface Date {

	/**
	 * Die Methode liefert die im Datumsobjekt
	 * enthaltene Tagesangabe
	 */
	int getDay();

	/**
	 * Die Methode liefert die im Datumsobjekt
	 * enthaltene Monatsangabe
	 */
	int getMonth();

	/**
	 * Die Methode liefert die im Datumsobjekt
	 * enthaltene Jahresangabe
	 */
	int getYear();

	/**
	 * Die Methode liefert das Datum im gewohnten
	 * Format TT.MM.YYYY
	 */
	String toString();
	
	/**
	 * Die Methode speichert die im Datumsobjekt
	 * enthaltenen Daten in die angegebene Datei.
	 */
	void saveToFile( Object file );

	/**
	 * Die Methode lädt alle Daten für das 
	 * Datumsobjekt aus der angegebenen Datei.
	 * Dabei werden die im Objekt 
	 * vorhandenen Daten überschrieben.
	 */
	void loadFromFile( Object file );

}
