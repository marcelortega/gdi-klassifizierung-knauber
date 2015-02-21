package hauptklassen;

/**
 * Diese Klasse stellt die Items dar. Sie erbt von Equipment.
 * @author mehmet
 *
 */
public class Items extends Equipment{
	private int effect;
		
	/**
	 * Konstruktor der das Objekt erstellt und die variable effect hinzufügt
	 * @param name Name des Items
	 * @param price Preis des Items
	 * @param effect Effekt des Items
	 */
	public Items(String name, int price, int effect) {
		super(name);
		this.effect = effect;
	}
	
	/**
	 * Getter für den Effect
	 * @return Effect des Items
	 */
	public int getEffect() {
		return effect;
	}

}
