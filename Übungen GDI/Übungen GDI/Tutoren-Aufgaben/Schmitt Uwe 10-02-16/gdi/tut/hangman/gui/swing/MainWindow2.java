package gdi.tut.hangman.gui.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.plaf.DimensionUIResource;

public class MainWindow2 extends JFrame {

	public MainWindow2() throws HeadlessException {
		super("Hangman");

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

		this.getContentPane().setLayout(new GridBagLayout());
		// this.setResizable(false);

		JLabel hangmanWord = new JLabel("ABCDE");
		hangmanWord.setPreferredSize(new Dimension(300, 25));
		// hangmanWord.setBackground(new Color(174));

		JLabel hangmanWord2 = new JLabel("ABCDE");
		hangmanWord2.setPreferredSize(new Dimension(300, 50));
		hangmanWord2.setBackground(new Color(174));
		// hangmanWord2.setHorizontalTextPosition(SwingConstants.RIGHT);

		JPanel drawPanel = new DrawPanel();

		GridBagConstraints gbc=new GridBagConstraints();

		// Festlegen, dass die GUI-Elemente die Gitterfelder in
		// waagerechter Richtung ausfüllen:
		gbc.fill = GridBagConstraints.HORIZONTAL;

		// Die Abstände der einzelnen GUI-Elemente zu den gedachten
		// Gitterlinien festgelegen:
		gbc.insets = new Insets(2, 2, 2, 2);

		gbc.gridx = 0; // x-Position im gedachten Gitter
		gbc.gridy = 0; // y-Position im gedachten Gitter
		gbc.gridheight = 1; // zwei Gitter-Felder hoch

		this.getContentPane().add(drawPanel,gbc);
		
		gbc.gridx = 0; // x-Position im gedachten Gitter
		gbc.gridy = 1; // y-Position im gedachten Gitter
		//JPanel hangmanWordPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		// hangmanWordPanel.add(hangmanWord);
		hangmanWord.setHorizontalAlignment(SwingConstants.CENTER);
		this.getContentPane().add(hangmanWord,gbc);
		// this.getContentPane().add(hangmanWord2);
		// this.getContentPane().setBackground(new Color(84));

		this.pack();

		this.setLocation((d.width - getSize().width) / 2,
				(d.height - getSize().height) / 2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
