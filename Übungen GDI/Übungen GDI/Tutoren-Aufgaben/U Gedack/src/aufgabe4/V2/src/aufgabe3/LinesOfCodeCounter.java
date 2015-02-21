package aufgabe3;

import static gdi.MakeItSimple.*;

public class LinesOfCodeCounter {
    
    boolean insideComment = false; //Befindet man sich beim Lesen innerhalb eines Kommentarblocks?
    
    public int countLines(String pfadZurDatei) {
        
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

    private boolean isCountable(String line, boolean insideComment) {
        return !line.trim().startsWith("//") && !insideComment && !line.trim().contentEquals("");
    }

    private boolean commentBeginning(String line) {
        return line.trim().startsWith("/*");
    }

    private boolean commentEnding(String line) {
        if(line.trim().contains("*/")) {
        	return false;
        } else {
        	return true;
        }
    }
    
   
}