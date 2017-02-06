package nbpapp.UserComunication;

import java.util.Scanner;

public class ConsoleComunication {

	public static void warning() {
		System.out.println(Messages.GOLD_APP_INFO);
		System.err.println(Messages.NOT_ADVAICE_WARRNING);
	}

	public static int getDaysRange() {
		int daysRange;
		String text = null;
		try (Scanner input = new Scanner(System.in)) {
			System.out.println(Messages.RANGE_OF_DAYS);
			try {
				text = input.nextLine();
				daysRange = Integer.parseInt(text);
			} catch (NumberFormatException e) {
				System.out.println(Messages.INCORRECT_DATA_FORMAT);
				daysRange = getDaysRange();
			}

			if (daysRange <= 0 || daysRange > 255) {
				System.out.println(Messages.INCORRECT_VALUE);
				daysRange = getDaysRange();
			}
		}
		return daysRange;

	}
	
	public static void recomendationPrintln(String text) {
		System.out.println(Messages.RECOMENDATION + ": " + text);
	}

}
