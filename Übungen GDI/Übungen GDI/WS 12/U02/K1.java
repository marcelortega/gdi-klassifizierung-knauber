
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class HangManMainWindow extends JFrame implements ActionListener {

	private HangManGame game;
	private JButton newGameButton;
	private JButton exitButton;
	private DrawPanel hangmanPanel;
	private JLabel hangmanWord;
	private JPanel letters;
	protected JPanel buttons;
	/**
	 * auto generated
	 */
	private static final long serialVersionUID = 8634044104590168192L;

	public HangManMainWindow(HangManGame game) throws HeadlessException {
		super("Hangman");

		this.game = game;
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		
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

		this.hangmanPanel = new DrawPanel();
		
		this.add(hangmanPanel,gbc);
		
		// Hangman Word
		gbc.gridy = 1; // y-Position im gedachten Gitter
		this.hangmanWord = new JLabel("Ha_g_an");
		// this.mainBox.add(this.hangmanWord);
		this.hangmanWord.setPreferredSize(new Dimension(310, 25));
		this.hangmanWord.setHorizontalAlignment(SwingConstants.CENTER);
		this.hangmanWord.setFont(new Font("Courier", Font.PLAIN,16));
				
	
		this.add(this.hangmanWord,gbc);

		// Letters (Buttons) A-Z
		gbc.gridy = 2; // y-Position im gedachten Gitter
		this.letters = new JPanel(new FlowLayout());
		this.letters.setPreferredSize(new Dimension(310,60));
		this.add(letters,gbc);
		JButton aButton;
		for (char i = 'A'; i <= 'Z'; i++) {
			aButton = new JButton("" + i);
			aButton.setMargin(new Insets(0, 2, 0, 2));
			aButton.setActionCommand("select_" + i);
			aButton.addActionListener(this);
			aButton.setEnabled(false);
			this.letters.add(aButton);
		}

		// Buttons
		gbc.gridy = 3; // y-Position im gedachten Gitter
		this.buttons = new JPanel(new FlowLayout());
		this.newGameButton = new JButton("Neues Spiel");
		this.newGameButton.addActionListener(this);
		this.buttons.add(newGameButton);
		this.exitButton = new JButton("Beenden");
		this.exitButton.addActionListener(this);
		this.buttons.add(exitButton);
		// this.mainBox.add(buttons);
		this.add(this.buttons,gbc);

		
		this.pack();
		// Frame properties
		// this.setSize(600, 400);
		this.setResizable(false);
		this.setLocation((d.width - getSize().width) / 2,
				(d.height - getSize().height) / 2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.startsWith("select_")) {
			((JComponent)e.getSource()).setEnabled(false);
			char c = cmd.charAt(cmd.length()-1);
			this.game.addChar(c);
			this.hangmanWord.setText(this.game.getSearchField());
			if(this.game.won()) {
				setEnableAllLetters(false);
			} else if(this.game.lost()) {
				setEnableAllLetters(false);
			}
			this.hangmanPanel.draw(this.game.getNumFailures(),this.game.won());
		} else if (e.getSource().equals(exitButton)) {
			this.dispose();
			System.exit(0);
		} else if(e.getSource().equals(newGameButton)) {
			newGame();
		}
		
	}
	
	private void newGame() {
		this.game.start();
		initGUI();
	}

	protected void initGUI() {
		this.hangmanWord.setText(this.game.getSearchField());
		this.hangmanPanel.draw(0,false);
		setEnableAllLetters(true);
	}
	
	private void setEnableAllLetters(boolean value) {
		Component[] tmpLetters = this.letters.getComponents();
		for (int i = 0; i < tmpLetters.length; i++) {
			(tmpLetters[i]).setEnabled(value);			
		}
	}

}
