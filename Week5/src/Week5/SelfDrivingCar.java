package Week5;
/**
 * This is a class that represents a self-driving car
 * @author Marzieh Ahmadzadeh
 *
 */
public class SelfDrivingCar {
	private String make;
	private String model;
	private int color;
	private char[] plateNumber;
	private int maxAllowedSpeed;
	/**
	 * This is the default construcotr for this class
	 */
	
	public SelfDrivingCar () {
		this.make = "";
		this.model = "";
		this.color = 0;
		this.maxAllowedSpeed = 0;
		this.plateNumber = null;
	}
	/**
	 * This is the overloaded constructor for this class
	 * @param make is the make of the car
	 * @param model represents the model of the car
	 * @param color is the color of the car
	 * @param plateNumber shows the plate number of the car
	 * @param maxSpeed represents the maximum speed of this car
	 */
	public SelfDrivingCar (String make, String model, int color, char[] plateNumber, int maxSpeed) {
		this.make = make;
		this.model = model;
		this.color = color;
		this.maxAllowedSpeed = maxSpeed;
		this.plateNumber = plateNumber; 	
	}

	/**
	 * This the copy constructor for the car
	 * @param object is am object of the car by which this object is created. 
	 */
	public SelfDrivingCar (SelfDrivingCar object) {
		this.make = object.make;
		this.model = object.model;
		this.color = object.color;
		this.maxAllowedSpeed = object.maxAllowedSpeed;
		this.plateNumber = new char[object.plateNumber.length];
		for (int i = 0; i < object.plateNumber.length; i++)
			this.plateNumber[i] = object.plateNumber[i];
	}
	/** 
	 * A getter method for make of the car
	 * @return the make of the car
	 */
	public String getMake() {
		return make;
	}
	/**
	 * A setter method for the make of the car
	 * @param make is the new value for the make of this car
	 */
	public void setMake(String make) {
		this.make = make;
	}
	
	/**
	 * a getter method for the plate number of the car
	 * @return returns a copy of the plate number -- Deep copy
	 */
	public char [] getPlateNumber() {
		char [] plateNumberCopy = new char[this.plateNumber.length];
		for (int i = 0; i < this.plateNumber.length; i++)
			plateNumberCopy[i] = this.plateNumber[i];
		return plateNumberCopy;
	}
	
	/**
	 * A setter method for the plate number that uses deep copying
	 * @param plateNumber is the new value for the plate number.
	 */
	public void setPlateNumber(char[] plateNumber) {
		this.plateNumber = new char[plateNumber.length];
		for (int i = 0; i < plateNumber.length; i++)
			this.plateNumber[i] = plateNumber[i];
	}
	
	/**
	 * A getter method for the model of the car
	 * @return returns the model of this car
	 */
	public String getModel() {
		return this.model;
	}
	/**
	 * a getter method for the color.
	 * @return returns the color of the car
	 */
	public int getColor() {
		return this.color;
	}
	/**
	 * A getter method for maximum speed of the car
	 * @return returns the maximum allowed speed of the car
	 */
	public int getMaxAllowedSpeed() {
		return this.maxAllowedSpeed;
	}
}

