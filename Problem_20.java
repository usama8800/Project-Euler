import java.math.BigInteger;



public class Problem_20 {

	public static void main(String[] args) {
		String f100 = factorial(100);
		int answer = 0;
		for (int i = 0; i < f100.length(); i++) {
			answer += Integer.parseInt(f100.substring(i, i+1));
		}
		System.out.println(answer);
	}
	
	public static String factorial(int num) {
		BigInteger factorial = BigInteger.ONE;
		for (int i = 1; i <= num; i++) {
			factorial = factorial.multiply(new BigInteger(String.valueOf(i)));
		}
		return String.valueOf(factorial);
	}
}
