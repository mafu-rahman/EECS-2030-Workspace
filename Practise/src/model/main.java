package model;

public class main {

	public static void main(String[] args) {
		
		int a=1, b=2, k=3;
		k = a++ + b++ +a-- - b-- - k--;
		
		System.out.println(k);
	}

}
