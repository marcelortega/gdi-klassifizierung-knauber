
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class HangManImpl implements HangManGame {

	private static final String FILENAME = "hangman.txt";
	protected char[] searchField;
	protected String selectedWord;
	protected String[] dictonary;
	protected int state;
	protected int numFailures;

	final static private int STATE_RUNNING = 1;
	final static private int STATE_LOST = 2;
	final static private int STATE_WON = 3;

	public HangManImpl() {
		super();
		loadDictonary();
		start();
	}

	protected void loadDictonary() {
		// dictonary = new String[0];
		List<String> tmpDictonary = new ArrayList<String>();
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(FILENAME));
			String line = in.readLine();
			while (line != null) {
				tmpDictonary.add(line);
				line = in.readLine();
			}
			in.close();
		} catch (Exception e) {
			throw new RuntimeException(
					"Fehler beim Initialisieren des Dictionarys: " + e.getMessage());
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
		if (this.numFailures == MAX_FAILURES) {
			this.searchField = this.selectedWord.toCharArray();
			this.state = STATE_LOST;
		} else if (new String(this.searchField).equals(this.selectedWord)) {
			this.state = STATE_WON;
		}
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
		int wordIndex = (int) (rand * numWords);
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
