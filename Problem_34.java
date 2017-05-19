import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Problem_34 {

	public static void main(String[] args) {
		Map<Integer, Integer> factorials = new HashMap<Integer, Integer>();
		ArrayList<Integer> dFacs = new ArrayList<Integer>();
		for (int i = 3; i < factorial(9, factorials); i++) {
			String num = String.valueOf(i);
			ArrayList<String> digits = new ArrayList<String>();
			Collections.addAll(digits, num.split(""));
			digits.remove(0);
			int sum = 0;
			for (int j = 0; j < digits.size(); j++)
				sum += factorial(Integer.parseInt(digits.get(j)), factorials);
			if (sum == i) dFacs.add(i);
		}
		int answer = 0;
		for (int i = 0; i < dFacs.size(); i++) 
			answer += dFacs.get(i);
		System.out.println(answer);
	}

	private static int factorial(int num, Map<Integer, Integer> factorials) {
		if (factorials.get(num) != null) return factorials.get(num);
		int answer = 1;
		for (int i = 2; i <= num; i++)
			answer *= i;
		factorials.put(num, answer);
		return answer;
	}
}
