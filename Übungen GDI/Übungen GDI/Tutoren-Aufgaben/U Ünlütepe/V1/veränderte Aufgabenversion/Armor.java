
/**
 * Dieser Klasse ist für die Erzeugung von neunen Rüstungen zuständig.
 * @author mehmet
 *
 */
public class Armor{
	
	int defense; 		//Variable für die Verteidigung
	int magDefense;		//variable für die magische Verteidugung

	/**
	 * KOnstruktor der die Jewilige Rüstung erstellt
	 * @param name Name der Rüstung
	 * @param price Preis der Rüstung
	 */
	protected Armor(String name, int defense, int magDefense) {
		super(name);
		this.defense = defense;
		this.magDefense = magDefense;
	}

}
