package tictactoe;

import javax.swing.JButton;

class Figure extends JButton {
  static final char NONE   = '\0';
  static final char CROSS  = 'X';
  static final char CIRCLE = 'O';
  static       char currentSymbol = CROSS;
  char symbol = NONE;

  Figure() {
    symbol = NONE;
	setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 36));

  }

  static void toggleSymbol () {
    if ( currentSymbol == CROSS )
      currentSymbol = CIRCLE;
    else
      currentSymbol = CROSS;
  }

}