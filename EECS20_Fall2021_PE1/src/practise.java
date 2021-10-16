
public class practise {
	
	
	
	public static void main(String[] args) {
		
		Engrave e = new Engrave();
		
		int value[] = new int[] {5, 12, 8 , 1, 10};
		int weight[] = new int[] {100, 200, 300, 400 , 500};
		int sum = e.cupSelection(weight, value, 600, 5);
		
		System.out.println(sum);
		
		
		int value2[] = new int[] {60, 50, 20};
		int weight2[] = new int[] {30, 30 , 10};
		System.out.println(e.cupSelection(weight2, value2,50, 3));
	}
	
	
	
}
