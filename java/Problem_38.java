import java.util.ArrayList;
import java.util.Collections;

public class Problem_38 {

	/* Take the number 192 and multiply it by each of 1, 2, and 3:
	 * 
	 * 192 × 1 = 192
	 * 192 × 2 = 384
	 * 192 × 3 = 576
	 * By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the
	 * concatenated product of 192 and (1,2,3)
	 * 
	 * The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the
	 * pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).
	 * 
	 * What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated
	 * product of an integer with (1,2, ... , n) where n > 1? */
	public static void main(String[] args) {
		int answer = 0;
		for (int i = 1000; i < 10000; i++) {
			if(isPandigital(String.valueOf(concatProd(i))) && concatProd(i)>answer) {
				answer = concatProd(i);
			}
		}
		System.out.println(answer);
	}
	
	private static int concatProd(int num) {
		return Integer.parseInt(String.valueOf(num)+String.valueOf(num*2));
	}

	public static boolean isPandigital(String num) {
		if (num.indexOf("0") != -1 || num.length() != 9) return false;
		ArrayList<String> digits = new ArrayList<String>();
		Collections.addAll(digits, num.split(""));
		digits.remove(0);
		for (int i = 1; i < 10; i++) {
			if (!digits.contains(String.valueOf(i))) return false;
			digits.remove(digits.indexOf(String.valueOf(i)));
		}
		return digits.size() == 0;
	}
}
