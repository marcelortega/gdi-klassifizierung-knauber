
/**
 * Dieses Interface legt fest, welche Funktionalit�t die
 * erweiterte Kontaktverwaltung bietet; im Wesentlichen
 * kommt Such-Funktionalit�t hinzu.
 * Die Bedeutung der einzelnen Methoden ist bei jeder
 * Methode beschrieben.
 */
public interface SearchableContactManager extends ContactManager {
	
	/**
	 * Diese Methode liefert ein passend dimensioniertes Array
	 * mit allen Kontakten, deren Nachname mit dem angegebenen 
	 * String beginnt. Es wird dabei kein Unterschied zwischen
	 * Gro�- und Kleinschreibung gemacht.
	 * Wenn das Kriterium auf mehrere Kontakte zutrifft, werden
	 * diese anhand des angegebenen Suchkriteriums sortiert.
	 */
	Contact[] searchNameStart( String text );
	
	/**
	 * Diese Methode liefert ein passend dimensioniertes Array
	 * mit allen Kontakten, f�r die zumindest ein  
	 * Eintrag (egal ob zum Beispiel Name, Titel oder Wohnort) 
	 * existiert, der den angegebenen String enth�lt; ausgenommen
	 * sind lediglich das Geburtsdatum inkl. Erinnerung und
	 * die Hausnummern.
	 */
	Contact[] searchFullText( String text );

	String getDeveloperTeamInformation();
	
	String getFreeTextLabel();

	void setFreeTextLabel( String text );

}
