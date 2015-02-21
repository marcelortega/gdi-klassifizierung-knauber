package gdi;

import static gdi.MakeItSimple.*;

/**
 * Liest ein einfaches Sudoku-Feld im Format 9x9 Felder von einer Datei ein und
 * füllt die leeren Felder des Rätsels aus.
 * Sowohl das eingelesene Rätsel, als auch dessen Lösung wird auf der
 * Konsole ausgegeben.
 * 
 * @author Kim
 */
public class SolveSudoku {

	// Konstanten, welche die Größe des Sudoku-Feldes angeben
	public static final int NUM_OF_ROWS = 9;
	public static final int NUM_OF_COLS = 9;
	
	/**
	 * Programmstart
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		String filename = getFilenameOfSudokuField();
		
		int[][] field = loadSudokuField(filename);
		println("Ausgangsfeld:");
		printSudokuField(field);
		solveSudoku(field);
		println("\n\nLösung:");
		printSudokuField(field);
	}
	
	/**
	 * Liest einen Dateipfad von der Konsole ein und prüft,
	 * ob die Datei existiert.
	 * 
	 * @return Pfad zur Datei mit dem Sudoku-Rätsel
	 */
	private static String getFilenameOfSudokuField() {

		String filename;
		boolean filenameEntered = false;

		do {
			println("Bitte Dateipfad eingeben: ");
			filename = readLine();
			// Pfüt, ob Datei vorhanden ist und gibt ggf. eine
			// Fehlermeldung aus.
			if (!isFilePresent(filename)) {
				println("Fehler: Datei ist nicht vorhanden.");
				filenameEntered = false;
			} else {
				filenameEntered = true;
			}
		} while (!filenameEntered);
		return filename;
	}
	
	/**
	 * Lädt ein Sudoku-Rätsel aus der angegebenen Datei in ein
	 * zwei-dimensionales Array.
	 * Das Array ist dabei wie folgt aufgebaut: array[Row][Column]
	 * wobei array[0][0] die obere linke Ecke des Sudoku-Feldes ist.
	 * 
	 * @param filename Pfad zur Datei des Sudoku-Rätsels
	 * @return Das Sudoku-Feld als Array
	 */
	public static int[][] loadSudokuField(String filename) {
		Object file = openInputFile(filename);
		int[][] sudokuField = new int[NUM_OF_ROWS][NUM_OF_COLS];

		for (int row = 0; row < NUM_OF_ROWS; row++) {
			for (int column = 0; column < NUM_OF_COLS; column++) {
				sudokuField[row][column] = readInt(file);
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

		return sudokuField;
	}
	
	
	/**
	 * Löst das übergebene Sudoku-Rätsel.
	 * Hierbei wird nacheinander jede freie Stelle des Rätsels gelöst.
	 * Nacheinander werden alle Ziffern von 1 bis 9 an der zu lösenden
	 * Stelle eingesetzt und geprüft, ob dadurch ein Konflikt auftritt.
	 * Sofern nur eine Ziffer ohne Konflikt gesetzt werden kann, wird
	 * diese eingesetzt.
	 * 
	 * @param arr Das Sudoku-Rätsel
	 * @return true wenn das Rätsel korrekt ist, sonst false
	 */
	public static void solveSudoku(int[][] arr) {
		
		// Anzahl der geprüften Ziffern, die keinen Konflikt hervorrufen
		int numOfPossibleNumbers = 0;
		
		// Zahl die an der Stelle gesetzt werden kann, ohne dass ein Konflikt auftritt
		int numberToSet = 0;
		
		// Anzahl der im gesamten Rätsel bereits gefundenen Zahlen
		int foundNumbers = 0;
		
		// Ermittle zunächst die Anzahl der bereits angegebenen Zahlen
		for(int row = 0; row < NUM_OF_ROWS; row++){
			for(int column = 0; column < NUM_OF_COLS; column++){
				if(arr[row][column] != 0)
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
					if(arr[row][column] == 0){ // Freie Stelle gefunden
						numOfPossibleNumbers = 0;
						numberToSet = 0;
				
						// prüfe jede Zahl von 1 bis 9 auf Konflikte
						for(int numberToTest = 1; numberToTest <= 9; numberToTest++){
							if(checkNumber(arr, numberToTest, row, column)){
								numOfPossibleNumbers++;
								numberToSet = numberToTest;
							}
						}
						
						// eindeutige Zahl gefunden -> setze diese an die freie Stelle
						if(numOfPossibleNumbers == 1){
							arr[row][column] = numberToSet;
							foundNumbers++;
						}
					}
				}
			}
		}
	
	}

	/**
	 * Prüft, ob ein Konflikt für die angegebene Position des Sudoku-Feldes vorliegt.
	 * 
	 * @param arr 		Das Sudoku-Feld
	 * @param number 	Die Ziffer an der zu prüfenden Position
	 * @param row		Die Reihe der zu prüfenden Ziffer
	 * @param column	Die Zeile der zu prüfenden Ziffer
	 * @return true wenn kein Konflikt vorliegt, sonst false
	 */
	public static boolean checkNumber(int[][] arr, int number, int row, int column) {
		return checkHorizontal(arr, number, row, column)
				&& checkVertical(arr, number, row, column)
				&& checkSquare(arr, number, row, column);
	}

	/**
	 * Prüft, ob ein Konflikt in der Zeile der zu prüfenden Stelle vorliegt.
	 * 
	 * @param arr		Das Sudoku-Feld
	 * @param number	Die Ziffer an der zu prüfenden Position
	 * @param row		Die Reihe der zu prüfenden Ziffer
	 * @param column	Die Zeile der zu prüfenden Ziffer
	 * @return true wenn kein Konflikt vorliegt, sonst false
	 */
	public static boolean checkHorizontal(int[][] arr, int number, int row, int column) {
		// prüfe nacheinander jede Zeile in der angegebenen Reihe des Sudoku-Feldes
		for (int x = 0; x < NUM_OF_COLS; x++) {
			if(x != column){ // die zu prüfende Stelle muss übersprungen werden
				if (arr[row][x] == number) // gleiche Ziffer gefunden -> Konflikt
					return false;
			}
		}
		return true;
	}

	/**
	 * Prüft, ob ein Konflikt in der Spalte der zu prüfenden Stelle vorliegt.
	 * 
	 * @param arr		Das Sudoku-Feld
	 * @param number	Die Ziffer an der zu prüfenden Position
	 * @param row		Die Reihe der zu prüfenden Ziffer
	 * @param column	Die Zeile der zu prüfenden Ziffer
	 * @return true wenn kein Konflikt vorliegt, sonst false
	 */
	public static boolean checkVertical(int[][] arr, int number, int row, int column) {
		// prüfe nacheinander jede Spalte in der angegebenen Zeile des Sudoku-Feldes
		for (int y = 0; y < NUM_OF_ROWS; y++) {
			if(y != row){ // die zu prüfende Stelle muss übersprungen werden
				if (arr[y][column] == number) // gleiche Ziffer gefunden -> Konflikt
					return false;
			}
		}
		return true;
	}

	/**
	 * Prüft, ob ein Konflikt im Teilquadrat der zu prüfenden Stelle vorliegt.
	 * 
	 * @param arr		Das Sudoku-Feld
	 * @param number	Die Ziffer an der zu prüfenden Position
	 * @param row		Die Reihe der zu prüfenden Ziffer
	 * @param column	Die Zeile der zu prüfenden Ziffer
	 * @return true wenn kein Konflikt vorliegt, sonst false
	 */
	public static boolean checkSquare(int[][] arr, int number, int row, int column) {
		/*
		 * Um das Teilquadrat zu prüfen, muss zunächst die linke obere Ecke
		 * des Teilquadrates anhand der zu prüfenden Position ermittelt werden. 
		 */
		int upperLeftCornerCol = (column / 3) * 3;
		int upperLeftCornerRow = (row / 3) * 3;

		for (int y = upperLeftCornerRow; y < upperLeftCornerRow + 3; y++) {
			for (int x = upperLeftCornerCol; x < upperLeftCornerCol + 3; x++) {
				if(y != row && x != column){ // die zu prüfende Stelle muss übersprungen werden
					if (arr[y][x] == number) // gleiche Ziffer gefunden -> Konflikt
						return false;
				}
			}
		}

		return true;
	}
	
	
	/**
	 * Gibt das Sudoku-Feld auf der Konsole aus.
	 * 
	 * @param arr	Das Sudoku-Feld
	 */
	public static void printSudokuField(int[][] arr) {
		for (int row = 0; row < NUM_OF_ROWS; row++) {
			if(row % 3 == 0)
				println("+---+---+---+");
			
			for (int column = 0; column < NUM_OF_COLS; column++) {
				if(column % 3 == 0)
					print("|");
				print(arr[row][column]);
			}
			println("|");
		}
		println("+---+---+---+");
	}

}
