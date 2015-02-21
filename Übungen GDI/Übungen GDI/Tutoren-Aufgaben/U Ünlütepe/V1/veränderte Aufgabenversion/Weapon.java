

/**
 * Diese Klasse erbt von Equipment und ist für die Erzeugung neuer Waffen zuständig
 * Als Werte hat eine Waffe einen Physischen und magischen Schaden
 * @author mehmet
 *
 */
public class Weapon {
	
	int damage; 					//Physischer Schaden
	int magDamage;					//Magischer Schaden
	
	/**
	 * Konstruktor um die Waffen zu erstellen
	 * @param name Name der Waffe
	 * @param price Preis der Waffe
	 */
	protected Weapon(String name, int damage, int magDamage) {
		super(name);
		this.damage = damage;
		this.magDamage = magDamage;
	}
	
	
	
	
	
}
