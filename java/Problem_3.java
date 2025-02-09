import java.util.ArrayList;

public class Problem_3 {

	public static void main(String[] args) {
		long num = 600851475143L;
		int answer = 0;
		ArrayList<Integer> primeNums = new ArrayList<Integer>();
		for (int i = 1; i < 1000000; i++) {
			if (num % i == 0) {
				primeNums.add(i);
				num /= i;
			}
		}
		for (int i = 0; i < primeNums.size(); i++) {
			if(primeNums.get(i)>answer) answer = primeNums.get(i);
		}
		System.out.println(answer);
	}
}
