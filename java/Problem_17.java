import java.util.ArrayList;

public class Problem_17 {

	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<String>();
		for (int i = 1; i < 1000; i++) {
			String num = String.valueOf(i);
			String niw = "";
			if (num.length() == 3) {
				String left = num.substring(1);
				switch (num.substring(0, 1)) {
					case "1":
						niw += ntw._100.toString();
						if (!left.equals("00"))  niw += ntw.and.toString();
						break;
					case "2":
						niw += ntw._200.toString();
						if (!left.equals("00"))  niw += ntw.and.toString();
						break;
					case "3":
						niw += ntw._300.toString();
						if (!left.equals("00"))  niw += ntw.and.toString();
						break;
					case "4":
						niw += ntw._400.toString();
						if (!left.equals("00"))  niw += ntw.and.toString();
						break;
					case "5":
						niw += ntw._500.toString();
						if (!left.equals("00"))  niw += ntw.and.toString();
						break;
					case "6":
						niw += ntw._600.toString();
						if (!left.equals("00"))  niw += ntw.and.toString();
						break;
					case "7":
						niw += ntw._700.toString();
						if (!left.equals("00"))  niw += ntw.and.toString();
						break;
					case "8":
						niw += ntw._800.toString();
						if (!left.equals("00"))  niw += ntw.and.toString();
						break;
					case "9":
						niw += ntw._900.toString();
						if (!left.equals("00"))  niw += ntw.and.toString();
						break;
				}
			}
			if (num.length() >= 2) {
				switch (num.substring(num.length() - 2, num.length() - 1)) {
					case "1":
						String left = num.substring(num.length() - 1);
						switch (left) {
							case "0":
								niw += ntw._10.toString();
								break;
							case "1":
								niw += ntw._11.toString();
								break;
							case "2":
								niw += ntw._12.toString();
								break;
							case "3":
								niw += ntw._13.toString();
								break;
							case "4":
								niw += ntw._14.toString();
								break;
							case "5":
								niw += ntw._15.toString();
								break;
							case "6":
								niw += ntw._16.toString();
								break;
							case "7":
								niw += ntw._17.toString();
								break;
							case "8":
								niw += ntw._18.toString();
								break;
							case "9":
								niw += ntw._19.toString();
								break;
						}
						break;
					case "2":
						niw += ntw._20.toString();
						break;
					case "3":
						niw += ntw._30.toString();
						break;
					case "4":
						niw += ntw._40.toString();
						break;
					case "5":
						niw += ntw._50.toString();
						break;
					case "6":
						niw += ntw._60.toString();
						break;
					case "7":
						niw += ntw._70.toString();
						break;
					case "8":
						niw += ntw._80.toString();
						break;
					case "9":
						niw += ntw._90.toString();
						break;
				}
			}
			if ((num.length() > 1 && !num.substring(num.length() - 2, num.length() - 1).equals("1"))
				|| num.length() == 1) {
				switch (num.substring(num.length() - 1)) {
					case "1":
						niw += ntw._1.toString();
						break;
					case "2":
						niw += ntw._2.toString();
						break;
					case "3":
						niw += ntw._3.toString();
						break;
					case "4":
						niw += ntw._4.toString();
						break;
					case "5":
						niw += ntw._5.toString();
						break;
					case "6":
						niw += ntw._6.toString();
						break;
					case "7":
						niw += ntw._7.toString();
						break;
					case "8":
						niw += ntw._8.toString();
						break;
					case "9":
						niw += ntw._9.toString();
						break;
				}
			}
			System.out.println(niw);
			names.add(niw);
		}
		names.add(ntw._1000.toString());
		int answer = 0;
		for (int i = 0; i < names.size(); i++) {
			answer += names.get(i).length();
		}
		System.out.println(answer);
	}

	public enum ntw {
		_1("One"), _2("Two"), _3("Three"), _4("Four"), _5("Five"), _6("Six"), _7("Seven"), _8("Eight"), _9(
			"Nine"), _10("Ten"), _11("Eleven"), _12("Twelve"), _13("Thirteen"), _14("Fourteen"), _15(
			"Fifteen"), _16("Sixteen"), _17("Seventeen"), _18("Eighteen"), _19("Nineteen"), _20("Twenty"), _30(
			"Thirty"), _40("Forty"), _50("Fifty"), _60("Sixty"), _70("Seventy"), _80("Eighty"), _90(
			"Ninety"), _100(_1+"Hundred"), _200(_2+"Hundred"), _300(_3+"Hundred"), _400(_4+"Hundred"), _500(
				_5+"Hundred"), _600(_6+"Hundred"), _700(_7+"Hundred"), _800(_8+"Hundred"), _900(_9
			+ "Hundred"), _1000(_1 + "Thousand"),and("And");

		String niw;

		private ntw(String niw) {
			this.niw = niw;
		}

		public String toString() {
			return niw;
		}
	}
}
