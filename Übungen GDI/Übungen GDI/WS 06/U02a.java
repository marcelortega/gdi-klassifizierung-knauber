package tictactoe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class UndecidedFrame extends Frame implements ActionListener {
  private final int WIDTH  = 300;
  private final int HEIGHT = 150;
  private JButton stop = new JButton( "OK" );
  private Frame playGround;

  public UndecidedFrame( Frame playGround ) {
    super( "Unentschieden!" );
    this.playGround = playGround;
    setSize( WIDTH, HEIGHT );
    setLayout( new GridLayout( 2, 1 ) );
    Label lb = new Label( "Das Spiel endete unentschieden!" );
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