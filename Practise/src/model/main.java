package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class main {

	public static void main(String[] args) {
		
		Parent obj1 = new FirstChild();
		Parent obj2 = new SecondChild();
		Parent obj3 = new FirstGrandChild();
		
		System.out.println(obj1.getClass());
	}
}