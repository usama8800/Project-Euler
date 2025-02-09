public class Problem_5 {

	public static void main(String[] args) {
		double answer = 0;
		boolean found = false;
		double i = 2520;
		while (!found) {
			i += 2520;
			boolean lcm = true;
			for (double j = 11; j < 21; j++) {
				if (i % j != 0) {
					lcm = false;
					break;
				}
			}
			if (lcm) {
				answer = i;
				found = true;
			}
		}
		System.out.println(answer);
	}
}
