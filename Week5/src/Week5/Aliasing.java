package Week5;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Aliasing {
	public static void main(String[] args) {
		// Aliasing does not work, because String creates a deep copy  
		String he = "Jack ";
		String nameCopy = he; 
		he = "John";
		System.out.println(he + nameCopy);
		String newName = new String(" Peter");
		String newNameCopy = newName;
		newName = "John";
		System.out.println(newName + newNameCopy);
		
		// Aliasing 
		int[] array = {1, 2, 3, 4, 5};
		int[] arrayCopy = array; 
		// how aliasing works: I change the arrayCopy[0] and the change is reflected on array[0]	
		arrayCopy[0] = 99;
		System.out.println("arrayCopy[0] was changed so array[0] = "+ array[0] + " becuase of aliasing.");
		
		// Aliasing and how it works
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		ArrayList<Integer> arrayListCopy = arrayList;
		arrayList.add(1);
		arrayList.add(2);
		arrayList.set(0, 100);
		System.out.println("arrayListCopy was changed so arrayList at index 0 = "+ arrayList.get(0) + " becuase of aliasing.");
		
		// Aliasing and how it works
		SelfDrivingCar car = new SelfDrivingCar();
		SelfDrivingCar carCopy = car;
		car.setMake("Toyota");
		System.out.println(carCopy.getMake());
		System.out.println("#########");
		
		
		

		/* The first side effect of aliasing: the object is no longer needed. so all the references should be nullified.
		 * otherwise, GC can not clean up the memory allocated to the object
		 */
		array = null; 
		System.out.println(arrayCopy[0]);
		arrayList = null; 
		System.out.println(arrayListCopy.get(0));
		car = null; 
		System.out.println(carCopy.getMake());
		System.out.println("#########");

		
		// deep copy
		
		char [] charArray = {'A', 'B', 'C'};	
		char [] charArrayClone = new char [charArray.length];
		for (int i = 0; i < charArray.length; i++)
			charArrayClone[i] = charArray[i];
		
		ArrayList<Double> grade = new ArrayList<Double>();
		grade.add(78.9);
		grade.add(89.7);
		
		ArrayList<Double> gradeClone = new ArrayList<Double>();
		for (int i = 0; i < grade.size(); i++)
			gradeClone.add(grade.get(i));
		
		String plate = "xxx000";
		char [] plateNumber = plate.toCharArray();
		SelfDrivingCar driverlessCar = new SelfDrivingCar("Toyota", "Rav4", 220355235, plateNumber ,110);

		SelfDrivingCar carClone = new SelfDrivingCar(driverlessCar.getMake(), 
														driverlessCar.getModel(),
														driverlessCar.getColor(),
														driverlessCar.getPlateNumber(),
														driverlessCar.getMaxAllowedSpeed());
	
	
		SelfDrivingCar myCar = new SelfDrivingCar(driverlessCar);
		char[] plateNo = myCar.getPlateNumber();
		plateNo[0] = 'Y';
		System.out.println(plateNo);
		System.out.println(myCar.getPlateNumber());
		
		String name = "John";
		String nameClone = name; 
		System.out.println(name + " " + nameClone);
		name = "Jane";
		System.out.println(name + " " + nameClone);
		System.out.println(name.concat(" Smith"));
		System.out.println(name + " " + nameClone);
		
		// example of Shallow copy
		Account firstAcc = new Account('C', 100200, 100.0, new Date());
		Account secondAcc = new Account(firstAcc);

		// A misture of deep and shallow copy
		Calendar db = Calendar.getInstance();
		db.set(2010, 9, 24);
		ArrayList <Account> acc = new ArrayList<Account>(); 
		acc.add(firstAcc);
		Customer jane = new Customer ("Jane", db, acc);
		
	}

}
