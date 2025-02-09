public class Problem_24 {

	public static void main(String[] args) {
		String permutation = "0123456789";
		for (int i = 0; i < 999999; i++) {
			permutation = nextPermutation(permutation);
		}
		System.out.println(permutation);
	}

	public static String nextPermutation(String pp) {
		int k = 0, l = 0;
		for (int i = pp.length() - 2; i >= 0; i--) {
			if (Character.getNumericValue(pp.charAt(i)) < Character.getNumericValue(pp.charAt(i + 1))) {
				k = i;
				break;
			}
		}
		for (int i = pp.length() - 1; i >= 0; i--) {
			if (Character.getNumericValue(pp.charAt(i)) > Character.getNumericValue(pp.charAt(k))) {
				l = i;
				break;
			}
		}
		char backupL = pp.charAt(l);
		char[] ppArray = pp.toCharArray();
		ppArray[l] = pp.charAt(k);
		ppArray[k] = backupL;
		pp = "";
		for (int i = 0; i < k + 1; i++) {
			pp += ppArray[i];
		}
		for (int i = ppArray.length - 1; i >= k + 1; i--) {
			pp += ppArray[i];
		}
		return pp;
	}
}
