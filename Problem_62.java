import java.math.BigInteger;
import java.util.ArrayList;


public class Problem_62 {
	/* The cube, 41063625 (345^3), can be permuted to produce two other cubes: 56623104 (384^3) and 66430125 (405^3). In fact, 41063625 is the smallest cube which has
	 * exactly three permutations of its digits which are also cube.
	 * 
	 * Find the smallest cube for which exactly five permutations of its digits are cube. */
	public static void main(String[] args) {
		BigInteger answer = BigInteger.ZERO;
		int counter = 10;
		ArrayList<BigInteger> cubes = new ArrayList<>();
		while (answer.equals(BigInteger.ZERO)) {
			BigInteger cube = new BigInteger(String.valueOf(counter)).pow(3);
			cubes.add(cube);
			int perms = 0;
			for (int i = 0; i < cubes.size(); perms = (Funcs.isPermutation(String.valueOf(cube), String.valueOf(cubes.get(i)))) ? perms + 1 : perms, i++);
			if (perms == 5) answer = cube;
			if (String.valueOf(cube).length() > String.valueOf(cubes.get(0)).length()) cubes = clean(cubes);
			counter++;
		}
		for (int i = 0; i < cubes.size(); i++) {
			if (Funcs.isPermutation(String.valueOf(answer), String.valueOf(cubes.get(i)))) {
				System.out.println(cubes.get(i));
				break;
			}
		}
	}

	private static ArrayList<BigInteger> clean(ArrayList<BigInteger> cubes) {
		int lastLength = String.valueOf(cubes.get(cubes.size() - 1)).length();
		for (int i = 0; i < cubes.size(); i++) {
			if (String.valueOf(cubes.get(i)).length() < lastLength) {
				cubes.remove(i);
				i--;
			} else break;
		}
		return cubes;
	}

}
// 127035954683