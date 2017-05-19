import java.util.ArrayList;

public class Problem_33 {

	public static void main(String[] args) {
		ArrayList<String> fractions = new ArrayList<String>();
		for (int i = 10; i < 100; i++) {
			for (int j = 10; j < 100; j++) {
				String fraction = String.format("%d/%d", i, j);
				if (isNonTrivial(fraction)) fractions.add(fraction);
			}
		}
		double n = 1, answer = 1;
		for (int i = 0; i < fractions.size(); i++) {
			n *= Integer.parseInt(fractions.get(i).substring(0, fractions.get(i).indexOf("/")));
			answer *= Integer.parseInt(fractions.get(i).substring(fractions.get(i).indexOf("/")+1));
		}
		double num = n/answer;
		answer = 1;
		while(num%1!=0) {
			num*=10;
			answer*=10;
		}
		System.out.println(answer);
	}

	private static boolean isNonTrivial(String num) {
		String[] nad = num.split("/");
		if (nad[0].equals(nad[1]) || nad[0].substring(1).equals("0") || nad[1].substring(1).equals("0"))
			return false;
		double ans = Double.parseDouble(nad[0]) / Double.parseDouble(nad[1]);
		if (ans >= 1) return false;
		int common = getCommon(nad);
		if (common == -1) return false;
		nad[0] = nad[0].replaceFirst(String.valueOf(common), "");
		nad[1] = nad[1].replaceFirst(String.valueOf(common), "");
		if (Integer.parseInt(nad[1]) == 0) return false;
		if (ans == Double.parseDouble(nad[0]) / Double.parseDouble(nad[1])) return true;
		return false;
	}

	private static int getCommon(String[] nad) {
		for (int i = 0; i < 2; i++) {
			String n = nad[0].substring(i, i + 1);
			for (int j = 0; j < nad.length; j++) {
				String d = nad[1].substring(j, j + 1);
				if (n.equals(d)) return Integer.parseInt(n);
			}
		}
		return -1;
	}
}
