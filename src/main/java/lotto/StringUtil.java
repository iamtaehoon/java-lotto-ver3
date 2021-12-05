package lotto;

import java.util.ArrayList;

public class StringUtil {
	public static ArrayList<String> makeTicket(String input) {
		ArrayList<String> eachNumbersInTicket = new ArrayList<>();
		String[] numbers = input.split(", ");
		if (numbers.length != 6) {
			throw new IllegalArgumentException("번호는 여섯 개를 입력해야 합니다.");
		}
		for (String number : numbers) {
			eachNumbersInTicket.add(number);
		}
		return eachNumbersInTicket;
	}
}
