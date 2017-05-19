public class Problem_12 {

	public static void main(String[] args) {
		long answer = 0;
		long ctn = 0;
		int i = 0;
		while (numFactors(ctn) <= 500) {
			i++;
			ctn += i;
		}
		answer = ctn;
		System.out.println(answer);
	}

	public static int numFactors(long ctn) {
		if (ctn > 1) {
			int factors = 0;
			for (long i = 1; i * i <= ctn; i++) {
				if (ctn % i == 0) factors++;
			}
			factors*=2;
			if(Math.sqrt(ctn)%1==0) factors--;
			return factors;
		} else {
			return 1;
		}
	}
}
