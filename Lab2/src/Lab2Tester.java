import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;





@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Lab2Tester {

	
	// sum
	
	@Test
	public void testSum1() {
		int start = 0;
		int end = 5; 
		int  sum= 0;
		for (int i = start ; i <= end ; i++) 
			sum  += i;
		
		assertEquals("Failed at sum (" + start + ", " + end + ")", sum, Lab2.sum(start, end));
			
	}
	@Test
	public void testSum2() {
		int start = -2;
		int end = 10; 
		int  sum= 0;
		for (int i = start ; i <= end ; i++) 
			sum  += i;
		
		assertEquals("Failed at sum (" + start + ", " + end + ")", sum, Lab2.sum(start, end));
			
	}
	
	@Test
	public void testSum3() {
		int start = 0;
		int end = 0; 
		int  sum= 0;
		for (int i = start ; i <= end ; i++) 
			sum  += i;
		
		assertEquals("Failed at sum (" + start + ", " + end + ")", sum, Lab2.sum(start, end));
			
	}
	

	@Test
	public void testMakeString1() {
		char init = '*'; 
		int n = 5;
		String result = ""; 
		for (int i = 0 ; i < n ; i++)
			result += init;
		assertEquals("Failed at makeString(" + init + ", " + n + ")", result, Lab2.makeString(init, n));	
	}
	
	@Test
	public void testMakeString2() {
		char init = '.'; 
		int n = 10;
		String result = ""; 
		for (int i = 0 ; i < n ; i++)
			result += init;
		assertEquals("Failed at makeString(" + init + ", " + n + ")", result, Lab2.makeString(init, n));	
	}
	
	@Test
	public void testMakeString3() {
		char init = 'A'; 
		int n = 0;
		String result = ""; 
		for (int i = 0 ; i < n ; i++)
			result += init;
		assertEquals("Failed at makeString(" + init + ", " + n + ")", result, Lab2.makeString(init, n));	
	}

	
	@Test
	public void testInterlace2() {

		String str = "*";
		assertEquals("Failed: interlace(\"*\",\"-\",1)", str, Lab2.interlace("*","-",1));
	}
	
	@Test
	public void testInterlace3() {

		String str = "Hello ";
		assertEquals("Failed: interlace(\"*\",\"-\",1)", str, Lab2.interlace("Hello ","World ",1));
	}
	
	@Test
	public void testInterlace4() {

		String str = "Mahfuz ";
		assertEquals("Failed: interlace(\"*\",\"-\",1)", str, Lab2.interlace("Mahfuz ","Rahman ",1));
	}

	

	@Test
	public void testGetSubstring1() {

		String str1 = "x + y + z - ( y * z) / 3 * n ";
		String result = " y * z";
		char open = '(';
		char close = ')';
		assertEquals("Failed: getSubstring(\"x + y + z - ( y * z) / 3 * n \", \"(\", \")\")", result, Lab2.getSubstring("x + y + z - ( y * z) / 3 * n ", '(', ')'));
	}
	//extra
	@Test
	public void testGetSubstring2() {

		String str1 = "This is a 'good' practice";
		String result = "good";
		char open = '"';
		char close = '"';
		assertEquals("Failed: getSubstring(\"This is a 'good' practice\", '\"', '\"')", result, Lab2.getSubstring2("This is a 'good' practice", '"', '"'));
	}

	@Test
	public void testDecimalToBinary4() {
		int decimal = 23; 
		String binary = "10111";
		assertEquals("Failed: decimalToBinary(23)", binary, Lab2.decimalToBinary(23));
	}
	
	@Test
	public void testDecimalToBinary5() {
		int decimal = 100; 
		String binary = "1100100";
		assertEquals("Failed: decimalToBinary(100)", binary, Lab2.decimalToBinary(100));
	}
	
	@Test
	public void testDecimalToBinary6() {
		int decimal = 0; 
		String binary = "0";
		assertEquals("Failed: decimalToBinary(0)", binary, Lab2.decimalToBinary(0));
	}
	
	@Test
	public void testDecimalToBinary7() {
		int decimal = 1; 
		String binary = "1";
		assertEquals("Failed: decimalToBinary(23)", binary, Lab2.decimalToBinary(1));
	}

}