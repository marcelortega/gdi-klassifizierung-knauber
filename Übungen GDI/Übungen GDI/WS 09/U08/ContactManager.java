package contactManager09;

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
	 * Die Methode l�scht den angegebenen aktuellen
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
	 * Die Methode l�dt alle Kontakte aus
	 * der angegebenen Datei.
	 * Dabei werden eventuell bereits 
	 * vorhandene Kontakte �berschrieben.
	 */
	void loadFromFile( Object file );
	
	/**
	 * Die Methode liefert ein passend 
	 * dimensioniertes Array mit allen
	 * aktuell vorliegenden Kontakten.
	 */
	Contact[] getAllContacts();

}
