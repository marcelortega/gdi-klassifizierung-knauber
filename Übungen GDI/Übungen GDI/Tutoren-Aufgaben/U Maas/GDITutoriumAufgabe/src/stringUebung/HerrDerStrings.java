package stringUebung;

public class HerrDerStrings {
	
	/**
	 * Aufgabe 1: Erstelle eine Klasse namens "HerrDerStrings".
	 * Implementiere für diese Klasse eine öffentliche und statische Methode
	 * mit dem Namen "macheGrossbuchstabenKlein". Diese Funktion
	 * hat genau eine String-Variable als Parameter. In
	 * dieser Funktion sollen alle Großbuchstaben 'A' - 'Z'
	 * und auch alle großgeschriebenen Umlaute 'Ö', 'Ü' und 'Ä'
	 * in Kleinbuchstaben umgewandelt werden. Alle anderen
	 * Zeichen dürfen nicht verändert werden. Der bearbeitete
	 * String wird am Ende zurückgegeben und darf keine Großbuchstaben
	 * mehr enthalten.
	 * 
	 * Lernziel(e): Zeichen, Arrays, Schleifen, String aufbauen
	 * 
	 * Restriktion(en): Nur die String-Methoden "length()" und "charAt(idx)" dürfen als
	 * externe Hilfsmethoden benutzt werden.
	 * 
	 * @param str
	 * @return
	 */
	public static String macheGrossbuchstabenKlein(String str) {
		
		char[] umlauteGross = { 'Ö', 'Ü', 'Ä' };
		char[] umlauteKlein = { 'ö', 'ü', 'ä' };
		
		String lowerCaseStr = "";
		
		char curChar;
		
		for (int i = 0; i < str.length(); i++) {
			
			curChar = str.charAt(i);
			
			// "großes" Alphabet ohne Umlaute
			if ( (curChar >= 'A' && curChar <= 'Z') ) {
				
				// falls die Typumwandlung noch nicht erlaubt ist
				// könnte man es auch wie bei den Umlauten lösen.
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
	 * Aufgabe 2: Implementiere für die Klasse
	 * "HerrDerStrings" eine weitere Methode namens "findeGollum".
	 * Auch diese soll wieder öffentlich und statisch sein und
	 * eine String-Variable als Parameter erhalten. Diese Methode
	 * soll true liefern, wenn in dem übergebenen String folgende
	 * Zeichenfolge enthalten ist: "Gollum". Dabei spielt die
	 * Groß- und Kleinschreibung keine Rolle. Desweiteren
	 * müssen die einzelnen Buchstaben von "Gollum" nicht direkt
	 * nacheinander folgen. So wird z.B. auch bei diesem String
	 * " g5o5ll5u5m?_" true zurückgegeben. Es ist also nur wichtig,
	 * dass jeder der Buchstaben von "Gollum" mindestens einmal
	 * und in der richtigen Reihenfolge vorkommt.
	 * 
	 * weitere Beispiele:
	 * "GGOOLLUUMM" -> true
	 * "g o l l u m" -> true
	 * "g4oluml" -> false
	 * 
	 * möglicher Tipp: Die Methode der Aufgabe 1 könnte hilfreich sein.
	 * 
	 * Lernziel(e): Methodenaufruf, Schleifen
	 * 
	 * Restriktion(en): Nur die String-Methoden "length()" und "charAt(idx)" dürfen als
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
	 * Aufgabe 3: Implementiere für die Klasse
	 * "HerrDerStrings" noch eine Methode namens "zähleDieRinge".
	 * Auch diese soll wieder öffentlich und statisch sein und
	 * eine String-Variable als Parameter erhalten.
	 * In dem übergebenen String soll das Vorkommen der
	 * Zeichenfolge "Ring" gezählt werden. Dabei ist es
	 * egal ob die einzelnen Buchstaben von "Ring" aufeinanderfolgend
	 * und/oder in der richtigen Reihenfolge stehen. Auch die
	 * Groß- und Kleinschreibung spielt keine Rolle.
	 * Der Rückgabewert der Funktion soll ein String-Array
	 * der Länge 2 sein. An der ersten Stelle soll "n*Ring" eingetragen sein, wobei
	 * n die Anzahl von "Ring", in jeglicher Form, ist. An zweiter Stelle
	 * soll der ursprünglich übergebene String sein.
	 * 
	 * Beispiele:
	 * "Ring ignr" -> ["2*Ring", "Ring ignr"]
	 * "ing" -> ["0*Ring", "ing"]
	 * 
	 * möglicher Tipp: Die Methode der Aufgabe 1 könnte hilfreich sein.
	 * 
	 * Lernziel(e): Methodenaufruf, Schleifen, Arrays, String aufbauen
	 * 
	 * Restriktion(en): Nur die String-Methoden "length()" und "charAt(idx)" dürfen als
	 * externe Hilfsmethoden benutzt werden.
	 * 
	 * @param str
	 * @return
	 */
	public static String[] zähleDieRinge(String str) {
		
		String strLowerCase = macheGrossbuchstabenKlein(str);
		
		char[] target = {'r', 'i', 'n', 'g'};
		int[] charCount = {0, 0, 0, 0};
		
		char curChar;
		
		// zählt die Anzahl der einzelnen Buchstaben von "Ring"
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
	 * Beim Testat oder als 4. Aufgabe könnte man z.B. fragen, wie man die
	 * "findeGollum" und "zähleDieRinge" Methoden für
	 * variable Suchstrings umbauen könnte.
	 */
}
