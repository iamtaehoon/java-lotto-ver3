package lotto.view;

import java.util.ArrayList;
import java.util.Scanner;

import lotto.StringUtil;

public class InputView {
	private static Scanner sc = new Scanner(System.in);

	public static String inputWinningNum() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		return getInput();
	}

	public static String inputBonusBall() {
		System.out.println("보너스 볼을 입력해 주세요.");
		return getInput();
	}

	private static String getInput() {
		return sc.nextLine();
	}

	public static String inputMoney() {
		System.out.println("구입금액을 입력해 주세요.");
		return getInput();
	}

	public static String inputManualLottoCnt() {
		System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
		return getInput();
	}

	public static void inputManualLottoTickets() {
		System.out.println("수동으로 구매할 번호를 입력해 주세요.");
	}

	public static ArrayList<String> inputEachManualLottoTicket() {
		return StringUtil.splitUsingComma(getInput());
	}
}
