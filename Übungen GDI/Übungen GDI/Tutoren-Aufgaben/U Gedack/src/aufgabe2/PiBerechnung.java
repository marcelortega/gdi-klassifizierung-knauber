package aufgabe2;

import static gdi.MakeItSimple.*; //Verwendet zur Ausgabe auf der Konsole (println)



/**
 * Dieses Programm berechnet Pi n�herungsweise �ber das wallissche Produkt.
 * Interessant zu sehen ist es, dass recht viele Durchl�ufe ben�tigt werden, um 
 * sich an Pi anzun�hern.
 */
public class PiBerechnung {

	
	
	/**
	 * Methode zur Berechnung von Pi mit dem wallissche Produkt.
	 * Als Parameter wird n �bergeben. n ist die Stelle, bis zu 
	 * der Pi angen�hert werden soll.
	 */
	public static double berechnePi (int n) {
		
		/* 
		 * Initialisierung der Start Variablen:
		 * Wir starten bei piHalbe=1 bzw. pi=1 (nicht bei 0
		 * wegen dem Produkt in der Formel) und n�hern uns
		 * dann an. 
		 */
		double piHalbe = 1, pi = 1;
		
		if(n!=0) {
		/*
		 * Wallisches Produkt:
		 * Pi / 2 = (2/1) * (2/3) * (4/3) * (4/5) * (6/5) *
		 * (6/7) * (8/7) * (8/9) * (10/9) * (10/11) * (12/11) ...
		 */
		for (double i=1, j=1; i<n; i++, j++) {
			/*
			 * Mit Modulo Pr�fen ob i gerade oder ungerade ist und
			 * dann die passende Variable um eins erh�hen vor dem Teilen.
			 */
			if(i % 2 == 0) {
				piHalbe = piHalbe * (j / (j+1));
				//println(j + "/" + (j+1));
			} else {
				piHalbe = piHalbe * ((j+1) / j);
				//println((j+1) + "/" + j);
			}
		}

		pi = 2 * piHalbe; //Es muss pi und nicht nur piHalbe zur�ck gegeben werden.
		return (pi); //Berechnetes Pi wird zur�ck gegeben.
		} else {
			return 0;
		}
			
	}//public static double berechnePi (int n)
	
	
	
	/**
	 * Methode zur mehrfachen Berechnung von Pi mit Hilfe der
	 * berechnePi Methode.
	 * Als Parameter wird n �bergeben, was die Anzahl an Durchl�ufen angibt.
	 */
	public static void zeigePi(int n) {
		
		for(int i = 1; i <= n; i++) {
			double berechnetesPi = berechnePi(i);
			println("Pi berechnet:          " + berechnetesPi);
			println("Math.PI:               " + Math.PI);
			//println("Differenz:             " + (Math.PI - berechnetesPi));
		}
		
	}//public static void zeigePi(int n)
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		println("Bis zu welchem Faktor (n) soll Pi bestimmt werden?: ");
		zeigePi(readInt());
		
	}//public static void main(String[] args)

	
	
}//public class PiBerechnung

