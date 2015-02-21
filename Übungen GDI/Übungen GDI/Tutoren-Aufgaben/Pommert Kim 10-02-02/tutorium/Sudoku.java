package tutorium;

import static gdi.MakeItSimple.closeInputFile;
import static gdi.MakeItSimple.isEndOfInputFile;
import static gdi.MakeItSimple.openInputFile;
import static gdi.MakeItSimple.print;
import static gdi.MakeItSimple.println;
import static gdi.MakeItSimple.readInt;
import static gdi.MakeItSimple.readLine;

/**
 * Die Klasse stellt ein Sudoku-Rätsel der Feldgröße 9x9 dar.
 * Sie enthält alle nötigen Funktionen, um Zahlen-Konflikte innerhalb
 * des Rätsels zu prüfen, sowie die Lösung des Rätsels zu bestimmen.
 * 
 * @author Kim
 *
 */
public class Sudoku {

	// Konstanten, welche die Größe des Sudoku-Feldes angeben
	public static final int NUM_OF_ROWS = 9;
	public static final int NUM_OF_COLS = 9;
	
	// Aufbau des Arrays: field[row][column]
	// wobei field[0][0] die obere linke Ecke des Sudoku-Feldes ist.
	private int[][] field; 
	
	public Sudoku(){
		this.field = new int[NUM_OF_ROWS][NUM_OF_COLS];
	}
	
	/**
	 * Lädt ein Sudoku-Rätsel aus der angegebenen Datei in ein
	 * zwei-dimensionales Array.
	 * 
	 * @param filename Pfad zur Datei des Sudoku-Rätsels
	 */
	public void loadSudokuFieldFromFile(String filename) {
		Object file = openInputFile(filename);
		this.field = new int[NUM_OF_ROWS][NUM_OF_COLS];

		for (int row = 0; row < NUM_OF_ROWS; row++) {
			for (int column = 0; column < NUM_OF_COLS; column++) {
				this.field[row][column] = readInt(file);
			}
			/*
			 * Wenn nach der letzten Ziffer kein \n folgt,
			 * kann dies zu einer Exception führen.
			 * Daher muss geprüft werden, ob das Dateiende erreicht wurde.
			 * Wurde es nicht erreicht, wird das \n am Ende der Zeile weggelesen.
			 */
			if (!isEndOfInputFile(file))
				readLine(file);
		}

		closeInputFile(file);
	}
	
	/**
	 * Prüft, ob das Sudoku-Rätsel korrekt gelöst wurde.
	 * 
	 * @return true wenn das Rätsel korrekt ist, sonst false
	 */
	public boolean isSolved() {
		for (int row = 0; row < NUM_OF_ROWS; row++) {
			for (int column = 0; column < NUM_OF_COLS; column++) {
				if (this.field[row][column] < 1 || this.field[row][column] > 9) {
					// fehlerhafte Ziffer
					return false;
				} else {
					// prüfe ob Konflikt an dieser Position vorliegt
					if (isConflictAtPosition(this.field[row][column], row, column)){
						println("Fehler an Stelle: " + row + "," + column);
						return false;
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * Prüft, ob ein Konflikt für die angegebene Position des Sudoku-Feldes
	 * ein Konflikt vorliegt.
	 * 
	 * @param number 	Die Ziffer an der zu prüfenden Position
	 * @param row		Die Reihe der zu prüfenden Ziffer
	 * @param column	Die Zeile der zu prüfenden Ziffer
	 * @return true wenn Konflikt vorliegt, sonst false
	 */
	public boolean isConflictAtPosition(int number, int row, int column) {
		return isConflictInRow(number, row, column)
				|| isConflictInColumn(number, row, column)
				|| isConflictInSubsquare(number, row, column);
	}

	/**
	 * Prüft, ob ein Konflikt in der Zeile der zu prüfenden Stelle vorliegt.
	 * 
	 * @param number	Die Ziffer an der zu prüfenden Position
	 * @param row		Die Reihe der zu prüfenden Ziffer
	 * @param column	Die Zeile der zu prüfenden Ziffer
	 * @return true wenn Konflikt vorliegt, sonst false
	 */
	public boolean isConflictInRow(int number, int row, int column) {
		// prüfe nacheinander jede Zeile in der angegebenen Reihe des Sudoku-Feldes
		for (int x = 0; x < NUM_OF_COLS; x++) {
			if(x != column){ // die zu prüfende Stelle muss übersprungen werden
				if (this.field[row][x] == number) // gleiche Ziffer gefunden -> Konflikt
					return true;
			}
		}
		return false;
	}

	/**
	 * Prüft, ob ein Konflikt in der Spalte der zu prüfenden Stelle vorliegt.
	 * 
	 * @param number	Die Ziffer an der zu prüfenden Position
	 * @param row		Die Reihe der zu prüfenden Ziffer
	 * @param column	Die Zeile der zu prüfenden Ziffer
	 * @return true wenn Konflikt vorliegt, sonst false
	 */
	public boolean isConflictInColumn(int number, int row, int column) {
		// prüfe nacheinander jede Spalte in der angegebenen Zeile des Sudoku-Feldes
		for (int y = 0; y < NUM_OF_ROWS; y++) {
			if(y != row){ // die zu prüfende Stelle muss übersprungen werden
				if (this.field[y][column] == number) // gleiche Ziffer gefunden -> Konflikt
					return true;
			}
		}
		return false;
	}

	/**
	 * Prüft, ob ein Konflikt im Teilquadrat der zu prüfenden Stelle vorliegt.
	 * 
	 * @param number	Die Ziffer an der zu prüfenden Position
	 * @param row		Die Reihe der zu prüfenden Ziffer
	 * @param column	Die Zeile der zu prüfenden Ziffer
	 * @return true wenn Konflikt vorliegt, sonst false
	 */
	public boolean isConflictInSubsquare(int number, int row, int column) {
		/*
		 * Um das Teilquadrat zu prüfen, muss zunächst die linke obere Ecke
		 * des Teilquadrates anhand der zu prüfenden Position ermittelt werden. 
		 */
		int upperLeftCornerCol = (column / 3) * 3;
		int upperLeftCornerRow = (row / 3) * 3;

		for (int y = upperLeftCornerRow; y < upperLeftCornerRow + 3; y++) {
			for (int x = upperLeftCornerCol; x < upperLeftCornerCol + 3; x++) {
				if(y != row && x != column){ // die zu prüfende Stelle muss übersprungen werden
					if (this.field[y][x] == number) // gleiche Ziffer gefunden -> Konflikt
						return true;
				}
			}
		}

		return false;
	}

	/**
	 * Gibt das Sudoku-Feld auf der Konsole aus.
	 */
	public void printSudokuField() {
		for (int row = 0; row < NUM_OF_ROWS; row++) {
			if(row % 3 == 0)
				println("+---+---+---+");
			
			for (int column = 0; column < NUM_OF_COLS; column++) {
				if(column % 3 == 0)
					print("|");
				print(this.field[row][column]);
			}
			println("|");
		}
		println("+---+---+---+");
	}
	
	
	/**
	 * Löst das Sudoku-Rätsel.
	 * Hierbei wird nacheinander jede freie Stelle des Rätsels gelöst.
	 * Nacheinander werden alle Ziffern von 1 bis 9 an der zu lösenden
	 * Stelle eingesetzt und geprüft, ob dadurch ein Konflikt auftritt.
	 * Sofern nur eine Ziffer ohne Konflikt gesetzt werden kann, wird
	 * diese eingesetzt.
	 */
	public void solveSudoku() {
		
		// Anzahl der geprüften Ziffern, die keinen Konflikt hervorrufen
		int numOfPossibleNumbers = 0;
		
		// Zahl die an der Stelle gesetzt werden kann, ohne dass ein Konflikt auftritt
		int numberToSet = 0;
		
		// Anzahl der im gesamten Rätsel bereits gefundenen Zahlen
		int foundNumbers = 0;
		
		// Ermittle zunächst die Anzahl der bereits angegebenen Zahlen
		for(int row = 0; row < NUM_OF_ROWS; row++){
			for(int column = 0; column < NUM_OF_COLS; column++){
				if(this.field[row][column] != 0)
					foundNumbers++;
			}
		}
		
		/*
		 * Finde für jede freie Stelle des Sudoku-Rätsels eine eindeutige
		 * Lösung, bis das Rätsel vollständig gelöst wurde.
		 * Ggf. muss das Rätsel mehrfach komplett durchlaufen werden
		 * bis die Lösung ermittelt wurde.
		 */
		while(foundNumbers < NUM_OF_ROWS * NUM_OF_COLS){
			for(int row = 0; row < NUM_OF_ROWS; row++){
				for(int column = 0; column < NUM_OF_COLS; column++){
					if(this.field[row][column] == 0){ // Freie Stelle gefunden
						numOfPossibleNumbers = 0;
						numberToSet = 0;
				
						/*
						 *  prüfe jede Zahl von 1 bis 9 auf Konflikte
						 *  wenn mehr als eine mögliche Ziffer gefunden wurde, kann die
						 *  Schleife vorzeitig terminieren, da keine eindeutige Ziffer vorhanden
						 */
						for(int numberToTest = 1; numberToTest <= 9 && numOfPossibleNumbers < 2; numberToTest++){
							if(!isConflictAtPosition(numberToTest, row, column)){
								numOfPossibleNumbers++;
								numberToSet = numberToTest;
							}
						}
						
						// eindeutige Zahl gefunden -> setze diese an die freie Stelle
						if(numOfPossibleNumbers == 1){
							this.field[row][column] = numberToSet;
							foundNumbers++;
						}
					}
				}
			}
		}
	}
	
}
