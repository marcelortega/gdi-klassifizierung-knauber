package hauptklassen;

import static gdi.MakeItSimple.*;
import character.Elf;
import character.Human;
import character.Orc;

/**
 * Diese Klasse stellt den Player dar. In dieser Klasse werden die verschiedenen
 * Chars des Spieler verwaltet und auch das Gold des Spielers.
 * 
 * @author mehmet
 * 
 */
public class Player {
	/**
	 * Der Spieler kann bis zu 5 verschiedene Characktere haben
	 */
	Race[] chars = new Race[5];
	int currentChar; // variable für den aktuellen Character

	/**
	 * Konstruktor der für die Kriierung des ersten Chars zuständig ist.
	 */
	Player() {
		createChar();
	}

	/**
	 * Methode erstellt einen Charakter, in dem man die Rasse und den Namen wählt.
	 */
	public void createChar() {

		int selection; // variable für dei gewählte Rasse
		String name; // Name des neuen Chars
		
		// Überprüfung ob es noch freie plätze gibt und man einen Char erstellen
		// kann
		if ((currentChar = getFreeSlot()) != -1) {

			// Wahl der Rasse
			println("Plese selcet your Race: ");
			println("1. Human\n2.Elf\n3.Orc");
			selection = readInt();
			readLine();

			// Wahl des Namens
			println("Please choose a name: ");
			name = readLine();

			// Erstellung des neune chars anhand der eben getroffenen Auswahl
			switch (selection) {

			// Erstellung eines Menschen
				case 1: {
					this.chars[currentChar] = (Human) new Human(name);
				break;
				}

			// erstellung eines Elfen
				case 2: {
					this.chars[currentChar] = (Elf) new Elf(name);
				break;
				}

			// Erstellung eines Orks
				case 3: {
					this.chars[currentChar] = (Orc) new Orc(name);
				break;
				}
			}
			//Maximal mögliche chars erstellt
		} else {
			println("You cannot create anymore chars!");
		}
	}

	/**
	 * Methode ist dafür zuständig einen freien Character Slot zu finden
	 * und zurückzugeben
	 * @return freier Charslot oder -1 falls kein freier Slot mehr verfügbar ist
	 */
	public int getFreeSlot() {
		int freeslot = -1;
		for (int i = 0; i < this.chars.length; i++) {
			if (chars[i] == null)
				return freeslot = i;
		}
		return freeslot;
	}

	/**
	 * Methode gibt alle erstellten chars zurück
	 * @return anzahl an chars
	 */
	public int getChars() {
		int chars = 0;
		for (int i = 0; i < this.chars.length; i++) {
			if (this.chars[i] != null)
				chars++;
		}
		return chars;
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
		return this.chars[charIndex];
	}

	/**
	 * Methode um den Char zu wechseln
	 */
	public void changeChar() {
		println("Your available characters: ");			//Alle verfügbaren chars werden ausgegeben
		for (int i = 0; i < this.chars.length; i++) {
			if (this.chars[i] != null) {
				println(i + 1 + "." + this.chars[i].getName());
			}
		}
		//der Auszuwählende Char wird gewählt
		println("Choose your Char: ");
		int ret = readInt();
		readLine();
		setCurrentChar(ret - 1);
	}

}
