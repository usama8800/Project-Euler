import java.util.ArrayList;
import java.util.Collections;


public class Problem_50 {
	/*
	 * The prime 41, can be written as the sum of six consecutive primes:
	 * 
	 * 41 = 2 + 3 + 5 + 7 + 11 + 13 This is the longest sum of consecutive
	 * primes that adds to a prime below one-hundred.
	 * 
	 * The longest sum of consecutive primes below one-thousand that adds to a
	 * prime, contains 21 terms, and is equal to 953.
	 * 
	 * Which prime, below one-million, can be written as the sum of the most
	 * consecutive primes?
	 */
	public static void main(String[] args) {
		final int limit = 1000000;
		int longest = 0;
		int answer = 0;
		ArrayList<Integer> primes = new ArrayList<>();
		Funcs.fillPrimesToN(limit, primes);
		for (int i = 0; i < primes.size(); i++) {
			int sum = 0;
			for (int j = i; j < primes.size(); j++) {
				int length = j - i;
				sum += primes.get(j);
				if (sum > limit) break;
				if (Collections.binarySearch(primes, sum) >= 0 && length > longest) {
					answer = sum;
					longest = length;
				}
			}
		}
		System.out.println(answer);
	}
}
