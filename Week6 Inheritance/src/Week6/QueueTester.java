package Week6;

public class QueueTester {
	public static void main (String [] args) {
		
		ImproperQueue queue1 = new ImproperQueue(); 
		char obj = 'A';
		// adding the alphabets to the queue
		for (int i = 0; i < 26; i++)
			queue1.enqueue(Character.toString((char) (obj + i)));		
		// shows the top of the queue
		System.out.println("Top of the queue = " + queue1.top());
		//shows the size of the queue
		System.out.println("Size = " + queue1.getSize());	
		// removing an element from the queue 
		System.out.println(queue1.dequeue() + " ");
		// shows the top of the queue
		System.out.println("Top of the queue = " + queue1.top());
		//shows the size of the queue
		System.out.println("Size = " + queue1.getSize());	
		
		/* A queue should not let us to get access to the data 
		that are between the head and tail of the queue. Bit with this
		improper use of inheritance we can! */
		for (int i = 0; i< queue1.getSize(); i++)
			//this is the ArrayList method
			System.out.print(queue1.get(i)+ " ");
		System.out.println();
		System.out.println("__________________________");

		//##### testing the proper queue #####//
		Queue queue2 = new Queue();
		// adding the alphabets to the queue
		for (int i = 0; i < 26; i++)
			queue2.enqueue(Character.toString((char) (obj + i)));		
		// shows the top of the queue
		System.out.println("Top of the queue = " + queue2.top());
		//shows the size of the queue
		System.out.println("Size = " + queue2.getSize());	
		// removing an element from the queue 
		System.out.println(queue2.dequeue() + " ");
		// shows the top of the queue
		System.out.println("Top of the queue = " + queue2.top());
		//shows the size of the queue
		System.out.println("Size = " + queue2.getSize());		



}

}
