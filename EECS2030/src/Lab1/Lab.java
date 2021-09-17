package Lab1;

public class Lab {
	
	String studentNumber;
	
	public static String getMyID() {
		return "217847518";
	}
	
	/**
	 * @param gradeNum The input grade is a double number between zero and 100 inclusive. 
	 * @return Returns the letter grade corresponding to the grade number.
	 */
	 
	public static String getLetterGrade(double gradeNum) {
		String gradeLetter = "";
		
		if(gradeNum >= 90)
			gradeLetter = "A+";
		
		else if(gradeNum < 90 && gradeNum >= 80)
			gradeLetter = "A";
		
		else if(gradeNum < 80 && gradeNum >= 75)
			gradeLetter = "B+";
		
		else if(gradeNum < 75 && gradeNum >= 70)
			gradeLetter = "B";
		
		else if(gradeNum < 70 && gradeNum >= 65)
			gradeLetter = "C+";
		
		else if(gradeNum < 65 && gradeNum >= 60)
			gradeLetter = "C";
		
		else if(gradeNum < 60 && gradeNum >= 55)
			gradeLetter = "D+";
		
		else if(gradeNum < 55 && gradeNum >= 50)
			gradeLetter = "D";
		
		else if(gradeNum < 50 && gradeNum >= 45)
			gradeLetter = "E";
		
		else if(gradeNum < 45)
			gradeLetter = "F";
		
		
		return gradeLetter;
	}

}
