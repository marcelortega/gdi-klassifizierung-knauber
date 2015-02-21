package gdi.tut.a3;

public class IntUtil {

	public static int reverseInt(int num) {
		int sign = 1;
		// Berücksichtigung von negativen Zahlen
		if(num < 0) {
			sign = -1;
		}
		return sign * reverseInt(0, sign * num);
	}
	
	private static int reverseInt(int sum, int rest) {
		// Solange noch ein Rest da is, wird die bisherige Summe um eine Stellen erweitert
		if(rest > 0) {
			sum = sum*10;
		} 
		
		if(rest >= 10) {
			int mod = rest % 10;	// Letzte Stelle filtern
			int div = rest / 10;	// Rest (ohne letzte Stelle) berechnen
			sum = sum + mod;
			return reverseInt(sum,div);
		} else {	// Abbruchbedingung ( nur noch eine Ziffer )
			return sum + rest;
		}
	}
}
