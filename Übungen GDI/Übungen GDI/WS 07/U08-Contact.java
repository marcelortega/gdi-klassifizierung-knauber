package contactManagement;

/**
 * Dieses Interface definiert, welche Daten zu einem
 * Kontakt gehören. Die Getter- und Setter-Methoden
 * sind sicherlich selbsterklärend.
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
	 * einzelnen Kontaktobjekt gehörenden 
	 * Daten in die Datei, die durch das
	 * angegebene Objekt repräsentiert wird
	 * (Ergebnis von openOutputFile(...)).
	 */
	void saveToFile( Object file );
	/**
	 * Die Methode lädt alle zu einem
	 * einzelnen Kontaktobjekt gehörenden 
	 * Daten aus der Datei, die durch den
	 * angegebenen Parameter repräsentiert wird
	 * (Ergebnis von openInputFile(...)),
	 * in das Kontaktobjekt.
	 */
	void loadFromFile( Object file );

}