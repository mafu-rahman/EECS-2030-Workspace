package p1;

public class C extends A{

	public static void main(String[] args) {
		// This class is in the same package as class A
		
		C obj = new C(); 
		obj.useAttributes();

	}
	public void useAttributes() {
		/* Note that I do not create an object of A because 
		 * the attributes are inherited. 
		 */
		System.out.println("public attribute = " + x+ 
                           "\nPackage attribute = " + y+ 
                           "\nProtected attribute = "+ z);
		// Please note that t is not visible as it is private. 

		
	}

}
