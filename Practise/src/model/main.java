package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class main {

	public static void main(String[] args) {
		
		Parent obj1 = new FirstChild();
		Parent obj2 = new SecondChild();
		Parent obj3 = new FirstGrandChild();
		obj1.fifthOp();
		obj2.firstOp();
		obj3.firstOp();
		System.out.println("count= " +obj1.count);
		System.out.println("done= "+ obj1.done);
		Parent obj4 = FirstChild.getInstance();
		Parent obj5 = SecondChild.getInstance();
		Parent obj6 = FirstGrandChild.getInstance();
		obj4.fifthOp();
		obj5.secondOp();
		obj6.thirdOp();
		System.out.println("count= " +obj6.count);
		System.out.println("done= "+ obj6.done);
	}
}