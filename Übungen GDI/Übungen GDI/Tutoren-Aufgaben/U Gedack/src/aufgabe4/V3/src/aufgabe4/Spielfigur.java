package aufgabe4;

import static gdi.MakeItSimple.*;

/**
 * Diese Klasse repr�sentiert die Spielfigur im Labyrinth.
 */
public class Spielfigur {
	
	
	/*
	 * Labyrinth und Position f�r dem Spieler.
	 */
	private Labyrinth labyrinth;
	private Position position;

	
	
	/*
	 * Diese Methode betritt quasi das Labyrinth.
	 * Wie in der letzten Version kann der Spieler zuf�llig Positioniert werden.
	 * @param labyrinth, random
	 */
	public void betreteLabyrinth(Labyrinth labyrinth, boolean random) {
		this.labyrinth = labyrinth;
		if(!random) { //Wenn Spieler nicht zuf�llig positiniert werden soll startet er am Eingang
			if (labyrinth != null) {
				springeZuPosition(labyrinth.holeEingang());
			}
		} else { //Zuf�llige Positionierung
			if (labyrinth != null) {
				int x, y;
				do {
					x = (int)(Math.random()*((10-1) + 1));
					y = (int)(Math.random()*((10-1) + 1));
				} while (!((x>=0 && x<10) && (y>=0 && y<10)));
				springeZuPosition(new Position(x, y));
			}
		}
	}//public void enterLabyrinth(Labyrinth labyrinth)

	
	
	/*
	 * Getter f�r die Position
	 */
	public Position getPosition() {	
		return position;	
	}//public Position getPosition() 

	
	
	/*
	 * Der Spieler soll zu einer Position springen k�nnen
	 */
	public void springeZuPosition(Position position) {
		this.position = position;
	}//public void springeZuPosition(Position position)

	
	
	/*
	 * Der Spieler muss in eine Richtugn laufen k�nnen. 
	 * Man h�tte sch�nerweise eine enum �bergeben k�nnen aber das ist nicht GDI konform.
	 * @param richtung
	 */
	public boolean laufe(char richtung) {
		if(position.equals(labyrinth.holeAusgang()) || position.equals(labyrinth.holeEingang())) { //Ausgang oder Eingang erreicht?
			return false;
		} else { //Ausgang noch nicht erreicht
			Position position = new Position(this.position);
			switch (richtung) {
				case 'o': //'o' = OBEN
					if(position.y>0) {
						position.y--;
					}
					break;
				case 'r': //'r' = RECHTS
					if(position.x<labyrinth.breite-1) {
						position.x++;
					}
					break;
				case 'u': //'u' = UNTEN
					if(position.y<labyrinth.hoehe-1) {
						position.y++;
					}
					break;
				case 'l': //'l' = LINKS
					if(position.x>0) {
						position.x--;
					}
					break;
			}	
			if (labyrinth.pruefeAufWand(position)) { //lauft man in eine Wand?
				return false;
			} else { //Falls man laufen kann gehe zur neuen Position
				springeZuPosition(position);
				return true;
			}
		}		
	}//public boolean laufe(richtung richtung)

	
	
	/*
	 * Man muss �berpr�fen k�nnen ob man sich am Ausgang befindet.
	 * In dieser Version hei�t "am" Ausgang quasi auf dem Ausgang.
	 * Im Vergleich zur letzten Version wo man sich "neben" dem
	 * Ausgang befinden musste. Es ist sch�ner, wenn der Spieler
	 * das Labyrinth komplett betreten und verlassen kann.
	 */
	protected boolean checkObAusgang() {
		//Entspricht die aktuelle Position der Position des Ausgangs?
		return position.equals(labyrinth.holeAusgang());
	}//protected boolean checkObAusgang()

	
	
	/*
	 * Das Herzst�ck ;-)
	 * Der Ausgang soll gefunden werden. Der Algorithmus ist auf das einfache Labyrinth
	 * was eigentlich nur ein Weg ist zugeschnitten. Eine generelle L�sung um 
	 * Labyrinthe der Gr��e n x m am besten mit Rundwegen zu l�sen �bersteigt GDI etwas ;-)
	 */
	public void findeAusgang() {
		String letzteRichtung = null; //Man merke sich die Richtung aus der man gekommen ist
		/*
		 * Der "Algorithmus" ist ziehmlich einfach, aufgrund des gegebenen "Labyrinths" besser gesagt
		 * "Weg" und funktioniert nicht mit jedem "Labyrinth". Normale Wege sollten funktionieren.
		 */
		do {
			if (letzteRichtung != "UNTEN") { // kommt man nicht von UNTEN
				while (laufe('o')) { // 'o' = OBEN
					letzteRichtung = "OBEN"; // setze lettze Richtung
					println("\n" + labyrinth.toString(position)
							+ "\n" + "Position: " + position + "\n"
							+ "Ausgang erreicht: "
							+ position.equals(labyrinth.holeAusgang()) + "\n"
							+ "Eingang erreicht: "
							+ position.equals(labyrinth.holeEingang()));
				}
			}
			if (letzteRichtung != "LINKS") { // kommt man nicht von LINKS
				while (laufe('r')) { // 'r' = RECHTS
					letzteRichtung = "RECHTS"; // setze lettze Richtung
					println("\n" + labyrinth.toString(position)
							+ "\n" + "Position: " + position + "\n"
							+ "Ausgang erreicht: "
							+ position.equals(labyrinth.holeAusgang()) + "\n"
							+ "Eingang erreicht: "
							+ position.equals(labyrinth.holeEingang()));
				}
			}
			if (letzteRichtung != "OBEN") { // kommt man nicht von OBEN
				while (laufe('u')) { // 'u' = UNTEN
					letzteRichtung = "UNTEN"; // setze lettze Richtung
					println("\n" + labyrinth.toString(position)
							+ "\n" + "Position: " + position + "\n"
							+ "Ausgang erreicht: "
							+ position.equals(labyrinth.holeAusgang()) + "\n"
							+ "Eingang erreicht: "
							+ position.equals(labyrinth.holeEingang()));
				}
			}
			if (letzteRichtung != "RECHTS") { // kommt man nicht von RECHTS
				while (laufe('l')) { // 'l' = LINKS
					letzteRichtung = "LINKS"; // setze lettze Richtung
					println("\n" + labyrinth.toString(position)
							+ "\n" + "Position: " + position + "\n"
							+ "Ausgang erreicht: "
							+ position.equals(labyrinth.holeAusgang()) + "\n"
							+ "Eingang erreicht: "
							+ position.equals(labyrinth.holeEingang()));
				}
			}

			/*
			 * Kommt man am Eingang an, muss man umdrehen und in die Andre
			 * Richtung laufen. Daf�r wird die SPielfigur wieder vor dem Eingang
			 * platziert und l�uft dann in die andere Richtung.
			 */
			if (position.equals(labyrinth.holeEingang())) {
				letzteRichtung = ""; //letzte Richtung zur�cksetzen
				springeZuPosition(new Position(labyrinth.holeEingang().x, (labyrinth.holeEingang().y) - 1));
				println("\n" + labyrinth.toString(position) + "\n"
						+ "Position: " + position + "\n" + "Ausgang erreicht: "
						+ position.equals(labyrinth.holeAusgang()) + "\n"
						+ "Eingang erreicht: "
						+ position.equals(labyrinth.holeEingang()));
			}
		} while (!position.equals(labyrinth.holeAusgang()));//Solange man nicht am Ausgang ist, sollte man ihn suchen
	}//public boolean findeAusgang()
	
		
}//public class Spielfigur
