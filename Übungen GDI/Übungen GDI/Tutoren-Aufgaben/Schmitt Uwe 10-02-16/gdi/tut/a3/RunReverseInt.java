package gdi.tut.a3;

import static gdi.MakeItSimple.*;
import static gdi.tut.a3.IntUtil.*;

public class RunReverseInt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		print("Geben Sie einen Integer ein: ");
		int input = readInt();
		readLine();
		int rInput = reverseInt(input);
		print("Umgedrehte Zahl: "+rInput);
	}

}
