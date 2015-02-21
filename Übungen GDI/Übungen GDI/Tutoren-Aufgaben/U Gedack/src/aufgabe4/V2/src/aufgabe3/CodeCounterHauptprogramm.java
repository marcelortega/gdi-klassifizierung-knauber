package aufgabe3;

import static gdi.MakeItSimple.println;
import static gdi.MakeItSimple.readLine;

public class CodeCounterHauptprogramm {

    public static void main(String[] args) {
    	
    		println("Bitte geben Sie den Pfad zur Java Quellcode Datei an:");
    		String pathToFile = readLine();
			LinesOfCodeCounter locc = new LinesOfCodeCounter(); 
    		println("Anzahl Lines of Code: " + locc.countLines(pathToFile));
			
		}
    	
}
	

