
public class Problem_27 {

	public static void main(String[] args) {
		int nl = 0, al = 0, bl = 0;
		for (int a = -999; a <= 999; a++) {
			for (int b = -999; b <= 999; b++) {
				int n = 0;
				while (isPrime(Math.abs(n * n + a * n + b)))
					n++;
				if (n > nl) {
					nl = n;
					al = a;
					bl = b;
				}
			}
		}
		System.out.printf("Formula: %dn2 + %dn + %d\n", nl, al, bl);
		System.out.println(al * bl);
	}

	private static boolean isPrime(int num) {
		if(num%2==0) return false;
		for (int i = 3; i*i <= num; i+=2) {
			if (num%i==0) return false;
		}
		return true;
	}
}
