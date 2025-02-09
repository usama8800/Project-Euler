import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Problem_22 {

	public static void main(String[] args) {
		File file = new File("Problem_22_Data.txt");
		String dataString = "";
		try {
			Scanner data = new Scanner(file);
			while(data.hasNextLine()) {
				dataString = data.next();
			}
			data.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String[] names = dataString.split(",");
		for (int i = 0; i < names.length; i++) {
			names[i] = names[i].substring(1, names[i].length()-1);
		}
		Arrays.sort(names);
		int answer = 0;
		for (int i = 0; i < names.length; i++) {
			int nameScore = getAlphabeticValue(names[i]);
			nameScore *= i+1;
			answer+=nameScore;
		}
		System.out.println(answer);
	}
	
	public static int getAlphabeticValue(String alphabet) {
		int value = 0;
		for (int i = 0; i < alphabet.length(); i++) {
			value += (alphabet.charAt(i)-'A'+1);
		}
		return value;
	}
}
