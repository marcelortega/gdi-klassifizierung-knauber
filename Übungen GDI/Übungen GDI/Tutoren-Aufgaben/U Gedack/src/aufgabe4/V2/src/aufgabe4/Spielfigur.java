package aufgabe4;

import java.util.Random;

public class Spielfigur {
	
	/*
	 * Die Spielfigur muss immer eine Position haben, eine urspr�ngliche Startposition
	 * und auch ein Labyrinth zum spielen.
	 */
	private Position pos = null;
	private Position posBeiStart = null;
	private EinfachesLabyrinth l = null;
	
	
	
	/*
	 * Der Spielfigur wird ein Labyrinth �bergeben.
	 * Da die Spielfigur eine Position ben�tigt bekommt bekommt sie eine und wird
	 * zuf�llig plaziert.
	 */
	public Spielfigur(EinfachesLabyrinth l) {
		this.l = l;
		pos = new Position();
		posBeiStart = new Position();
		setzeSpielfigurZufaellig();
	}
	
	
	
	/**
	 * Die Spielfigur sollte mit Math.Random zuf�llig im Labyrinth positioniert werden.
	 */
	public void setzeSpielfigurZufaellig() {
		
		boolean spielfigurGesetzt = false;
		int zeile, spalte;
		
		do {
			String[][] lab = l.getLabyrinth(); // Hole das aktuelle Labyrinth
			zeile = new Random().nextInt(lab.length-1); //0 bis 31
			spalte = new Random().nextInt(lab.length-1); //0 bis 31
			
			//�berpr�fe ob die Position auch auf dem Weg und nicht auf dem Ausgang, Eingang oder auf der Wand ist
			if(lab[zeile][spalte] != "#" && lab[zeile][spalte] != "A" && lab[zeile][spalte] != "E") {
				lab[zeile][spalte] = "S";
				spielfigurGesetzt = true;
			}
			
		} while(!spielfigurGesetzt);
		
		//Wenn Position gefunden wurde muss sie gesetzt werden
		pos.setXPosition(spalte);
		pos.setYPosition(zeile);

		//Hier merken wir uns die urspr�ngliche Startposition, falls man in die falsche RIchtung l�uft
		posBeiStart.setXPosition(pos.getXPosition());
		posBeiStart.setYPosition(pos.getYPosition());	
		
	}
	
	
	
	/**
	 * Spielfigur soll auf dem in der Konsole angezeigten Labyrinth Links laufen k�nnen.
	 */
	public boolean laufeLinks() { 			//laufeInNegativerXrichtung
		
		String[][] lab = l.getLabyrinth(); 	// Hole das aktuelle Labyrinth
		int spalte = pos.getXPosition(); 
		int zeile = pos.getYPosition();

		//Pr�fe ob die Spielfigur eine Stelle nach Links laufen kann im Labyrinth
		if(lab[zeile][spalte-1] != "#" && lab[zeile][spalte-1] != "A" && lab[zeile][spalte-1] != "E") {
			int neueSpalte = spalte-1; 		//Der Weg ist frei
			lab[zeile][spalte] = "O"; 		//Alte Spielfigur von S nach s �ndern
			pos.setXPosition(neueSpalte); 	//Neue Pos setzen
			lab[zeile][neueSpalte] = "S"; 	//Setze neue Position in Labyrinth
			l.setLabyrinth(lab); 			//Labyrinth aktualisieren
			l.zeichneLabyrinth(); 
			return true;
		} else {
			return false;
		}
		
	}
	
	
	/**
	 * Spielfigur soll auf dem in der Konsole angezeigten Labyrinth Rechts laufen k�nnen.
	 */
	public boolean laufeRechts() { //laufeInPositiverXrichtung
		
		String[][] lab = l.getLabyrinth(); // Hole das aktuelle Labyrinth
		int spalte = pos.getXPosition(); 
		int zeile = pos.getYPosition();
		
		if(lab[zeile][spalte+1] != "#" && lab[zeile][spalte+1] != "A" && lab[zeile][spalte+1] != "E") {
			lab[zeile][spalte] = "O"; //Alte Spielfigur von S nach s �ndern
			pos.setXPosition(spalte+1); //Neue Pos setzen
			lab[zeile][pos.getXPosition()] = "S"; //Setze neue Position
			l.setLabyrinth(lab);
			l.zeichneLabyrinth();
			return true;
		} else {
			return false;
		}
		
	}
	
	
		
	/**
	 * Spielfigur soll auf dem in der Konsole angezeigten Labyrinth Aufw�rts laufen k�nnen.
	 */
	public boolean laufeAufwaerts() { //laufeInPositiverYrichtung
		
		String[][] lab = l.getLabyrinth(); // Hole das aktuelle Labyrinth
		int spalte = pos.getXPosition(); 
		int zeile = pos.getYPosition();
		
		if(lab[zeile-1][spalte] != "#" && lab[zeile-1][spalte] != "A" && lab[zeile-1][spalte] != "E") {
			lab[zeile][spalte] = "O"; //Alte Spielfigur von S nach s �ndern
			pos.setYPosition(zeile-1);  //Neue Pos setzen
			lab[pos.getYPosition()][spalte] = "S"; //Setze neue Position
			l.setLabyrinth(lab);
			l.zeichneLabyrinth();
			return true;
		} else {
			return false;
		}
		
	}
	
	
	/**
	 * Spielfigur soll auf dem in der Konsole angezeigten Labyrinth Abw�rts laufen k�nnen.
	 */
	public boolean laufeAbwaerts() { //laufeInNegativerYrichtung
		
		String[][] lab = l.getLabyrinth(); // Hole das aktuelle Labyrinth
		int spalte = pos.getXPosition(); 
		int zeile = pos.getYPosition();
		
		if(lab[zeile+1][spalte] != "#" && lab[zeile+1][spalte] != "A" && lab[zeile+1][spalte] != "E") {
			lab[zeile][spalte] = "O"; //Alte Spielfigur von S nach s �ndern
			pos.setYPosition(zeile+1); //Neue Pos setzen
			lab[pos.getYPosition()][spalte] = "S"; //Setze neue Position
			l.setLabyrinth(lab);
			l.zeichneLabyrinth();
			return true;
		} else {
			return false;
		}
		
	}
	
	
	
	/**
	 * Diese Methode enth�lt die Logik zum finden des Ausgangs.
	 * Beginnt die Suche des Ausgangs zuerst in die falsche Richtung, d.h. der
	 * Eingang wird zuerst gefunden, l�uft die Logik weiter, springt zur�ck zum 
	 * urspr�nglichen STartpunkt und findet 
	 * den Ausgang.
	 * Es wird immer solage wie M�glich in die Richtung gelaufen, in der sich keine Wand ("#")
	 * befinden und in der man noch nicht war ("O").
	 */
	public void findeAusgang() {
		
		boolean ausgangErreicht = false;
		int zeile, spalte;
		
		//Laufe solange der Ausgang A nicht erreicht wurde
		do {
			String[][] lab = l.getLabyrinth(); // Hole das aktuelle Labyrinth
			ausgangErreicht = checkObAusgangErreicht();
			
			boolean spielerLaeftInPositiverYrichtung = false;
			boolean spielerLaeftInNegativerYrichtung = false;
			boolean spielerLaeftInPositiverXrichtung = false;
			boolean spielerLaeftInNegativerXrichtung = false;
			
				/*
				 * Laufe so lange wie m�glich Rechts
				 */
				zeile = pos.getYPosition();
				spalte = pos.getXPosition();
				//Pr�fe ob rechts ein Hindernis ist, falls nicht laufe nach Rechts so weit wie m�glich. Nat�rlich nur in die Richtung, in die man noch nicht war.
				if(lab[zeile][spalte+1] != "#" && lab[zeile][spalte+1] != "O" && lab[zeile][spalte+1] != "A" && lab[zeile][spalte+1] != "E") {					
					do {
						spielerLaeftInPositiverXrichtung = laufeRechts();
						if(checkObAusgangErreicht()) {
							break;
						}						
					}while(spielerLaeftInPositiverXrichtung);
				} 
				
				/*
				 * Laufe so lange wie m�glich Links
				 */
				zeile = pos.getYPosition();
				spalte = pos.getXPosition();
				//Pr�fe ob links ein Hindernis ist, falls nicht laufe nach Links so weit wie m�glich. Nat�rlich nur in die Richtung, in die man noch nicht war.
				if(lab[zeile][spalte-1] != "#" && lab[zeile][spalte-1] != "O" && lab[zeile][spalte-1] != "A" && lab[zeile][spalte-1] != "E") {
					do {
						spielerLaeftInNegativerXrichtung = laufeLinks();
						if(checkObAusgangErreicht()) {
							break;
						}
					}while(spielerLaeftInNegativerXrichtung);
				} 
				
				/*
				 * Laufe so lange wie m�glich nach Oben
				 */
				zeile = pos.getYPosition();
				spalte = pos.getXPosition();
				//Pr�fe ob oben ein Hindernis ist, falls nicht laufe nach Oben so weit wie m�glich. Nat�rlich nur in die Richtung, in die man noch nicht war.
				if(lab[zeile-1][spalte] != "#" && lab[zeile-1][spalte] != "O" && lab[zeile-1][spalte] != "A" && lab[zeile-1][spalte] != "E") {
					do {
						spielerLaeftInPositiverYrichtung = laufeAufwaerts();
						if(checkObAusgangErreicht()) {
							break;
						}						
					}while(spielerLaeftInPositiverYrichtung);
				} 
				
				/*
				 * Laufe so lange wie m�glich nach Unten
				 */
				zeile = pos.getYPosition();
				spalte = pos.getXPosition();
				//Pr�fe ob unten ein Hindernis ist, falls nicht laufe nach unten so weit wie m�glich. Nat�rlich nur in die Richtung, in die man noch nicht war.
				if(lab[zeile+1][spalte] != "#" && lab[zeile+1][spalte] != "O" && lab[zeile+1][spalte] != "A" && lab[zeile+1][spalte] != "E") {
					do {
						spielerLaeftInNegativerYrichtung = laufeAbwaerts();
						if(checkObAusgangErreicht()) {
							break;
						}						
					}while(spielerLaeftInNegativerYrichtung);
				}
				
				
				
				
				/*
				 * Wenn man in die falsche Richtung gelaufen ist, kommt man am Eingang an.
				 * Dann sollte man den Weg zur�cklaufen (am einfachsten durch Springen an den
				 * urspr�nglichen Spielstart) und in die andere, m�gliche Richtung laufen.
				 */
				zeile = pos.getYPosition();
				spalte = pos.getXPosition();
				//Pr�fe ob man sich am Eingang befindet
				if(lab[zeile][spalte+1] == "E" || lab[zeile][spalte-1] == "E" || lab[zeile-1][spalte] == "E" || lab[zeile+1][spalte] == "E") {	

					/*
					 * Springe zur�ck zu urspr�nglicher Startposition
					 */
			    	lab[zeile][spalte] = "O"; //Markiere als gelesen wen es nicht weitergeht
			    	pos.setXPosition(posBeiStart.getXPosition()); //Wieder zur alten startposition zur�ckkehren
			    	pos.setYPosition(posBeiStart.getYPosition()); //Wieder zur alten startposition zur�ckkehren
			    	zeile = pos.getYPosition();
					spalte = pos.getXPosition();
			    	lab[zeile][spalte] = "S"; 

					/*
					 * Laufe so lange wie m�glich Rechts
					 */
					//Pr�fe ob rechts ein Hindernis ist, falls nicht laufe nach rechts so weit wie m�glich. Nat�rlich nur in die Richtung, in die man noch nicht war.
					if(lab[zeile][spalte+1] != "#" && lab[zeile][spalte+1] != "O" && lab[zeile][spalte+1] != "A" && lab[zeile][spalte+1] != "E") {					
						do {
							spielerLaeftInPositiverXrichtung = laufeRechts();
							if(checkObAusgangErreicht()) {
								break;
							}						
						}while(spielerLaeftInPositiverXrichtung);
					}
					
					/*
					 * Laufe so lange wie m�glich Links
					 */
					zeile = pos.getYPosition();
					spalte = pos.getXPosition();
					//Pr�fe ob links ein Hindernis ist, falls nicht laufe Links unten so weit wie m�glich. Nat�rlich nur in die Richtung, in die man noch nicht war.
					if(lab[zeile][spalte-1] != "#" && lab[zeile][spalte-1] != "O" && lab[zeile][spalte-1] != "A" && lab[zeile][spalte-1] != "E") {
						do {
							spielerLaeftInNegativerXrichtung = laufeLinks();
							if(checkObAusgangErreicht()) {
								break;
							}
						}while(spielerLaeftInNegativerXrichtung);
					}
					
					/*
					 * Laufe so lange wie m�glich nach Unten
					 */
					zeile = pos.getYPosition();
					spalte = pos.getXPosition();
					//Pr�fe ob unten ein Hindernis ist, falls nicht laufe nach unten so weit wie m�glich. Nat�rlich nur in die Richtung, in die man noch nicht war.
					if(lab[zeile+1][spalte] != "#" && lab[zeile+1][spalte] != "O" && lab[zeile+1][spalte] != "A" && lab[zeile+1][spalte] != "E") {
						do {
							spielerLaeftInNegativerYrichtung = laufeAbwaerts();
							if(checkObAusgangErreicht()) {
								break;
							}						
						}while(spielerLaeftInNegativerYrichtung);
					}
					
					/*
					 * Laufe so lange wie m�glich nach Oben
					 */
					zeile = pos.getYPosition();
					spalte = pos.getXPosition();
					//Pr�fe ob oben ein Hindernis ist, falls nicht laufe nach Oben so weit wie m�glich. Nat�rlich nur in die Richtung, in die man noch nicht war.
					if(lab[zeile-1][spalte] != "#" && lab[zeile-1][spalte] != "O" && lab[zeile-1][spalte] != "A" && lab[zeile-1][spalte] != "E") {
						do {
							spielerLaeftInPositiverYrichtung = laufeAufwaerts();
							if(checkObAusgangErreicht()) {
								break;
							}						
						}while(spielerLaeftInPositiverYrichtung);
					}
					
					
				}//Pr�fe ob man sich am Eingang befindet, falls ja wechsle die Position und laufe in die andere Richtung.
				
				ausgangErreicht = checkObAusgangErreicht();			
		}while(!ausgangErreicht);
		
	}

	
	
	/**
	 * Diese Hilfs-Methode prueft, ob der Ausgang erreicht wurde.
	 */
	private boolean checkObAusgangErreicht() {
		
		String[][] lab = l.getLabyrinth(); // Hole das aktuelle Labyrinth
		int spalte = pos.getXPosition(); 
		int zeile = pos.getYPosition();
		
		if(lab[zeile][spalte-1] == "A") { //Ist links der Ausgang?
			return true;
		} else if(lab[zeile][spalte+1] == "A") { //Ist rechts der Ausgang?
			return true;
		} else if(lab[zeile-1][spalte] == "A") { //Ist oben der Ausgang?
			return true;
		} else if(lab[zeile+1][spalte] == "A") { //Ist unten der Ausgang?
			return true;			
		} else { //Oder nirgends der Ausgang?
			return false;
		}
		
	}
	
	
	
}
