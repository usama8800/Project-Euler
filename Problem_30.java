public class Problem_30 {

	public static void main(String[] args) {
		int answer = 0;
		for (int i = 1000; i < 5 * Math.pow(9, 5); i++) {
			if (isAplicable(i)) answer += i;
		}
		System.out.println(answer);
	}

	private static boolean isAplicable(int num) {
		String[] digits = String.valueOf(num).split("");
		int sum = 0;
		for (int i = 1; i < digits.length; i++)
			sum += Math.pow(Integer.parseInt(digits[i]), 5);
		if (sum == num) return true;
		return false;
	}
}
