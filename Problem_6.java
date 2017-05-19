

public class Problem_6 {

	public static void main(String[] args) {
		int answer = 0;
		int p1 = 0;
		int p2 = 0;
		for (int i = 0; i <= 100; i++) {
			p1+=i*i;
			p2+=i;
		}
		p2*=p2;
		answer = p2-p1;
		System.out.println(answer);
	}
}
