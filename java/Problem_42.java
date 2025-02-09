import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Problem_42 {

	/* The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten
	 * triangle numbers are:
	 * 
	 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
	 * 
	 * By converting each letter in a word to a number corresponding to its alphabetical position and
	 * adding these values we form a word value. For example, the word value for SKY is 19 + 11 + 25 = 55
	 * = t10. If the word value is a triangle number then we shall call the word a triangle word.
	 * 
	 * Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly
	 * two-thousand common English words, how many are triangle words? */
	public static void main(String[] args) {
		int answer = 0;
		try {
			Scanner file = new Scanner(new File("Problem_42_Data.txt"));
			Scanner sc = file.useDelimiter(",");
			while (sc.hasNext()) {
				String word = file.next();
				if (isTriWord(word.substring(1, word.length() - 1))) answer++;
			}
			file.close();
		} catch (FileNotFoundException e) {
			System.out.printf("Cannot find file '%s'.\n",
				e.getMessage().substring(0, e.getMessage().length() - 44));
		}
		System.out.println(answer);
	}

	public static boolean isTriWord(String word) {
		int charSum = 0;
		for (int i = 0; i < word.length(); i++)
			charSum += Character.getNumericValue(word.charAt(i)) - 9;
		return Funcs.isShapeNum(charSum).contains(3);
	}

}
