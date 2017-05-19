import java.math.BigInteger;

public class Problem_63 {
	/* The 5-digit number, 16807=7^5, is also a fifth power. Similarly, the 9-digit number, 134217728=8^9, is a ninth power.
	 * 
	 * How many n-digit positive integers exist which are also an nth power? */
	public static void main(String[] args) {
		int answer = 0;
		for (int num = 1; num < 10; num++) {
			BigInteger exp = BigInteger.ZERO;
			System.out.println(num);
			for (int n = 1; n < 100; n++) {
				exp = new BigInteger(String.valueOf(num)).pow(n);
				System.out.printf("\tpow: %d, digits: %d\n", n, exp.toString().length());
				if (exp.toString().length() == n) {
					answer++;
					System.out.printf("Num: %d, Pow: %d, Exp: %s, Digits: %d\n", num, n, exp, exp.toString().length());
				}
			}
		}
		System.out.println(answer);
	}
}
// 49