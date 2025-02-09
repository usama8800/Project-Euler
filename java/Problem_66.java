import java.math.BigInteger;
import java.util.ArrayList;

public class Problem_66 {
	public static void main(String[] args) {
		BigInteger max = BigInteger.ZERO;
		BigInteger maxD = max;
		for (BigInteger d = BigInteger.ONE; d.compareTo(BigInteger.valueOf(1000L)) <= 0; d = d.add(BigInteger.ONE)) {
			double sqrt = Math.sqrt(d.doubleValue());
			if ((int) sqrt == sqrt) continue;
			int i = 2;
			BigInteger ans = BigInteger.ZERO;
			BigInteger x = BigInteger.ZERO;
			BigInteger y = BigInteger.ZERO;
			while (!ans.equals(BigInteger.ONE)) {
				ArrayList<Integer> cfe = Funcs.CFESQRT.CFESqrt(d + " sqrt");
				String[] frac = Funcs.getPostFixFraction(Funcs.postFixToInfix(Funcs.CFESQRT.getConvergent(i, cfe)));
				x = new BigInteger(frac[0]);
				y = new BigInteger(frac[1]);
				ans = x.multiply(x).subtract(y.multiply(y).multiply(d));
				i++;
			}
			if (max.compareTo(x) == -1) {
				max = x;
				maxD = d;
			}
		}
		System.out.println("MAX: " + maxD);
	}
	
}
