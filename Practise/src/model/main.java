package model;

public class main {

	public static void main(String[] args) {
		
		int x = 0;
		int y = 10;
		try {
			x = y/x;
			System.out.println("BBB");
		}
		catch(Exception e) {
			System.out.println("AAA");
		}
	}

}
