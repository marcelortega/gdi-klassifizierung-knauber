package uebung02;

import static gdi.MakeItSimplePrivate.*;
import static gdi.TestSupport.*;

public class TestEaster {
	
	public static void assertEaster( int day, int month, int year, String packageAndClassName ) {
		startLog();
		supplyReadIntValues(year);
		supplyReadLineValues("");
		
		runMainMethod(packageAndClassName);
		
		String res = stopAndGetLog();
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
		assertPackageAndClassNamePresent(args);
		assertCorrectPassword("gDi");
		assertEaster(19, 4, 1981, args[0]);
		assertEaster(11, 4, 1982, args[0]);
		assertEaster( 3, 4, 1983, args[0]);
		assertEaster(22, 4, 1984, args[0]);
		assertEaster( 7, 4, 1985, args[0]);
		assertEaster(30, 3, 1986, args[0]);
		assertEaster(19, 4, 1987, args[0]);
		assertEaster( 3, 4, 1988, args[0]);
		assertEaster(26, 3, 1989, args[0]);
		assertEaster(15, 4, 1990, args[0]);
		assertEaster(31, 3, 1991, args[0]);
		
		assertEaster( 8, 4, 2007, args[0]);
		assertEaster(23, 3, 2008, args[0]);
		assertEaster(12, 4, 2009, args[0]);
		if (!isErrorSignalled())
			System.out.println("Alles richtig erkannt");
	}
	
}
