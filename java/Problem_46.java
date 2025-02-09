import java.util.ArrayList;


public class Problem_46 {
	
	/* It was proposed by Christian Goldbach that every odd composite number can be written as the sum of
	 * a prime and twice a square.
	 * 
	 * 9 = 7 + 2×1^2 15 = 7 + 2×2^2 21 = 3 + 2×3^2 25 = 7 + 2×3^2 27 = 19 + 2×2^2 33 = 31 + 2×1^2
	 * 
	 * It turns out that the conjecture was false.
	 * 
	 * What is the smallest odd composite that cannot be written as the sum of a prime and twice a
	 * square? */
	
	public static void main(String[] args) {
		ArrayList<Integer> ocns = new ArrayList<>();
		ArrayList<Integer> primes = new ArrayList<>();
		int answer = 0;
		while (answer == 0) {
			int ocn = Funcs.getOCN(ocns);
			Funcs.fillPrimesToN(ocn, primes);
			if (isGoldbachNumber(ocn, primes)) {
				
			} else answer = ocn;
		}
		System.out.println(answer);
	}
	
	
	
	public static boolean isGoldbachNumber(int ocn, ArrayList<Integer> primes) {
		for (int i = 0;i * i < ocn / 2;i++) {
			for (int j = 0;j < primes.size();j++) {
				int p = primes.get(j);
				if ((ocn - p) / 2 == i * i) return true;
			}
		}
		return false;
	}
	
}
