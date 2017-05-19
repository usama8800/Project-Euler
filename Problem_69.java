import java.util.ArrayList;

public class Problem_69 {
	/* Euler's Totient function, φ(n) [sometimes called the phi function], is used to determine the number of numbers less than n which are relatively prime to n. For
	 * example, as 1, 2, 4, 5, 7, and 8, are all less than nine and relatively prime to nine, φ(9)=6.
	 * 																												@formatter:off
	 * n		 Relatively Prime 		φ(n) 	n/φ(n)
	 * 2 		1 						1 		2
	 * 3 		1,2 					2 		1.5
	 * 4 		1,3 					2 		2
	 * 5 		1,2,3,4 				4 		1.25
	 * 6 		1,5 					2 		3
	 * 7 		1,2,3,4,5,6 			6 		1.1666...
	 * 8 		1,3,5,7 				4 		2
	 * 9 		1,2,4,5,7,8 			6 		1.5
	 * 10		1,3,7,9 				4 		2.5
	 * It can be seen that n=6 produces a maximum n/φ(n) for n ≤ 10.
	 *																												@formatter:on
	 * Find the value of n ≤ 1,000,000 for which n/φ(n) is a maximum. */

	public static void main(String[] args) {
		ArrayList<Integer> primes = new ArrayList<>();
		Funcs.fillPrimesToN(1000000, primes);
		double max = 0;
		int answer = 0;
		System.out.println(String.format("%s\t%s\t%s\n", "n", "φ(n)", "n/φ(n)"));
		for (int n = 2; n <= 10000000; n++) {
			int phiN = totient(n, primes);
			double nDbPhiN = n / (double) phiN;
			System.out.println(String.format("%d\t%d\t%f", n, phiN, nDbPhiN));
			if (nDbPhiN > max) {
				max = nDbPhiN;
				answer = n;
			}
		}
		System.out.println(answer);
	}
	
	public static int totient(int n, ArrayList<Integer> primes) {
		ArrayList<Integer> rps = new ArrayList<>();
		for (int i = 2; i < n; i++) {
			if (Funcs.hcf(i, n, primes) == 1) rps.add(i);
		}
		return rps.size() + 1;
	}
}
