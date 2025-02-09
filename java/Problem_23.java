import java.util.ArrayList;

public class Problem_23 {

	public static void main(String[] args) {
		ArrayList<Integer> abundantNumbers = new ArrayList<Integer>();
		long answer = 0;
		for (int i = 1; i < 28123; i++) {
			if (isAbundant(i)) {
				abundantNumbers.add(i);
			}
		}
		for (int i = 0; i < 28123; i++) {
			if(!isSumofAbundants(i, abundantNumbers)) answer += i;
		}
		System.out.println(answer);
	}

	public static boolean isSumofAbundants(int num, ArrayList<Integer> abundantNumbers) {
		boolean abundant = false;
		for (int i = 0; i < abundantNumbers.size(); i++) {
			int num2 = num-abundantNumbers.get(i);
			if(num2<0) break;
			if(isAbundant(num2)) {
				abundant = true;
				break;
			}
		}
		return abundant;
	}

	public static boolean isAbundant(int num) {
		return sumOfFactors(num) > num ? true : false;
	}

	public static int sumOfFactors(int num) {
		int sum = 0;
		for (int i = 1; i * i <= num; i++) {
			if (num % i == 0) {
				sum += i;
				if (i != 1) sum += num / i;
			}
		}
		if (Math.sqrt(num) % 1 == 0) sum -= Math.sqrt(num);
		return sum;
	}
}
