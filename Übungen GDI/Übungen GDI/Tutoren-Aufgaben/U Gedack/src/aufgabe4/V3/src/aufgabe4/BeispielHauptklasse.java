package aufgabe4;

import static gdi.MakeItSimple.*;

/**
 * BeispielHauptklasse.
 * Kann prinzipiell auch anders aussehen, z.B. Ausgaben enthalten etc. je nach Implementierung.
 */
public class BeispielHauptklasse {
	
	
	public static void main(String[] args) {

		println("Spielstart.\n\n");
		
		/*
		 * Erzeugen eines Labyrinths.
		 * Wie das Labyrinth aussieht und wie die Daten gehalten werden ist
		 * nur in der Klasse Labyrinth festgelegt und somit vor dem "Benutzer" Game verborgen. Kein lästiges 
		 * Array hin und her schaufeln mehr. 
		 */
		println("Das Labyrinth wird erzeugt ...");
		Labyrinth labyrinth = new Labyrinth();
		
		
		/*
		 * Komplettes Labyrinth ausgeben.
		 * Das Labyrinth kann einfach ausgegeben werden, da die Methode toString() überschrieben wurde um das
		 * mit einem String Builder zusammen gebaute Labyrinth auszugeben.
		 */
		println(labyrinth.toString());
		println("... das Labyrinth wurde erzeugt.");
		
		
		/*
		 * Spieler erzeugen.
		 * Eine Spielfigur wird erzeugt. Diese kann laufen, den Ausgang finden, eine Position zurückgeben etc. 
		 */
		println("Die Spielfigur wird erzeugt ...");
		Spielfigur spieler = new Spielfigur();
		println("... die Spielfigur wurde erzeugt.");
		
		/*
		 * Spieler Position ist am Eingang.
		 * Bei Spielstart ist die Figur am Eingang zu positionieren.
		 */		
		println("Das Labyrinth wird betreten ...");
		/*
		 * Das Labyrinth wird übergeben und ein boolean welche regelt ob die Position
		 * beim Start zufällig gewählt wird oder man am Eingang startet.
		 */
		spieler.betreteLabyrinth(labyrinth, true); 
		println("... das Labyrinth wurde betreten.");
		
		println("Der Ausgang wird gesucht ...");
		spieler.findeAusgang();
		println("... der Ausgang wurde gesucht und gefunden.");
		
		println("\n\nSpielende.");
	   		
	}//public static void main(String[] args)
	
	
}//public class BeispielHauptklasse