
public class Problem_52 {
	/* It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits,
	 * but in a different order.
	 * 
	 * Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits. */
	public static void main(String[] args) {
		int answer = 0;
		for (int i = 1; answer == 0; i++)
			if (isApplicable(i)) answer = i;
		System.out.println(answer);
	}
	
	public static boolean isApplicable(int num) {
		String digits = Funcs.sortString(String.valueOf(num));
		for (int i = 2; i <= 6; i++)
			if (!Funcs.sortString(String.valueOf(i * num)).equals(digits)) return false;
		return true;
	}
}
