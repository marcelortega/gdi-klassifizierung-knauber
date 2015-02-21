package gdi;

import static gdi.MakeItSimple.*;

/**
 * Liest ein einfaches Sudoku-Feld im Format 9x9 Felder von einer Datei ein und
 * pr�ft, ob es korrekt gel�st wurde.
 * 
 * @author Kim
 */
public class CheckSudoku {

	// Konstanten, welche die Gr��e des Sudoku-Feldes angeben
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
		printSudokuField(field);
		if(checkSudoku(field))
			println("Das Sudoku-R�tsel wurde korrekt gel�st.");
		else
			println("Fehler im R�tsel.");
	}

	/**
	 * Liest einen Dateipfad von der Konsole ein und pr�ft,
	 * ob die Datei existiert.
	 * 
	 * @return Pfad zur Datei mit dem Sudoku-R�tsel
	 */
	private static String getFilenameOfSudokuField() {

		String filename;
		boolean filenameEntered = false;

		do {
			println("Bitte Dateipfad eingeben: ");
			filename = readLine();
			// Pf�t, ob Datei vorhanden ist und gibt ggf. eine
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
	 * L�dt ein Sudoku-R�tsel aus der angegebenen Datei in ein
	 * zwei-dimensionales Array.
	 * Das Array ist dabei wie folgt aufgebaut: array[Row][Column]
	 * wobei array[0][0] die obere linke Ecke des Sudoku-Feldes ist.
	 * 
	 * @param filename Pfad zur Datei des Sudoku-R�tsels
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
			 * kann dies zu einer Exception f�hren.
			 * Daher muss gepr�ft werden, ob das Dateiende erreicht wurde.
			 * Wurde es nicht erreicht, wird das \n am Ende der Zeile weggelesen.
			 */
			if (!isEndOfInputFile(file))
				readLine(file);
		}

		closeInputFile(file);

		return sudokuField;
	}

	/**
	 * Pr�ft, ob das Sudoku-R�tsel korrekt gel�st wurde.
	 * 
	 * @param arr Das Sudoku-R�tsel
	 * @return true wenn das R�tsel korrekt ist, sonst false
	 */
	public static boolean checkSudoku(int[][] arr) {
		for (int row = 0; row < NUM_OF_ROWS; row++) {
			for (int column = 0; column < NUM_OF_COLS; column++) {
				if (arr[row][column] < 1 || arr[row][column] > 9) {
					// fehlerhafte Ziffer
					return false;
				} else {
					// pr�fe ob Konflikt an dieser Position vorliegt
					if (!checkNumber(arr, arr[row][column], row, column)){
						println("Fehler an Stelle: " + row + "," + column);
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * Pr�ft, ob ein Konflikt f�r die angegebene Position des Sudoku-Feldes
	 * ein Konflikt vorliegt.
	 * 
	 * @param arr 		Das Sudoku-Feld
	 * @param number 	Die Ziffer an der zu pr�fenden Position
	 * @param row		Die Reihe der zu pr�fenden Ziffer
	 * @param column	Die Zeile der zu pr�fenden Ziffer
	 * @return true wenn kein Konflikt vorliegt, sonst false
	 */
	public static boolean checkNumber(int[][] arr, int number, int row, int column) {
		return checkHorizontal(arr, number, row, column)
				&& checkVertical(arr, number, row, column)
				&& checkSquare(arr, number, row, column);
	}

	/**
	 * Pr�ft, ob ein Konflikt in der Zeile der zu pr�fenden Stelle vorliegt.
	 * 
	 * @param arr		Das Sudoku-Feld
	 * @param number	Die Ziffer an der zu pr�fenden Position
	 * @param row		Die Reihe der zu pr�fenden Ziffer
	 * @param column	Die Zeile der zu pr�fenden Ziffer
	 * @return true wenn kein Konflikt vorliegt, sonst false
	 */
	public static boolean checkHorizontal(int[][] arr, int number, int row, int column) {
		// pr�fe nacheinander jede Zeile in der angegebenen Reihe des Sudoku-Feldes
		for (int x = 0; x < NUM_OF_COLS; x++) {
			if(x != column){ // die zu pr�fende Stelle muss �bersprungen werden
				if (arr[row][x] == number) // gleiche Ziffer gefunden -> Konflikt
					return false;
			}
		}
		return true;
	}

	/**
	 * Pr�ft, ob ein Konflikt in der Spalte der zu pr�fenden Stelle vorliegt.
	 * 
	 * @param arr		Das Sudoku-Feld
	 * @param number	Die Ziffer an der zu pr�fenden Position
	 * @param row		Die Reihe der zu pr�fenden Ziffer
	 * @param column	Die Zeile der zu pr�fenden Ziffer
	 * @return true wenn kein Konflikt vorliegt, sonst false
	 */
	public static boolean checkVertical(int[][] arr, int number, int row, int column) {
		// pr�fe nacheinander jede Spalte in der angegebenen Zeile des Sudoku-Feldes
		for (int y = 0; y < NUM_OF_ROWS; y++) {
			if(y != row){ // die zu pr�fende Stelle muss �bersprungen werden
				if (arr[y][column] == number) // gleiche Ziffer gefunden -> Konflikt
					return false;
			}
		}
		return true;
	}

	/**
	 * Pr�ft, ob ein Konflikt im Teilquadrat der zu pr�fenden Stelle vorliegt.
	 * 
	 * @param arr		Das Sudoku-Feld
	 * @param number	Die Ziffer an der zu pr�fenden Position
	 * @param row		Die Reihe der zu pr�fenden Ziffer
	 * @param column	Die Zeile der zu pr�fenden Ziffer
	 * @return true wenn kein Konflikt vorliegt, sonst false
	 */
	public static boolean checkSquare(int[][] arr, int number, int row, int column) {
		/*
		 * Um das Teilquadrat zu pr�fen, muss zun�chst die linke obere Ecke
		 * des Teilquadrates anhand der zu pr�fenden Position ermittelt werden. 
		 */
		int upperLeftCornerCol = (column / 3) * 3;
		int upperLeftCornerRow = (row / 3) * 3;

		for (int y = upperLeftCornerRow; y < upperLeftCornerRow + 3; y++) {
			for (int x = upperLeftCornerCol; x < upperLeftCornerCol + 3; x++) {
				if(y != row && x != column){ // die zu pr�fende Stelle muss �bersprungen werden
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
