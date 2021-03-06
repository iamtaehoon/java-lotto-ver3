package lotto.domain;

import static lotto.Constant.*;

import java.util.ArrayList;

import lotto.view.InputView;

public class Player {
	private int purchaseMoney;
	private int purchasedTicketCnt;
	private int manualTicketCnt;
	private ArrayList<LottoTicket> tickets = new ArrayList<>();
	
	public int calculateTotalTicketCnt(String input) {
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

	public int inputManualTicketCnt(String input) {
		int manualTicketCnt = validateInputIsNumber(input);
		validateManualTicketCnt(manualTicketCnt);
		this.manualTicketCnt = manualTicketCnt;
		return manualTicketCnt;
	}

	private void validateManualTicketCnt(int manualTicketCnt) {
		if (manualTicketCnt > purchasedTicketCnt) {
			throw new IllegalArgumentException("수동으로 구매할 로또의 수는 전체 로또의 수보다 클 수 없습니다.");
		}
		if (manualTicketCnt < 0) {
			throw new IllegalArgumentException("수동으로 구매할 로또의 수는 음수가 될 수 없습니다");
		}
	}

	public ArrayList<LottoTicket> inputManualTickets() {
		InputView.inputManualLottoTickets();
		for (int i = 0; i < manualTicketCnt; i++) {
			ArrayList<String> inputLottoNumbers = InputView.inputEachManualLottoTicket();
			tickets.add(LottoTicket.makeLottoTicketByManual(inputLottoNumbers));
		}
		return tickets;
	}
}
