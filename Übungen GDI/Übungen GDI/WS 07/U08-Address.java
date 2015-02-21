package contactManagement;

/**
 * Dieses Interface definiert, welche Daten zu einer
 * Adresse gehören. Alle Methoden
 * sind sicherlich selbsterklärend.
 */
public interface Address {

	String getStreet();
	void setStreet( String street );

	int getNumber();
	void setNumber( int number );


	int getZip();
	void setZip( int zip );

	String getCity();
	void setCity( String city );

	/**
	 * Die Methode speichert alle zu einem
	 * einzelnen Adressobjekt gehörenden 
	 * Daten in die Datei, die durch das
	 * angegebene Objekt repräsentiert wird
	 * (Ergebnis von openOutputFile(...)).
	 */
	void saveToFile( Object file );
	/**
	 * Die Methode lädt alle zu einem
	 * einzelnen Adressobjekt gehörenden 
	 * Daten aus der Datei, die durch den
	 * angegebenen Parameter repräsentiert wird
	 * (Ergebnis von openInputFile(...)), in
	 * das Adressobjekt.
	 */
	void loadFromFile( Object file );

}
