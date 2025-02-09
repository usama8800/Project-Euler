import java.util.ArrayList;
import java.util.Collections;

public class Problem_32 {

	public static void main(String[] args) {
		int answer = 0;
		ArrayList<Long> products = new ArrayList<Long>();
		for (int num1 = 1; num1 < 1000; num1++) {
			for (int num2 = 1; num2 < 10000; num2++) {
				long product = num1 * num2;
				if (isPandigital(String.format("%d%d%d", num1, num2, product), products)) {
					products.add(product);
					System.out.printf("%d\tX\t%d\t=\t%d\n", num1, num2, product);
				}
			}
		}
		for (int i = 0; i < products.size(); i++)
			answer += products.get(i);
		System.out.println(answer);
	}

	public static boolean isPandigital(String num, ArrayList<Long> products) {
		if (num.indexOf("0") != -1 || num.length() < 9) return false;
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i) == Long.parseLong(num.substring(num.length()
				- String.valueOf(products.get(i)).length()))) return false;
		}
		ArrayList<String> digits = new ArrayList<String>();
		Collections.addAll(digits, num.split(""));
		digits.remove(0);
		for (int i = 1; i < 10; i++) {
			if (!digits.contains(String.valueOf(i))) return false;
			digits.remove(digits.indexOf(String.valueOf(i)));
		}
		if (digits.size() == 0) return true;
		return false;
	}
}
