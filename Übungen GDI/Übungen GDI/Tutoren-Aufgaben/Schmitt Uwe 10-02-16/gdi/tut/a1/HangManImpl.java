package gdi.tut.a1;

import gdi.tut.hangman.interfaces.HangManGame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class HangManImpl implements HangManGame {

	protected char[] searchField;
	protected String selectedWord;
	protected String[] dictonary;
	protected int state;
	protected int numFailures;

	final static private int STATE_RUNNING = 1;
	final static private int STATE_LOST = 2;
	final static private int STATE_WON = 3;

	public HangManImpl(String dictPath) {
		super();
		loadDictonary(dictPath);
		start();
	}

	protected void loadDictonary(String dictPath) {
		// dictonary = new String[0];
		List<String> tmpDictonary = new ArrayList<String>();
		File dictFile = new File(dictPath);

		System.out.println("File exists");
		System.out.println(dictFile);

		// throw new RuntimeException("Could not find dictionary file " +
		// dictFile);
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(dictFile));
			String line = "";
			while ((line = reader.readLine()) != null) {
				tmpDictonary.add(line.trim());
			}
			reader.close();
		} catch (Exception e) {
			throw new RuntimeException(
					"Hangman: Fehler beim Initialisieren des Dictionarys.", e);
		}

		this.dictonary = tmpDictonary.toArray(new String[1]);
	}

	@Override
	public void addChar(char c) {
		if (this.state == STATE_RUNNING) {
			boolean found = false;
			for (int i = 0; i < this.selectedWord.length(); i++) {
				if (Character.toLowerCase(c) == Character
						.toLowerCase(this.selectedWord.charAt(i))) {
					this.searchField[i] = this.selectedWord.charAt(i);
					found = true;
				}
			}
			if (!found) {
				this.numFailures += 1;
			}
			computeState();
		}
	}

	private void computeState() {
		System.out.println("computeState()");

		System.out.println("numFailures=" + this.numFailures);
		if (this.numFailures == MAX_FAILURES) {
			System.out.println("lost");
			this.searchField = this.selectedWord.toCharArray();
			this.state = STATE_LOST;
		} else if (new String(this.searchField).equals(this.selectedWord)) {
			System.out.println("won");
			this.state = STATE_WON;
		}
		System.out.println("state=" + this.state);
	}

	@Override
	public String getSearchField() {
		return new String(this.searchField);
	}

	@Override
	public void start() {
		initStateAndNumFailures();
		selectNewWord();
		initSearchField();
	}

	protected void initStateAndNumFailures() {
		this.state = STATE_RUNNING;
		this.numFailures = 0;
	}

	private void selectNewWord() {
		// select new word
		int numWords = this.dictonary.length;
		double rand = Math.random();
		// System.out.println(rand);
		int wordIndex = (int) (rand * numWords);
		// System.out.println(wordIndex);
		this.selectedWord = this.dictonary[wordIndex];
		
	}

	protected void initSearchField() {
		// init searchField by '_'
		this.searchField = new char[this.selectedWord.length()];
		for (int i = 0; i < this.selectedWord.length(); i++) {
			this.searchField[i] = HIDDEN_CHAR;
		}
	}

	@Override
	public boolean won() {
		if (this.state == STATE_WON) {
			return true;
		}
		return false;
	}

	@Override
	public boolean lost() {
		if (this.state == STATE_LOST) {
			return true;
		}
		return false;
	}

	@Override
	public int getNumFailures() {
		return this.numFailures;
	}
}
