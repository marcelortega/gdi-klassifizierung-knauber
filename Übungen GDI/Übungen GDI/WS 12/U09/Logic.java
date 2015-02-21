package uebung09;

public interface Logic {

	/**
	 * Die Methode bekommt den Eingang zu einem ihr bekannten Labyrinth,
	 * sucht von dort aus alle Wege hindurch und gibt jeden gefundenen
	 * Weg auf der Konsole aus.
	 */
	void findAndPrintWaysOut(Position position);

}