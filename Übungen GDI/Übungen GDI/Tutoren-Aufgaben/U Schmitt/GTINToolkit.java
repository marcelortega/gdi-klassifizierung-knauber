import static gdi.MakeItSimple.*;

public class GTINToolkit {

	public static void main(String[] args) {
		int checkDigit = 0;
		int realCheckDigit = 0;
		boolean isValidGTIN = false;


		//Tests fuer die Funktion computeGTINCheckDigit

		//Test fuer leeren String
		println("Teste Funktion computeGTINCheckDigit mit leerem String.");
		checkDigit = computeGTINCheckDigit("");

		if (checkDigit == -1) {
			println("Test erfolgreich.");
		} else {
			println("Test fehlgeschlagen.");
		}


		//Test fuer weniger als 12 Ziffern
		println("Teste Funktion computeGTINCheckDigit mit weniger als 12 Ziffern.");
		checkDigit = computeGTINCheckDigit("1-234567-8901");

		if (checkDigit == -1) {
			println("Test erfolgreich.");
		} else {
			println("Test fehlgeschlagen.");
		}

		checkDigit = computeGTINCheckDigit("1-234-8901");

		if (checkDigit == -1) {
			println("Test erfolgreich.");
		} else {
			println("Test fehlgeschlagen.");
		}


		//Test fuer mehr als 12 Ziffern
		println("Teste Funktion computeGTINCheckDigit mit mehr als 12 Ziffern.");
		checkDigit = computeGTINCheckDigit("1-234567-89011234");

		if (checkDigit == -1) {
			println("Test erfolgreich.");
		} else {
			println("Test fehlgeschlagen.");
		}

		checkDigit = computeGTINCheckDigit("1-232424244 8901");

		if (checkDigit == -1) {
			println("Test erfolgreich.");
		} else {
			println("Test fehlgeschlagen.");
		}


		//Testen, ob die richtigen Pruefziffern errechnet werden
		println("Teste, ob Funktion computeGTINCheckDigit die richtigen Pruefziffern errechnet.");
		realCheckDigit = 1;
		checkDigit = computeGTINCheckDigit("5 449000 09624");
		
		if (checkDigit == realCheckDigit) {
			println("Test erfolgreich.");
		} else {
			println("Test fehlgeschlagen.");
		}

		realCheckDigit = 3; 
		checkDigit = computeGTINCheckDigit("1 232 424 244 89");

		if (checkDigit == realCheckDigit) {
			println("Test erfolgreich.");
		} else {
			println("Test fehlgeschlagen.");
		}


		//----------------------------------------------------------------------------
		//Tests fuer die Funktion isGTINValid

		//Test fuer leeren String
		println("Teste Funktion isGTINValid mit leerem String.");
		isValidGTIN = isGTINValid("");

		if (!isValidGTIN) {
			println("Test erfolgreich.");
		} else {
			println("Test fehlgeschlagen.");
		}


		//Test fuer weniger als 12 Ziffern
		println("Teste Funktion isGTINValid mit weniger als 12 Ziffern.");
		isValidGTIN = isGTINValid("1-234567-8901");

		if (!isValidGTIN) {
			println("Test erfolgreich.");
		} else {
			println("Test fehlgeschlagen.");
		}

		isValidGTIN = isGTINValid("1-234-8901");

		if (!isValidGTIN) {
			println("Test erfolgreich.");
		} else {
			println("Test fehlgeschlagen.");
		}


		//Test fuer mehr als 12 Ziffern
		println("Teste Funktion isGTINValid mit mehr als 12 Ziffern.");
		isValidGTIN = isGTINValid("1-234567-89011234");

		if (!isValidGTIN) {
			println("Test erfolgreich.");
		} else {
			println("Test fehlgeschlagen.");
		}

		isValidGTIN = isGTINValid("1-232424244 8901");

		if (!isValidGTIN) {
			println("Test erfolgreich.");
		} else {
			println("Test fehlgeschlagen.");
		}


		//Testen, ob gueltige GTINs als gueltig erkannt werden
		println("Teste, ob gueltige GTINs als gueltig erkannt werden.");
		isValidGTIN = isGTINValid("123242424489-3"); 

		if (isValidGTIN) {
			println("Test erfolgreich.");
		} else {
			println("Test fehlgeschlagen.");
		}

		isValidGTIN = isGTINValid("6-35152 512512-4"); 

		if (isValidGTIN) {
			println("Test erfolgreich.");
		} else {
			println("Test fehlgeschlagen.");
		}


		//Testen, ob ungueltige GTINs als ungueltig erkannt werden
		println("Teste, ob ungueltige GTINs als ungueltig erkannt werden.");
		isValidGTIN = isGTINValid("6-35152 512512-1"); 

		if (!isValidGTIN) {
			println("Test erfolgreich.");
		} else {
			println("Test fehlgeschlagen.");
		}

		isValidGTIN = isGTINValid("6350 9522 6644-4");

		if (!isValidGTIN) {
			println("Test erfolgreich.");
		} else {
			println("Test fehlgeschlagen.");
		}
	}


	//berechnet die Pruefziffer fuer eine 12-stellige gtin 
	static int computeGTINCheckDigit(String gtin) {
		int checkDigit = -1;
		String purgedGTIN = "";
		
		purgedGTIN = purgeString(gtin); //gtin von Zeichen, die keine Ziffern sind, befreien

		//Pruefziffer kann nur berechnet werden, wenn uebergebene gtin genau 12 Ziffern hat
		if (strLen(purgedGTIN) == 12) { 
			checkDigit = computeCheckDigit(purgedGTIN);
		} 
		
		return checkDigit;
	}

	//prueft, ob die uebergebene gtin gueltig ist
	static boolean isGTINValid(String gtin) {
		int checkDigit = 0;
		String purgedGTIN = "";
		String purgedGTINShort = "";

		purgedGTIN = purgeString(gtin); //gtin von Zeichen, die keine Ziffern sind, befreien
		
		//Pruefziffer kann nur berechnet werden, wenn uebergebene gtin genau 13 Ziffern hat
		if (strLen(purgedGTIN) == 13) { 
			//pruefziffer von der uebergebenen gtin "abziehen", da nur die ersten 12 Ziffern zur Berechnung der Pruefziffer verwendet werden
			int pos = 0;
			
			while (pos < strLen(purgedGTIN)-1) {
				purgedGTINShort += strCharAt(purgedGTIN, pos);
				pos++;
			}

			//Pruefziffer berechnen
			checkDigit = computeCheckDigit(purgedGTINShort);

			//wenn die berechnete Pruefziffer der Pruefziffer am Ende der uebergebenen gtin entspricht, wird true zurueckgegeben  
			if (checkDigit == strCharAt(purgedGTIN, strLen(purgedGTIN)-1) - 48) { //die Dezimaldarstellung von char 0 ist 48
				return true;
			}
		} 
		return false;
	}
	
	//entfernt alle Zeichen aus dem String gtin, die keine Ziffern sind
	static String purgeString(String gtin) {
		String purgedGTIN = "";
		int pos = 0;

		while (pos < strLen(gtin)) {
			if (strCharAt(gtin, pos) >= '0' && strCharAt(gtin, pos) <= '9') {
				purgedGTIN += strCharAt(gtin, pos);
			}
			pos++;
		}
		
		return purgedGTIN;
	}
	
	//berechnet die Pruefziffer fuer eine 12 Ziffern lange gtin
	static int computeCheckDigit(String gtin) {
		int pos = 0;
		int sum = 0;
		
		while (pos < strLen(gtin)) {
			if (pos % 2 == 1) { //bei geraden Stellen mit 3 multiplizieren (eigentlich die ungeraden Stellen, weil strCharAt bei 0 anfaengt)
				sum += (strCharAt(gtin, pos) - 48) * 3; //die Dezimaldarstellung von char 0 ist 48
			} else { //bei ungeraden Stellen mit 1 multiplizieren (hier eigentlich die geraden Stellen)
				sum += strCharAt(gtin, pos) - 48;
			}
			pos++;
		}

		return 10 - (sum % 10); //die Pruefziffer ergaenzt die Summe zum naechstgroesseren Vielfachen von 10
	}
}