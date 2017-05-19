
public class Problem_40 {

	/* An irrational decimal fraction is created by concatenating the positive integers:
	 * 
	 * 0.12345678910(1)112131415161718192021...
	 * 
	 * It can be seen that the 12th digit of the fractional part is 1.
	 * 
	 * If dn represents the nth digit of the fractional part, find the value of the following expression.
	 * 
	 * d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000 */
	public static void main(String[] args) {
		int limit = 1000000;
		int count = 0;
		int df = 1;
		int answer = 1;
		for (int i = 1; i < limit+1; i++) {
			if(count+String.valueOf(i).length()>=df) {
				answer *= Integer.parseInt(String.valueOf(i).substring(df-count-1,df-count));
				df*=10;
				if(df > limit) {
					i = limit+1;
					break;
				}
			}
			count+= String.valueOf(i).length();
		}
		System.out.println(answer);
	}
}
