package model;

public class A{
	
	protected int a1;
	protected double a2;
	protected boolean a3;
	public A(){
		a1 = 0;
		a2 = 0;	
		a3 = false;
		System.out.println("A's Default Constructor. ");
	}
	public A(int a1, double a2, boolean a3) {
		this.a1 = a1;
		this.a2 = a2;
		this. a3 = a3;	
		System. out.println("A's Overloaded Constructor. ");
	}
}
	class B extends A{
		protected char b1;
		public B() {
		b1 = ' ';
		System.out.println("B's Default Constructor.");
	}
	
	public B(int al, double a2, boolean a3, char b1) {
		this.a1 = a1;
		this. a2 = a2;
		this.a3 = a3;
		this.b1 = b1;
		System.out.println("B's Overloaded Constructor.") ;
	}
}
	class C extends B{
		protected String c1;
		public C() {
			super();
			c1 = " ";
			System.out.println("C's Default Constructor.");
		}
		public C(int a1, double a2, boolean a3, char b1, String c1) {
			super (a1, a2, a3, b1);
			this.c1 = c1;
			System.out.println("C's Overloaded Constructor. ");
		}
	}