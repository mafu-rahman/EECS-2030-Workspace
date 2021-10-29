package Week6;

/**
 * This class creates an Animal.
 * @author Marzieh Ahmadzadeh
 *
 */
public class Animal {
	public String name;
	public String picturePath;
	
	/**
	 * This is the default constructor to create an object of Animal
	 */
	public Animal(){
		name = "";
		picturePath = "";
	}
	/**
	 * This is the constructor that creates an object of Animal by the given name and picture path
	 * @param name this is the name of the animal
	 * @param pict this is the path in which the picture of th animal is kept.
	 */
	public Animal(String name, String pict){
		this.name = name;
		picturePath = pict;
	}

	/**
	 * This method does not do anything meaningful. It is there for inheritance only.
	 */
	public void makeNoise(){
		System.out.println("This animal makes noise.");
	}

	/**
	 * This method does not do anything meaningful. It is there for inheritance only.
	 */
	public void eat(){
		System.out.println("This animal eats. What a surprise!");
	}
	
	/**
	 * This method does not do anything meaningful. It is there for inheritance only.
	 */
	public void sleep(){
		System.out.println("This animal sleeps well :)");
	}
	/**
	 * This method does not do anything meaningful. It is there for inheritance only.
	 */
	public void roam(){
		System.out.println("This animal roams.");
	}
}


/**
 * This class defines a Dog.
 * @author Marzieh Ahmadzadeh
 *
 */
class Dog extends Animal{
	
	/**
	 * This is the default constructor for this class. 
	 * It only changes the name of the animal to "Dog".
	 * It calls the overloaded super constructor that takes in two parameters. 
	 */
	public Dog (){
		super("dog", "");
	}

	/**
	 * This is an overloaded constructor for this class. 
	 * It calls the overloaded super constructor that takes in two parameters. 
	 */

	public Dog(String name, String path) {
		super(name, path);
	}
		
	/** 
	 * This method overrides the super.eat() method.
	 */
	@Override
	public void eat(){
		System.out.println("It is a " + name + " and loves to eat peanut butter.");
	}
	
	
	/** 
	 * This method overrides the super.makeNoise() method.
	 */
	@Override
	public void makeNoise(){
		System.out.println("It is a " + name + " and it whoofs");
	}
	/**
	 * This method overrides the super.roam method.
	 */
	@Override
	public void roam(){
		System.out.println("It roams around the kitchen");
	}
}

class Cat extends Animal{

	public Cat (){
		super("cat", "");
	}
	@Override
	public void eat(){
		System.out.println("It is a " + name + " and eats a mouse.");
	}
	@Override
	public void makeNoise(){
		System.out.println("It is a " + name + " and it meows");
	}
	@Override
	public void roam(){
		System.out.println("It roams around the garden");
	}
}


class Owl extends Animal {

	public Owl(){
		super("owl", "");
	}
	@Override
	public void eat(){
		System.out.println("It is an " + name + " and eats everything!");
	}
	@Override
	public void sleep(){
		System.out.print("The owl does not sleep at night! However,");
		super.sleep();
	}
	
}

