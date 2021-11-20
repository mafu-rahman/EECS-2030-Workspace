package model;

public class main {

	public static void main(String[] args) {

		Object obj1 = new Building(2, 2);
		Building obj2 = new Building(4, 3);
		Building obj3 = new Residential();
		Building obj4 = new Commercial(10, 2, 80.0);
		Building obj5 = new Townhouse(5, 1, 6);
		Building obj6 = new Detached();
		
		Residential obj7 = new Residential ();
		Residential obj8 = new Townhouse (5, 1, 6) ;
		Residential obj9 = new Detached();
		Object obj10 = new Townhouse(3, 2, 5) ;
		
		System.out.println(obj1);
		System.out.println(obj2);
		System.out. println(obj3);
		System.out.println(obj4);
		System.out.println(obj5);
		System.out.println(obj6);
		System.out.println(obj7);
		System.out.println(obj8);
		System.out.println(obj9);
		System.out.println(obj10);
		
		
		Superclass obj11 = new Subclass(3,4);
		Object[] obj22 = obj11.mainMethod();
		for(int i=0; i<obj22.length; i++) {
			System.out.println(obj22[i]);
		}
	}
}