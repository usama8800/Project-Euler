
public class Problem_58 {
	/* Starting with 1 and spiralling anticlockwise in the following way, a square spiral with side
	 * length 7 is formed.												@formatter:off
	 * 
	 * (37) 36  35  34  33  32 (31)
	 *  38 (17) 16  15  14 (13) 30
	 *  39  18 (05) 04 (03) 12  29
	 *  40  19  06  01  02  11  28
	 *  41  20 (07) 08  09  10  27
	 *  42  21  22  23  24  25  26
	 * (43) 44  45  46  47  48  49
	 *//*																@formatter:on
	 * It is interesting to note that the odd squares lie along the bottom right diagonal, but what is
	 * more interesting is that 8 out of the 13 numbers lying along both diagonals are prime; that is, a
	 * ratio of 8/13 ~= 62%.
	 * 
	 * If one complete new layer is wrapped around the spiral above, a square spiral with side length 9
	 * will be formed. If this process is continued, what is the side length of the square spiral for
	 * which the ratio of primes along both diagonals first falls below 10%? */
	public static void main(String[] args) {
		// top right 4n2 -2n+1
		// top left 4n2 +1
		// bottom left 4n2+2n+1
		// bottom right 4n2 + 4n +1
		int answer = 0;
		int totalNums = 0;
		int totalPrimes = 0;
		for (int i = 0; answer == 0; i++) {
			int tr = 4 * i * i - 2 * i + 1;
			int tl = 4 * i * i + 1;
			int br = 4 * i * i + 4 * i + 1;
			int bl = 4 * i * i + 2 * i + 1;
			totalNums += 4;
			if (Funcs.isPrime(tr)) totalPrimes++;
			if (Funcs.isPrime(tl)) totalPrimes++;
			if (Funcs.isPrime(br)) totalPrimes++;
			if (Funcs.isPrime(bl)) totalPrimes++;
			double ratio = ((double) totalPrimes / totalNums) * 100;
			System.out.printf("%d/%d\t%f\n", totalPrimes, totalNums, ratio);
			if (ratio < 10 && ratio != 0) answer = i * 2 + 1;
		}
		System.out.println(answer);
	}
}
