package hauptklassen;
/**
 * Klasse ist dafür zuständig das spiel zu starten 
 * und am laufen zu halten.
 *
 */

public class {
	static Race[] opponents = new Race[3];
	static int currentChar;
	static boolean fight = true;
	

	public static void main(String[] args) {
		String file = "pfad zur txt Datei";
	}

	/**
	 * Methode lässt den Player mit seinem Gegner kämpfen
	 * 
	 * @param a
	 *            Player
	 * @param b
	 *            Gegner
	 * @return Boolean darüber ob der kampf zu ende ist oder nicht
	 */
	public static boolean fight(Race a, Race b) {

	}

	/**
	 * Methode schreibt für den Kampf wichtige Werte des Chars in eine Datei
	 */
	public static void saveCharToFile(Race player) {

	}

	/**
	 * Methode ist dafür zuständig die Werte eines chars aus einer txt datei zu
	 * lesen und damit einen neuen char zu erstellen
	 * 
	 * @return
	 */
	public static Race loadOpponent() {

	}

	/**
	 * Methode erstellt standard NPC Gegner
	 * 
	 * @return ein Array mit 3 Gegnern
	 */
	public static Race[] loadOpponent() {

	}

	/**
	 * Methode ist dafür zuständig das Menue auf der Konsole auszugeben und das
	 * Spiel am laufen zu halten.
	 * 
	 * @param player
	 */
	public static void menue(Race player) {

	}

	/**
	 * Methode ist dafür zuständig, den Player gegen eine NPC kämpfen zu lassen
	 * 
	 * @param player
	 *            Der spieler
	 *@param character
	 *				Der aktuell ausgewählte char
	 */
	private static void fightNPC(Race character, Player p) {
	}

	/**
	 * Methode ist dafür zuständig den Player gegen andere Spieler kämpfen zu
	 * lassen
	 * 
	 * @param player
	 *            Spieler
 	 * @param character
	 *				Der aktuell ausgewählte char
	 */
	private static void fightPlayer(Race character, Player p) {

	}

}