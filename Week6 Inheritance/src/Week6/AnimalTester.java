package Week6;


public class AnimalTester {
	public static void main(String[] args) {
		Dog myPet = new Dog();
		Dog yourPet = new Dog("Joe", "C:/pictures/Joe.jif");
		myPet.makeNoise();
		// please note: class Dog does not have sleep() method. it gets it from its superclass.
		yourPet.sleep();
		// an owl has its overridden method, while it calls the super method as well. 
		Owl firstOwl = new Owl();
		firstOwl.sleep();
		
	}

}
