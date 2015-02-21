package uebung09;

public interface Labyrinth {

	/**
	 * Die Methode liefert diejenige Position im Rand des Labyrinths,
	 * die durch ein 'E' als Eingang gekennzeichnet ist.
	 */
	Position findStartPosition();

	/**
	 * Die Methode liefert genau dann true, wenn es sich bei der 
	 * angegebenen Position um die Startposition des Labyrinths handelt.
	 */
	boolean isStartPosition( int row, int col );

	/**
	 * Die Methode liefert genau dann true, wenn es sich bei der 
	 * angegebenen Position um eine Position am Rand des Labyrinths handelt.
	 */
	boolean isBorderPosition( int row, int col );

	/**
	 * Die Methode liefert genau dann true, wenn von der angegebenen
	 * Position aus ein Schritt nach "Süden", d.h. auf dem Bildschirm unten,
	 * möglich ist.
	 */
	boolean isGoingSouthPossible( int row, int col );

	/**
	 * Die Methode liefert genau dann true, wenn von der angegebenen
	 * Position aus ein Schritt nach "Norden", d.h. auf dem Bildschirm oben,
	 * möglich ist.
	 */
	boolean isGoingNorthPossible( int row, int col );

	/**
	 * Die Methode liefert genau dann true, wenn von der angegebenen
	 * Position aus ein Schritt nach "Westen", d.h. auf dem Bildschirm links,
	 * möglich ist.
	 */
	boolean isTurningWestPossible( int row, int col );

	/**
	 * Die Methode liefert genau dann true, wenn von der angegebenen
	 * Position aus ein Schritt nach "Osten", d.h. auf dem Bildschirm rechts,
	 * möglich ist.
	 */
	boolean isTurningEastPossible( int row, int col );

	/**
	 * Die Methode liefert einen String, der das Labyrinth im augenblicklichen
	 * Zustand, d.h. mit den markierten Wegen, enthält. Für den Ausdruck
	 * kann dieser String mittels eines einzelnen 'println'-Aufrufs auf der 
	 * Konsole ausgegeben werden.
	 */
	String toString();

	/**
	 * Die Methode markiert die angegebene Position im Labyrinth mit
	 * einem '+'-Zeichen.
	 */
	void markVisited( int row, int col );

	/**
	 * Die Methode entfernt eine etwaige Markierung ('*', '+' oder 'E') an
	 * der angegebenen Position im Labyrinth.
	 */
	void removeMark( int row, int col );

}
