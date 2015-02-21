
import gdi.MakeItSimple;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

public class TestEaster {
	
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
	
	public static void assertEaster( int day, int month, int year ) {
		initInput(year + "\n");
		Easter.main(null);
		String res = finishInput();
		String beforeDate = res.split("[0-9]\\.[0-9]\\.")[0];
		String date = res.substring(beforeDate.length() - 1);
		String[] dateArray = date.split("\\.");
		int calcDay = Integer.parseInt(dateArray[0].trim());
		int calcMonth = Integer.parseInt(dateArray[1].trim());
		if (day != calcDay || month != calcMonth) {
			System.err.println(String.format("Falsches Ergebnis: %1$d.%2$d.%3$d (korrekt: %4$d.%5$d.)", 
					calcDay, calcMonth, year, day, month));
			signalError();
		}
	}
	
	public static void main( String[] args ) {
		assertEaster(19, 4, 1981);
		assertEaster(11, 4, 1982);
		assertEaster( 3, 4, 1983);
		assertEaster(22, 4, 1984);
		assertEaster( 7, 4, 1985);
		assertEaster(30, 3, 1986);
		assertEaster(19, 4, 1987);
		assertEaster( 3, 4, 1988);
		assertEaster(26, 3, 1989);
		assertEaster(15, 4, 1990);
		assertEaster(31, 3, 1991);
		
		assertEaster( 8, 4, 2007);
		assertEaster(23, 3, 2008);
		assertEaster(12, 4, 2009);
		if (!isErrorSignalled())
			System.out.println("Alles richtig erkannt");
	}
	
}
