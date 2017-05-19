
public class Problem_68 {
	/* Consider the following "magic" 3-gon ring, filled with the numbers 1 to 6, and each line adding to nine.
	 * 
	 * Pic 1
	 * 
	 * Working clockwise, and starting from the group of three with the numerically lowest external node (4,3,2 in this example), each solution can be described
	 * uniquely. For example, the above solution can be described by the set: 4,3,2; 6,2,1; 5,1,3.
	 * 
	 * It is possible to complete the ring with four different totals: 9, 10, 11, and 12. There are eight solutions in total.
	 * 																															@formatter:off
	 * Total					Solution Set
	 * 9 					4,2,3; 5,3,1; 6,1,2
	 * 9 					4,3,2; 6,2,1; 5,1,3
	 * 10 					2,3,5; 4,5,1; 6,1,3
	 * 10 					2,5,3; 6,3,1; 4,1,5
	 * 11 					1,4,6; 3,6,2; 5,2,4
	 * 11 					1,6,4; 5,4,2; 3,2,6
	 * 12 					1,5,6; 2,6,4; 3,4,5
	 * 12 					1,6,5; 3,5,4; 2,4,6
	 *//*																														@formatter:on
	 * By concatenating each group it is possible to form 9-digit strings; the maximum string for a 3-gon ring is 432621513.
	 * 
	 * Using the numbers 1 to 10, and depending on arrangements, it is possible to form 16- and 17-digit strings. What is the maximum 16-digit string for a "magic" 5-gon
	 * ring?
	 * 
	 * Pic 2 */
	public static void main(String[] args) {
		long max = 0;
		for (int a = 1; a <= 10; a++) {
			for (int b = 1; b <= 10; b++) {
				if (b == a) continue;
				for (int c = 1; c <= 10; c++) {
					if (c == a || c == b) continue;
					for (int d = 1; d <= 10; d++) {
						if (d == a || d == b || d == c) continue;
						for (int e = 1; e <= 10; e++) {
							if (e == a || e == b || e == c || e == d) continue;
							for (int f = 1; f <= 10; f++) {
								if (f == a || f == b || f == c || f == d || f == e) continue;
								for (int g = 1; g <= 10; g++) {
									if (g == a || g == b || g == c || g == d || g == e || g == f) continue;
									for (int h = 1; h <= 10; h++) {
										if (h == a || h == b || h == c || h == d || h == e || h == f || h == g) continue;
										for (int i = 1; i <= 10; i++) {
											if (i == a || i == b || i == c || i == d || i == e || i == f || i == g || i == h) continue;
											jFor: for (int j = 1; j <= 10; j++) {
												if (j == a || j == b || j == c || j == d || j == e || j == f || j == g || j == h || j == i) continue;
												int[][] values = { {a, b, c}, {d, c, e}, {f, e, g}, {h, g, i}, {j, i, b}};
												int lineSum = a + b + c;
												for (int k = 1; k < values.length; k++) {
													int sum = 0;
													for (int l = 0; l < values[k].length; l++) {
														sum += values[k][l];
													}
													if (sum != lineSum) continue jFor;
												}
												int min = 11;
												int minIndex = -1;
												for (int k = 0; k < values.length; k++) {
													if (values[k][0] < min) {
														min = values[k][0];
														minIndex = k;
													}
												}
												StringBuilder sb = new StringBuilder();
												for (int k = minIndex; k < values.length + minIndex; k++) {
													int ii = k;
													if (ii >= values.length) ii -= values.length;
													for (int l = 0; l < values[ii].length; l++) {
														sb.append(values[ii][l]);
													}
												}
												long num = Long.parseLong(sb.toString());
												if (sb.length() == 16 && num > max) max = num;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(max);
		int war;
	}
}
