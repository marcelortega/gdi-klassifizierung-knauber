/**
 * Durch Ändern von
 *     SiebDesEratosthenes.main(null);
 * in
 *     PrimzahlMitSchleifen.main(null);
 * kann auch Aufgabe 1 geprüft werden.
 */

import gdi.MakeItSimple;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class TestSiebDesEratosthenes {
	
	private static Method setConsole;
	private static PrintStream console;
	private static ByteArrayOutputStream out;
	public static void initInput( String input ) {
		console = System.out;
		out = new ByteArrayOutputStream();
		try {
			setConsole = MakeItSimple.class.getDeclaredMethod("setConsoleOut", Object.class);
			setConsole.setAccessible(true);
			setConsole.invoke(null, new PrintStream(out));
		} catch (Exception e) {
			// die Methode existiert!
		}
		System.setIn(new ByteArrayInputStream(input.getBytes()));
	}
	public static String finishInput() {
		try {
			setConsole.invoke(null, console);
		} catch (Exception e) {
			// die Methode existiert!
		}
		return out.toString();
	}
	
	private static boolean errorFound;
	public static void resetError() {
		errorFound = false;
	}
	public static void signalError() {
		errorFound = true;
	}
	public static boolean isErrorSignalled() {
		return errorFound;
	}
	
/////////////////////////////////////////////////////////////////////
	
	private static int[] prim = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
	
	/**
	 * Die Methode prüft, ob bis zur angegebenen Zahl n inklusive
	 * alle Primzahlen richtig berechnet wurden
	 */
	private static void assertPrim( int n ) {
		System.out.println("Test auf die Zahl " + n);
		initInput(n + "\n");
		SiebDesEratosthenes.main(null);
		String res = finishInput();
		ArrayList<Integer> calculated = toInt(res);
		System.out.println("  berechnet: " + calculated);
		
		// Position der Zahl <= n im Array bestimmen
		int primIndex = prim.length - 1;
		while (primIndex > 0 && prim[primIndex] > n) {
			primIndex--;
		}
		
		/* Inhalt von Soll- und berechneter Liste werden miteinander
		 * verglichen und Abweichungen ausgegeben.
		 */
		int pi = 0, c = 0;
		while (pi <= primIndex && c < calculated.size()) {
			if (prim[pi] > calculated.get(c)) {
				// eine Zahl zuviel berechnet
				System.out.println("  ## fehlerhafte Primzahl: " + calculated.get(c));
				signalError();
				c++;
			} else if (prim[pi] < calculated.get(c)) {
				// eine Zahl zuwenig berechnet
				System.out.println("  ## fehlende Primzahl: " + prim[pi]);
				signalError();
				pi++;
			} else {
				// beide Zahlen gleich: gut!
				pi++;
				c++;
			}
		}
		if (pi <= primIndex && !calculated.isEmpty()) {
			System.out.println("  ## nicht alle Primzahlen gefunden");
			signalError();
		} else if (c < calculated.size()) {
			System.out.println("  ## zu viele Primzahlen gefunden");
			signalError();
		}
		System.out.println();
	}
	
	/**
	 * Die Methode liefert eine ArrayList mit allen ganzen Zahlen,
	 * die im angegebenen String enthalten sind. Es werden keine
	 * Bereichsüberprüfungen durchgeführt.<br>
	 * Achtung: Eventuell enthält die Eingaeaufforderung eine Zahl,
	 * die dann mitgeliefert und geprüft wird!
	 */
	private static ArrayList<Integer> toInt( String s ) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int start = 0, end;
		
		while (start < s.length()) {
			while (start < s.length() && !(s.charAt(start) >= '0' && s.charAt(start) <= '9'))
				start++;
			if (start < s.length()) {
				// es gibt noch eine Zahl
				end = start + 1;
				while (end < s.length() && s.charAt(end) >= '0' && s.charAt(start) <= '9')
						end++;
				// Zahl gefunden
				res.add(Integer.parseInt(s.substring(start, end)));
				start = end;
			}
		}
		return res;
	}
	
	/**
	 * Verschiedene (nicht zu große) Zahlen als Eingabe für die
	 * Primzahlberechnung vorsehen
	 */
	public static void main( String[] args ) {
		assertPrim(0);
		assertPrim(1);
		assertPrim(2);
		assertPrim(3);
		assertPrim(4);
		assertPrim(30);
		assertPrim(31);
		if (!isErrorSignalled())
			System.out.println("Alles richtig berechnet");
	}
	
}
