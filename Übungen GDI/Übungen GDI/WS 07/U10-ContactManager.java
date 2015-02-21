package contactManagement;

/**
 * Dieses Interface legt fest, welche Funktionalität die
 * Kontaktverwaltung bietet.
 * Die Bedeutung der einzelnen Methoden ist bei jeder
 * Methode beschrieben.<br><br>
 * Allgemeine Erklärungen:<br>
 * <ul>
 * <li>Das Interface schreibt vor, dass zu jedem Kontakt eine
 * Reihe von "Blankotexten" verwaltet werden können, damit
 * Informationen gespeichert werden können, für die keine
 * Rubrik wie "Adresse" oder "Telefonnummer" vorgesehen sind.
 * Diese bestehen jeweils aus einem (für alle Kontakte 
 * einheitlichen) Namen und einem freien Text pro Kommentar.
 * Zum Beispiel könnte zu jedem Kontakt gespeichert werden,
 * wann und wo man diese Person kennengelernt hat. Dann könnte
 * man den Namen eines der Blankotexte "Erstkontakt" nennen und
 * die Texte zu einigen Kontakten könnten "Geburtstagsparty von 
 * Udo '05" oder "XP-Konferenz 2006" lauten. Andere Beispiele
 * für Verwendungsmöglichkeiten von Blankotexten könnten
 * "2. Email-Adresse" oder "Nummer der Sekretärin" sein.
 * Die Konstante <code>ContactManager.CUSTOM_LABEL_NUMBER</code>
 * legt fest, wieviele solcher Zusatztexte pro Kontakt 
 * gespeichert werden können.</li>
 * <li>Jeder Kontakt in der Kontaktverwaltung kann einer
 * sogenannten Kategorie zugeordnet werden, z.B. "Privat",
 * "Dienstlich", "Kinder". Die Namen dieser Kategorien lassen
 * sich im Kontaktmanager ändern und es ist möglich, neue
 * Kategorien anzulegen, existierende zu löschen sowie nach
 * Kategorien zu suchen. Für Kontakte, die nicht (mehr) einer 
 * Kategorie zugeordnet sind, gibt es eine Kategorie, die durch 
 * den Namen der Konstante <code>ContactManager.CATEGORY_UNFILED</code> 
 * bezeichnet wird. In der Kontaktverwaltung das Speichern der 
 * Namen aller vorhandenen Kategorien; jeder Kontakt speichert
 * die ihm jeweils zugeordnete Kategorie.<br>
 * Die Anzahl der Kategorien ist nicht beschränkt.</li>
 * </ul>
 */
public interface ContactManager {
	
	/**
	 * Die Methode fügt den neuen Kontakt den 
	 * bereits vorhandenen hinzu.
	 */
	void add( Contact contact );
	/**
	 * Die Methode löscht den angegebenen Kontakt 
	 * aus den bisher vorhandenen.
	 */
	void remove( Contact contact );
	
	/**
	 * Die Methode speichert alle aktuell 
	 * vorliegenden Kontakte in eine Datei
	 * mit dem angegebenen Namen. Sollten
	 * in der Datei bereits (irgendwelche)
	 * Daten vorliegen, werden diese überschrieben.
	 */
	void saveToFile( String filename );
	/**
	 * Die Methode lädt alle Kontakte aus
	 * einer Datei mit dem angegebenen Namen.
	 * Dabei werden eventuell im Speicher 
	 * vorhandene Kontaktdaten überschrieben
	 * <b>nur dann</b>, wenn die Datei existiert.
	 * Falls die Datei nicht existiert, bleiben
	 * die vorhandenen Kontaktdaten erhalten.
	 */
	void loadFromFile( String filename );
	
	/**
	 * Die Methode liefert ein passend 
	 * dimensioniertes Array mit allen
	 * aktuell vorliegenden Kontaktdaten.
	 */
	Contact[] getAllContacts();
	
	// Teil 2
	/**
	 * Diese Konstante legt fest, wieviele Zusatztexte pro 
	 * 
	 * Kontakt gespeichert werden können (siehe allgemeine
	 * Beschreibung dieser Funktionalität bei der Klasse).
	 */
	static final int CUSTOM_LABEL_NUMBER = 4;
	
	/**
	 * Diese Methode liefert alle Namen der Blankotexte (siehe 
	 * allgemeine Beschreibung dieser Funktionalität bei der 
	 * Klasse).
	 */
	String[] getCustomLabels();
	
	/**
	 * Diese Methode erlaubt es, die Namen aller Blankotexte
	 * zu definieren (siehe allgemeine Beschreibung dieser 
	 * Funktionalität bei der Klasse).<br>
	 * Voreinstellung: <code>SortOrder.LAST_NAME_THEN_FIRST_NAME</code>
	 */
	void setCustomTextLabels( String[] labels );
	
	/**
	 * Mit dieser Methode wird definiert, in welcher
	 * Reihenfolge die bei einer Suche gefundenen Kontakte
	 * geliefert werden, sofern die Suche mehr als einen 
	 * Kontakt als Ergebnis liefert. Sind eins oder mehrere
	 * der relevanten Kriterien in einem Kontakt nicht 
	 * verfügbar, wird dieser Kontakt im Ergebnis nicht 
	 * berücksichtigt.
	 */
	void setSortOrder( SortOrder order );
	
	/**
	 * Diese Methode liefert ein passend dimensioniertes Array
	 * mit allen Kontakten, für die ein Nachname angegeben ist,
	 * der mit dem angegebenen String beginnt. Groß- und
	 * Kleinschreibung ist dabei irrelevant.
	 * Wenn das Kriterium auf mehrere Kontakte zutrifft, werden
	 * diese anhand des gesetzten Suchkriteriums sortiert.
	 */
	Contact[] searchByNameStart( String nameStart );
	
	/**
	 * Diese Methode liefert ein passend dimensioniertes Array
	 * mit allen Kontakten, für die zumindest eine Postleitzahl
	 * (privat oder beruflich) angegeben ist, die innerhalb
	 * der angegebenen Grenzen (inklusive) liegt.
	 * Wenn das Kriterium auf mehrere Kontakte zutrifft, werden
	 * diese anhand des gesetzten Suchkriteriums sortiert.
	 */
	Contact[] searchByZip( int lowerBound, int upperBound );
	
	/**
	 * Diese Methode liefert ein passend dimensioniertes Array
	 * mit allen Kontakten, für die zumindest ein <b>beliebiger</b> 
	 * Eintrag (egal ob zum Beispiel Name, Titel oder Wohnort) 
	 * existiert, der den angegebenen String enthält.
	 * Wenn das Kriterium auf mehrere Kontakte zutrifft, werden
	 * diese anhand des gesetzten Suchkriteriums sortiert.
	 */
	Contact[] searchByText( String text );
	
	
	// Teil 3
	/**
	 * Diese Konstante steht als Default für die Kategorie 
	 * neuer Kontakte. Sie kann nicht umbenannt oder gelöscht 
	 * werden.
	 */
	public static final String CATEGORY_UNFILED = "Unsortiert";
	
	/**
	 * Mit dieser Methode kann man der Kontaktverwaltung eine
	 * neue Kategorie hinzufügen. Der Name darf noch nicht
	 * vergeben sein und es dürfen keine Leerstrings oder
	 * null-Strings übergeben werden. Die neue Kategorie ist
	 * zunächst leer.
	 */
	void addCategory( String categoryName );
	
	/**
	 * Mit dieser Methode kann man eine existierende Kategorie
	 * in der Kontaktverwaltung umbenennen. Der ursprüngliche
	 * Name muss, der neue Namen darf noch nicht vergeben sein.
	 * Leerstrings sind nicht erlaubt. Alle Kontakte der
	 * ursprünglichen Kategorie werden in die neue Kategorie
	 * "verschoben".
	 */
	void modifyCategory( String oldCategoryName, String newCategoryName );
	
	/**
	 * Mit dieser Methode kann man eine existierende Kategorie
	 * in der Kontaktverwaltung löschen. Der 
	 * Name muss vergeben sein, Leerstrings sind nicht erlaubt. 
	 * Alle Kontakte der zu löschenden Kategorie werden in
	 * Abhängigkeit vom Parameter 
	 * <code>moveContactsToUnfiled</code> entweder in die
	 * <code>CATEGORY_UNFILED</code>-Kategorie verschoben oder 
	 * gelöscht.
	 */
	void removeCategory( String categoryName, boolean moveContactsToUnfiled );
	
	/**
	 * Diese Methode liefert die Namen aller aktuell angelegten 
	 * Kategorien inklusive <code>CATEGORY_UNFILED</code>.
	 */
	String[] getAllCategories();
	
	/**
	 * Diese Methode liefert die Namen aller aktuell angelegten 
	 * Kategorien exklusive <code>CATEGORY_UNFILED</code>.
	 * Nur diese Kategorien können umbenannt oder gelöscht
	 * werden!
	 */
	String[] getAllEditableCategories();
	
	/**
	 * Diese Methode liefert ein passend dimensioniertes Array
	 * mit allen Kontakten der angegebenen Kategorie.
	 * Wenn es mehrere Kontakte in dieser Kategorie gibt, werden
	 * diese anhand des gesetzten Suchkriteriums sortiert.
	 */
	Contact[] searchByCategory( String categoryName );
	
}
