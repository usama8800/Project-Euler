import java.math.BigInteger;
import java.util.ArrayList;

public class Problem_57 {
	/* It is possible to show that the square root of two can be expressed as an infinite continued
	 * fraction.
	 * 
	 * sqrt(2) = 1 + 1/(2 + 1/(2 + 1/(2 + ... ))) = 1.414213...
	 * 
	 * By expanding this for the first four iterations, we get:
	 * 
	 * 1 + 1/2 = 3/2 = 1.5
	 * 1 + 1/(2 + 1/2) = 7/5 = 1.4
	 * 1 + 1/(2 + 1/(2 + 1/2)) = 17/12 = 1.41666...
	 * 1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...
	 * 
	 * The next three expansions are 99/70, 239/169, and 577/408, but the eighth expansion, 1393/985, is
	 * the first example where the number of digits in the numerator exceeds the number of digits in the
	 * denominator.
	 * 
	 * In the first one-thousand expansions, how many fractions contain a numerator with more digits than
	 * denominator? */
	public static void main(String[] args) {
		ArrayList<Integer> primes = new ArrayList<>();
		int answer = 0;
		for (int i = 0; i <= 1000; i++) {
			if (isApplicable(i, primes)) answer++;
		}
		System.out.println(answer);
	}
	
	public static boolean isApplicable(int num, ArrayList<Integer> primes) {
		BigInteger n = new BigInteger("3"), d = new BigInteger("2");
		for (int i = 0; i < num; i++) {
			BigInteger nPrev = n;
			n = d.multiply(new BigInteger("2")).add(n);
			d = d.add(nPrev);
		}
		boolean answer = n.toString().length() > d.toString().length();
		return answer;
	}
}
