import java.util.ArrayList;


public class Problem_47 {
	
	/* The first two consecutive numbers to have two distinct prime factors are:
	 * 
	 * 14 = 2 × 7
	 * 15 = 3 × 5
	 * 
	 * The first three consecutive numbers to have three distinct prime factors are:
	 * 
	 * 644 = 2² × 7 × 23
	 * 645 = 3 × 5 × 43
	 * 646 = 2 × 17 × 19.
	 * 
	 * Find the first four consecutive integers to have four distinct prime factors. What is the first of
	 * these numbers? */
	public static void main(String[] args) {
		int answer = 0;
		ArrayList<Integer> primes = new ArrayList<>();
		int i = 15;
		while (answer == 0) {
			i++;
			for (int j = i;j < i + 4;j++){
				ArrayList<Integer> pf = new ArrayList<>();
				pf = Funcs.primeFactors(j, primes, false);
				answer = 0;
				if(pf.size()!=4) break; 
				answer = i;
			}
		}
		System.out.println(answer);
	}
	
}
