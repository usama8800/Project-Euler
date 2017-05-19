public class Problem_9 {
	public static void main(String[] args) {
		int answer = 0;
		for (int a = 1;a < 500;a++)
			for (int b = 1;b < 500;b++)
				if (a < b) {
					double c = Math.sqrt(a * a + b * b);
					if ((int) c == c) System.out.printf("%d\u00b2 + %d\u00b2 = %d\u00b2\n", a, b, (int) c);
					if (c % 1 == 0 && a + b + c == 1000) answer += a * b * c;
				}
		System.out.println(answer);
	}
}
