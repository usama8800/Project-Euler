import java.math.BigInteger;
import java.util.ArrayList;



public class Problem_29 {

	public static void main(String[] args) {
		ArrayList<BigInteger> dts = new ArrayList<BigInteger>();
		for (int a = 2; a <= 100; a++) {
			for (int b = 2; b <= 100; b++) {
				dts.add(new BigInteger(String.valueOf(a)).pow(b));
			}
		}
		for (int i = 0; i < dts.size(); i++) {
			for (int j = 0; j < dts.size(); j++) {
				if(i!=j && dts.get(i).equals(dts.get(j))) dts.remove(j);
			}
		}
		System.out.println(dts.size());
	}
}
