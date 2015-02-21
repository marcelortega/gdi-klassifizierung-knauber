package aufgabe4;

import static gdi.MakeItSimple.print;
import static gdi.MakeItSimple.println;

public class EinfachesLabyrinth {
	
	
	/*
	 * Das in der †bung vorgegebene Labyrinth (Siehe Aufgabenblatt)
	 */
	private String[][] labyrinth = {	
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
	
	
	
	
	/**
	 * Ausgabe des Labyrinths auf der Konsole
	 */
	public void zeichneLabyrinth() {
		for(int i = 0; i < labyrinth.length; ++i)
	    {	
			//print( "Zeile" + i + " ");
			for (int j = 0; j < labyrinth.length; j++)
	      {
	        print(labyrinth[i][j]); //Reihe zeichnen
	      }
	      println(); //Zeilenumbruch
	    }
		println(); //Leere Zeile zwischen den ausgegebenen Labyrinths
	}
	
	
	/**
	 * Getter fŸr das Labyrinth
	 */
	public String[][] getLabyrinth() {
		return this.labyrinth;
	}
	
	
	/**
	 * Labyrinth verŠndern, wenn Spielfigur gesetzt wurde
	 */
	public void setLabyrinth(String[][] labyrinth) {
		 this.labyrinth = labyrinth;
	}
	
	
}//public class Labyrinth