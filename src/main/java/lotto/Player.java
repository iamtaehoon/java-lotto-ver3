package lotto;

import static lotto.Constant.*;

public class Player {
	public int inputMoney(String input) {
		int money = validateInputMoney(input);
		int purchasedTicketCnt = (money / LOTTO_TICKET_COST);
		return purchasedTicketCnt;
	}

	private int validateInputMoney(String input) {
		int money = validateInputIsNumber(input);
		validateGreaterThanTicketCost(money);
		return money;
	}

	private void validateGreaterThanTicketCost(int money) {
		if (money < LOTTO_TICKET_COST) {
			throw new IllegalArgumentException("입력 금액이 부족합니다.");
		}
	}

	private int validateInputIsNumber(String input) {
		if (!input.matches(NUMBER_REGEX)) {
			throw new IllegalArgumentException("입력받은 금액은 숫자가 아닙니다.");
		}
		return Integer.parseInt(input);
	}
}
