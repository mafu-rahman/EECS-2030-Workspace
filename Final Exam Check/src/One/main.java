package One;
import java.util.*;

public class main {

	public static void main(String[] args) {
		
		List<Device> device = new ArrayList<Device>();
//		List<Device> computer = new ArrayList<Computer>();
//		ArrayList<Tablet> table = new ArrayList<Laptop>();
		
		
		Computer[] obj = {new Laptop(), new Tablet()};
		
		
		
		Computer[] obj1 = new Computer[2];
		obj1[0] = new Tablet();
		obj1[1] = new Laptop();
		
		
		
		Computer a = new Tablet();
		Computer b = new Laptop();
		Computer[] c = {a,b};
	}

}
