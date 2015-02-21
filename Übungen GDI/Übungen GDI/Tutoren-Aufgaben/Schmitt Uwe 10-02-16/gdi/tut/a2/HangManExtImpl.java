package gdi.tut.a2;

import gdi.tut.a1.HangManImpl;
import gdi.tut.hangman.interfaces.HangManGameExt;

public class HangManExtImpl extends HangManImpl implements HangManGameExt{

	public HangManExtImpl(String dictPath) {
		super(dictPath);
	}

	@Override
	public void start(String word) {
		initStateAndNumFailures();
		this.selectedWord = word;
		initSearchField();
	}
}
