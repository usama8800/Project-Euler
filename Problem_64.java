import java.util.ArrayList;

public class Problem_64 {

	public static void main(String[] args) {
		int count = 0;
		for (int i = 0; i <= 10000; i++) {
			System.out.println(i);
			if (CFE(Math.sqrt(i), new ArrayList<>(), new ArrayList<>()).size() % 2 == 0)
				count++;
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(count);
		// System.out.println(CFE(Math.sqrt(95), new ArrayList<>(), new
		// ArrayList<>()).size());
	}

	public static ArrayList<Integer> CFE(double m, ArrayList<Integer> list, ArrayList<Double> remainders) {
		int n = (int) m;
		list.add(n);
		m = 1 / (m - n);
		remainders.add(m);
		if (round(m, 3) == round(remainders.get(0), 3) && remainders.size() != 1)
			return list;
		else
			return CFE(m, list, remainders);
	}

	public static double round(double num, int decimals) {
		return Math.round(num * Math.pow(10, decimals)) / Math.pow(10, decimals);
	}
}
