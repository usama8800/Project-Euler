import java.util.ArrayList;

public class Problem_64 {

	public static void main(String[] args) {
		// int count = 0;
		// for (int i = 0; i <= 10000; i++) {
		// System.out.println(i);
		// if (CFE(i + " sqrt", new ArrayList<>(), "").size() % 2 == 0)
		// count++;
		// }
		// System.out.println(count);
		System.out.println(CFE("67 sqrt", new ArrayList<>(), ""));
	}

	public static ArrayList<Integer> CFE(String x, ArrayList<Integer> list, String endPoint) {
		double m = Funcs.postFixToNumber(x);
		int n = (int) m;
		list.add(n);
		m = 1 / (m - n); // x = "7 sqrt"
		x = optimizePostFix(String.format("1 %s %d - /", x, n));
		System.out.println(x);
		if (endPoint.equals(""))
			endPoint = x;
		if (Funcs.round(Funcs.postFixToNumber(x), 5) == Funcs.round(Funcs.postFixToNumber(endPoint), 5)
				&& list.size() != 1)
			return list;
		else
			return CFE(x, list, endPoint);
	}

	public static String optimizePostFix(String x) {
		return x;
	}
}
