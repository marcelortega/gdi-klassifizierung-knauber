package gdi.tut.hangman.gui.swing;

import gdi.tut.hangman.interfaces.HangManGameExt;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class HangManMainWindowExt extends HangManMainWindow {
	private JButton newGameExtButton;
	private WordInput wordInput;
	private HangManGameExt game;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1765197740278569502L;

	public HangManMainWindowExt(HangManGameExt game) throws HeadlessException {
		super(game);

		this.game = game;
		this.wordInput = new WordInput(this);
		this.wordInput.setAlwaysOnTop(true);
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.newGameExtButton = new JButton("Neues Spiel (Ext)");
		this.newGameExtButton.addActionListener(this);
		this.buttons.add(newGameExtButton);

		this.pack();
		// Frame properties
		this.setResizable(false);
		this.setLocation((d.width - getSize().width) / 2,
				(d.height - getSize().height) / 2);
		
	}

	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		
		if (e.getSource().equals(newGameExtButton)) {
			newGameExt();
		} else if(e.getActionCommand().equals("Ok")) {
			this.wordInput.setVisible(false);
			this.game.start(wordInput.getValue());
			this.initGUI();
		}

	}

	private void newGameExt() {
		
		this.wordInput.pack();
		this.wordInput.setVisible(true);
		System.out.println("newGameExt");
	}
}
