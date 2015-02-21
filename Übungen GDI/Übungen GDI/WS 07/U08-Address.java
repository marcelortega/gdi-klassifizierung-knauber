package contactManagement;

/**
 * Dieses Interface definiert, welche Daten zu einer
 * Adresse geh�ren. Alle Methoden
 * sind sicherlich selbsterkl�rend.
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
	 * einzelnen Adressobjekt geh�renden 
	 * Daten in die Datei, die durch das
	 * angegebene Objekt repr�sentiert wird
	 * (Ergebnis von openOutputFile(...)).
	 */
	void saveToFile( Object file );
	/**
	 * Die Methode l�dt alle zu einem
	 * einzelnen Adressobjekt geh�renden 
	 * Daten aus der Datei, die durch den
	 * angegebenen Parameter repr�sentiert wird
	 * (Ergebnis von openInputFile(...)), in
	 * das Adressobjekt.
	 */
	void loadFromFile( Object file );

}
