package contactManager;

/**
 * Dieses Interface legt fest, welche Funktionalität die
 * Kontaktverwaltung bietet.
 * Die Bedeutung der einzelnen Methoden ist bei jeder
 * Methode beschrieben.
 */
public interface ContactManager {
	
	/**
	 * Die Methode fügt den neuen Kontakt zu den 
	 * bereits vorhandenen Kontakten hinzu.
	 */
	void add( Contact contact );
	
	/**
	 * Die Methode löscht den angegebenen Kontakt 
	 * aus den bisher vorhandenen.
	 */
	void remove( Contact contact );
	
	/**
	 * Die Methode speichert alle aktuell 
	 * vorliegenden Kontakte in die Datei, 
	 * die durch das angegebene Objekt repräsentiert 
	 * wird (Ergebnis von openOutputFile(...)). 
	 * Sollten in der Datei bereits (irgendwelche)
	 * Daten vorliegen, werden diese überschrieben.
	 */
	void saveToFile( Object out );
	
	/**
	 * Die Methode lädt alle Kontakte aus
	 * der Datei, die durch den angegebenen 
	 * Parameter repräsentiert wird
	 * (Ergebnis von openInputFile(...)).
	 * Dabei werden eventuell im Speicher 
	 * vorhandene Kontaktdaten überschrieben.
	 */
	void loadFromFile( Object in );
	
	/**
	 * Die Methode liefert ein passend 
	 * dimensioniertes Array mit allen
	 * aktuell vorliegenden Kontaktdaten.
	 */
	Contact[] getAllContacts();
	
}
