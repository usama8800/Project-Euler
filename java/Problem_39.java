import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Problem_39 {

	/* If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are
	 * exactly three solutions for p = 120.
	 * 
	 * {20,48,52}, {24,45,51}, {30,40,50}
	 * 
	 * For which value of p ≤ 1000, is the number of solutions maximised? */
	public static void main(String[] args) {
		int answer = 0;
		int longest = 0;
		ArrayList<Integer> ps = new ArrayList<Integer>();
		Map<Integer, Integer> pso = new HashMap<Integer, Integer>();
		for (int a = 1; a < 500; a++)
			for (int b = 1; b < 500; b++)
				if (a < b) {
					double c = Math.sqrt(a * a + b * b);
					if (c % 1 != 0) continue;
					int p = (int) (a + b + c);
					if (p <= 1000) ps.add(p);
				}
		for (int i = 0; i < ps.size(); i++) {
			int num = ps.get(i);
			if (!pso.containsKey(num)) pso.put(num, 1);
			else pso.put(num, pso.get(num) + 1);
		}
		for (Map.Entry<Integer, Integer> entry : pso.entrySet())
			if (entry.getValue() > longest) {
				longest = entry.getValue();
				answer = entry.getKey();
			}
		System.out.printf("%d has %d solutions.",answer, longest );
	}
}
