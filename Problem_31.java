public class Problem_31 {

	public static void main(String[] args) {
		// done on excel first
		int[] pennies = { 1, 2, 5, 10, 20, 50, 100, 200 };
		int[][] table = new int[200 + 1][pennies.length];
		for (int i = 0; i < 2; i++) { // first two rows 1
			for (int j = 0; j < table[0].length; j++) {
				table[i][j] = 1;
			}
		}
		for (int i = 2; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				if (j == 0) table[i][j] = 1;
				else {
					table[i][j] = table[i][j - 1];
					if (i >= pennies[j]) table[i][j] += table[i - pennies[j]][j];
				}
			}
		}
		for (int i = 0; i < table.length; i++) {
			System.out.printf("%3d: [", i);
			for (int j = 0; j < table[i].length; j++) {
				System.out.printf(
					"%" + (String.valueOf(table[table.length - 1][table[0].length - 1]).length()) + "d",
					table[i][j]);
				if (j + 1 != table[i].length) System.out.printf(", ");
			}
			System.out.println("]");
		}
		System.out.printf("\nAnswer is %d", table[table.length - 1][table[0].length - 1]);
	}
}
