public class Problem_14 {

	public static void main(String[] args) {
		long answer = 0;
		long longest = 0;
		for (long i = 0; i < 1000000; i++) {
			long num = i;
			long counter = 1;
			while (num > 1) {
				if (num % 2 == 0) num /= 2;
				else num = 3 * num + 1;
				counter++;
			}
			if (counter > longest) {
				answer = i;
				longest = counter;
			}
		}
		System.out.println(answer);
	}
}
