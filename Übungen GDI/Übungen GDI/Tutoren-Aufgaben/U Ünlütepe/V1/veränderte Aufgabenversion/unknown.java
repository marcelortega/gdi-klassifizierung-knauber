package hauptklassen;
/**
 * Diese Klasse stellt den Player dar. In dieser Klasse werden die verschiedenen
 * Chars des Spieler verwaltet und auch das Gold des Spielers.
 * 
 * @author mehmet
 * 
 */
public class {
	/**
	 * Der Spieler kann bis zu 5 verschiedene Characktere haben
	 */
	chars = new [5];
	int currentChar; // variable für den aktuellen Character

	/**
	 * Konstruktor der für die Kriierung des ersten Chars zuständig ist.
	 */
	Player() {
		createChar();
	}

	/**
	 * Methode erstellt einen Charakter, in dem man die Rasse und den Namen wählt.
	 * Aber nur solange man noch freie Charakterslots hat
	 */
	public void createChar() {

		
	}

	/**
	 * Methode ist dafür zuständig einen freien Character Slot zu finden
	 * und zurückzugeben
	 * @return freier Charslot oder -1 falls kein freier Slot mehr verfügbar ist
	 */
	public int getFreeSlot() {
		
	}

	/**
	 * Methode gibt alle erstellten chars zurück
	 * @return anzahl an chars
	 */
	public int getChars() {
		
	}

	/**
	 * Getter fpr den aktuellen char
	 * @return Aktueller char
	 */
	public int getCurrentChar() {
		return currentChar;
	}
	
	/**
	 * Setter für den Aktuellen Char
	 * @param current auszuwählender Char
	 */
	public void setCurrentChar(int current) {
		this.currentChar = current;
	}

	/**
	 * Methode gibt einen Char zurück
	 * @param charIndex auszuwählender Char
	 * @return ausgewählter char
	 */
	public Race getChar(int charIndex) {
	}

	/**
	 * Methode um den Char zu wechseln
	 */
	public void changeChar() {
										//Alle verfügbaren chars werden ausgegeben
		
		}
		//der Auszuwählende Char wird gewählt
}
