package hauptklassen;

import armor.LeatherArmor;
import weapons.OldSword;

import static gdi.MakeItSimple.*;

/**
 * Diese Klasse ist die Oberklasse für alle Rassen. Die Rassen Mensch, Elf und
 * Ork erben von dieser Klasse und fügen notwendige Eigenschaften hinzu
 * 
 * @author mehmet
 * 
 */
public class {
	private String race; // Rasse des Chars
	private String name; // Name des Characters
	private int hp; // Lebenspunkte
	private int physDamage; // Physischer Schaden
	private int magDamage; // Magischer Schaden
	private int physDefense; // Physiche Verteidugung
	private int magDefense; // Magische Verteidugung
	private int level; // Level des Characters
	private Equipment[] equipSlots; // Inventar des Characters
	private Weapon weapon; // Waffen slot
	private Armor armor; // Rüstungsslot

	/**
	 * 
	 * @param race
	 *            Rasse des Chars
	 * @param name
	 *            Name des Chars
	 * @param hp
	 *            Lebenspunkte des Chars
	 * @param physDamage
	 *            Physischer Schaden
	 * @param magDamage
	 *            Magischer SChaden
	 * @param physDefense
	 *            Physischen Verteidigung
	 * @param magDefense
	 *            Magische Verteidigung
	 */
	public Race(String race, String name, int hp, int physDamage,
			int magDamage, int physDefense, int magDefense) {
		this.race = race;
		this.name = name;
		this.hp = hp;
		this.physDamage = physDamage;
		this.magDamage = magDamage;
		this.physDefense = physDefense;
		this.magDefense = magDefense;
		this.level = 0;
		this.equipSlots = new Equipment[5];
		this.weapon = new OldSword("Old Sword", 20);
		this.armor = new LeatherArmor("Leather Armor");
	}

	/**
	 * Getter für die Rasse des Chars
	 * 
	 * @return Rasse des Chars
	 */
	public String getRace() {
		return race;
	}

	/**
	 * Getter für den Namen
	 * 
	 * @return Name des Chars
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter für die Lebenspunkte
	 * 
	 * @return Lebenspunkte des Chars
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * Getter für den Physischen Schaden
	 * 
	 * @return Physischer Basisschaden
	 */
	public int getPhysDamage() {
		return physDamage;
	}

	/**
	 * Getter für den Magiischen Schaden
	 * 
	 * @return Magischer Basisschaden
	 */
	public int getMagDamage() {
		return magDamage;
	}

	/**
	 * Getter für die Physische Verteidugung
	 * 
	 * @return Physische Basisverteidigung
	 */
	public int getPhysDefense() {
		return physDefense;
	}

	/**
	 * Getter für die Magische Verteidugung
	 * 
	 * @return Magische Basisverteidigung
	 */
	public int getMagDefense() {
		return magDefense;
	}

	/**
	 * Getter für den Level des Chars
	 * 
	 * @return Aktueller Char Level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Getter für das Inventar Gibt das aktueller Inventar in der Konsole aus
	 */
	public void getEquipment() {
		for (int i = 0; i < equipSlots.length; i++) {
			if (equipSlots[i] != null) {
				println(equipSlots[i].name);
			} else {
				println("frei");
			}
		}
	}

	/**
	 * Getter für die ausgerüstete Waffe
	 * 
	 * @return Aktuell benutzte Waffe
	 */
	public Weapon getWeapon() {
		return weapon;
	}

	/**
	 * Getter für die ausgerüstete Rüstung
	 * 
	 * @return Aktuelle Rüstung
	 */
	public Armor getArmor() {
		return armor;
	}

	/**
	 * Setter für die MAximalen Lebenspunkte
	 * 
	 * @param hp
	 *            Neue Lebenspunkte
	 */
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	/**
	 * Setter für den Physischen Basisschaden
	 * 
	 * @param physDamage
	 *            Neuer Basisschaden
	 */
	public void setPhysDamage(int physDamage) {
		this.physDamage = physDamage;
	}

	/**
	 * Setter für den Magischen Basisschaden
	 * 
	 * @param magDamage
	 *            Neuer magischer Basisschaden
	 */
	public void setMagDamage(int magDamage) {
		this.magDamage = magDamage;
	}

	/**
	 * Setter für die Physische Basisverteidugung
	 * 
	 * @param physDefense
	 *            Neue Physische Basisverteidigung
	 */
	public void setPhysDefense(int physDefense) {
		this.physDefense = physDefense;
	}

	/**
	 * Setter für die Magische Basisverteidugung
	 * 
	 * @param magDefense
	 *            Neue Magische Basisverteidigung
	 */
	public void setMagDefense(int magDefense) {
		this.magDefense = magDefense;
	}

	/**
	 * Setter für den Char Level
	 * 
	 * @param level
	 *            Neuer Level
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * Setter um gegenstände in das Inventar einzufügen
	 * 
	 * @param equip
	 *            Einzufügender Gegenstand
	 * @param place
	 *            Platz im Inventar
	 */
	public void setEquipment(Equipment equip, int place) {
		equipSlots[place] = equip;
	}

	/**
	 * Setter um eine Waffe auszurüsten
	 * 
	 * @param weapon
	 *            Waffe aus dem Inventar
	 */
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	/**
	 * Setter um eine Rüstung auszurüsten
	 * 
	 * @param armor
	 *            Rüstung aus dem Inventar
	 */
	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	/**
	 * Methode um aktuelle Waffe oder Rüstung mit einer Waffe oder Rüstung aus
	 * dem Inventar auszutauschen
	 * 
	 * @param i
	 *            platz des auszurüstenden Gegenstandes
	 * @param e
	 *            auszurüstender Gegenstand
	 */
	public void changeEquip(int i, Equipment e) {

	}

	/**
	 * Methode um einen Schlag auszuführen
	 * 
	 * @param r
	 *            Rasse gegen die gekämpft wird
	 */
	public void hit(Race r) {
		println(getName() + " ist dran.");
		int p = this.physDamage + weapon.damage;
		int m = this.magDamage + weapon.magDamage;
		setDamage(countDamage(p, m), r);
	}

	/**
	 * Methode die den Schlag abfängt und den schaden berechnet
	 * 
	 * @param phDamage
	 *            Physischer Schaden
	 * @param maDamage
	 *            Magischer Schaden
	 * @return zuzufügender schaden
	 */
	private int countDamage(int phDamage, int maDamage) {
		if (maDamage == 0) {
			maDamage = getMagDamage();
		}
		if (phDamage == 0) {
			phDamage = getPhysDamage();
		}
		int damage = (phDamage - getPhysDefense())
				+ (maDamage - getMagDefense());
		if (damage <= 0) {
			return 1;
		} else {
			return damage;
		}

	}

	/**
	 * Methode zieht den berechneten schaden von den Lebenspunkten des Chars ab
	 * 
	 * @param damage
	 *            Zugefügter schaden
	 */
	private void setDamage(int damage, Race r) {
		r.setHp(r.getHp() - damage);
		println(this.name + " Hat dem Gegner " + damage
				+ " Schaden hinzugefügt");
		println("Gegner " + r.getName() + " hat noch " + r.getHp()
				+ " Lebenspunkte");
	}

	/**
	 * Methode gibt den aktuellen Status des Chars in der Konsole aus
	 */
	public void state() {
	}

}
