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
	
	
	/////     Teil 3     ////////////////////////////////////////
	
	/**
	 * Diese Methode liefert den zu einem kontakt vorliegenden
	 * Kategorienamen.
	 * Default-Wert: ContactManager.CATEGORY_UNFILED.
	 */
	String getCategoryName();
	
	/**
	 * Diese Methode erm�glicht das Setzen der Kategorie
	 * f�r einen Kontakt. Es sind nur existierende Kategorienamen
	 * erlaubt.
	 */
	void setCategoryName( String categoryName );
	
	
	/////     Teil 4     ////////////////////////////////////////
	
	/**
	 * Diese Methode erm�glicht das Setzen eines Geburtsdatums.
	 * Es erfolgt keine R�ckmeldung, ob es sich um ein g�ltiges
	 * Datum handelt; das kann mithilfe der Methoden 
	 * <code>getDayOfBirth</code>, 
	 * <code>getMonthOfBirth</code> oder
	 * <code>getYearOfBirth</code> �berpr�ft werden.
	 */
	void setBirthDay( int day, int month, int year );
	
	/**
	 * Diese Methode liefert einen String mit dem Tag des 
	 * Geburtsdatums im Monat genau dann, wenn zuvor ein 
	 * g�ltiges Geburtsdatum eingetragen wurde, sonst einen
	 * leeren String.
	 */
	String getDayOfBirth();
	
	/**
	 * Diese Methode liefert einen String mit dem Geburtsmonat 
	 * genau dann, wenn zuvor ein g�ltiges Geburtsdatum 
	 * eingetragen wurde, sonst einen leeren String.
	 */
	String getMonthOfBirth();
	
	/**
	 * Diese Methode liefert einen String mit dem Geburtsjahr 
	 * genau dann, wenn zuvor ein g�ltiges Geburtsdatum 
	 * eingetragen wurde, sonst einen leeren String.
	 */
	String getYearOfBirth();

	/**
	 * Mittels dieser Methode l�sst sich einstellen, ob im
	 * Falle eines vorliegenden Geburtsdatums an allen Tagen
	 * in der Woche vor dem Geburtsdatum beim Start des
	 * Kontaktmanagers ein entsprechender Hinweis (z.B.
	 * "Hans Schmidt hat am n�chsten Freitag Geburtstag" 
	 * ausgegeben werden soll.
	 */
	void setRemindOneWeekBefore( boolean remindOneWeekBefore );
	
	/**
	 * Liefert <code>true</code> genau dann, wenn auf den
	 * Geburtstag hingewiesen werden soll (wenn also die
	 * Methode <code>setRemindOneWeekBefore</code> zuletzt mit 
	 * <code>true</code> aufgerufen wurde) und ein
	 * Geburtsdatum vorliegt, sonst <code>false</code>.
	 */
	boolean isRemindOneWeekBefore();
	
	/**
	 * Liefert eine Woche bis einen Tag vor dem Geburtsdatum 
	 * <code>true</code>, sonst <code>false</code>. Wenn kein
	 * Geburtsdatum angegeben ist, wird immer <code>false</code>
	 * geliefert. Achtung: Das Ergebnis ist nicht davon 
	 * abh�ngig, ob der Reminder gesetzt wurde (Methode
	 * <code>setRemindOneWeekBefore</code>)!
	 */
	boolean isOneWeekBefore();
	
}
