package contactManager;

/**
 * Objekte dieser Klasse dienen als Parameter für eine Methode, die
 * Kontakt-Objekte sortiert. Ein Comparator-Objekt dient dazu, jeweils
 * zwei Kontakt-Objekte miteinander zu vergleichen.<br>
 * Jede Implementierung dieser Klasse kann nach anderen Kriterien
 * vergleichen; davon muss der eigentliche Sortieralgorithmus aber 
 * nichts wissen, weil er lediglich die compare-Methode aufruft, 
 * ohne deren Implementierung zu kennen.
 */
public interface ContactComparator {
	
	/**
	 * Diese Methode vergleicht zwei Contact-Objekte.
	 * Sie liefert ComparisonResult.LESS, EQUAL oder
	 * GREATER, je nachdem was der Vergleich ergibt.
	 */
	ComparisonResult compare( Contact c1, Contact c2 );
	
}
