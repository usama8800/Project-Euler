public class Problem_37 {

	/* The number 3797 has an interesting property. Being prime itself, it is possible to continuously
	 * remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly
	 * we can work from right to left: 3797, 379, 37, and 3.
	 * 
	 * Find the sum of the only eleven primes that are both truncatable from left to right and right to
	 * left.
	 * 
	 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes. */
	public static void main(String[] args) {
		int answer = 0;
		int found = 0;
		int i = 11;
		while (found < 11) {
			if (isTruncatablePrime(String.valueOf(i))) {
				answer += i;
				found++;
			}
			i += 2;
		}
		System.out.println(answer);
	}

	private static boolean isTruncatablePrime(String num) {
		if (!isPrime(Integer.parseInt(num))) return false;
		for (int i = 1; i < num.length(); i++)
			if (!isPrime(Integer.parseInt(num.substring(i)))) return false;
		for (int i = num.length() - 1; i > 0; i--)
			if (!isPrime(Integer.parseInt(num.substring(0, i)))) return false;
		return true;
	}

	private static boolean isPrime(int num) {
		if (num == 2 || num == 3) return true;
		if (num % 2 == 0 || num == 1) return false;
		for (int i = 3; i * i <= num; i += 2)
			if (num % i == 0) return false;
		return true;
	}

}
