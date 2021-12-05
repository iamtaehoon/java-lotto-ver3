package lotto;

import java.util.ArrayList;

public class StringUtil {
	public static ArrayList<String> makeTicket(String input) {
		ArrayList<String> eachNumbersInTicket = new ArrayList<>();
		String[] numbers = input.split(", ");
		for (String number : numbers) {
			eachNumbersInTicket.add(number);
		}
		return eachNumbersInTicket;
	}
}
