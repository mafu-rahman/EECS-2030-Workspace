package Lab7;
import java.util.Date;
import java.util.Objects;


public abstract class Account implements Comparable {//throws NotEnoughMoneyException, TransferNotAllowedException{
	// define the instance variables based on the given UML, here. 
	public int accountNo;
	public double balance;
	public String fullName;
	public Date dateOpened;
	public double maxTransferable;
	
	/**
	 * This method deposit <code> amount </code> to this account.
	 * @param amount is the amount that is deposited to this account. 
	 */
	public abstract void deposit(double amount);	
	
	/**
	 * This method withdraw <code> amount </code> from this account.
	 * @param amount is the amount that should be withdrawn from this account
	 * @return It returns true if the transaction is done successfully. 
	 * @throws Exception This methods may throw either <code> NotEnoughMoneyException </code> or
	 * <code> TransferNotAllowedException </code>.
	 */
	public abstract boolean withdraw(double amount) throws Exception;
	
	/**
	 * This method transfers money from this account to the given account.
	 * @param to is the destination account, where the money is deposited to.
	 * @param amount is the amount of money that is transfered. 
	 * @return It returns true if the transaction is successful. 
	 * @throws Exception This methods may throw either <code> NotEnoughMoneyException </code> or
	 * <code> TransferNotAllowedException </code>.
	 */
	public boolean transferFrom(Account account, double amount) throws Exception{
		if(amount > this.balance) throw new NotEnoughMoneyException("There is not enough money in this account.");
		else if(amount > this.maxTransferable) throw new TransferNotAllowedException("The transfer amount is more than the Max Transferable amount for this account.");
		else {
			this.balance -= amount;
			account.balance += amount;
			return true;
		}
		
//		try {
//			if(amount > this.balance) throw new NotEnoughMoneyException("There is not enough money in this account.");
//			else if(amount > this.maxTransferable) throw new TransferNotAllowedException("The transfer amount is more than the Max Transferable amount for this account.");
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//			return false;
//		}
//		this.balance -= amount;
//		account.balance += amount;
//		return true;
	}
	
	/**
	 * This is the accessor method for <code> accountNo </code>
	 * @return It returns the accountNo of this account.
	 */
	public int getAccountNo(){
		return this.accountNo;
	}
	
	/**
	 * This is the accessor method for <code> balance </code>
	 * @return It returns the balance of the account.
	 */
	public double getBalance() {
		return this.balance;
	}	
	
	/**
	 * This is the accessor method for <code> fullName </code>
	 * @return It returns the name of the holder of the account.
	 */
	public String getFullName() {
		return this.fullName;
	}
	
	
	/**
	 * This is the accessor method for <code> dateOpened </code>
	 * @return It returns the date at which the account was opened.
	 */
	public Date getDateOpened() {
		return this.dateOpened;
	}
	
	/**
	 * This is the accessor method for <code> maxTransferable </code>
	 * @return It returns the maximum allowed amount that can be withdrawn from this account in one transaction.
	 */
	public double getmaxTransferable() {
		return this.maxTransferable;
	}
	
	
	/**
	 * This method compares two accounts. If the two accounts have the same values
	 * for all the instance variables, they are considered, equal and this 
	 * method returns 0. If two objects were not equal, the account whose accountNo is less, 
	 * is the smaller object so this method returns -1. Otherwise it returns 1.
	 * @param object is an object of type account. 
	 * @return<pre> It returns 0, if the two objects are equal. 
	 * It returns -1, if this object is less than the object that is passed as a parameter into the method. 
	 * It returns 1, if this object is greater than the object that is passed as a parameter into the method<pre>. 
	 */
	public int compareTo(Object object) {
		Current obj = (Current) object;
		boolean equal = (this.balance == obj.balance) && (this.dateOpened == obj.dateOpened) && (this.fullName.equals(obj.fullName)) && (this.maxTransferable == obj.maxTransferable);
		if(!(equal)) {
			if(this.accountNo < obj.accountNo) {
				return -1;
			}
			else{
				return 1;
			}
		}
		return 0;
	}
}
	
// Implement class Current based on the given UML in the description.
class Current extends Account {
	public Current() {
		this.accountNo = 0;
		this.balance = 0.0;
		this.fullName = "";
		this.dateOpened = new Date();
		this.maxTransferable = 0.0;
	}
	public Current(int accountNo, double balance, String name, Date date, double maxT) {
		this.accountNo = accountNo;
		this.balance = balance;
		this.fullName = name;
		this.dateOpened = date;
		this.maxTransferable = maxT;
	}
	
	public boolean equals(Object object) {
		int e = this.compareTo(object);
		if(e == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int hashCode() {
		return 0;
	}
	
	
	public void deposit(double amount) {
		this.balance += amount;
	}
	
	public boolean withdraw(double amount) throws Exception {
		if(amount > this.balance) throw new NotEnoughMoneyException("There is not enough money in this account.");
		else if(amount > this.maxTransferable) throw new TransferNotAllowedException("The withdraw amount exceeds the Maximum withdrawable amount.");
		else {
			this.balance -= amount;
			return true;
		}
		
//		try {
//			if(amount > this.balance) throw new NotEnoughMoneyException("There is not enough money in this account.");
//			else if(amount > this.maxTransferable) throw new TransferNotAllowedException("The withdraw amount exceeds the Maximum withdrawable amount.");
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//			return false;
//		}
//		
//		this.balance -= amount;
//		return true;
	}

//	public int compareTo(Object object) {
//		return 0;
//	}
	
}
	

//Define the Exception classes here
class TransferNotAllowedException extends Exception{
	public TransferNotAllowedException() {
		super();
	}
	
	public TransferNotAllowedException(String s) {
		super(s);
	}
}

class NotEnoughMoneyException extends TransferNotAllowedException{
	public NotEnoughMoneyException() {
		super();
	}
	
	public NotEnoughMoneyException(String s) {
		super(s);
	}
}