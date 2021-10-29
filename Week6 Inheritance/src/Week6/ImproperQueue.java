package Week6;
import java.util.ArrayList;
/**
 * This class is an improper implementation of the Queue Abstract Data Type. 
 * This example is to show that not all is-a relationship should be implemented
 * by inheritance.
 * @author Marzieh Ahmadzadeh
 *
 */

public class ImproperQueue extends ArrayList<String>{
	/**
	 * adds one element to the end of the queue.
	 * @param obj is the object that is added to the end of the queue
	 */
	public void enqueue(String obj) {
		this.add(obj);
	}
	/**
	 * removes one item form the top of the queue
	 * @return the first element, which is at the top of the queue
	 */
	public String dequeue() {
		return this.remove(0);
	}
	
	/**
	 * shows what is on top of the queue without removing it
	 * @return returns the element that can be seen on top of the queue
	 */
	public String top() {
		return this.get(0);
	}
	/**
	 * shows the number of the elements in the queue
	 * @return returns the size of the queue
	 */
	public int getSize() {
		return this.size();
	}
	
}
