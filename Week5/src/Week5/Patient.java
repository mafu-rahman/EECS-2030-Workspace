package Week5;
import java.util.*;
/** 
 * This class represent a Patient
 * @author Marzieh Ahmadzadeh
 *
 */

public class Patient {
	String name;
	Calendar dob;
	/** 
	 * This is the constructor of this class
	 * @param name is the name of the patient 
	 * @param dob  is the date of birth of this patient.
	 */
	public Patient(String name, Calendar dob) {
		this.name = name; 
		this.dob = dob;
	}
}
