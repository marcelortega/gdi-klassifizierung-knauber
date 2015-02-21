package contactManager;

/**
 * Dieses Interface legt fest, welche Funktionalit�t die
 * Kontaktverwaltung bietet.
 * Die Bedeutung der einzelnen Methoden ist bei jeder
 * Methode beschrieben.
 */
public interface ContactManager {
	
	/**
	 * Die Methode f�gt den neuen Kontakt zu den 
	 * bereits vorhandenen Kontakten hinzu.
	 */
	void add( Contact contact );
	
	/**
	 * Die Methode l�scht den angegebenen Kontakt 
	 * aus den bisher vorhandenen.
	 */
	void remove( Contact contact );
	
	/**
	 * Die Methode speichert alle aktuell 
	 * vorliegenden Kontakte in die Datei, 
	 * die durch das angegebene Objekt repr�sentiert 
	 * wird (Ergebnis von openOutputFile(...)). 
	 * Sollten in der Datei bereits (irgendwelche)
	 * Daten vorliegen, werden diese �berschrieben.
	 */
	void saveToFile( Object out );
	
	/**
	 * Die Methode l�dt alle Kontakte aus
	 * der Datei, die durch den angegebenen 
	 * Parameter repr�sentiert wird
	 * (Ergebnis von openInputFile(...)).
	 * Dabei werden eventuell im Speicher 
	 * vorhandene Kontaktdaten �berschrieben.
	 */
	void loadFromFile( Object in );
	
	/**
	 * Die Methode liefert ein passend 
	 * dimensioniertes Array mit allen
	 * aktuell vorliegenden Kontaktdaten.
	 */
	Contact[] getAllContacts();
	
}
