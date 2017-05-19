import java.math.BigInteger;

public class Problem_48 {

	/* The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.
	 * 
	 * Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000. */
	public static void main(String[] args) {
		BigInteger sps = BigInteger.ZERO;
		for (int i = 1;i < 1001;i++)
			sps = sps.add(new BigInteger(String.valueOf(i)).pow(i));
		System.out.println(sps.toString().substring(sps.toString().length()-10, sps.toString().length()));
	}
}
