package contactManagement;

/**
 * Dieses Interface definiert, welche Daten zu einem
 * Kontakt geh�ren. Die Getter- und Setter-Methoden
 * sind sicherlich selbsterkl�rend.<br>
 * 
 * Mit den Getter- und Setter-Methoden f�r die 
 * <code>CustomTexts</code> werden die kontaktspezifischen Texte 
 * (durch einen Index identifiziert) gesetzt oder abgefragt, 
 * s. Beschreibung des Interface' <code>ContactManager</code>.<br>
 * 
 */
public interface Contact {

	String getFirstName();
	void setFirstName( String firstName );

	String getLastName();
	void setLastName( String lastName );

	
	String getTitle();
	void setTitle( String title );

	String getCompanyName();
	void setCompanyName( String companyName );

	
	Address getHome();
	void setHome( Address home );

	Address getWork();
	void setWork( Address work );

	
	String getPhoneAtHome();
	void setPhoneAtHome( String phoneAtHome );

	String getPhoneAtWork();
	void setPhoneAtWork( String phoneAtWork );

	String getMobilePhone();
	void setMobilePhone( String mobilePhone );

	
	String getEmail();
	void setEmail( String email );

	String getUrl();
	void setUrl( String website );

	/**
	 * Die Methode speichert alle zu einem
	 * einzelnen Kontaktobjekt geh�renden 
	 * Daten in die Datei, die durch das
	 * angegebene Objekt repr�sentiert wird
	 * (Ergebnis von openOutputFile(...)).
	 */
	void saveToFile( Object file );
	/**
	 * Die Methode l�dt alle zu einem
	 * einzelnen Kontaktobjekt geh�renden 
	 * Daten aus der Datei, die durch den
	 * angegebenen Parameter repr�sentiert wird
	 * (Ergebnis von openInputFile(...)),
	 * in das Kontaktobjekt.
	 */
	void loadFromFile( Object file );

	
	/////     Teil 2     ////////////////////////////////////////
	
	/**
	 * Diese Methode dient dazu, einen der "Blankotexte" in
	 * einem Kontakt zu setzen, siehe Beschreibung im Interface
	 * <code>ContactManager</code>.
	 * Die Indexwerte m�ssen im Bereich 0 bis
	 * <code>ContactManager.CUSTOM_LABEL_NUMBER</code> liegen.
	 */
	void setCustomText( int index, String text );
	
	/**
	 * Diese Methode dient dazu, einen der "Blankotexte" in
	 * einem Kontakt abzufragen, siehe Beschreibung im Interface
	 * <code>ContactManager</code>
	 * Die Indexwerte m�ssen im Bereich 0 bis
	 * <code>ContactManager.CUSTOM_LABEL_NUMBER</code> liegen.
	 */
	String getCustomText( int index );
		
}