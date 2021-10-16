

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * A set of JUnit test cases to test engrave.java
 * 
 * @author Marzieh Ahmadzadeh
 *
 */
class EngraveTester {
	@Test
	void drawLineTest1() {
		Engrave e = new Engrave();
		e.drawLine (6, '4');
		boolean equal = e.charPrintCount == 8; 
		assertEquals(true, equal, "drawLine (6, '4'); is not correct");
	}

	@Test
	void drawLineTest4() {
		Engrave e = new Engrave();
		e.drawLine (0, 'A');
		boolean equal = e.charPrintCount == 2; 
		assertEquals(true, equal, "drawLine (0, 'A'); is not correct");
	}

	@Test
	void CupSelectiontest1() {
			int value[] = new int[] {60, 50, 20};
			int weight[] = new int[]  {30,  30 , 10};
			int result = Engrave.cupSelection(weight, value,50,  3);
			assertEquals(80, result, "80 expected but "+ result+ "is given");
	}
	
	@Test
	void drawIntervalTest1() {
		ArrayList<String> expected = new ArrayList<String>(); 
		expected.add("[1]"); 
		expected.add("[2]"); 
		expected.add("[1]"); 
		expected.add("[3]"); 
		expected.add("[1]"); 
		expected.add("[2]"); 
		expected.add("[1]"); 
		Engrave e = new Engrave();
		e.drawIntervals(3);
		boolean equal = true; 
		if (expected.size() == e.drawnObject.size()) {
			for (int i = 0; i < expected.size(); i++)
				if (expected.get(i).compareTo(e.drawnObject.get(i)) != 0) {
					equal = false;
					break;
				}
			
		}
		else 
			equal = false;
		assertEquals(true, equal, "drawIntervals(3) is not correct");
	}
	@Test
	void drawIntervalTest3() {
		Engrave e = new Engrave();
		e.drawIntervals(1);
		boolean equal = (e.drawnObject.size() == 1 && e.drawnObject.get(0).compareTo("[1]") == 0); 
		assertEquals(true, equal, "drawIntervals(1) is not correct");
	}
	@Test
	void engraveTest1() {
		Engrave e = new Engrave();
		e.engrave(5, 0);
		boolean equal = (e.drawnObject.size()== 1 && e.drawnObject.get(0).compareTo("[5, 0]") == 0); 
		assertEquals(true, equal, "engrave(5, 0) is not correct");
	}
	@Test
	void engraveTest2() {
		ArrayList<String> expected = new ArrayList<String>(); 
		expected.add("[2, 3]"); 
		expected.add("[1]"); 
		expected.add("[2, 2]"); 
		expected.add("[1]"); 
		expected.add("[2, 1]"); 
		expected.add("[1]"); 
		expected.add("[2, 0]");
		Engrave e = new Engrave();
		e.engrave(2, 3);
		boolean equal = e.drawnObject.size()== 7;
		if (equal) {
			for (int i = 0; i < expected.size(); i++)
				if (expected.get(i).compareTo(e.drawnObject.get(i)) != 0) {
					equal = false;
					break;
				}
			
		}

		assertEquals(true, equal, "engrave(2, 3) is not correct");
	}


	@Test
	void engraveTest4() {
		ArrayList<String> expected = new ArrayList<String>(); 
		expected.add("[0, 3]"); 
		expected.add("[0, 2]"); 
		expected.add("[0, 1]"); 
		expected.add("[0, 0]");

		Engrave e = new Engrave();
		e.engrave(0, 3);
		boolean equal = e.drawnObject.size() == 4;
		if (equal) {
			for (int i = 0; i < expected.size(); i++)
				if (expected.get(i).compareTo(e.drawnObject.get(i)) != 0) {
					equal = false;
					break;
				}
		}
		assertEquals(true, equal, "engrave(0, 3) is not correct");
	}
	

}
