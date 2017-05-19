public class Problem_21 {

	public static void main(String[] args) {
		int answer = 0;
		for (int i = 0; i < 10000; i++) {
			answer += isAmicable(i)?i:0;
		}
		System.out.println(answer);
	}

	public static boolean isAmicable(int num) {
		int sof1 = sumOfFactors(num);
		int sof2 = sumOfFactors(sof1);
		if(sof1==num) return false;
		return sof2 == num ? true : false;
	}

	public static int sumOfFactors(int num) {
		int sum = 0;
		for (int i = 1; i * i <= num; i++) {
			if (num % i == 0) {
				sum += i;
				if (i != 1) sum += (num / i);
			}
		}
		if (Math.sqrt(num) % 1 == 0) sum -= Math.sqrt(num);
		return sum;
	}
}
