package Lab5;

import org.hamcrest.core.IsInstanceOf;

public class Container {
	// Do not change the value of the following constants.
	protected final int ORIGINAL_SIZE = 10; 
	protected Object[] list; // is a container that stores the element of MyList
	protected Object[] set; // is a container that stores the element of MySet
	protected int size; // this variable holds the actual number of elements that are stored in either of the containers (i.e. MyList or MySet).
	/**
	 * This method adds the <code> obj </code> to the end of the container.
	 * @param obj is the object that is added to the container.
	 */
	public void add(Object obj) {
		System.out.println("The object was added to the contianer");
	}
	/**
	 * This method removes the <code> obj </code> from the container. 
	 * It shifts all the elements to make sure that removal of the element
	 * does not create a whole in the container.
	 * @param obj is the object that is removed from the container. 
	 * @return It returns the object that was removed.
	 */
	public Object remove(Object obj) {
		System.out.println("The object was removed from the container.");
		return obj;
	}
	/**
	 * This method returns true if the container is empty.
	 * @return It returns true if the container is empty, otherwise false.
	 */
	public boolean isEmpty() {
		if (size == 0)
			return true;
		else
			return false;
	}
	/**
	 * This method returns the number of elements stored in the container.
	 * @return It returns the number of elements in the container.
	 */
	public int getSize() {
		return size;
	}
}

/**
 * 
 * This class simulates an ArrayList, where you can add unlimited number of 
 * elements to the list.
 *
 */
class MyList extends Container{
	
	int numOfList;	// to keep the number of lists stored
	/**
	 * This is the default constructor that sets all the instance variables to their defualt value. 
	 */
	public MyList () {
		list= new Object[ORIGINAL_SIZE];
		size = 0; 
		numOfList = 0;
	}
	
	/**
	 * This method returns the element that is stored at index <code> index </code>.
	 * @param index is the<code> index </code> at which the element is accessed and returned. 
	 * @return it returns the element stored at the given <code> index </code>.
	 */
	public Object get(int index) {
		return list[index]; 	
	}
	/**
	 * This method overrides the <code> add </code> method defined in class <code> container</code>. By
	 * adding the <code> obj </code> to the back of the <code> list </code> array. 
	 * The original size of the <code> array </code> is defined by <code> ORIGINAL_SIZE </code>, however, it is possible that 
	 * more elements is added to this array. In case the array does not have enough capacity to add one more element, it grows itself 
	 * by doubling the size of <code> list </code> array.     
	 */
	@Override
	public void add(Object obj) {
		if(numOfList == list.length) {	// if number of lists reaches the length of the list create a new list object with double size
			Object[] listCopy = new Object[list.length];
			for(int i=0; i<list.length; i++) {	// copying the list to another object
				listCopy[i] = list[i];
			}
			
			list = new Object[numOfList * 2];	// doubling the list size
			
			for(int i=0; i<listCopy.length; i++) {	// copying back the original elements back to list
				list[i] = listCopy[i];
			}
		}
		
		super.add(obj);
		list[numOfList] = obj;	// adding the objcet at the end of list
		numOfList++;	// since, new object added, num of list increases
		size++;
	}

	
	/**
	 * This method removes the first occurrence of <code> obj </code>
	 * from <code> list </code>
	 * @pre <code> obj </code> exists in the <code>list</code> array.
	 * 
	 */
	@Override
	public Object remove(Object obj) {
		int index = 0; //assumption that obj exists in the list array

		for(int i=0; i<numOfList; i++) {	// finding the index of the object
			if(list[i].equals(obj)) {
				index = i;
				size--;
				numOfList--;
				break;
			}
		}
		Object[] listCopy = new Object[numOfList];	// creating another array of list object with a new length as an object should be removed
		
		for(int i=0; i<index; i++) {	//copying the elements into the new list array from beginning till the object to be removed
			listCopy[i] = list[i];
		}
		
		for(int i=index; i<numOfList; i++) {	// copying the elements from the object to be removed till the end into the new list object
			listCopy[i] = list[i+1];
		}
		
		list = new Object[numOfList];	// resetting the original list object
		for(int i=0; i<numOfList; i++) {	// copying back the elements into the original list object
			list[i] = listCopy[i];
		}
		super.remove(obj);
		return list;
	}
	/**
	 * This method returns the elements of the MyList in a form of 
	 * [obj1 obj2 obj3 ...]
	 */
	@Override
	public String toString() {
		String s = "[";
		for(int i=0; i<numOfList; i++) {
			s += list[i];
			if(i != numOfList -1)
				s+= " ";
		}
		s += "]";
		return s;
	}
}

class MySet extends Container{
	
	int numOfSet;
	
	public MySet() {
		set = new Object[ORIGINAL_SIZE];
		size = 0; 
		numOfSet = 0;
	}
	
	/**
	 * This method overrrides the <code> add </code> method defined in class <code> container</code>. By
	 * adding the <code> obj </code> to the back of the <code> set </code> array. 
	 * The original size of the <code> set </code> is defined by <code> ORIGINAL_SIZE </code>, however, it is possible that 
	 * more elements is added to this set. In case the set does not have enough capacity to add one more element, it grows itself 
	 * by doubling the size of <code> set </code> array.      
	 */
	
	@Override
	public void add(Object obj) {
		boolean objectExist = false;
		
		for(int i=0; i<numOfSet; i++) {	// checking if the object exists. If it does, then the method does not add the object.
			if(set[i].equals(obj))
				objectExist = true;
		}
		
		if(!objectExist) {
			if(numOfSet == set.length) {
				Object[] setCopy = new Object[set.length];
				for(int i=0; i<set.length; i++) {
					setCopy[i] = set[i];
				}
				
				set = new Object[numOfSet * 2];
				
				for(int i=0; i<setCopy.length; i++) {
					set[i] = setCopy[i];
				}
			}
			super.add(obj);
			set[numOfSet] = obj;
			numOfSet++;
			size++; 		
		}
	}
	
	
	/**
	 * This method removes the first occurrence of <code> obj </code>
	 * from <code> set </code>
	 * @pre <code> obj </code> exists in the <code>set</code> array.
	 * 
	 */
	@Override
	public Object remove(Object obj) {
		int index = 0; //assumption that obj exists in the set array

		for(int i=0; i<numOfSet; i++) {
			if(set[i].equals(obj)) {
				index = i;
				size--;
				numOfSet--;
				break;
			}
		}
		Object[] setCopy = new Object[numOfSet];
		
		for(int i=0; i<index; i++) {
			setCopy[i] = set[i];
		}
		
		for(int i=index; i<numOfSet; i++) {
			setCopy[i] = set[i+1];
		}
		
		set = new Object[numOfSet];
		for(int i=0; i<numOfSet; i++) {
			set[i] = setCopy[i];
		}
		
		super.remove(obj);
		return set;	
	}
	
	/**
	 * This method returns the elements of the MySet in a form of 
	 * [obj1 obj2 obj3 ...]
	 */
	
	@Override
	public String toString() {
		String s = "[";
		for(int i=0; i<numOfSet; i++) {
			s += set[i];
			if(i != numOfSet -1)
				s+= " ";
		}
		s += "]";
		return s;
	}
	
}
