import java.math.BigInteger;


public class Problem_56 {
	
	/* A googol (10^100) is a massive number: one followed by one-hundred zeros; 100^100 is almost
	 * unimaginably large: one followed by two-hundred zeros. Despite their size, the sum of the digits
	 * in each number is only 1.
	 * 
	 * Considering natural numbers of the form, ab, where a^b < 100, what is the maximum digital sum? */
	public static void main(String[] args) {
		int answer = 0;
		for (int a = 0; a < 100; a++) {
			for (int b = 0; b < 100; b++) {
				int digitSum = Funcs.digitSum(new BigInteger(String.valueOf(a)).pow(b).toString());
				if(digitSum>answer) answer = digitSum;
			}
		}
		System.out.println(answer);
	}
	
}
