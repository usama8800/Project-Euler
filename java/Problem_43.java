import java.util.ArrayList;
import java.util.Collections;


public class Problem_43 {
	
	/* The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits
	 * 0 to 9 in some order, but it also has a rather interesting sub-string divisibility property.
	 * 
	 * Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:
	 * 
	 * d2d3d4=406 is divisible by 2 d3d4d5=063 is divisible by 3 d4d5d6=635 is divisible by 5 d5d6d7=357
	 * is divisible by 7 d6d7d8=572 is divisible by 11 d7d8d9=728 is divisible by 13 d8d9d10=289 is
	 * divisible by 17 Find the sum of all 0 to 9 pandigital numbers with this property. */

	public static void main(String[] args) {
		String num = "0987654321";
		long answer = 0;
		int[] divisors = {2, 3, 5, 7, 11, 13, 17};
		for (int i = 0;i < Funcs.factorial(11).intValue();i++) {
			boolean ok = true;
			num = Funcs.nextPermutation(num);
			for (int j = 2;j < 9;j++) {
				String d = "";
				for (int k = j;k < j + 3;k++) {
					if (num.startsWith("0")) break;
					d += num.substring(k - 1, k);
				}
				if (!d.equals("") && Integer.parseInt(d) % divisors[j-2] != 0) ok = false;
			}
			if (ok) answer += Long.parseLong(num);
		}
		System.out.println(answer);
	}
	
	public static boolean isPandigital(String num) {
		if (num.length() != 10) return false;
		ArrayList<String> digits = new ArrayList<String>();
		Collections.addAll(digits, num.split(""));
		digits.remove(0);
		for (int i = 0;i < 10;i++) {
			if (!digits.contains(String.valueOf(i))) return false;
			digits.remove(digits.indexOf(String.valueOf(i)));
		}
		return digits.size() == 0;
	}
}
