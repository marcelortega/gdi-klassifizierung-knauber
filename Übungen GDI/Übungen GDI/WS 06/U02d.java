package tictactoe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class SuccessFrame extends Frame implements ActionListener {
  private final int WIDTH  = 200;
  private final int HEIGHT = 150;
  private JButton stop = new JButton( "OK" );
  private Frame playGround;

  public SuccessFrame( char successNr, Frame playGround ) {
    super( "Gewonnen!" );
    this.playGround = playGround;
    setSize( WIDTH, HEIGHT );
    setLayout( new GridLayout( 2, 1 ) );
    Label lb = new Label( "Spieler '"+successNr+"' hat gewonnen!" );
    lb.setAlignment(Label.CENTER);
    add( lb );
    add( stop );
    stop.addActionListener( this );
    setVisible(true);
  }

  public void actionPerformed( ActionEvent e ) {
  	setVisible(false);
    playGround.setVisible(false);
    System.exit( 0 );
  }

}