package gdi.tut.hangman.interfaces;

public interface HangManGame {
	/**
	 * Maxmimale Anzahl von Fehlversuchen. Ist dieser Wert erreicht, so ist das
	 * Spiel verloren.
	 */
	public static final int MAX_FAILURES = 10;
	/**
	 * Dieser Char repr�sentiert einen nicht erratenen Buchstaben.
	 */
	public static final char HIDDEN_CHAR = '_';

	/**
	 * Das Spiel wird in den Startzustand gebracht. - neuen Begriff ausw�hlen -
	 * Fehlversuche auf 0 setzen
	 */
	public void start();

	/**
	 * F�gt einen weiteren Buchstaben hinzu. Gro�- oder Kleinbuchstabe soll egal
	 * sein (case insensitiv)
	 * 
	 * @param neuer
	 *            Buchstabe
	 */
	public void addChar(char c);

	/**
	 * 
	 * @return true falls das R�tsel gel�st wurde.
	 */
	public boolean won();

	/**
	 * 
	 * @return true falls das Spiel verloren wurde.
	 */
	public boolean lost();

	/**
	 * Liefert den bisher erratenen Suchstrings. Bsp.: "E_se_b_hn" 
	 * Ausnahme: Das Spiel ist bereits verloren. Dann liefert die Methode den Suchstring.
	 * 
	 * @return String bisher erratener Suchstring
	 */
	public String getSearchField();

	/**
	 * 
	 * @return Anzahl der bisherigen Fehlversuche im aktuellen Spiel.
	 */
	public int getNumFailures();
}
