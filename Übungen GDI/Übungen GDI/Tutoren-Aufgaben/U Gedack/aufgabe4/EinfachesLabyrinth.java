package aufgabe4;

import java.util.Random;
import static gdi.MakeItSimple.*;

public class EinfachesLabyrinth {

	static int[] position;
	static int[] rememberStartPosition;
	//10x10 Labyrinth
	static String[][] labyrinth = {	
		{"#","#","#","#","#","#","#","#","#","#"},
		{"#"," "," "," "," "," "," "," "," ","#"},
		{"#"," ","#","#","#","#","#","#"," ","#"},
		{"#"," "," "," "," "," ","#","#"," ","#"},
		{"#","#","#","#","#"," ","#","#"," ","A"},
		{"#"," "," "," ","#"," ","#","#","#","#"},
		{"#"," ","#"," ","#"," "," "," "," ","#"},
		{"#"," ","#"," ","#","#","#","#"," ","#"},
		{"#"," ","#"," "," "," "," "," "," ","#"},
		{"#","E","#","#","#","#","#","#","#","#"},
	};
	
	
	public static void main(String[] args) {
		
		zeichneLabyrinth(labyrinth); //Leeres Labyrinth zeichnen
		position = setzeSpielfigurZufaellig(labyrinth); //ZufŠllig Figur setzten
		rememberStartPosition = position.clone();
		zeichneLabyrinth(labyrinth); //Labyrinth mit Spielfigur in startPosition zeichnen
		findeAusgang();
	
	}
	
	
	/**
	 * Diese Methode enthält die Logik zum finden des Ausgangs.
	 * Beginnt die Suche des Ausgangs zuerst in die falsche Richtung, d.h. der
	 * Eingang wird zuerst gefunden, läuft die Logik weiter, dreht um und findet 
	 * des Ausgang.
	 */
	public static void findeAusgang() {
		boolean ausgangErreicht = false;
		do {
			ausgangErreicht = checkObAusgangErreicht();
			
			boolean spielerLaeftInPositiverYrichtung = false;
			boolean spielerLaeftInNegativerYrichtung = false;
			boolean spielerLaeftInPositiverXrichtung = false;
			boolean spielerLaeftInNegativerXrichtung = false;
			
			
				if(labyrinth[position[0]][position[1]+1] != "#" && labyrinth[position[0]][position[1]+1] != "O" && labyrinth[position[0]][position[1]+1] != "A" && labyrinth[position[0]][position[1]+1] != "E") {					
					do {
						spielerLaeftInPositiverXrichtung = laufeRechts(position, labyrinth);
						//
						if(checkObAusgangErreicht()) {
							break;
						}						
					}while(spielerLaeftInPositiverXrichtung);
				} 
				if(labyrinth[position[0]][position[1]-1] != "#" && labyrinth[position[0]][position[1]-1] != "O" && labyrinth[position[0]][position[1]-1] != "A" && labyrinth[position[0]][position[1]-1] != "E") {
					do {
						spielerLaeftInNegativerXrichtung = laufeLinks(position, labyrinth);
						//zeichneLabyrinth(labyrinth);
						if(checkObAusgangErreicht()) {
							break;
						}
					}while(spielerLaeftInNegativerXrichtung);
				} 
				if(labyrinth[position[0]-1][position[1]] != "#" && labyrinth[position[0]-1][position[1]] != "O" && labyrinth[position[0]-1][position[1]] != "A" && labyrinth[position[0]-1][position[1]] != "E") {
					do {
						spielerLaeftInPositiverYrichtung = laufeAufwaerts(position, labyrinth);
						//zeichneLabyrinth(labyrinth);
						if(checkObAusgangErreicht()) {
							break;
						}						
					}while(spielerLaeftInPositiverYrichtung);
				} 
				if(labyrinth[position[0]+1][position[1]] != "#" && labyrinth[position[0]+1][position[1]] != "O" && labyrinth[position[0]+1][position[1]] != "A" && labyrinth[position[0]+1][position[1]] != "E") {
					do {
						spielerLaeftInNegativerYrichtung = laufeAbwaerts(position, labyrinth);
						//zeichneLabyrinth(labyrinth);
						if(checkObAusgangErreicht()) {
							break;
						}						
					}while(spielerLaeftInNegativerYrichtung);
				}
				
				if(labyrinth[position[0]][position[1]+1] == "E" ||
				   labyrinth[position[0]][position[1]-1] == "E" ||
				   labyrinth[position[0]-1][position[1]] == "E" ||
				   labyrinth[position[0]+1][position[1]] == "E") {	

				   labyrinth[position[0]][position[1]] = "O"; //Markiere als gelesen wen es nicht weitergeht
				   position[0]=rememberStartPosition[0];
				   position[1]=rememberStartPosition[1];
				   labyrinth[rememberStartPosition[0]][rememberStartPosition[1]] = "S"; 
					//zeichneLabyrinth(labyrinth);

					if(labyrinth[position[0]][position[1]+1] != "#" && labyrinth[position[0]][position[1]+1] != "O" && labyrinth[position[0]][position[1]+1] != "A" && labyrinth[position[0]][position[1]+1] != "E") {					
						do {
							spielerLaeftInPositiverXrichtung = laufeRechts(position, labyrinth);
							//zeichneLabyrinth(labyrinth);
							if(checkObAusgangErreicht()) {
								break;
							}						
						}while(spielerLaeftInPositiverXrichtung);
					} 
					if(labyrinth[position[0]][position[1]-1] != "#" && labyrinth[position[0]][position[1]-1] != "O" && labyrinth[position[0]][position[1]-1] != "A" && labyrinth[position[0]][position[1]-1] != "E") {
						do {
							spielerLaeftInNegativerXrichtung = laufeLinks(position, labyrinth);
							//zeichneLabyrinth(labyrinth);
							if(checkObAusgangErreicht()) {
								break;
							}
						}while(spielerLaeftInNegativerXrichtung);
					} 
					if(labyrinth[position[0]+1][position[1]] != "#" && labyrinth[position[0]+1][position[1]] != "O" && labyrinth[position[0]+1][position[1]] != "A" && labyrinth[position[0]+1][position[1]] != "E") {
						do {
							spielerLaeftInNegativerYrichtung = laufeAbwaerts(position, labyrinth);
							//zeichneLabyrinth(labyrinth);
							if(checkObAusgangErreicht()) {
								break;
							}						
						}while(spielerLaeftInNegativerYrichtung);
					}
					if(labyrinth[position[0]-1][position[1]] != "#" && labyrinth[position[0]-1][position[1]] != "O" && labyrinth[position[0]-1][position[1]] != "A" && labyrinth[position[0]-1][position[1]] != "E") {
						do {
							spielerLaeftInPositiverYrichtung = laufeAufwaerts(position, labyrinth);
							//zeichneLabyrinth(labyrinth);
							if(checkObAusgangErreicht()) {
								break;
							}						
						}while(spielerLaeftInPositiverYrichtung);
					}
					
				}
				ausgangErreicht = checkObAusgangErreicht();			
		}while(!ausgangErreicht);
		
	}

	
	/**
	 * Diese Hilfs-Methode prüft, ob der Ausgang erreicht wurde.
	 */
	public static boolean checkObAusgangErreicht() {
		if(labyrinth[position[0]][position[1]-1] == "A") {
			return true;
		} else if(labyrinth[position[0]][position[1]+1] == "A") {
			return true;
		} else if(labyrinth[position[0]-1][position[1]] == "A") {
			return true;
		} else if(labyrinth[position[0]+1][position[1]] == "A") {
			return true;			
		} else {
			return false;
		}
	}
	
	
	/**
	 * Spielfigur soll auf dem in der Konsole angezeigten Labyrinth Links laufen können.
	 */
	public static boolean laufeLinks(int[] position, String[][] labyrinth) { //laufeInNegativerXrichtung
		if(labyrinth[position[0]][position[1]-1] != "#" && labyrinth[position[0]][position[1]-1] != "A" && labyrinth[position[0]][position[1]-1] != "E") {
			labyrinth[position[0]][position[1]] = "O"; //Alte Spielfigur von S nach s Šndern
			position[1] = position[1]-1; //Neue Pos setzen
			labyrinth[position[0]][position[1]] = "S"; //Setze neue Position
			
			//zeichneLabyrinth(labyrinth);
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * Spielfigur soll auf dem in der Konsole angezeigten Labyrinth Rechts laufen können.
	 */
	public static boolean laufeRechts(int[] position, String[][] labyrinth) { //laufeInPositiverXrichtung
		if(labyrinth[position[0]][position[1]+1] != "#" && labyrinth[position[0]][position[1]+1] != "A" && labyrinth[position[0]][position[1]+1] != "E") {
			labyrinth[position[0]][position[1]] = "O"; //Alte Spielfigur von S nach s Šndern
			position[1] = position[1]+1; //Neue Pos setzen
			labyrinth[position[0]][position[1]] = "S"; //Setze neue Position
			
			//zeichneLabyrinth(labyrinth);
			return true;
		} else {
			return false;
		}
	}
	
		
	/**
	 * Spielfigur soll auf dem in der Konsole angezeigten Labyrinth Aufwärts laufen können.
	 */
	public static boolean laufeAufwaerts(int[] position, String[][] labyrinth) { //laufeInPositiverYrichtung
		if(labyrinth[position[0]-1][position[1]] != "#" && labyrinth[position[0]-1][position[1]] != "A" && labyrinth[position[0]-1][position[1]] != "E") {
			labyrinth[position[0]][position[1]] = "O"; //Alte Spielfigur von S nach s Šndern
			position[0] = position[0]-1; //Neue Pos setzen
			labyrinth[position[0]][position[1]] = "S"; //Setze neue Position
			
			//zeichneLabyrinth(labyrinth);
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * Spielfigur soll auf dem in der Konsole angezeigten Labyrinth Abwärts laufen können.
	 */
	public static boolean laufeAbwaerts(int[] position, String[][] labyrinth) { //laufeInNegativerYrichtung
		if(labyrinth[position[0]+1][position[1]] != "#" && labyrinth[position[0]+1][position[1]] != "A" && labyrinth[position[0]+1][position[1]] != "E") {
			labyrinth[position[0]][position[1]] = "O"; //Alte Spielfigur von S nach s Šndern
			position[0] = position[0]+1; //Neue Pos setzen
			labyrinth[position[0]][position[1]] = "S"; //Setze neue Position
			
			//zeichneLabyrinth(labyrinth);
			return true;
		} else {
			return false;
		}
	}

	
	/**
	 * Die Spielfigur sollte mit Math.Random zufällig im Labyrinth positioniert werden.
	 */
	public static int[] setzeSpielfigurZufaellig(String[][] labyrinth) {
		boolean spielfigurGesetzt = false;
		int zeile, spalte;
		do {
			zeile = new Random().nextInt(labyrinth.length-1); //0 bis 31
			spalte = new Random().nextInt(labyrinth.length-1); //0 bis 31
			
			if(labyrinth[spalte][zeile] != "#" && labyrinth[spalte][zeile] != "A" && labyrinth[spalte][zeile] != "E") {
				labyrinth[spalte][zeile] = "S";
				spielfigurGesetzt = true;
			}
		} while(!spielfigurGesetzt);
		
		int position[] = {spalte, zeile};
		return position;
	}
	
	
	/**
	 * Ausgabe des Labyrinths
	 */
	public static void zeichneLabyrinth(String[][] labyrinth) {
		for ( int i = 0; i < labyrinth.length; ++i )
	    {	
	      for ( int j = 0; j < labyrinth.length; j++ )
	      {
	        print(labyrinth[i][j] );//Reihe zeichnen
	      }
	      println();//Neue Zeile
	    }
		println();
	}

	

}
