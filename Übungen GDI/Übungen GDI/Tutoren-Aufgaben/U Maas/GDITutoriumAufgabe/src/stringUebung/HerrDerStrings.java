package stringUebung;

public class HerrDerStrings {
	
	/**
	 * Aufgabe 1: Erstelle eine Klasse namens "HerrDerStrings".
	 * Implementiere f�r diese Klasse eine �ffentliche und statische Methode
	 * mit dem Namen "macheGrossbuchstabenKlein". Diese Funktion
	 * hat genau eine String-Variable als Parameter. In
	 * dieser Funktion sollen alle Gro�buchstaben 'A' - 'Z'
	 * und auch alle gro�geschriebenen Umlaute '�', '�' und '�'
	 * in Kleinbuchstaben umgewandelt werden. Alle anderen
	 * Zeichen d�rfen nicht ver�ndert werden. Der bearbeitete
	 * String wird am Ende zur�ckgegeben und darf keine Gro�buchstaben
	 * mehr enthalten.
	 * 
	 * Lernziel(e): Zeichen, Arrays, Schleifen, String aufbauen
	 * 
	 * Restriktion(en): Nur die String-Methoden "length()" und "charAt(idx)" d�rfen als
	 * externe Hilfsmethoden benutzt werden.
	 * 
	 * @param str
	 * @return
	 */
	public static String macheGrossbuchstabenKlein(String str) {
		
		char[] umlauteGross = { '�', '�', '�' };
		char[] umlauteKlein = { '�', '�', '�' };
		
		String lowerCaseStr = "";
		
		char curChar;
		
		for (int i = 0; i < str.length(); i++) {
			
			curChar = str.charAt(i);
			
			// "gro�es" Alphabet ohne Umlaute
			if ( (curChar >= 'A' && curChar <= 'Z') ) {
				
				// falls die Typumwandlung noch nicht erlaubt ist
				// k�nnte man es auch wie bei den Umlauten l�sen.
				curChar = (char) (curChar + ('a'-'A'));
			}
			// Umlaute
			else {
				
				for (int j = 0; j < umlauteGross.length; j++) {
					
					if ( curChar == umlauteGross[j] ) {
						curChar = umlauteKlein[j];
						break;
					}
				}
			}
			
			lowerCaseStr += curChar;
		}
		
		return lowerCaseStr;
	}

	/**
	 * Aufgabe 2: Implementiere f�r die Klasse
	 * "HerrDerStrings" eine weitere Methode namens "findeGollum".
	 * Auch diese soll wieder �ffentlich und statisch sein und
	 * eine String-Variable als Parameter erhalten. Diese Methode
	 * soll true liefern, wenn in dem �bergebenen String folgende
	 * Zeichenfolge enthalten ist: "Gollum". Dabei spielt die
	 * Gro�- und Kleinschreibung keine Rolle. Desweiteren
	 * m�ssen die einzelnen Buchstaben von "Gollum" nicht direkt
	 * nacheinander folgen. So wird z.B. auch bei diesem String
	 * " g5o5ll5u5m?_" true zur�ckgegeben. Es ist also nur wichtig,
	 * dass jeder der Buchstaben von "Gollum" mindestens einmal
	 * und in der richtigen Reihenfolge vorkommt.
	 * 
	 * weitere Beispiele:
	 * "GGOOLLUUMM" -> true
	 * "g o l l u m" -> true
	 * "g4oluml" -> false
	 * 
	 * m�glicher Tipp: Die Methode der Aufgabe 1 k�nnte hilfreich sein.
	 * 
	 * Lernziel(e): Methodenaufruf, Schleifen
	 * 
	 * Restriktion(en): Nur die String-Methoden "length()" und "charAt(idx)" d�rfen als
	 * externe Hilfsmethoden benutzt werden.
	 * 
	 * @param str
	 * @return
	 */
	public static boolean findeGollum(String str) {
		
		String target = "gollum";
		
		if (str.length() < target.length())
			return false;
		
		str = macheGrossbuchstabenKlein(str);
		
		int curTargetIdx = 0;
		char curTargetChar = target.charAt(curTargetIdx);
		char curChar;
		
		for ( int i=0; i < str.length(); i++ ) {
			
			curChar = str.charAt(i);
			
			if (curChar == curTargetChar) {
				
				curTargetIdx++;
				if (curTargetIdx == target.length()) {
					return true;
				}
				curTargetChar = target.charAt(curTargetIdx);
			}
		}
		
		return false;
	}

	/**
	 * Aufgabe 3: Implementiere f�r die Klasse
	 * "HerrDerStrings" noch eine Methode namens "z�hleDieRinge".
	 * Auch diese soll wieder �ffentlich und statisch sein und
	 * eine String-Variable als Parameter erhalten.
	 * In dem �bergebenen String soll das Vorkommen der
	 * Zeichenfolge "Ring" gez�hlt werden. Dabei ist es
	 * egal ob die einzelnen Buchstaben von "Ring" aufeinanderfolgend
	 * und/oder in der richtigen Reihenfolge stehen. Auch die
	 * Gro�- und Kleinschreibung spielt keine Rolle.
	 * Der R�ckgabewert der Funktion soll ein String-Array
	 * der L�nge 2 sein. An der ersten Stelle soll "n*Ring" eingetragen sein, wobei
	 * n die Anzahl von "Ring", in jeglicher Form, ist. An zweiter Stelle
	 * soll der urspr�nglich �bergebene String sein.
	 * 
	 * Beispiele:
	 * "Ring ignr" -> ["2*Ring", "Ring ignr"]
	 * "ing" -> ["0*Ring", "ing"]
	 * 
	 * m�glicher Tipp: Die Methode der Aufgabe 1 k�nnte hilfreich sein.
	 * 
	 * Lernziel(e): Methodenaufruf, Schleifen, Arrays, String aufbauen
	 * 
	 * Restriktion(en): Nur die String-Methoden "length()" und "charAt(idx)" d�rfen als
	 * externe Hilfsmethoden benutzt werden.
	 * 
	 * @param str
	 * @return
	 */
	public static String[] z�hleDieRinge(String str) {
		
		String strLowerCase = macheGrossbuchstabenKlein(str);
		
		char[] target = {'r', 'i', 'n', 'g'};
		int[] charCount = {0, 0, 0, 0};
		
		char curChar;
		
		// z�hlt die Anzahl der einzelnen Buchstaben von "Ring"
		for (int i = 0; i < strLowerCase.length(); i++) {
			
			curChar = strLowerCase.charAt(i);
			
			for (int j = 0; j < charCount.length; j++) {
				
				if ( curChar == target[j] ) {
					charCount[j]++;
				}
			}
		}
		
		return new String[]{smallestValue(charCount) +"*Ring", str};
	}
	
	private static int smallestValue(int[] values) {
		
		int smallestValue = -1;
		
		if (values.length > 0)
			smallestValue = values[0];
		
		for (int i = 1; i < values.length; i++) {
			
			if (values[i] < smallestValue) {
				smallestValue = values[i];
			}
		}
		
		return smallestValue;
	}
	
	/**
	 * Beim Testat oder als 4. Aufgabe k�nnte man z.B. fragen, wie man die
	 * "findeGollum" und "z�hleDieRinge" Methoden f�r
	 * variable Suchstrings umbauen k�nnte.
	 */
}
