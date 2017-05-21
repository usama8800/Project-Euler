import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Funcs {

	public static void Statistics(String dataString) {
		String x = dataString;
		if (x.trim().equals("")) {
			System.out.println("No data given!");
			return;
		}
		System.out.print("Is it a population? ");
		boolean all = new Scanner(System.in).nextLine().equals("1");
		DecimalFormat df = new DecimalFormat("#.#");
		df.setRoundingMode(RoundingMode.HALF_UP);
		String[] data = x.split(",");
		double average = 0;
		for (int i = 0; i < data.length; i++)
			average += Double.parseDouble(data[i]);
		average /= data.length;
		average = Double.parseDouble(df.format(average));
		double variance = 0;
		for (int i = 0; i < data.length; i++)
			variance += Math.pow(Double.parseDouble(data[i]) - average, 2);
		variance /= data.length - (all ? 0 : 1);
		variance = Double.parseDouble(df.format(variance));
		double sd = Math.sqrt(variance);
		sd = Double.parseDouble(df.format(sd));
		System.out.printf("Average: %.1f\nVariance: %.1f\nStandard Deviation: %.1f", average, variance, sd);
	}

	public static double round(double num, int decimals) {
		return Math.round(num * Math.pow(10, decimals)) / Math.pow(10, decimals);
	}

	public static long getNShapeNum(int n, int shape) {
		if (shape == 3)
			return n * (n + 1) / 2;
		if (shape == 4)
			return n * n;
		if (shape == 5)
			return n * (3 * n - 1) / 2;
		if (shape == 6)
			return n * (2 * n - 1);
		if (shape == 7)
			return n * (5 * n - 3) / 2;
		if (shape == 8)
			return n * (3 * n - 2);
		return -1;
	}

	public static ArrayList<Integer> isShapeNum(long num) {
		ArrayList<Integer> shape = new ArrayList<>();
		if (num < 1)
			return shape;
		if (((Math.sqrt(8 * num + 1) - 1) / 2) % 1 == 0)
			shape.add(3);
		else if (Math.sqrt(num) % 1 == 0)
			shape.add(4);
		else if (((Math.sqrt(24 * num + 1) + 1) / 6) % 1 == 0)
			shape.add(5);
		else if (((Math.sqrt(8 * num + 1) + 1) / 4) % 1 == 0)
			shape.add(6);
		else if (((Math.sqrt(40 * num + 9)) + 3) / 10 % 1 == 0)
			shape.add(7);
		else if ((Math.sqrt(3 * num + 1) + 1) / 3 % 1 == 0)
			shape.add(8);
		return shape;
	}

	public static boolean isPandigital(String num) {
		if (num.indexOf("0") != -1 || num.length() != 9)
			return false;
		ArrayList<String> digits = new ArrayList<String>();
		Collections.addAll(digits, num.split(""));
		digits.remove(0);
		for (int i = 1; i <= 9; i++) {
			if (!digits.contains(String.valueOf(i)))
				return false;
			digits.remove(digits.indexOf(String.valueOf(i)));
		}
		return digits.size() == 0;
	}

	public static boolean isPrime(int num) {
		if (num == 2 || num == 3)
			return true;
		if (num % 2 == 0 || num < 2)
			return false;
		for (int i = 3; i * i <= num; i += 2)
			if (num % i == 0)
				return false;
		return true;
	}

	public static boolean isPermutation(String num1, String num2) { // 1234 4321
		String[] num1Sorted = num1.split("");
		String[] num2Sorted = num2.split("");
		Arrays.sort(num1Sorted);
		Arrays.sort(num2Sorted);
		return Arrays.equals(num1Sorted, num2Sorted);
	}

	public static BigInteger factorial(int num) {
		BigInteger answer = BigInteger.ONE;
		for (int i = 2; i <= num; i++)
			answer = answer.multiply(new BigInteger(String.valueOf(i)));
		return answer;
	}

	public static String nextPermutation(String pp) {
		int k = 0, l = 0;
		for (int i = pp.length() - 2; i >= 0; i--) {
			if (Character.getNumericValue(pp.charAt(i)) < Character.getNumericValue(pp.charAt(i + 1))) {
				k = i;
				break;
			}
		}
		for (int i = pp.length() - 1; i >= 0; i--) {
			if (Character.getNumericValue(pp.charAt(i)) > Character.getNumericValue(pp.charAt(k))) {
				l = i;
				break;
			}
		}
		char backupL = pp.charAt(l);
		char[] ppArray = pp.toCharArray();
		ppArray[l] = pp.charAt(k);
		ppArray[k] = backupL;
		pp = "";
		for (int i = 0; i < k + 1; i++) {
			pp += ppArray[i];
		}
		for (int i = ppArray.length - 1; i >= k + 1; i--) {
			pp += ppArray[i];
		}
		return pp;
	}

	public static String nextRotation(String num) {
		String[] digits = num.split("");
		String first = digits[1];
		for (int i = 1; i < digits.length - 1; i++)
			digits[i] = digits[i + 1];
		digits[digits.length - 1] = first;
		num = "";
		for (int i = 1; i < digits.length; i++) {
			num += digits[i];
		}
		return num;
	}

	public static int getNPrime(int n, ArrayList<Integer> primes) {
		fillPrimesToSize(n, primes);
		return primes.get(n - 1);
	}

	public static void fillPrimesToSize(int size, ArrayList<Integer> primes) {
		if (primes.size() == 0) {
			primes.add(2);
			primes.add(3);
		}
		for (int i = primes.get(primes.size() - 1); size > primes.size(); i += 2)
			if (isPrime(i) && Collections.binarySearch(primes, i) < 0)
				primes.add(i);
	}

	public static void fillPrimesToN(long a, ArrayList<Integer> primes) {
		if (primes.size() == 0)
			primes.add(2);
		int prime = primes.get(primes.size() - 1);
		while (prime < a) {
			prime += prime == 2 ? 1 : 2;
			if (isPrime(prime))
				primes.add(prime);
		}
	}

	public static String toFraction(double num, ArrayList<Integer> primes) {
		long d = 1;
		String stringNum = String.valueOf(num);
		for (int i = 0; i < stringNum.length() - stringNum.substring(0, stringNum.indexOf('.')).length(); i++) {
			d *= 10;
			num *= 10;
		}
		long n = (int) num;
		long hcf = hcf(n, d, primes);
		d /= hcf;
		n /= hcf;
		return String.format("%s/%s", n, d);
	}

	public static String toFraction(double input, DecimalFormat df) {
		int p0 = 1;
		int q0 = 0;
		int p1 = (int) Math.floor(input);
		int q1 = 1;
		int p2;
		int q2;

		double r = input - p1;
		double next_cf;
		while (true) {
			r = 1.0 / r;
			next_cf = Math.floor(r);
			p2 = (int) (next_cf * p1 + p0);
			q2 = (int) (next_cf * q1 + q0);

			// Limit the numerator and denominator to be 256 or less
			if (p2 > 256 || q2 > 256)
				break;

			// remember the last two fractions
			p0 = p1;
			p1 = p2;
			q0 = q1;
			q1 = q2;

			r -= next_cf;
		}

		input = (double) p1 / q1;
		// hard upper and lower bounds for ratio
		// if (input > 256.0) {
		// p1 = 256;
		// q1 = 1;
		// } else if (input < 1.0 / 256.0) {
		// p1 = 1;
		// q1 = 256;
		// }
		String ans = String.valueOf(p1);
		if (q1 != 1)
			ans += "/" + q1;
		return ans;
	}

	// public static String toFraction(double num, DecimalFormat df) {
	// if ((int) num == num) return df.format(num);
	// int numerator = 1;
	// double denominator = 0;
	// int counter = 0;
	// String n = String.valueOf(num);
	// System.out.println(n);
	// if (n.length() - n.indexOf(".") + 1 > 14) n = n.substring(0,
	// n.indexOf(".") + 15);
	// System.out.println(n);
	// String ans = df.format(num);
	// do {
	// double temp = numerator / num;
	// if (Math.abs(Math.floor(temp + 0.5)) - Math.abs(temp) == 0) {
	// denominator = temp;
	// break;
	// }
	// numerator++;
	// counter++;
	// // if (counter > 1000) return ans;
	// } while (true);
	// if (denominator != 0) if (denominator < 0 && numerator > 0) ans =
	// String.format("%d/%s", -numerator, df.format(-denominator));
	// else ans = String.format("%d/%s", numerator, df.format(denominator));
	// return ans;
	// }

	/**
	 * Highest Common Factor or Greatest Common Divisor
	 * 
	 * @param a
	 * @param b
	 * @param primes
	 * @return hcf of a and b
	 */
	public static long hcf(long a, long b, ArrayList<Integer> primes) {
		ArrayList<Integer> commonFactors = new ArrayList<>();
		ArrayList<Integer> pfsa = primeFactors(a, primes, true);
		ArrayList<Integer> pfsb = primeFactors(b, primes, true);
		for (Integer pfa : pfsa)
			if (pfsb.contains(pfa)) {
				pfsb.remove(pfsb.indexOf(pfa));
				commonFactors.add(pfa);
			}
		int hcf = 1;
		for (Integer integer : commonFactors)
			hcf *= integer;
		return hcf;
	}

	/**
	 * @param num
	 * @return Sum of all digits in num
	 */

	public static int digitSum(String num) {
		int sum = 0;
		for (int i = 0; i < num.length(); i++)
			sum += Integer.parseInt(num.substring(i, i + 1));
		return sum;
	}

	/**
	 * @param string
	 * @return string == string.reverse()
	 */
	public static boolean isPalindromic(String string) {
		return new StringBuilder(string).reverse().toString().equals(string);
	}

	public static ArrayList<Integer> primeFactors(long a, ArrayList<Integer> primes, boolean dublicates) {
		ArrayList<Integer> pfs = new ArrayList<Integer>();
		Funcs.fillPrimesToN(a, primes);
		while (a != 1) {
			for (int i = 0; i < primes.size(); i++) {
				int prime = primes.get(i);
				if (a % prime == 0) {
					if (dublicates)
						pfs.add(prime);
					else if (!pfs.contains(prime))
						pfs.add(prime);
					a /= prime;
				}
			}
		}
		return pfs;
	}

	public static ArrayList<Integer> primeFactorize(long a, ArrayList<Integer> primes) {
		ArrayList<Integer> pfs = new ArrayList<>();
		Funcs.fillPrimesToN(a, primes);
		while (a != 1) {
			for (int i = 0; i < primes.size(); i++) {
				int prime = primes.get(i);
				if (a % prime == 0) {
					a /= prime;
					pfs.add(prime);
					break;
				}
			}
		}
		return pfs;
	}

	public static int getOCN(ArrayList<Integer> ocns) { // Odd Composite Number
		int size = ocns.size();
		if (size == 0)
			ocns.add(9);
		else {
			int ocn = ocns.get(size - 1);
			while (size == ocns.size()) {
				ocn += 2;
				if (!Funcs.isPrime(ocn))
					ocns.add(ocn);
			}
		}
		return ocns.get(ocns.size() - 1);
	}

	public static double postFixToNumber(String postFix) {
		Queue<String> q = new ArrayDeque<>();
		Stack<String> s = new Stack<>();
		q.addAll(Arrays.asList(postFix.split(" ")));
		String[] op = { "+", "-", "*", "/", "sqrt" };
		ArrayList<String> ops = new ArrayList<>();
		ops.addAll(Arrays.asList(op));
		return Double.parseDouble(pftn(q, s, ops));
	}

	private static String pftn(Queue<String> q, Stack<String> s, ArrayList<String> operators) {
		if (q.size() > 0) {
			String x = q.poll();
			if (operators.contains(x)) {
				if (x.equals("!")) {
					double num = Double.parseDouble(s.pop());
					s.push(String.valueOf(factorial((int) num)));
				}
				if (x.equals("sqrt")) {
					double num = Double.parseDouble(s.pop());
					s.push(String.valueOf(Math.sqrt(num)));
				}
				if (x.equals("+")) {
					double num2 = Double.parseDouble(s.pop());
					double num1 = Double.parseDouble(s.pop());
					s.push(String.valueOf((num1 + num2)));
				}
				if (x.equals("-")) {
					double num2 = Double.parseDouble(s.pop());
					double num1 = Double.parseDouble(s.pop());
					s.push(String.valueOf((num1 - num2)));
				}
				if (x.equals("*")) {
					double num2 = Double.parseDouble(s.pop());
					double num1 = Double.parseDouble(s.pop());
					s.push(String.valueOf((num1 * num2)));
				}
				if (x.equals("/")) {
					double num2 = Double.parseDouble(s.pop());
					double num1 = Double.parseDouble(s.pop());
					s.push(String.valueOf((num1 / num2)));
				}
			} else
				s.push(x);
		} else {
			return s.pop();
		}
		return pftn(q, s, operators);
	}

	public static BigInteger nCr(int n, int r) {
		if (r == 0 || r == n)
			return BigInteger.ONE;
		if (r > n)
			return BigInteger.ZERO;
		return factorial(n).divide(factorial(r).multiply(factorial(n - r))); // n!/(r!*(n-r)!)
	}

	public static String sortString(String string) {
		char[] charArray = string.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}

	public static class Fraction {
		private int numerator;
		private int denominator;
		private ArrayList<Integer> primes = null;

		public Fraction(int n, int d, ArrayList<Integer> primes) {
			numerator = n;
			denominator = d;
			this.primes = primes;
		}

		public Fraction(String fraction, ArrayList<Integer> primes) {
			numerator = Integer.parseInt(fraction.substring(0, fraction.indexOf("/")));
			denominator = Integer.parseInt(fraction.substring(fraction.indexOf("/") + 1));
			this.primes = primes;
		}

		public Fraction(int n, Fraction d, ArrayList<Integer> primes) {
			numerator = n * d.denominator;
			denominator = d.numerator;
			this.primes = primes;
		}

		public Fraction add(Fraction f2) {
			Fraction r = new Fraction((numerator * f2.denominator) + (f2.numerator * denominator),
					(denominator * f2.denominator), primes);
			return r;
		}

		public Fraction add(int num) {
			Fraction r = new Fraction(numerator + (denominator * num), denominator, primes);
			return r;
		}

		public double toDouble() {
			DecimalFormat df = new DecimalFormat("#.##");
			double ans = Double.parseDouble(df.format((double) numerator / denominator));
			return ans;
		}

		public int getNumerator() {
			return numerator;
		}

		public int getDenominator() {
			return denominator;
		}

		public String toString() {
			long hcf = hcf(numerator, denominator, primes);
			long n = numerator / hcf;
			long d = denominator / hcf;
			String fraction = String.valueOf(n);
			if (d != 1)
				fraction += "/" + d;
			return fraction;
		}
	}
}
