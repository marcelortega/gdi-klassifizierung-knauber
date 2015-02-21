package aufgabe4;

import static org.junit.Assert.*;
import org.junit.Test;


public class EinfachesLabyrinthTest {

	String[][] testLabyrinth = {	
			{"#","#","#","#","#","#","#","#","#","#"},
			{"#"," "," "," "," "," "," "," "," ","#"},
			{"#"," ","#","#","#","#","#","#"," ","#"},
			{"#"," "," "," "," "," ","#","#"," ","#"},
			{"#","#","#","#","#"," ","#","#"," ","A"},
			{"#"," "," "," ","#"," ","#","#","#","#"},
			{"#"," ","#"," ","#"," "," "," "," ","#"},
			{"#"," ","#"," ","#","#","#","#"," ","#"},
			{"#"," ","#"," "," "," "," "," "," ","#"},
			{"#","E","#","#","#","#","#","#","#","#"},
		};


	/*
	 * Zufall lässt sich schwer testen, aber bei mehrfach durchgeführten 
	 * Tests kann man einen Trend erkennen. Daher wird die setzeSpielfigurZufaellig
	 * Methode 100 mal getestet und man kann dann erwarten, dass nicht öfters
	 * als 1000 mal das gleiche Ergebnis kommt.
 	 */
	
	@Test
	public void testSetzeSpielfigurZufaelligVergleichXachse() {	
		int errorCount = 0;
		for(int i = 0; i<1000; i++) {
			if(EinfachesLabyrinth.setzeSpielfigurZufaellig(EinfachesLabyrinth.labyrinth)[0] == EinfachesLabyrinth.setzeSpielfigurZufaellig(EinfachesLabyrinth.labyrinth)[0]) {
				errorCount++;
			}
		}	
		assertFalse(errorCount<100);
	}
	
	@Test
	public void testSetzeSpielfigurZufaelligVergleichYachse() {
		int errorCount = 0;
		for(int i = 0; i<1000; i++) {
			if(EinfachesLabyrinth.setzeSpielfigurZufaellig(EinfachesLabyrinth.labyrinth)[1] == EinfachesLabyrinth.setzeSpielfigurZufaellig(EinfachesLabyrinth.labyrinth)[1]) {
				errorCount++;
			}
		}	
		assertFalse(errorCount<100);
	}
	
	@Test
	public void testLaufeNachRechtsOhneHindernis() {
		int[] positionOld = {1,1};
		assertTrue(EinfachesLabyrinth.laufeRechts(positionOld, testLabyrinth));
		//EinfachesLabyrinth.zeichneLabyrinth(testLabyrinth);
	}
	
	@Test
	public void testLaufeNachRechtsMitHindernis() {
		//Hinderniss erkennen:
		int[] positionOld = {1,8};
		assertFalse(EinfachesLabyrinth.laufeRechts(positionOld, testLabyrinth));
		//EinfachesLabyrinth.zeichneLabyrinth(testLabyrinth);
	}
	
	@Test
	public void testLaufeNachLinksOhneHindernis() {
		int[] positionOld = {1,8};
		assertTrue(EinfachesLabyrinth.laufeLinks(positionOld, testLabyrinth));
		//EinfachesLabyrinth.zeichneLabyrinth(testLabyrinth);

	}
	
	@Test
	public void testLaufeNachLinksMitHindernis() {
		//Hinderniss erkennen:
		int[] positionOld = {1,1};
		//EinfachesLabyrinth.zeichneLabyrinth(testLabyrinth);
		assertFalse(EinfachesLabyrinth.laufeLinks(positionOld, testLabyrinth));
	}

	@Test
	public void testLaufeAufwaertsOhneHindernis() {
		int[] positionOld = {2,8};
		assertTrue(EinfachesLabyrinth.laufeAufwaerts(positionOld, testLabyrinth));
		//EinfachesLabyrinth.zeichneLabyrinth(testLabyrinth);

	}
	
	@Test
	public void testLaufeAufwaertsMitHindernis() {
		//Hinderniss erkennen:
		int[] positionOld = {1,1};
		//EinfachesLabyrinth.zeichneLabyrinth(testLabyrinth);
		assertFalse(EinfachesLabyrinth.laufeAufwaerts(positionOld, testLabyrinth));
	}
	
	@Test
	public void testLaufeAbwaertsOhneHindernis() {
		int[] positionOld = {2,1};
		assertTrue(EinfachesLabyrinth.laufeAbwaerts(positionOld, testLabyrinth));
		//EinfachesLabyrinth.zeichneLabyrinth(testLabyrinth);

	}
	
	@Test
	public void testLaufeAbwaertsMitHindernis() {
		//Hinderniss erkennen:
		int[] positionOld = {3,1};
		//EinfachesLabyrinth.zeichneLabyrinth(testLabyrinth);
		assertFalse(EinfachesLabyrinth.laufeAbwaerts(positionOld, testLabyrinth));
	}

}
