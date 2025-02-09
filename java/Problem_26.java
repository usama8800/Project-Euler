import java.util.HashMap;

public class Problem_26 {

	public static void main(String[] args) {
		int longestRecursion = 0;
		int answer = 0;
		for (int den = 999; den > 980; den-=2) {
			HashMap<Integer, Integer> quotient = new HashMap<Integer, Integer>();
			for (int i = 1; i <= den; i++) {
				quotient.put(i, 0);
			}
			int count = 0;
			int num = 1;
			while(quotient.get(num)==0 && num!=0) {
				quotient.put(num, count);
				num*=10;
				num%=den;
				count++;
			}
			int difference = count-quotient.get(num);
			if(difference>longestRecursion) {
				longestRecursion=difference;
				answer = den;
			}
		}
		System.out.println(answer);
	}
}
