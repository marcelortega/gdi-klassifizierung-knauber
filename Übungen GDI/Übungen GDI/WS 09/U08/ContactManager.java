package contactManager09;

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
	 * Die Methode löscht den angegebenen aktuellen
	 * Kontakt aus den bisher vorhandenen und ersetzt
	 * ihn durch den angegebenen neuen Kontakt.
	 */
	void replace( Contact currentContact, Contact newContact );
	
	/**
	 * Die Methode speichert alle aktuell 
	 * vorliegenden Kontakte in die angegebene
	 * Datei.
	 */
	void saveToFile( Object file );
	
	/**
	 * Die Methode lädt alle Kontakte aus
	 * der angegebenen Datei.
	 * Dabei werden eventuell bereits 
	 * vorhandene Kontakte überschrieben.
	 */
	void loadFromFile( Object file );
	
	/**
	 * Die Methode liefert ein passend 
	 * dimensioniertes Array mit allen
	 * aktuell vorliegenden Kontakten.
	 */
	Contact[] getAllContacts();

}
