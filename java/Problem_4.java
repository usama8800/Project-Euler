import java.util.ArrayList;

public class Problem_4 {

	public static void main(String[] args) {
		ArrayList<Integer> palindromes = new ArrayList<Integer>();
		int answer = 0;
		for (int i = 100; i < 1000; i++) {
			for (int j = 100; j < 1000; j++) {
				int number = i * j;
				String num = String.valueOf(number);
				if (num.length() % 2 == 0) {
					String h1 = num.substring(0, num.length() / 2);
					String h2 = num.substring(num.length() / 2);
					if (h1.charAt(0) == h2.codePointAt(2) && h1.charAt(1) == h2.charAt(1) && h1.charAt(2) == h2.charAt(0))
						palindromes.add(Integer.parseInt(num));
				}
			}
		}
		for (int i = 0; i < palindromes.size(); i++) {
			if (palindromes.get(i) > answer) answer = palindromes.get(i);
		}
		System.out.println(answer);
	}
}
