import java.math.BigInteger;

public class Problem_25 {

	public static void main(String[] args) {
		BigInteger fib1 = BigInteger.ONE;
		BigInteger fib2 = fib1;
		int fibn = 2;
		int iterator = 1;
		boolean found = false;
		while (!found) {
			if (iterator == 1) {
				iterator = 2;
				fib1 = fib1.add(fib2);
			} else {
				iterator = 1;
				fib2 = fib2.add(fib1);
			}
			fibn++;
			if(iterator == 2) {
				if(fib1.toString().length()==1000) found = true;
			}else {
				if(fib2.toString().length()==1000) found = true;				
			}
		}
		System.out.println(fibn);
	}
}
