package Lab6;

import java.util.*;
import java.io.*;
/**
 * This class is a container that holds an unlimited number of 
 * String objects. It is able to remove objects and add objects.
 */

public class Container {
	// No instance variable should be defined for this class. 


	/**
	 * Reads the given file and add it into a list. 
	 * Each element of the list contains one line of the file. 
	 * @param fileName is the name of the file that is read in this method. 
	 */

	public static final List<String> readFile(String fileName) throws Exception {
		
		Scanner in = new Scanner(new File(fileName));	//creating scanner object to accept input from a file
		
		ArrayList<String> list = new ArrayList<String>(); // this list will be used to store the input file line by line
		
		while(in.hasNextLine()) {	// accepting input line by line and storing into the list array
			list.add(in.nextLine());
		}
		
		in.close();
		
		return list;
	}
		
	/**
	 * This method adds the <code> obj </code> to the container.
	 * @param obj is the object that is added to the container.
	 */
	
	void add(Object object) {
		// insert your code here
	}

	/**
	 * This method removes the object from the container
	 * @return returns the removed object.
	 */
	Object remove() {
		// insert your code here. You may want to change the return value. 
		return null;
	}

	/**
	 * @return It returns the number of elements in the container.
	 */
	int getSize() {
		// insert your code here. You may need to change the return value. 
		return 0;
	}

}

/**
 * 
 * This class simulates a Queue, which is a data structure that insert and remove data 
 * by FIFO (first-in, first-out) rule
 *
 */
class Queue extends Container{
	ArrayList<String> queue; 
	
	/**
	 * This is the constructor that initializes the <code> queue </code>
	 * with all the strings in the <code> fileName </code> that is labeled 
	 * by "Queue"
	 * @param fileName is the name of the file that is read.  
	 */
	public Queue(String fileName) throws Exception{
		queue = new ArrayList<String>();
		
		for(int i=0; i<readFile(fileName).size(); i++) {
			if(readFile(fileName).get(i).substring(0,5).equals("Queue")) {
				queue.add(readFile(fileName).get(i).substring(6).trim());
			}
		}
	}
	
	/**
	 * This method adds the object into the Queue. 
	 * Please note that the rule of the queue insertion/removal is 
	 * First in, First out. 
	 * @param obj is the object that is added to the queue. 
	 */
	@Override
	public void add(Object obj) {
		queue.add(obj.toString());
	}
	/**
	 * This method removes an object from the Queue. 
	 * Please note that the rule of the queue insertion/removal is 
	 * First in, First out. 
	 */
	@Override
	public Object remove() {
		return queue.remove(0);
	}
	/**
	 * @return returns the object which is in front of the queue.
	 */
	public Object top() {
		return queue.get(0);
	}
	
	/**
	 * Returns the number of items in the queue.
	 */
	@Override 
	public int getSize(){
		return queue.size();
	}
}

/**
 * 
 * This class simulates a Stack, which is a data structure that insert and remove data 
 * by FILO (first-in, last-out) rule
 *
 */
class Stack extends Container{
	ArrayList<String> stack; 
	
	/**
	 * This is the constructor that initializes the <code> stack </code>
	 * with all the strings in the <code> fileName </code> that is labeled 
	 * by "Stack"
	 * @param fileName is the name of the file that is read.  
	 */
	public Stack(String fileName) throws Exception {
		stack = new ArrayList<String>();
		
		for(int i=0; i<readFile(fileName).size(); i++) {
			if(readFile(fileName).get(i).substring(0,5).equals("Stack")) {
				stack.add(readFile(fileName).get(i).substring(6).trim());
			}
		}
	}
	/**
	 * This method removes an object from the stack. 
	 * Please note that the rule of the stack insertion/removal is 
	 * First in, Last out. 
	 */

	@Override
	public void add(Object obj) {
		stack.add(obj.toString());
	}
	
	/**
	 * This method removes an object from the stack. 
	 * Please note that the rule of the stack insertion/removal is 
	 * First in, Last out. 
	 */

	@Override
	public Object remove() {
		return stack.remove(stack.size() - 1); 	
	}
	/**
	 * @return returns the object which is on top of the stack.
	 */
	
	public Object top() {
		return stack.get(stack.size() - 1); 
	}
	/**
	 * Returns the number of items in the stack.
	 */
	@Override 
	public int getSize() {
	      return stack.size();
	}
}