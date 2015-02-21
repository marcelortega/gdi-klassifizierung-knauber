package gdi.tut.hangman.interfaces;


public interface HangManGameExt extends HangManGame {
	/**
	 * Startet das Spiel neu mit dem �bergebenen Begriff.
	 * 
	 * @param word Das Suchwort, das f�r die n�chste Runde verwendet werden soll.
	 */
	public void start(String word);
}
