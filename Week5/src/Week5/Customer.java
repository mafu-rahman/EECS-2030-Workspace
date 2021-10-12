package Week5;

import java.util.Calendar;
import java.util.ArrayList;
/**
 * This class represents a customer
 * @author Marzieh Ahmadzadeh
 *
 */

public class Customer {
	String name; 
	Calendar dob;
	ArrayList<Account> account;
	/**
	 * This is a constructor that uses a mixture of deep and shallow copy to create this object.
	 * @param custName is the name of the customer
	 * @param dofb represents the date of birth of this customer
	 * @param acc is a list of the accoutns that this customer has opened.
	 */

	public Customer(String custName, Calendar dofb, ArrayList<Account> acc) {
		//deep copy
		this.name = new String (custName); 
		 // use of static factory method to create an object of Calendar
		this.dob = Calendar.getInstance();
		// deep copy
		this.dob.set(dofb.get(Calendar.YEAR), dofb.get(Calendar.MONTH), dofb.get(Calendar.DAY_OF_MONTH));
		//shallow copy [Although a new arrayList is created, the account is copied by its address]
		this.account = new ArrayList<Account>();
		for (int i = 0; i < acc.size(); i++)
			this.account.add(new Account(acc.get(i)));
	}	
	/**
	 * This is an accessor method for name.
	 * @return the name of this customer
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * This is a getter method for dob using deep copy
	 * @return returnd the date of birth.
	 */
	public Calendar getDob() {
		Calendar db = Calendar.getInstance();
		db.set(this.dob.get(Calendar.YEAR), this.dob.get(Calendar.MONTH), this.dob.get(Calendar.DAY_OF_MONTH));
		return db;		
	}
	/**
	 * This is a getter method for the list of accounts. It uses deep coping to create the objec that is returned.
	 * @return an arrayList of account that contains the account of this customer
	 */
	public ArrayList<Account> getAccount(){
		ArrayList<Account> acc = new ArrayList<Account>();
		for (int i = 0; i < this.account.size(); i++)
			acc.add(new Account(this.account.get(i)));
		return acc;
		
	}
	/**
	 * This is the setter method for the name.
	 * @param name is the name of this customer.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/** 
	 * This is the setter method for dob. Deep coping technique is used here.
	 * @param dofb is the date that is assigned to this.dob
	 */
	public void setDob(Calendar dofb) {
		this.dob = Calendar.getInstance();
		this.dob.set(dofb.get(Calendar.YEAR), dofb.get(Calendar.MONTH), dofb.get(Calendar.DAY_OF_MONTH));
	}
	/**
	 * This a mutator for the list of accounts. It uses deep coping technique to copy the accoutns.
	 * @param acc is an array list containg the accoutn of this customer.
	 */
	public void setAccount(ArrayList<Account> acc){
		this.account = new ArrayList<Account>();
		for (int i = 0; i < acc.size(); i++)
			this.account.add(new Account(acc.get(i)));
		
	}
	
}


