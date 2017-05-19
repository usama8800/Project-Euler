import java.math.BigInteger;



public class Problem_16 {

	public static void main(String[] args) {
		BigInteger tpt = new BigInteger("2");
		tpt = tpt.pow(1000);
		String tpts = tpt.toString();
		int answer = 0;
		for (int i = 0; i < tpts.length(); i++) {
			answer += Integer.parseInt(tpts.substring(i, i+1));
		}
		System.out.println(answer);
	}
}
