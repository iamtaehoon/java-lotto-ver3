package lotto;

import static lotto.LottoTicket.*;

import java.util.ArrayList;

public class LottoMachine {
	private ArrayList<LottoTicket> allTickets;

	public void showAllTickets() {
		allTickets.stream().forEach(System.out::println);
	}

	public void inputWinningNumAndBonusBall() {
		ArrayList<String> winningTicket = StringUtil.makeTicket(InputView.inputWinningNum());
		String bonusBall = InputView.inputBonusBall();
		validate(winningTicket, bonusBall);
	}

	private void validate(ArrayList<String> winningTicket, String bonusBall) {
		makeLottoTicketByManual(winningTicket);
		LottoBall.of(Integer.parseInt(bonusBall));
		for (String number : winningTicket) {
			if (number.equals(bonusBall)) {
				throw new IllegalArgumentException("보너스 볼은 당첨 숫자와 다른 숫자여야 합니다.");
			}
		}
	}
}
