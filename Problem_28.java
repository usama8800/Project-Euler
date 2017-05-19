

public class Problem_28 {

	public static void main(String[] args) {
		int rows = 1;
		int sum = 1;
		int num = 1;
		while(rows<1001) {
			for (int i = 0; i < 4; i++) {
				num+=rows+1;
				sum+=num;
			}
			rows+=2;
		}
		System.out.println(sum);
	}
}
