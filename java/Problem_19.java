public class Problem_19 {

	public static void main(String[] args) {
		int day = 2;
		int answer = 0;
		for (int year = 1901; year <= 2000; year++) {
			boolean leap = year % 100 == 0 ? year % 400 == 0 ? true : false : year % 4 == 0 ? true
				: false;
			for (int month = 1; month <= 12; month++) {
				if (day == 7) answer++;
				int days = 30;
				if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10
					|| month == 12) days = 31;
				if (month == 2) days = leap ? 29 : 28;
				day = nextMonth(day, days);
			}
		}
		System.out.println(answer);
	}

	public static int nextMonth(int day, int days) {
		if (days > 0) {
			day++;
			if (day > 7) day = 1;
			nextMonth(day, days-1);
		}
		return day;
	}
}
