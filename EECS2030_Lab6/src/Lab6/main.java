package Lab6;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class main {
	
	public static void main(String args[]) throws Exception {
		
		Queue c = new Queue("Hello");
		c.add("Jack");
		c.add("Harlow");
		
		
		Container con = new Container();
		con.add(c);
	}

}
