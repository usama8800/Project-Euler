import java.util.ArrayList;



public class Problem_7 {
	
	public static void main(String[] args) {
		int answer = 0;
		ArrayList<Integer> primes = getPrimes(10001);
		answer = primes.get(primes.size()-1);
		System.out.println(answer);
	}
	
	public static ArrayList<Integer> getPrimes(int howMany) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		int i = 2;
		while(primes.size()<howMany) {
			i++;
			boolean prime = true;
			for (int j = 0; j < primes.size(); j++) {
				if(i%primes.get(j)==0) {
					prime=false;
					break;
				}
			}
			if(prime) {
				primes.add(i);
			}
		}
		return primes;
	}
}
