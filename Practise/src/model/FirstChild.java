package model;

class FirstChild extends Parent{

	@Override
	public void secondOp() {
		System.out.println("F- 2");
	}
	public void thirdOp() {
		System.out.println("F- 3");
	}
	static FirstChild getInstance() {
		count++;
		System.out.println("Fcount- " + count);
		return new FirstChild();
	}	
}

class SecondChild extends Parent{

	@Override
	public void secondOp() {
		System.out.println("S- 2");
	}
	public void fourthOp() {
		System.out.println("S- 4");
	}
	public void fifthOp() {
		System.out.println("S- 5");
	}
	static SecondChild getInstance() {
		count = count +2;
		System.out.println("Scount- " + count);
		return new SecondChild();
	}
}

class FirstGrandChild extends FirstChild{
	@Override
	public void secondOp() {
		System.out.println("FG- 2");
	}
	
	public void thirdOp() {
		System.out.println("FG- 3");
	}
	public void fourthOp() {
		done = false;
		System.out.println("FG- 4");
	}
	static FirstGrandChild getInstance() {
		System.out.println("FGcount- "+count);
		count--;
		return new FirstGrandChild();
	}
}

abstract class Parent{
	boolean done;
	static int count;
	
	public void firstOp() {
		done = false;
		this.secondOp();
		this.thirdOp();
		this.fourthOp();
		this.fifthOp();
	}
	
	abstract public void secondOp();
	public void thirdOp() {
		System.out.println("P- 3");
	}
	public void fourthOp() {
		done = true;
		System.out.println("P- 4");
	}
	public void fifthOp() {
		System.out.println("P- 5");
	}
}