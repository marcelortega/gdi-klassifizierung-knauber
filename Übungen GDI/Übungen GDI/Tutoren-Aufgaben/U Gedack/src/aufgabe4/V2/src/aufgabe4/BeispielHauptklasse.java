package aufgabe4;

public class BeispielHauptklasse {

	public static void main(String[] args) {
		
		EinfachesLabyrinth lab = new EinfachesLabyrinth(); //Labyrinth erzeugen
		lab.zeichneLabyrinth(); //Leeres Labyrinth vor dem Start ausgeben
		
		Spielfigur spieler = new Spielfigur(lab); //Spielfigur in erzeugtem Labyrinth setzen
		lab.zeichneLabyrinth(); //Labyrinth mit gesetzer Spielfigur ausgeben
		
		spieler.findeAusgang(); //Ausgang finden
		
	}
	
}
