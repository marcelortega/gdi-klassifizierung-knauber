package contactManager09;

public interface Contact {
	
	/**
	 * Die Methode liefert den im Kontaktobjekt enthaltenen Nachnamen
	 */
	String getLastName();

	/**
	 * Die Methode liefert den im Kontaktobjekt enthaltenen Vornamen
	 */
	String getFirstName();

	/**
	 * Die Methode liefert den im Kontaktobjekt enthaltenen Titel
	 */
	String getTitle();

	/**
	 * Die Methode liefert die im Kontaktobjekt enthaltene Firma
	 */
	String getCompanyName();
	
	/**
	 * Die Methode liefert die im Kontaktobjekt enthaltene Email
	 */
	String getEmail();
	
	/**
	 * Die Methode liefert die im Kontaktobjekt enthaltene private Telefonnummer
	 */
	String getPhoneAtHome();

	/**
	 * Die Methode liefert die im Kontaktobjekt enthaltene dienstliche Telefonnummer
	 */
	String getPhoneAtWork();

	/**
	 * Die Methode liefert die im Kontaktobjekt enthaltene Mobil-Telefonnummer
	 */
	String getMobilePhone();

	/**
	 * Die Methode liefert die im Kontaktobjekt enthaltene URL
	 */
	String getUrl();

	/**
	 * Die Methode liefert die im Kontaktobjekt enthaltene private Adresse
	 */
	Address getHomeAddress();

	/**
	 * Die Methode liefert die im Kontaktobjekt enthaltene dienstliche Adresse
	 */
	Address getWorkAddress();
	
	/**
	 * Die Methode liefert das im Kontaktobjekt enthaltene Geburtsdatum
	 */
	Date getBirthday();

	/**
	 * Die Methode liefert true, wenn in der Woche vor dem im 
	 * Kontaktobjekt eingetragenen Geburtsdatum an den 
	 * Geburtstag erinnert werden soll, sonst false.
	 * Ist kein (gültiges) Geburtsdatum eingetragen, wird 
	 * auch nicht erinnert.
	 */
	boolean isBirthdayReminderActivated();

	/**
	 * Die Methode speichert die im Kontaktobjekt
	 * enthaltenen Daten in die angegebene Datei.
	 */
	void saveToFile( Object file );

	/**
	 * Die Methode lädt alle Daten für das Kontaktobjekt 
	 * aus der angegebenen Datei.
	 * Dabei werden die im Objekt 
	 * vorhandenen Daten überschrieben.
	 */
	void loadFromFile( Object file );
	
	/**
	 * Die Methode fügt alle Daten, die im
	 * Kontaktobjekt vorliegen, in einen String
	 * zusammen (getrennt durch ein beliebiges
	 * Zeichen) und liefert diesen String zurück.<br>
	 * Beispiel: "Hans|Schmidt||HS Mannheim|..."
	 */
	String toText();

}
