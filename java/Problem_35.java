
public class Problem_35 {

	/* The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and
	 * 719, are themselves prime.
	 * 
	 * There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
	 * 
	 * How many circular primes are there below one million? */
	public static void main(String[] args) {
		int answer = 1;
		for (int i = 3; i < 1000000; i += 2)
			if (isCPrime(i)) answer++;
		System.out.println(answer);
	}

	private static boolean isCPrime(int x) {
		if (!isPrime(x)) return false;
		String num = String.valueOf(x);
		if (!isPrime(Integer.parseInt(num))) return false;
		for (int i = 0; i < factorial(num.length()); i++) {
			num = nextRotation(num);
			if (!isPrime(Integer.parseInt(num))) return false;
		}
		return true;
	}

	private static int factorial(int num) {
		int answer = 1;
		for (int i = 2; i < num; i++)
			answer *= i;
		return answer;
	}

	private static boolean isPrime(int num) {
		if (num % 2 == 0) return false;
		for (int i = 3; i * i <= num; i += 2)
			if (num % i == 0) return false;
		return true;
	}

	public static String nextRotation(String num) {
		String[] digits = num.split("");
		String first = digits[1];
		for (int i = 1; i < digits.length - 1; i++)
			digits[i] = digits[i + 1];
		digits[digits.length-1] = first;
		num = "";
		for (int i = 1; i < digits.length; i++) {
			num+=digits[i];
		}
		return num;
	}
}
