package uebung08;

import static gdi.MakeItSimple.*;
import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Test;

public class Date1stTest {
	
	@After
	public void cleanUp() throws Exception {
		File f = new File("datei.txt");
		if (f.exists())
			f.delete();
	}
	
	@Test
	public void testToString() throws Exception {
		assertEquals("11.12.2013",  new DateImpl(11, 12,  2013).toString());
	}
	
	@Test
	public void isWeekBeforeWithinMonth() throws Exception {
		// innerhalb eines Monats
		assertFalse(new DateImpl(10, 5, 2007).isWeekBefore(18, 5));
		assertTrue( new DateImpl(11, 5, 2007).isWeekBefore(18, 5));
		assertTrue( new DateImpl(18, 5, 2011).isWeekBefore(18, 5));
		assertFalse(new DateImpl(19, 5, 2011).isWeekBefore(18, 5));
	}
	
	@Test
	public void isWeekBeforeInNonLeapYears() throws Exception {
		// Februar-Übergang im Schaltjahr
		assertFalse(new DateImpl(24, 2, 2008).isWeekBefore(3, 3));
		assertTrue( new DateImpl(25, 2, 2008).isWeekBefore(3, 3));
		assertTrue( new DateImpl( 3, 3, 2008).isWeekBefore(3, 3));
		assertFalse(new DateImpl( 4, 3, 2008).isWeekBefore(3, 3));
	}
	
	@Test
	public void writeAndRead() throws Exception {
		Object out = openOutputFile("datei.txt");
		new DateImpl(2, 3, 2004).saveToFile(out);
		closeOutputFile(out);
		Object in = openInputFile("datei.txt");
		DateImpl date1 = new DateImpl();
		date1.loadFromFile(in);
		closeInputFile(in);
		
		assertEquals("02.03.2004", date1.toString());
	}

}
