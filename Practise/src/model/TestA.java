package model;

public class TestA {
	public static int n = 0;
	public int m = 0;
		
	public TestA() {
		n++;
		m++;
	}
		
	public int getBoth() {
		return n + m;
	}
}
