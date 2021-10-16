
import java.util.ArrayList;

/* PLEASE DO NOT MODIFY A SINGLE STATEMENT IN THE TEXT BELOW.
READ THE FOLLOWING CAREFULLY AND FILL IN THE GAPS

I hereby declare that all the work that was required to 
solve the following problem including designing the algorithms
and writing the code below, is solely my own and that I received
no help in creating this solution and I have not discussed my solution 
with anybody. I affirm that I have read and understood
the Senate Policy on Academic honesty at 
https://secretariat-policies.info.yorku.ca/policies/academic-honesty-senate-policy-on/
and I am well aware of the seriousness of the matter and the penalties that I will face as a 
result of committing plagiarism in this assignment.

BY FILLING THE GAPS,YOU ARE SIGNING THE ABOVE STATEMENTS.

Full Name: Mahfuz Rahman
Student Number: 217847518
Course Section: C
*/


/**
 * This class engraves the measures on a measuring cup. 
 * @author Mahfuz Rahman
 *
 */

public class Engrave {
	public ArrayList<String> drawnObject; 
	int charPrintCount; 

	public Engrave() {
		drawnObject = new ArrayList<String>(); 
		charPrintCount = 0;
	}
	
	
	public void engrave(int tickLength, int magnitude) {
		
		if(magnitude == 0) {
			this.drawLine(tickLength, (char)(magnitude+'0')); // printing the last major line explicitly casting int to char.
			this.drawnObject.add("["+tickLength+", "+magnitude+"]");  // for major lines, the array will store the ticklength and the label.
		}
		
		else {
			this.drawLine(tickLength, (char)(magnitude+'0'));	// printing the major lines and explicitly casting int to char.
			this.drawnObject.add("["+tickLength+", "+magnitude+"]");
			this.drawIntervals(tickLength-1);	// draws interval between major lines. Interval is always one less than the ticklength.
			this.engrave(tickLength, --magnitude);	// recursively calls the method again with reduced magnitude untill it reached 0.
		}
	}
	
	/**
	 * @param tickLength is the length of the major lines.
	 * @return this method does not return any instance type.
	 */
	public void drawIntervals(int tickLength) {
		
		if(tickLength >=1) {	// checks if ticklength reaches zero, if it does reach zero, it does nothing.
			/*
			 * The method reduces the ticklength by one and recursively calls the method again until it reaches 0.
			 * It will reach 0 as the last recursive call and 
			 * call drawLine with the previous ticklength value, i.e, 1,2,3...
			 */
			this.drawIntervals(tickLength-1);
			this.drawLine(tickLength, '\0');	// prints the dash
			this.drawnObject.add("["+tickLength+"]"); // since it is only prnting the dash, the array only stores the number of dashes.
			this.drawIntervals(tickLength-1);
		}
	}
	
	/**
	 * 
	 * @param tickLength is the number of dash '-' to be printed.
	 * @param tickLabel is the label that should be printed next to the line.
	 * @return this method does not return any instance type.
	 */
	public void drawLine (int tickLength, char tickLabel) {
		this.charPrintCount++;	// counting the number of characters printed by incrementing it everytime this method is called.
		if(tickLength == 0) {	// if the ticklength reaches 0, means we have finished printing dash and now need to print the space between dash and the tickLabel
			System.out.print(' ');
			this.drawLine(--tickLength, tickLabel);
		}
		else if(tickLength == -1) {	// if ticklength has gone below zero means it has finished printing the dash along with the single space.
			System.out.println(tickLabel);	// now have to print the last character i.e, tickLabel. This is the end of the recursive function.
		}
		else {
			System.out.print('-');
			this.drawLine(--tickLength, tickLabel);	// decrementing tickLength and calling method recursively
		}
	}	
	
	public static int cupSelection(int weight[], int value[], int maxWeight, int index) {
		
		double ratio[] = new double[index];	// we will be selecting the cups which have the highest cost to weight ratio, keeping the weight limit as maxWeight.
		for(int i=0; i<index; i++)		// making another array of cost to weight ratio which corresponds to the value and weight array.
			ratio[i] = (double) value[i]/weight[i];	// need to explicitly type caste it as value and weight are integers.
		
		double maxRatio=0.0;
		int indexMaxRatio=0, sum;
		
		for(int i=0; i<index; i++) {
			if(ratio[i] > maxRatio) {	// capturing the values and index with highest cost to weight ratio.
				maxRatio = ratio[i];
				indexMaxRatio = i;
			}
		}
		
		if(maxWeight >= weight[indexMaxRatio]) {	// checking if we have reached the weight limit.
			sum = value[indexMaxRatio];
			value[indexMaxRatio] = 0;	// resetting the value of selected cup so that it is not recounted in next recursion.
			return (sum + cupSelection(weight, value, (maxWeight-weight[indexMaxRatio]), index));	//reducing the weight limit and implementing recursion with new value and maxWeight.
		}
		
		else {
			return 0;
		}
     }
}
