
public interface ContactWithTexts extends Contact {
	
	/**
	 * Liefert den im Kontaktobjekt eingetragenen 
	 * frei benennbaen Text
	 */
	String getFreeText();

	/**
	 * Liefert die im Kontaktobjekt eingetragene Notiz
	 */
	String getNotes();
	
}
