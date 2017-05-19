import java.util.ArrayList;
import java.util.Collections;


public class Problem_49 {
	
	/* The arithmetic sequence, 1487, 4817, 8147, in which each of the terms
	 * increases by 3330, is unusual in two ways: (i) each of the three terms
	 * are prime, and, (ii) each of the 4-digit numbers are permutations of one
	 * another.
	 * 
	 * There are no arithmetic sequences made up of three 1-, 2-, or 3-digit
	 * primes, exhibiting this property, but there is one other 4-digit
	 * increasing sequence.
	 * 
	 * What 12-digit number do you form by concatenating the three terms in this
	 * sequence? */
	public static void main(String[] args) {
		ArrayList<String> answer = new ArrayList<>();
		for (int i = 1000;i < 10000;i++) {
			String num = String.valueOf(i);
			ArrayList<String> pps = new ArrayList<>();
			for (int j = 0;j < Funcs.factorial(4).intValue();j++) {
				String pp = Funcs.nextPermutation(num);
				if (!Funcs.isPrime(Integer.parseInt(pp)) || pp.startsWith("0") || pps.contains(pp)) pp = "";
				if (!pp.equals("")) pps.add(pp);
				num = Funcs.nextPermutation(num);
			}
			if (isAplicable(pps)) answer = pps;
		}
		System.out.println(answer.get(0) + answer.get(1) + answer.get(2));
	}
	
	public static boolean isAplicable(ArrayList<String> pps) {
		if (pps.size() != 3) return false;
		Collections.sort(pps);
		int diff = Integer.parseInt(pps.get(1)) - Integer.parseInt(pps.get(0));
		for (int i = 1;i < pps.size() - 1;i++)
			if (Integer.parseInt(pps.get(i + 1)) - Integer.parseInt(pps.get(i)) != diff) diff = 0;
		return diff != 0;
	}
}
