package aufgabe3;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class LinesOfCodeTest {

	@Test
	public void testCountLines() throws IOException {
		assertEquals(10, LinesOfCode.countLines("src/aufgabe3/TestDateiZumZaehlen.java"));
	}

}
