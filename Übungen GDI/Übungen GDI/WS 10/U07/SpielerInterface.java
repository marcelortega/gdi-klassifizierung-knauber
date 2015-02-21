package uebung07_TicTacToe;

public interface SpielerInterface {
	
	/**
	 * Die Methode setzt den Stein an die Position mit der angegebenen Nummer.
	 * Die Positionsnummern sind wie folgt vergeben:<br>
	 * 0  1  2<br>
	 * 3  4  5<br>
	 * 6  7  8<br>
	 * Der Zug wird nicht ausgeführt, wenn es sich um einen ungültige Position
	 * handelt oder wenn die Position schon besetzt ist.
	 */
	void setzeStein(int positionsnummer);

}
