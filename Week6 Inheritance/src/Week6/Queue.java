package Week6;

import java.util.ArrayList;

public class Queue {
	private ArrayList<String> queue;
	/**
	 * This is the default constructor for the queue
	 */
	public Queue() {
		queue = new ArrayList<String>();
	}
	/**
	 * adds one element to the end of the queue.
	 * @param obj is the object that is added to the end of the queue
	 * {@inheritDoc} 
	 */
	public void enqueue(String obj) {
		this.queue.add(obj);
	}
	/**
	 * removes one item form the top of the queue
	 * @return the first element, which is at the top of the queue
	 */
	public String dequeue() {
		return this.queue.remove(0);
	}
	
	/**
	 * shows what is on top of the queue without removing it
	 * @return returns the element that can be seen on top of the queue
	 */
	public String top() {
		return this.queue.get(0);
	}
	/**
	 * shows the number of the elements in the queue
	 * @return returns the size of the queue
	 */
	public int getSize() {
		return this.queue.size();
	}


}
