
public class Problem_51 {
	/* By replacing the 1st digit of the 2-digit number *3, it turns out that
	 * six of the nine possible values: 13, 23, 43, 53, 73, and 83, are all
	 * prime.
	 * 
	 * By replacing the 3rd and 4th digits of 56**3 with the same digit, this
	 * 5-digit number is the first example having seven primes among the ten
	 * generated numbers, yielding the family: 56003, 56113, 56333, 56443,
	 * 56663, 56773, and 56993. Consequently 56003, being the first member of
	 * this family, is the smallest prime with this property.
	 * 
	 * Find the smallest prime which, by replacing part of the number (not
	 * necessarily adjacent digits) with the same digit, is part of an eight
	 * prime value family. */
	public static void main(String[] args) {
		int answer = 0;
		for (int i = 100000; answer == 0 && i < 999999; i++)
			if (isAplicable(i)) answer = i;
		System.out.println(answer);
	}

	private static boolean isAplicable(int num) {
		if (!Funcs.isPrime(num)) return false;
		String prime = String.valueOf(num);
		String repeating = "";
		for (int i = 0, sum = 0; sum != 3 && i < 10; sum = 0, i++) {
			String iString = String.valueOf(i);
			for (int j = 0; j < prime.length(); j++)
				if (prime.substring(j, j + 1).equals(iString)) sum++;
			if (sum == 3) repeating = iString;
		}
		if (repeating.equals("")) return false;
		StringBuilder regex = new StringBuilder(prime);
		regex.replace(0, regex.length(), repeating);
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			String newPrime = prime.replaceAll(regex.toString(), String.valueOf(i));
			if (newPrime.startsWith("0")) continue;
			if (Funcs.isPrime(Integer.parseInt(newPrime))) sum++;
		}
		return sum == 8;
	}
}
