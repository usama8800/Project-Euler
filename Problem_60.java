import java.util.ArrayList;

public class Problem_60 {
	
	/* The primes 3, 7, 109, and 673, are quite remarkable. By taking any two primes and concatenating
	 * them in any order the result will always be prime. For example, taking 7 and 109, both 7109 and
	 * 1097 are prime. The sum of these four primes, 792, represents the lowest sum for a set of four
	 * primes with this property.
	 * 
	 * Find the lowest sum for a set of five primes for which any two primes concatenate to produce
	 * another prime. */
	public static void main(String[] args) {
		ArrayList<Integer> primes = new ArrayList<>();
		Funcs.fillPrimesToN(10000, primes);
		int answer = 0;
		first:
		for (int a = 0; a < primes.size(); a++) {
			int p1 = primes.get(a);
			for (int b = 0; b < primes.size(); b++) {
				int p2 = primes.get(b);
				if (!Funcs.isPrime(Integer.parseInt(String.format("%d%d", p1, p2))) || !Funcs.isPrime(Integer.parseInt(String.format("%d%d", p2, p1)))) continue;
				for (int c = 0; c < primes.size(); c++) {
					int p3 = primes.get(c);
					if (!Funcs.isPrime(Integer.parseInt(String.format("%d%d", p1, p3))) || !Funcs.isPrime(Integer.parseInt(String.format("%d%d", p2, p3)))) continue;
					if (!Funcs.isPrime(Integer.parseInt(String.format("%d%d", p3, p1))) || !Funcs.isPrime(Integer.parseInt(String.format("%d%d", p3, p2)))) continue;
					for (int d = 0; d < primes.size(); d++) {
						int p4 = primes.get(d);
						if (!Funcs.isPrime(Integer.parseInt(String.format("%d%d", p1, p4))) || !Funcs.isPrime(Integer.parseInt(String.format("%d%d", p2, p4)))) continue;
						if (!Funcs.isPrime(Integer.parseInt(String.format("%d%d", p3, p4))) || !Funcs.isPrime(Integer.parseInt(String.format("%d%d", p4, p1)))) continue;
						if (!Funcs.isPrime(Integer.parseInt(String.format("%d%d", p4, p2))) || !Funcs.isPrime(Integer.parseInt(String.format("%d%d", p4, p3)))) continue;
						for (int e = 0; e < primes.size(); e++) {
							int p5 = primes.get(e);
							if (!Funcs.isPrime(Integer.parseInt(String.format("%d%d", p1, p5))) || !Funcs.isPrime(Integer.parseInt(String.format("%d%d", p2, p5)))) continue;
							if (!Funcs.isPrime(Integer.parseInt(String.format("%d%d", p3, p5))) || !Funcs.isPrime(Integer.parseInt(String.format("%d%d", p4, p5)))) continue;
							if (!Funcs.isPrime(Integer.parseInt(String.format("%d%d", p5, p1))) || !Funcs.isPrime(Integer.parseInt(String.format("%d%d", p5, p2)))) continue;
							if (!Funcs.isPrime(Integer.parseInt(String.format("%d%d", p5, p3))) || !Funcs.isPrime(Integer.parseInt(String.format("%d%d", p5, p4)))) continue;
							answer = p1 + p2 + p3 + p4 + p5;
							break first;
						}
					}
				}
			}
		}
		System.out.println(answer);
	}
}
