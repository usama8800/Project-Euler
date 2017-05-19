
public class Problem_36 {

	/* The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.
	 * 
	 * Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
	 * 
	 * (Please note that the palindromic number, in either base, may not include leading zeros.) */
	public static void main(String[] args) {
		int answer = 0;
		for (int i = 1; i < 1000000; i++)
			if (isPalindrome(String.valueOf(i)) && isPalindrome(Integer.toBinaryString(i)))
				answer += i;
		System.out.println(answer);
	}

	public static boolean isPalindrome(String num) {
		String reverse = new StringBuilder(num).reverse().toString();
		return reverse.equals(num);
	}
}
