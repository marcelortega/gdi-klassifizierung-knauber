package aufgabe3;

import java.io.IOException;
import static gdi.MakeItSimple.*;

public class LinesOfCode {
    
    static boolean insideComment = false;
    
    public static int countLines(String pfadZurDatei) throws IOException {
        
        int count = 0;
        String line;
        Object openFile = openInputFile(pfadZurDatei);
        
        while (!isEndOfInputFile(openFile)){
        	line = readLine(openFile);
        	if(!insideComment) {
        		insideComment = commentBeginning(line);
        	}
            if(isCountable(line, insideComment)) {
            	count +=1;
            }
            if(insideComment) {
        		insideComment = commentEnding(line);
        	}          
        }
        closeInputFile(openFile);
        return count;
    }

    private static boolean isCountable(String line, boolean insideComment) {
        return !line.trim().startsWith("//") && !insideComment && !line.trim().contentEquals("");
    }

    private static boolean commentBeginning(String line) {
        return line.trim().startsWith("/*");
    }

    private static boolean commentEnding(String line) {
        if(line.trim().contains("*/")) {
        	return false;
        } else {
        	return true;
        }
    }
    
    
    public static void main(String[] args) {
    	
    	try {
    		println("Bitte geben Sie den Pfad zur Java Quellcode Datei an:");
    		String pathToFile = readLine();
			println("Anzahl Lines of Code: " + countLines(pathToFile));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
		}
    	
    }
}