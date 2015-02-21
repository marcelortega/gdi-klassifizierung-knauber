

import gdi.MakeItSimple;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

public class TestZahlenPalindrom {
	
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
	
	private static void assertPalindrom( int number ) {
		initInput(number + "\n");
		
		ZahlenPalindrom.main(null);
		
		if (!finishInput().contains("ist ein Palindrom")) {
			System.err.println("Fehler oder zweifelhafte Ausgabe bei der Zahl '" + number + "' (ist ein Palindrom).");
			signalError();
		}
	}
	
	private static void assertNoPalindrom( int number ) {
		initInput(number + "\n");
		
		ZahlenPalindrom.main(null);
		
		if (!finishInput().contains("ist kein Palindrom")) {
			System.err.println("Fehler oder zweifelhafte Ausgabe bei der Zahl '" + number + "' (ist kein Palindrom).");
			signalError();
		}
	}
	
	public static void main( String[] args ) {
		assertPalindrom(0);
		assertPalindrom(1);
		assertPalindrom(121);
		assertPalindrom(324353423);
		assertPalindrom(1243553421);
		assertNoPalindrom(12);
		assertNoPalindrom(1243563421);
		assertNoPalindrom(324356423);
		assertNoPalindrom(324353623);
		assertNoPalindrom(324353463);
		assertNoPalindrom(324353426);
		if (!isErrorSignalled())
			System.out.println("Alle Zahlen richtig erkannt.");
	}
	
}
