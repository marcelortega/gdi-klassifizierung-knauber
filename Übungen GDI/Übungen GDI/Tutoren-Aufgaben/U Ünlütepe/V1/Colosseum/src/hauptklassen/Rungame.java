package hauptklassen;

import character.Elf;
import character.Human;
import character.Orc;
import static gdi.MakeItSimple.*;

public class Rungame {
	static Race[] opponents = new Race[3];
	static int currentChar;
	static boolean fight = true;
	static String file = "/home/mehmet/Dropbox/GDIWork/Colosseum/src/hauptklassen/saves.txt";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Player nemo = new Player();
		currentChar = nemo.getCurrentChar();
		nemo.getChar(currentChar).state();
		//menue(nemo.getChar(currentChar));
		menue(nemo);
	}
	
	/**
	 * Methode lässt den Player mit seinem Gegner kämpfen
	 * @param a Player
	 * @param b Gegner
	 * @return Boolean darüber ob der kampf zu ende ist oder nicht
	 */
	public static boolean fight(Race a, Race b){
		if(a.getHp()<=0){
			println(b.getName()+" hat gewonnen.");
			return fight = false;
		}
		
		a.hit(b);
		if(b.getHp()<=0){
			println(a.getName()+" hat gewonnen.");
			return fight = false;
		}
			
		b.hit(a);
		return fight =true;
	}
	
	/**
	 * Methode schreibt für den Kampf wichtige Werte des Chars in eine Datei
	 */
	public static void saveCharToFile(Race player){
		if(isFilePresent(file)){
			
		
			Object saveFile = openOutputFile("/home/mehmet/Dropbox/GDIWork/Colosseum/src/hauptklassen/saves.txt");
			println(saveFile, player.getRace());
			println(saveFile, player.getName());
			println(saveFile, player.getHp());
			println(saveFile, player.getPhysDamage());	
			println(saveFile, player.getMagDamage());
			println(saveFile, player.getPhysDefense());
			println(saveFile, player.getMagDefense());
			closeOutputFile(saveFile);
		}
		else{
			println("No file present");
		}
	}

	/**
	 * Methode ist dafür zuständig die Werte eines chars aus einer txt datei zu lesen und 
	 * damit einen neuen char zu erstellen
	 * @return
	 */
	public static Race loadOpponent(String file) {
		Race opponent = null;
		String race;
		String name;
		int hp;
		int pDamage;
		int mDamage;
		int pDefense;
		int mDefense;
		int creator = 0;

		if (isFilePresent(file)) {
			Object loadFile = openInputFile(file);
			race = readLine(loadFile);
			name = readLine(loadFile);
			hp = readInt(loadFile);

			pDamage = readInt(loadFile);

			mDamage = readInt(loadFile);

			pDefense = readInt(loadFile);

			mDefense = readInt(loadFile);

			closeInputFile(loadFile);
			if (race.equals("Human")) {
				creator = 1;
			} else if (race.equals("Elf")) {
				creator = 2;
			} else if (race.equals("Orc")) {
				creator = 3;
			}

			switch (creator) {
				case 1: {
					opponent = (Human) new Human(name);
					break;
				}
	
					// erstellung eines Elfen
				case 2: {
					opponent = (Elf) new Elf(name);
					break;
				}
	
					// Erstellung eines Orks
				case 3: {
					opponent = (Orc) new Orc(name);
					break;
				}
			}
			opponent.setHp(hp);
			opponent.setMagDamage(mDamage);
			opponent.setPhysDamage(pDamage);
			opponent.setMagDefense(mDefense);
			opponent.setPhysDefense(pDefense);
			return opponent;
		}else{
			println("No Opponent File");
		}
		return null;
	}


/**
 * Methode erstellt standard NPC Gegner
 * @return ein Array mit 3 Gegnern
 */
	public static Race[] loadOpponent(){
	opponents[0] = (Human) new Human("Aragorn");
	opponents[1] = (Elf) new Elf("Arwen");
	opponents[2] = (Orc) new Orc("Krushnak");

	return opponents;
		
	}

	/**
	 * Methode ist dafür zuständig das Menue auf der KOnsole auszugeben und das Spiel am laufen zu halten.
	 * @param player
	 */
public static void menue(Player player){
	Race character = player.getChar(player.getCurrentChar());
	println("********************\nWas möchten Sie tun?\n1. Gegen einen NPC kämpfen.\n2. Gegen anderen Spieler kämpfen.\n3. Inventar.\n4. Player status anzeigen.\n5. Aktuellen Char speichern.\n6. Char wechseln.\n7. Neuen Char erstellen. \n8. Beenden\n********************");
	int wahl = readInt();
	readLine();
	switch(wahl){
		case 1:{
			fightNPC(character, player);
			break;
		}
		case 2:{
			fightPlayer(character, player);
			break;
		}
		case 3:{
			character.getEquipment();
			menue(player);
			break;
		}
		case 4:{
			character.state();
			menue(player);
			break;
			
		}
		case 5:{
			saveCharToFile(character);
			menue(player);
			break;
			
		}
		case 6:{
			player.changeChar();
			menue(player);
			break;
		}
		case 7:{
			player.createChar();
			menue(player);
			break;
		}
		case 8:{
			println("Bye bye");
			break;
		}
	}
}

/**
 * Methode ist dafür zuständig, den Player gegen eine NPC kämpfen zu lassen
 * @param character Der spieler
 */
private static void fightNPC(Race character, Player p) {
	opponents = loadOpponent();	
	Race opponent = opponents[1];
	while(fight){
		fight(character,opponent);
	}
	menue(p);
	
}

/**
 * Methode ist dafür zuständig den Player gegen andere Spieler kämpfen zu lassen
 * @param character Spieler
 */
private static void fightPlayer(Race character, Player p) {
	Race opponent = loadOpponent(file);
	if(opponent != null){
		while(fight){
			fight(character, opponent);
		}
	}else{
		println("Kein Gegner Gefunden!");
	}
	menue(p);
}






}