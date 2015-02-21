package uebung09;

public interface BaconChiffre {

	String reinigeUrsprungstext( String text );

	String kodiereUrsprungstext( String text );

	String dekodiereUrsprungstext( String binaerCode );

	String versteckeText( String ursprungsText, String mediumText );

	String zeigeText( String steganogramm );

}
