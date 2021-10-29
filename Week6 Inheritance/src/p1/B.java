package p1;

public class B {
	public static void main(String[] args) {
		// class A is in the same package as class A
		A obj = new A(); 
		System.out.println("public attribute = " + obj.x + 
				            "\nPackage attribute = " + obj.y+ 
				            "\nProtected attribute = "+ obj.z);
		// Please note that obj.t is not visible as it is private. 
	}

}
