package p2;

import p1.A;

public class D {
	public static void main(String[] args) {
		// class A is NOT in the same package as class A
		A obj = new A(); 
		System.out.println("public attribute = " + obj.x);
		// Please note that obj.y is not visible as it is package attribute. 
		// Please note that obj.z is not visible as it is protected. 
		// Please note that obj.t is not visible as it is private. 
	}


}
