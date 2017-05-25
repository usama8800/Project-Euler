import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem_65 {
	
	public static void main(String[] args) {
		String frac = Funcs.postFixToInfix(getSum(100, ""));
		String[] part = Funcs.getPostFixFraction(frac);
		BigInteger bigNum = new BigInteger(part[0]);
		BigInteger bigDen = new BigInteger(part[1]);
		System.out.println(Funcs.digitSum(bigNum.divide(bigNum.gcd(bigDen)).toString()));
	}
	
	public static String getSum(int c, String sum) {
		if (sum.equals("")) sum = simplifyPostfix(String.format("1 %d /", getN(c)));
		else {
			if (c == 1) sum = simplifyPostfix(String.format("%s %d +", sum, getN(c)));
			else sum = simplifyPostfix(String.format("1 %s %d + /", sum, getN(c)));
		}
		if (c > 1) return getSum(c - 1, sum);
		else return sum;
	}
	
	static Pattern p1 = Pattern.compile("1 (\\d+) (\\d+) \\+ \\/");
	static Pattern p2 = Pattern.compile("1 (\\d+) (\\d+) \\/ (\\d+) \\+ \\/");
	static Pattern p3 = Pattern.compile("(\\d+) (\\d+) \\/ (\\d+) \\+");
	
	public static String simplifyPostfix(String postfix) {
		if (postfix.equals("1 1 /")) return "1";
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
			// long hcf = Funcs.hcf(bInt, dInt, primes);
			return String.format("%s %s /", bInt, dInt);
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
			// long hcf = Funcs.hcf(bInt, dInt, primes);
			return String.format("%s %s /", dInt, bInt);
		}
		return null;
	}
	
	public static int getN(int c) {
		if (c == 1) return 2;
		if (c % 3 == 0) return 2 * c / 3;
		return 1;
	}
}
