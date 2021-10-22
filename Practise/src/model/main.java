package model;

public class main {

	public static void main(String[] args) {
		
		
		A obj1 = new A();
		A obj2 = new A(1, 1.1, false);
		B obj3 = new B();
		B obj4 = new A(1, 1.1, true);
		B obj5 = new B(1, 1.1, true);
		B obj6 = new B(2, 2.2, false, 'f');
		C obj7 = new C(2, 2.2, false, 'f');
		C obj8 = new C(2, 2.2, false);
	}

}
