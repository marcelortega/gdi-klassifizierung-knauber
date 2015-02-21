package aufgabe4;

import static gdi.MakeItSimple.*;

/**
 * Diese Klasse h�lt das Labyrinth.
 * Die implementierung des mehrdimensionalen Arrays ist durch die Implementierung quasi
 * gekapselt. Daher sind im Vergleich zur letzten Version keine direkten Manipulationen
 * m�glich.
 *
 */
public class Labyrinth {

	/*
	 * Das Labyrinth hat eine hoehe und breite.
	 * Es gibt die Positionen des eingangs und des ausgangs.
	 */
	public final int breite, hoehe;
	private boolean[][] labyrinth;
	private Position eingang, ausgang;

	
	/*
	 * Hier ist die implementierung des Labyrinths. Es wird beim 
	 * instanziieren erzeugt.
	 */
	public Labyrinth() {		
		this.breite = 10;
		this.hoehe = 10;
		//Groesse des Labyrinths
		this.setLabyrinth(new boolean[breite][hoehe]);
		//Eingang setzen
		this.setzeEingang(new Position(1, 9));
		//Ausgang setzen
		this.setzeAusgang(new Position(9, 4));
		//Von oben angefangen Waende setzen
		this.setzeWand(new Position(2, 2), new Position(7, 2));
		this.setzeWand(new Position(1, 4), new Position(4, 4));
		this.setzeWand(new Position(6, 5), new Position(8, 5));
		this.setzeWand(new Position(4, 7), new Position(7, 7));
		this.setzeWand(new Position(6, 3), new Position(6, 4));
		this.setzeWand(new Position(7, 3), new Position(7, 4));
		this.setzeWand(new Position(2, 6), new Position(2, 8));
		this.setzeWand(new Position(4, 5), new Position(4, 6));
	}//public Labyrinth()

	
	
	/*
	 * Getter f�r die Position des Eingangs
	 */
	public Position holeEingang() {
		return eingang;
	}//public Position holeEingang()

	
	
	/*
	 * Der Eingang kann getztzt werden 
	 */
	public void setzeEingang(Position position) {
		/*
		 * Der Eingang sollte sich am Rand befinden ansonsten gibt es einen Hinweis.
		 * Sch�ner mit Exceptions. Aber wohl nicht GDI konform.
		 */
		if (position.x != 0 && position.x != this.breite - 1
				&& position.y != 0 && position.y != this.hoehe - 1) {
			println("Der Eingang muss am Rand liegen!");
		}
		this.eingang = position;
	}//public void setzeEingang(Position position)
	
	
	
	/*
	 * Getter f�r die Position des Ausgangs
	 */
	public Position holeAusgang() {
		return ausgang;
	}//public Position holeAusgang()

	
	
	/*
	 * Der Ausgang kann auch gesetzt werden
	 */
	public void setzeAusgang(Position position) {
		/*
		 * Der Ausgang sollte sich am Rand befinden ansonsten gibt es einen Hinweis.
		 * Sch�ner mit Exceptions. Aber wohl nicht GDI konform.
		 */
		if (position.x != 0 && position.x != this.breite - 1 && position.y != 0
				&& position.y != this.hoehe - 1) {
			println("Der Ausgang muss am Rand liegen!");			
		}		
		this.ausgang = position;
	}//public void setzeAusgang(Position position)

	
	
	/*
	 * Die W�nde werden gesetzt im boolean Array.
	 * Verwendet von der Methode public void setzeWand(Position von, Position bis).
	 */
	public void setzeWand(Position position) {
		holeLabyrinth()[position.x][position.y] = true;
	}//public void setzeWand(Position position)

	
	
	/*
	 * Die W�nde werden gesetzt im boolean Array.
	 * Man kann auch neben einzelnen Wandteile auch komplette Reihen, vertikal bzw. horizontal setzen.
	 */
	public void setzeWand(Position von, Position bis) {
		if (von.equals(bis)) {//Einzelnes Wandst�ck
			setzeWand(bis);
		}
		else if (von.x == bis.x) {//Vertikale Wandst�cke
			for (int y = von.y; y <= bis.y; y++) {
				setzeWand(new Position(bis.x, y));
			}
		}
		else if (von.y == bis.y) {//Horizontale Wandst�ck
			for (int x = von.x; x <= bis.x; x++) {
				setzeWand(new Position(x, bis.y));
			}
		}	
	}//public void setzeWand(Position von, Position bis)
	

	
	/*
	 * Diese Methode pr�ft, ob man sich "auf" einer Wand befindet.
	 * Durch R�ckgabe des boolean arrays.
	 */
	public boolean pruefeAufWand(Position position) {
		if (position.equals(holeEingang()) || position.equals(holeAusgang())) {
			return false;
		}
		return holeLabyrinth()[position.x][position.y];
	}//public boolean pruefeAufWand(Position position)

	
	
	/*
	 * Getter f�r das Labyrinth
	 */
	public boolean[][] holeLabyrinth() {
		return labyrinth;
	}//public boolean[][] holeLabyrinth()

	
	
	/*
	 * Diese Methode wird baim Aufrufen des Konstruktors aufgerufen und setzt
	 * die W�nde.
	 */
	public void setLabyrinth(boolean[][] labyrinth) {	
		this.labyrinth = labyrinth;
		//Jedes Labyrinth hat am Rand eine Wand. Diese wird nun gesetzt.
		if (breite != 0 && hoehe != 0) {
			setzeWand(new Position(0, 0), new Position(breite - 1, 0));
			setzeWand(new Position(0, 0), new Position(0, hoehe - 1));
			setzeWand(new Position(breite - 1, 0), new Position(breite - 1, hoehe - 1));
			setzeWand(new Position(0, hoehe - 1), new Position(breite - 1, hoehe - 1));
		}		
	}//public void setLabyrinth(boolean[][] labyrinth)

	
	
	/*
	 * Ausgabe des Labyrinths als String. �berschrieben. 
	 * Siehe Methode public String toString(Position mark).
	 */
	@Override
	public String toString() {
		return this.toString(null);
	}//public String bisString()


	
	/*
	 * Das Labytinth soll auch ausgegeben werden k�nnen.
	 * Daher muss es auch die Positionen der Figur (S), Den EIngang E
	 * und ausgang A sowie die W�nde # ber�cksichtigen
	 */
	public String toString(Position mark) {
		//String builder der einfachheit halber. Mit GDI Mitteln aber auch zu l�sen durch zusammenbauen.
		StringBuilder builder = new StringBuilder();
		for (int y = 0; y < breite; y++) {
			if (builder.length() != 0) {
				builder.append('\n');
			}
			for (int x = 0; x < breite; x++) {
				Position position = new Position(x, y);
				if (position.equals(holeEingang())) {
					builder.append('E');
				}
				else if (position.equals(holeAusgang())) { 
					builder.append('X');
				}
				else if (position.equals(mark)) {
					builder.append('S');
				}
				else if (pruefeAufWand(position)) {
					builder.append('#');
				}
				else  {
					builder.append(' ');
				}
			}
		}
		return builder.toString();
	}//public String toString(Position mark)
	
	
	
}//public class Labyrinth
