package studentenStatistikV4;

class Student {

	String vorname, nachname;
	int punkte;
	
	/**
	 * Der Konstruktor ermöglicht das Vorbelegen aller Attribute
	 */
	Student( String derVorname, String derNachname, int diePunkte ) {
		vorname = derVorname;
		nachname = derNachname;
		punkte = diePunkte;
	}
	
}
