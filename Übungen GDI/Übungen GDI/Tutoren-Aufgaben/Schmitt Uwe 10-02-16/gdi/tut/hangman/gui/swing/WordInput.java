package gdi.tut.hangman.gui.swing;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

public class WordInput extends JDialog {

	private JTextField word;
	private JButton ok;
	/**
	 * 
	 */
	private static final long serialVersionUID = -1625100288257824527L;

	public WordInput(ActionListener okal) {
		super();

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

		this.setPreferredSize(new Dimension(310, 100));

		this.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		// Festlegen, dass die GUI-Elemente die Gitterfelder in
		// waagerechter Richtung ausfüllen:
		gbc.fill = GridBagConstraints.HORIZONTAL;
		// Die Abstände der einzelnen GUI-Elemente zu den gedachten
		// Gitterlinien festgelegen:
		gbc.insets = new Insets(2, 2, 2, 2);

		gbc.gridx = 0; // x-Position im gedachten Gitter
		gbc.gridy = 0; // y-Position im gedachten Gitter
		gbc.gridheight = 1;

		this.word = new JTextField();
		this.word.setPreferredSize(new Dimension(300,25));
		this.add(this.word,gbc);

		gbc.gridy = 1;
		this.ok = new JButton("Ok");
		this.ok.addActionListener(okal);
		this.add(ok,gbc); 

		this.pack();
		this.setResizable(false);
		this.setLocation((d.width - getSize().width) / 2,
				(d.height - getSize().height) / 2);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	}

	public String getValue() {
		return word.getText();
	}
}
