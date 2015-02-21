package tutorium;

import static gdi.MakeItSimple.isFilePresent;
import static gdi.MakeItSimple.println;
import static gdi.MakeItSimple.readLine;

/**
 * Liest ein einfaches Sudoku-Feld im Format 9x9 Felder von einer Datei ein und
 * füllt die leeren Felder des Rätsels aus.
 * Sowohl das eingelesene Rätsel, als auch dessen Lösung wird auf der
 * Konsole ausgegeben.
 * 
 * @author Kim
 */
public class SolveSudoku {

	public static void main(String[] args) {
		
		String filename = getFilenameOfSudokuField();
		
		Sudoku sudoku = new Sudoku();
		sudoku.loadSudokuFieldFromFile(filename);
		
		println("Ausgangsfeld:");
		sudoku.printSudokuField();
		
		sudoku.solveSudoku();
		println("\n\nLösung:");
		sudoku.printSudokuField();
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
	
	
	
}
