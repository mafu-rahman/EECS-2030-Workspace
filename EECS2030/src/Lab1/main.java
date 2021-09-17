package Lab1;
import java.util.*;

public class main {

	public static void main(String[] args) {
		
		System.out.println(Lab.getMyID());
		
		Scanner in = new Scanner(System.in);
		
		int grade = 1;
		while (grade>0) {
			grade = in.nextInt();
			System.out.println(Lab.getLetterGrade(grade));
		}
		
	}

}
