package gdi.tut.hangman.interfaces;


public interface HangManGameExt extends HangManGame {
	/**
	 * Startet das Spiel neu mit dem übergebenen Begriff.
	 * 
	 * @param word Das Suchwort, das für die nächste Runde verwendet werden soll.
	 */
	public void start(String word);
}
