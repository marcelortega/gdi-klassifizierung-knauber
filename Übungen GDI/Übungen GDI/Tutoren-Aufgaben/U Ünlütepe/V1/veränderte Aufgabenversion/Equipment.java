

/**
 * Dies ist die Hauptklasse für das Equipment
 * Waffen, Rüstungen und andere items erben von dieser Klasse
 *
 *
 */
public class Equipment {
	String name;

		
	/**
	 * Konstruktor mit den parametern Preis und name
	 * Jeder Gegenstand wird mit einem Preis und einem Namen erstellt
	 * @param name Gegenstandname
	 * @param price	gegenstandpreis
	 */
	Equipment(String name){
		this.name = name;		
	}

	/**
	 * getter für den Namen des gegenstandes
	 * @return Name des gegenstandes
	 */
	public String getName() {
		return name;
	}


	
}
