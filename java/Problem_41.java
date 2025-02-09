import java.util.ArrayList;
import java.util.Collections;


public class Problem_41 {

	/* We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly
	 * once. For example, 2143 is a 4-digit pandigital and is also prime.
	 * 
	 * What is the largest n-digit pandigital prime that exists? */
	public static void main(String[] args) {
		int answer = 0;
		for (int i = 7654321; i >= 1234567; i -= 2)
			if (isPandigital(String.valueOf(i)) && Funcs.isPrime(i)) {
				answer = i;
				break;
			}
		System.out.println(answer);
	}

	public static boolean isPandigital(String num) {
		if (num.indexOf("0") != -1 || num.length() != 7) return false;
		ArrayList<String> digits = new ArrayList<String>();
		Collections.addAll(digits, num.split(""));
		digits.remove(0);
		for (int i = 1; i <= 7; i++) {
			if (!digits.contains(String.valueOf(i))) return false;
			digits.remove(digits.indexOf(String.valueOf(i)));
		}
		return digits.size() == 0;
	}

}
