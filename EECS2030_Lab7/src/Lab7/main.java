package Lab7;

import java.util.Date;

public class main {

	public static void main(String[] args)throws Exception {
		Date date = new Date(); 
		Account a1 = new Current(10, 100.0, "John Smith", date, 3000);
		Account a2 = new Current(20, 200.0, "Jane Smith", date, 3000);
		
		a1.transferFrom(a2,3200);
		System.out.println(TransferNotAllowedException.class);

	}

}
