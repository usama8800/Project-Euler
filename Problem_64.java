public class Problem_64 {
	
	public static void main(String[] args) {
		int count = 0;
		for (int i = 1; i <= 10000; i++) {
			if (Funcs.CFESQRT.CFESqrt(i + " sqrt").size() % 2 == 0) count++;
		}
		System.out.println(count);
	}
}
