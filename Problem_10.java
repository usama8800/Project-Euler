import java.util.ArrayList;

public class Problem_10 {

	public static void main(String[] args) {
		long answer = 0l;
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for(int i = 2;i<2000000;i++) {
			boolean prime = true;
			for (int j = 0; j*j < primes.size(); j++) {
				if (i % primes.get(j) == 0) {
					prime = false;
					break;
				}
			}
			if (prime) {
				primes.add(i);
				answer += i;
				if(i!=2) i++;
			}
		}
//		System.out.println(primes);
		System.out.println(answer);
	}
}
