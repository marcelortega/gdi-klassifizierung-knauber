package contactManagement;


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
	
}
