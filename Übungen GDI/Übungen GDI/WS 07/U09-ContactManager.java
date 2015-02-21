package contactManagement;

/**
 * Dieses Interface legt fest, welche Funktionalität die
 * Kontaktverwaltung bietet.
 * Die Bedeutung der einzelnen Methoden ist bei jeder
 * Methode beschrieben.<br><br>
 * Allgemeine Erklärungen:<br>
 * Das Interface schreibt vor, dass zu jedem Kontakt eine
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
 * gespeichert werden können.<br>
 * 
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
	 * vorhandene Kontaktdaten überschrieben.
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
	
}
