package gdi.tut.a2;

import gdi.tut.hangman.gui.swing.HangManMainWindowExt;

public class RunGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HangManMainWindowExt gameExt = new HangManMainWindowExt(
				new HangManExtImpl("dicts/hangman.txt"));
		
		// gameExt.setVisible(true);
	}

}
