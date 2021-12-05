package lotto;

import static lotto.Constant.*;

public class Player {
	private int purchaseMoney;
	private int purchasedTicketCnt;
	
	public int inputMoney(String input) {
		purchaseMoney = validateInputMoney(input);
		purchasedTicketCnt = determinePurchasedTicketCnt();

		return purchasedTicketCnt;
	}

	private int determinePurchasedTicketCnt() {
		purchasedTicketCnt = (purchaseMoney / LOTTO_TICKET_COST);
		if (isLimitPurchasedTicket()) {
			return LIMIT_TICKET_CNT;
		}
		return purchasedTicketCnt;
	}

	private boolean isLimitPurchasedTicket() {
		if (purchasedTicketCnt > LIMIT_TICKET_CNT) {
			purchaseMoney = LIMIT_TICKET_CNT * LOTTO_TICKET_COST;
			return true;
		}
		return false;
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
