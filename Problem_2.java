import java.util.ArrayList;

public class Problem_2 {

	public static void main(String[] args) {
		ArrayList<Integer> fib = new ArrayList<Integer>();
		ArrayList<Integer> fibEven = new ArrayList<Integer>();
		int answer = 0;
		fib.add(1);
		fib.add(2);
		for (int i = 0; i < 1000000; i++) {
			int last = fib.get(fib.size() - 1);
			int secLast = fib.get(fib.size() - 2);
			int newLast = last + secLast;
			if (newLast > 4000000) break;
			fib.add(newLast);
		}
		for (int i = 0; i < fib.size(); i++) {
			if (fib.get(i) % 2 == 0) fibEven.add(fib.get(i));
		}
		for (int i = 0; i < fibEven.size(); i++) {
			answer += fibEven.get(i);
		}
		System.out.println(answer);
	}
}
