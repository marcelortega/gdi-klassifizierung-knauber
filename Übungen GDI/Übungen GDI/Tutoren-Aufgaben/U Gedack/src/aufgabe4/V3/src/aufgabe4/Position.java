package aufgabe4;

/**
 * Position.
 * Diese Klasse bildet die Position des Spieler etc. ab. 
 * Zwei Dimensional (x, y).
 */
public class Position {
	
	
	/*
	 * Die x und y Koordinaten.
	 */
	public int x, y;

	
	
	/*
	 * Default Konstruktor
	 */
	public Position() {
		this(0, 0);
	}//public Position()

	
	
	/*
	 * Für dem Fall, man möchte die Koordinaten mit übergeben
	 */
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}//public Position(int x, int y)

	
	
	/*
	 * Für den Fall, man möchte eine Position übergeben
	 */
	public Position(Position p) {
		this(p.x, p.y);
	}//public Position(Position p)

	
	
	/*
	 * Zur Ausgabe der Position etc.
	 */
	public String toString() {
		return "(x=" + x + ",y=" + y + ")";
	}//public String toString()

	
	
	/*
	 * Um Positionen zu vergleichen.
	 */
	public boolean equals(Object obj) {
		if (obj instanceof Position) {
			Position position = (Position) obj;
			return ((x == position.x) && (y == position.y));
		}
		return super.equals(obj);
	}//public boolean equals(Object obj)

	
}//public class Position