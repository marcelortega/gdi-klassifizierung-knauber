package gdi.tut.a1;

import gdi.tut.hangman.gui.swing.HangManMainWindow;
import gdi.tut.hangman.interfaces.HangManGame;

import javax.swing.JFrame;

public class RunGame {
	public static void main(String[] args) {
		HangManGame game = new HangManImpl("dicts/hangman.txt");
		JFrame hangman = new HangManMainWindow(game);
		// JFrame hangman = new MainWindow2();
		// hangman.setVisible(true);
		// HangManGame game = new HangManImpl("dicts/hangman.txt");
		// game.start();
		// game.start();
		// game.addChar('a');
		System.out.println("...");
	}
}