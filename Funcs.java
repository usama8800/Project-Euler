import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Funcs {
	
	public static double round(double num, int decimals) {
		return Math.round(num * Math.pow(10, decimals)) / Math.pow(10, decimals);
	}
	
	public static long getNShapeNum(int n, int shape) {
		if (shape == 3) return n * (n + 1) / 2;
		if (shape == 4) return n * n;
		if (shape == 5) return n * (3 * n - 1) / 2;
		if (shape == 6) return n * (2 * n - 1);
		if (shape == 7) return n * (5 * n - 3) / 2;
		if (shape == 8) return n * (3 * n - 2);
		return -1;
	}
	
	public static ArrayList<Integer> isShapeNum(long num) {
		ArrayList<Integer> shape = new ArrayList<>();
		if (num < 1) return shape;
		if (((Math.sqrt(8 * num + 1) - 1) / 2) % 1 == 0) shape.add(3);
		else if (Math.sqrt(num) % 1 == 0) shape.add(4);
		else if (((Math.sqrt(24 * num + 1) + 1) / 6) % 1 == 0) shape.add(5);
		else if (((Math.sqrt(8 * num + 1) + 1) / 4) % 1 == 0) shape.add(6);
		else if (((Math.sqrt(40 * num + 9)) + 3) / 10 % 1 == 0) shape.add(7);
		else if ((Math.sqrt(3 * num + 1) + 1) / 3 % 1 == 0) shape.add(8);
		return shape;
	}
	
	public static boolean isPandigital(String num) {
		if (num.indexOf("0") != -1 || num.length() != 9) return false;
		ArrayList<String> digits = new ArrayList<String>();
		Collections.addAll(digits, num.split(""));
		digits.remove(0);
		for (int i = 1; i <= 9; i++) {
			if (!digits.contains(String.valueOf(i))) return false;
			digits.remove(digits.indexOf(String.valueOf(i)));
		}
		return digits.size() == 0;
	}
	
	public static boolean isPrime(int num) {
		if (num == 2 || num == 3) return true;
		if (num % 2 == 0 || num < 2) return false;
		for (int i = 3; i * i <= num; i += 2)
			if (num % i == 0) return false;
		return true;
	}
	
	public static boolean isPrime(BigInteger num) {
		BigInteger two = new BigInteger("2");
		BigInteger i = new BigInteger("3");
		if (num.equals(two) || num.equals(i)) return true;
		if (num.mod(two).equals(BigInteger.ZERO) || num.compareTo(BigInteger.ZERO) == 1) return false;
		while (i.multiply(i).compareTo(num) == -1) {
			if (num.mod(i).equals(BigInteger.ZERO)) return false;
			i = i.add(two);
		}
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
			if (isPrime(i) && Collections.binarySearch(primes, i) < 0) primes.add(i);
	}
	
	public static void fillPrimesToN(long a, ArrayList<Integer> primes) {
		if (primes.size() == 0) primes.add(2);
		int prime = primes.get(primes.size() - 1);
		while (prime < a) {
			prime += prime == 2 ? 1 : 2;
			if (isPrime(prime)) primes.add(prime);
		}
	}
	
	public static void fillPrimesToN(BigInteger a, ArrayList<BigInteger> primes) {
		BigInteger two = new BigInteger("2");
		if (primes.size() == 0) primes.add(two);
		BigInteger prime = primes.get(primes.size() - 1);
		BigInteger bigPrime = new BigInteger(String.valueOf(prime));
		while (a.compareTo(bigPrime) == 1) {
			bigPrime = bigPrime.add(bigPrime.intValue() == 2 ? BigInteger.ONE : two);
			if (isPrime(bigPrime)) primes.add(bigPrime);
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
	
	public static String toFraction(double input) {
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
			if (p2 > 256 || q2 > 256) break;
			
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
		if (q1 != 1) ans += "/" + q1;
		return ans;
	}
	
	/**
	 * Highest Common Factor or Greatest Common Divisor
	 * 
	 * @param a
	 *            First number
	 * @param b
	 *            Second number
	 * @param primes
	 *            ArrayList of primes
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
	
	public static BigInteger hcf(BigInteger a, BigInteger b, ArrayList<BigInteger> primes) {
		if (primes == null) primes = new ArrayList<>();
		ArrayList<BigInteger> commonFactors = new ArrayList<>();
		ArrayList<BigInteger> pfsa = primeFactors(a, primes, true);
		ArrayList<BigInteger> pfsb = primeFactors(b, primes, true);
		for (BigInteger pfa : pfsa)
			if (pfsb.contains(pfa)) {
				pfsb.remove(pfsb.indexOf(pfa));
				commonFactors.add(pfa);
			}
		BigInteger hcf = BigInteger.ONE;
		for (BigInteger integer : commonFactors)
			hcf = hcf.multiply(integer);
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
					if (dublicates) pfs.add(prime);
					else if (!pfs.contains(prime)) pfs.add(prime);
					a /= prime;
				}
			}
		}
		return pfs;
	}
	
	public static ArrayList<BigInteger> primeFactors(BigInteger a, ArrayList<BigInteger> primes, boolean dublicates) {
		ArrayList<BigInteger> pfs = new ArrayList<>();
		Funcs.fillPrimesToN(a, primes);
		while (a.intValue() != 1) {
			for (int i = 0; i < primes.size(); i++) {
				BigInteger prime = primes.get(i);
				if (a.mod(prime).equals(BigInteger.ZERO)) {
					if (dublicates) pfs.add(prime);
					else if (!pfs.contains(prime)) pfs.add(prime);
					a = a.divide(prime);
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
		if (size == 0) ocns.add(9);
		else {
			int ocn = ocns.get(size - 1);
			while (size == ocns.size()) {
				ocn += 2;
				if (!Funcs.isPrime(ocn)) ocns.add(ocn);
			}
		}
		return ocns.get(ocns.size() - 1);
	}
	
	public static String postFixToInfix(String string) {
		Stack<String> s = new Stack<>();
		Queue<String> q = new ArrayDeque<>();
		q.addAll(Arrays.asList(string.split(" ")));
		String[] op = {"+", "-", "*", "/", "sqrt"};
		ArrayList<String> ops = new ArrayList<>();
		ops.addAll(Arrays.asList(op));
		return pftif(q, s, ops);
	}
	
	public static String[] getPostFixFraction(String postFix) {
		return postFix.substring(1, postFix.length() - 1).split("\\)\\/\\(");
	}
	
	private static String pftif(Queue<String> q, Stack<String> s, ArrayList<String> operators) {
		if (q.size() > 0) {
			String x = q.poll();
			if (operators.contains(x)) {
				if (x.equals("sqrt")) {
					String y = s.pop();
					s.push(String.format("sqrt(%s)", y));
				}
				if (x.equals("+")) {
					String y = s.pop();
					String z = s.pop();
					s.push(String.format("%s + %s", z, y));
				}
				if (x.equals("-")) {
					String y = s.pop();
					String z = s.pop();
					s.push(String.format("%s - %s", z, y));
				}
				if (x.equals("/")) {
					String y = s.pop();
					String z = s.pop();
					s.push(String.format("(%s)/(%s)", z, y));
				}
				if (x.equals("*")) {
					String y = s.pop();
					String z = s.pop();
					s.push(String.format("(%s)(%s)", z, y));
				}
			} else s.push(x);
		} else return s.pop();
		return pftif(q, s, operators);
	}
	
	public static double postFixToNumber(String postFix) {
		Queue<String> q = new ArrayDeque<>();
		Stack<String> s = new Stack<>();
		q.addAll(Arrays.asList(postFix.split(" ")));
		String[] op = {"+", "-", "*", "/", "sqrt"};
		ArrayList<String> ops = new ArrayList<>();
		ops.addAll(Arrays.asList(op));
		return Double.parseDouble(pftn(q, s, ops));
	}
	
	private static String pftn(Queue<String> q, Stack<String> s, ArrayList<String> operators) {
		// System.out.println("QUEUE: " + q);
		// System.out.println("STACK: " + s);
		// System.out.println();
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
			} else s.push(x);
		} else {
			return s.pop();
		}
		return pftn(q, s, operators);
	}
	
	public static BigInteger nCr(int n, int r) {
		if (r == 0 || r == n) return BigInteger.ONE;
		if (r > n) return BigInteger.ZERO;
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
			Fraction r = new Fraction((numerator * f2.denominator) + (f2.numerator * denominator), (denominator * f2.denominator), primes);
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
			if (d != 1) fraction += "/" + d;
			return fraction;
		}
	}
	
	public static class CFESQRT {
		
		public static ArrayList<Integer> CFESqrt(String postfix) {
			return CFEsqrt(postfix, new ArrayList<>(), "");
		}
		
		public static String getConvergent(int convergent, ArrayList<Integer> cfe) {
			return getConv(convergent, "", cfe);
		}
		
		private static String getConv(int convergent, String sum, ArrayList<Integer> cfe) {
			if (sum.equals("") && convergent > 1) sum = simplifyPostfix(String.format("1 %d /", getN(convergent, cfe)));
			else if (sum.equals("")) sum = String.format("%d 1 /", getN(convergent, cfe));
			else {
				if (convergent == 1) sum = simplifyPostfix(String.format("%s %d +", sum, getN(convergent, cfe)));
				else sum = simplifyPostfix(String.format("1 %s %d + /", sum, getN(convergent, cfe)));
			}
			if (convergent > 1) return getConv(convergent - 1, sum, cfe);
			else return sum;
		}
		
		private static int getN(int convergent, ArrayList<Integer> cfe) {
			if (convergent == 1) return cfe.get(0);
			int x = (convergent - 1) % (cfe.size() - 1);
			if (x == 0) x = cfe.size() - 1;
			return cfe.get(x);
		}
		
		static Pattern p1 = Pattern.compile("^1 (\\d+) (\\d+) \\+ \\/$");
		static Pattern p2 = Pattern.compile("^1 (\\d+) (\\d+) \\/ (\\d+) \\+ \\/$");
		static Pattern p3 = Pattern.compile("^(\\d+) (\\d+) \\/ (\\d+) \\+$");
		static Pattern p4 = Pattern.compile("^1 (\\d+) \\/$");
		
		private static String simplifyPostfix(String postfix) {
			Matcher m4 = p4.matcher(postfix);
			if (m4.find()) return postfix;
			Matcher m1 = p1.matcher(postfix);
			if (m1.find()) {
				String a = m1.group(1);
				String b = m1.group(2);
				BigInteger aInt = new BigInteger(a);
				BigInteger bInt = new BigInteger(b);
				return String.format("1 %s /", aInt.add(bInt));
			}
			Matcher m2 = p2.matcher(postfix);
			if (m2.find()) {
				String a = m2.group(1);
				String b = m2.group(2);
				String c = m2.group(3);
				BigInteger aInt = new BigInteger(a);
				BigInteger bInt = new BigInteger(b);
				BigInteger cInt = new BigInteger(c);
				BigInteger dInt = aInt.add(bInt.multiply(cInt));
				BigInteger hcf = dInt.gcd(bInt);
				return String.format("%s %s /", bInt.divide(hcf), dInt.divide(hcf));
			}
			Matcher m3 = p3.matcher(postfix);
			if (m3.find()) {
				String a = m3.group(1);
				String b = m3.group(2);
				String c = m3.group(3);
				BigInteger aInt = new BigInteger(a);
				BigInteger bInt = new BigInteger(b);
				BigInteger cInt = new BigInteger(c);
				BigInteger dInt = aInt.add(bInt.multiply(cInt));
				BigInteger hcf = dInt.gcd(bInt);
				return String.format("%s %s /", dInt.divide(hcf), bInt.divide(hcf));
			}
			return null;
		}
		
		private static ArrayList<Integer> CFEsqrt(String x, ArrayList<Integer> list, String endPoint) {
			double m = Funcs.postFixToNumber(x);
			int n = (int) m;
			list.add(n);
			if (m - n == 0) return list;
			m = 1 / (m - n);
			String y = String.format("1 %s %d - /", x, n);
			x = optimizePostFix(y);
			if (x == null) {
				System.out.println(list + " " + y);
				ArrayList<Integer> a = new ArrayList<>();
				a.add(1);
				return a;
			}
			if (endPoint.equals("")) endPoint = x;
			if (x.equals(endPoint) && list.size() != 1) return list;
			else return CFEsqrt(x, list, endPoint);
		}
		
		static Pattern pattern1 = Pattern.compile("(\\d+) (\\d+) sqrt (\\d+) ([+\\-]) \\/");
		static Pattern pattern2 = Pattern.compile("1 (\\d+) sqrt (\\d+) ([+\\-]) (\\d+) \\/ (\\d+) - \\/");
		static Pattern pattern3 = Pattern.compile("1 (\\d+) sqrt (\\d+) ([+\\-]) (\\d+) - \\/");
		static Pattern pattern4 = Pattern.compile("1 (\\d+) (\\d+) sqrt (\\d+) ([+\\-]) \\* (\\d+) \\/ (\\d+) - \\/");
		static Pattern pattern5 = Pattern
				.compile("1 ?(?<a>\\d*) ?(?<b>\\d+) (?<c>\\d+) sqrt \\* (?<d>\\d+) (?<sign>[+\\-]) ?\\*? ?(?<e>\\d*) ?\\/? (?<f>\\d+) - \\/");
				
		private static String optimizePostFix(String x) {
			Matcher matcher1 = pattern1.matcher(x);
			if (matcher1.find()) {
				String a = matcher1.group(1);
				String b = matcher1.group(2);
				String c = matcher1.group(3);
				String sign = matcher1.group(4);
				int aInt = Integer.parseInt(a);
				int bInt = Integer.parseInt(b);
				int cInt = Integer.parseInt(c);
				int dInt = bInt - cInt * cInt;
				x = String.format("%s%s sqrt %s %s%s%s", aInt == 1 ? "" : a + " ", b, c, sign.equals("+") ? "-" : "+", aInt == 1 ? "" : " *",
						dInt == 1 ? "" : " " + dInt + " /");
				return x;
			}
			Matcher matcher2 = pattern2.matcher(x);
			if (matcher2.find()) {
				String a = matcher2.group(1);
				String b = matcher2.group(2);
				String c = matcher2.group(4);
				String d = matcher2.group(5);
				String sign = matcher2.group(3);
				int aInt = Integer.parseInt(a);
				int bInt = Integer.parseInt(b);
				int cInt = Integer.parseInt(c);
				int dInt = Integer.parseInt(d);
				int eInt = -cInt * dInt + (sign.equals("+") ? bInt : -bInt);
				int gInt = aInt - eInt * eInt;
				double hInt = (double) cInt / gInt;
				String frac = Funcs.toFraction(hInt);
				if (frac.matches("\\d+")) frac += "/1";
				String[] part = frac.split("\\/");
				if (part[1].equals("1")) x = String.format("%s%d sqrt %d %s%s", hInt == 1 ? "" : part[0] + " ", aInt, Math.abs(eInt),
						eInt < 0 ? "+" : "-", hInt == 1 ? "" : " *");
				else if (part[0].equals("1")) x = String.format("%d sqrt %d %s %s /", aInt, Math.abs(eInt), eInt < 0 ? "+" : "-", part[1]);
				else {
					x = String.format("%s %d sqrt %d %s * %s /", part[0], aInt, Math.abs(eInt), eInt < 0 ? "+" : "-", part[1]);
				}
				return x;
			}
			Matcher matcher3 = pattern3.matcher(x);
			if (matcher3.find()) {
				String a = matcher3.group(1);
				String b = matcher3.group(2);
				String c = matcher3.group(4);
				String sign = matcher3.group(3);
				int aInt = Integer.parseInt(a);
				int bInt = Integer.parseInt(b);
				int cInt = Integer.parseInt(c);
				int dInt = -cInt + (sign.equals("+") ? bInt : -bInt);
				int eInt = aInt - dInt * dInt;
				x = String.format("%d sqrt %d %s%s", aInt, Math.abs(dInt), dInt < 0 ? "+" : "-", eInt == 1 ? "" : " " + eInt + " /");
				return x;
			}
			Matcher matcher4 = pattern4.matcher(x);
			if (matcher4.find()) {
				String a = matcher4.group(1);
				String b = matcher4.group(2);
				String c = matcher4.group(3);
				String d = matcher4.group(5);
				String e = matcher4.group(6);
				String sign = matcher4.group(4);
				int aInt = Integer.parseInt(a);
				int bInt = Integer.parseInt(b);
				int cInt = Integer.parseInt(c);
				int dInt = Integer.parseInt(d);
				int eInt = Integer.parseInt(e);
				int fInt = -dInt * eInt + (sign.equals("+") ? aInt : -aInt) * cInt;
				int hInt = aInt * aInt * bInt - fInt * fInt;
				double gInt = (double) dInt / hInt;
				String frac = Funcs.toFraction(gInt);
				String[] part = frac.split("\\/");
				if (part[1].equals("1")) x = String.format("%s%s %s sqrt * %d %s%s", gInt == 1 ? "" : part[0] + " ", a, b, Math.abs(fInt),
						fInt < 0 ? "+" : "-", gInt == 1 ? "" : " *");
				else if (part[0].equals("1")) x = String.format("%s %s sqrt * %d %s%s", a, b, Math.abs(fInt), fInt < 0 ? "+" : "-",
						part[1].equals("1") ? "" : " " + part[1] + " /");
				else {
					x = String.format("%s %s %s sqrt * %d %s * %d /", part[0], a, b, Math.abs(fInt), fInt < 0 ? "+" : "-", part[1]);
				}
				return x;
			}
			Matcher matcher5 = pattern5.matcher(x);
			if (matcher5.find()) {
				String a = matcher5.group("a");
				String b = matcher5.group("b");
				String c = matcher5.group("c");
				String d = matcher5.group("d");
				String e = matcher5.group("e");
				String f = matcher5.group("f");
				if (a.equals("")) a = "1";
				String sign = matcher5.group("sign");
				int aInt = Integer.parseInt(a);
				int bInt = Integer.parseInt(b);
				int cInt = Integer.parseInt(c);
				int dInt = Integer.parseInt(d);
				int eInt = Integer.parseInt(e);
				int fInt = Integer.parseInt(f);
				int gInt = -fInt * eInt + (sign.equals("+") ? aInt : -aInt) * dInt;
				int jInt = aInt * bInt;
				int hInt = jInt * jInt * cInt - gInt * gInt;
				double iInt = (double) eInt / hInt;
				String frac = Funcs.toFraction(iInt);
				String[] part = frac.split("\\/");
				if (part[1].equals("1")) x = String.format("%s %d $s sqrt * %d %s *", part[0], jInt, c, Math.abs(gInt), gInt < 0 ? "+" : "-");
				else if (part[0].equals("1")) x = String.format("%d %s sqrt * %d %s %d /", jInt, c, Math.abs(gInt), gInt < 0 ? "+" : "-", part[1]);
				else {
					x = String.format("%s %d %s sqrt * %d %s * %d /", part[0], jInt, c, Math.abs(gInt), gInt < 0 ? "+" : "-", part[1]);
				}
				return x;
			}
			return null;
		}
	}
}
