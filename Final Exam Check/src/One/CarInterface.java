
package One;

import java.util.*;

interface CarInterface {
	List<Character> makeAndModel = new ArrayList<Character>();
	void assemble(Object obj);
	void disassemble(Object obj);
	boolean hasTech(Object obj);
	List<Character> model();
	boolean isEmpty();
}

abstract class SUV implements CarInterface{
	String [] part;
	public SUV (String[] arr, String make) {
		part = new String[arr.length];
		for(int i=0; i<arr.length; i++) {
			part[i] = arr[i];
			makeAndModel.add(make.charAt(i));
		}
	}
	public abstract void assemble(Object obj);
	public abstract void disassemble(Object obj);
	public boolean hasTech(Object obj) {
		boolean hasTech = true;
		return hasTech;
	}
	public List<Character> model(){
		return makeAndModel;
	}
	public boolean isEmpty() {
		if(makeAndModel.size() != 0 && part.length != 0) return false;
		else return true;
	}
}


class FirstGenSUV extends SUV{
	public FirstGenSUV(String [] arr, String make) {
		super(arr,make);
	}
	public void disassemble(Object obj) {
		
	}
	@Override
	public void assemble(Object obj) {
		// TODO Auto-generated method stub
		
	}
}

class SecondGenSUV extends SUV{
	public SecondGenSUV(String[] arr, String make) {
		super(arr,make);
	}
	public void assemble(Object obj) {
		String element = (String) obj;
		part[part.length] = element;
	}
	public void search(Object obj) {
		
	}
	
	public void disassemble(Object obj) {
		String element = (String) obj;
	}
}











