package aufgabe4;

public class Position {

	private int xPosition; //Zeile im Array
	private int yPosition; //Splate im Array
	
	
	/*
	 * Diese Methode setzt die Position in der Zeile
	 */
	public void setXPosition(int xPosition) {
		this.xPosition = xPosition;
	}
	
	
	/*
	 * Diese Methode gibt die Position in der Zeile zur�ck
	 */
	public int getXPosition() {
		return this.xPosition;
	}
	
	/*
	 * Diese Methode setzt die Position in der Spalte
	 */
	public void setYPosition(int yPosition) {
		this.yPosition = yPosition;
	}
	
	
	/*
	 * Diese Methode gibt die Position in der Spalte zur�ck
	 */
	public int getYPosition() {
		return this.yPosition;
	}
	
}
