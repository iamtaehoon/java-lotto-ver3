package lotto;

import java.util.ArrayList;
import java.util.Scanner;

public class InputView {
	Scanner sc = new Scanner(System.in);

	public String getInput() {
		return sc.nextLine();
	}

	public String inputMoney() {
		System.out.println("구입금액을 입력해 주세요.");
		return getInput();
	}

	public String inputManualLottoCnt() {
		System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
		return getInput();
	}

	public void inputManualLottoTickets(int ticketCnt) {
		System.out.println("수동으로 구매할 번호를 입력해 주세요.");
	}

	public ArrayList<String> inputEachManualLottoTicket() {
		return StringUtil.makeTicket(getInput());
	}
}
