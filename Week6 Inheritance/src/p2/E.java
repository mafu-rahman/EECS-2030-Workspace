package p2;
import p1.A;


public class E extends A {
	// This class is NOT in the same package as class A
	public static void main(String [] args) {
		E obj = new E(); 
		obj.useAttributes();
		
	}
	public void useAttributes() {
		/* Note that I do not create an object of A because 
		 * the attributes are inherited. 
		 */
		System.out.println("public attribute = " + x+ 
	                       "\nProtected attribute = "+ z);
		// Please note that y is not visible as it is package attribute. 
		// Please note that t is not visible as it is private. 
	}	
}

