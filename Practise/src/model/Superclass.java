package model;

public class Superclass {
	int first;
	int second;
	public Superclass() {
		first = 0;
		second = 0;
	}
	public Superclass(int f, int s) {
		first = f;
		second = s;
	}
	public Object[] mainMethod() {
		Object[] obj = new Object[5];
		obj[0] = this.methodA(5);
		obj[1] = this.methodB(4);
		obj[2] = this.methodC();
		obj[3] = this.methodD();
		obj[4] = this.methodE(3);
		return obj;
	}
	
	public static int methodA(int x) {
		return x+1;
	}
	private int methodB(int x) {
		return x+first;
	}
	public final int methodC() {
		return first + second;
	}
	public int methodD(){
		return first - second;
	}
	
	public int methodE(int x) {
		return first + second - x;
	}
}

class Subclass extends Superclass{
	public Subclass(int f, int s) {
		first = f;
		second = s;	
	}
	public static int methodA(int x) {
		return x-1;
	}
	private int methodB(int x) {
		return x-first;
	}
	private final int methodC(int x) {
		return first - second + x;
	}
	public int methodD() {
		return first * second;
	}
	public int methodE(int x) {
		return first * x;
	}
}