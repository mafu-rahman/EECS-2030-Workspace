package Week5;
import java.util.ArrayList;
/**
 * This class represents a doctor
 * @author Marzieh Ahmadzadeh
 *
 */

public class Doctor {
	private String name; 
	private ArrayList<Patient> patient; 
	/**
	 * This is a constructor that makes an object of Doctor.
	 * @param name is the initial value for the name of the doctor.
	 * @param patient is an arrayList containing all the patients that the doctor visits.
	 */
	
	public Doctor(String name, ArrayList<Patient> patient) {
		this.name = name;
		this.patient = new ArrayList<Patient>();
		for(int i = 0; i < patient.size(); i++)
			this.patient.add(patient.get(i));
		
	}
	
	/**
	 * This is the copy construct
	 * @param doctor is a reference to a doctor object
	 */
	public Doctor (Doctor doctor) {
		this.name = doctor.name;
		this.patient = doctor.patient;
	}
	 
	/**
	 * This is the getter method for name.
	 * @return returns this doctor's name
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * This is a getter method for patient.
	 * @return returns a reference to the patients list
	 */
	public ArrayList<Patient> getPatient() {
		return this.patient;
	}
	/**
	 * This mutates the name of the doctor
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * This mutates the list of patients
	 * @param patient
	 */
	public void setPatient(ArrayList<Patient> patient) {
		this.patient = new ArrayList<Patient>();
		for(int i = 0; i < patient.size(); i++)
			this.patient.add(patient.get(i));
	}
	

}
