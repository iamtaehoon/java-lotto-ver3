package lotto;

import static lotto.Constant.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.TreeSet;

public class LottoTicket{
	private TreeSet<LottoBall> lottoTicket;
	private static TreeSet<LottoBall> temp = new TreeSet<>();

	public TreeSet<LottoBall> getLottoTicket() {
		return lottoTicket;
	}

	private LottoTicket(TreeSet<LottoBall> lottoTicket) {
		this.lottoTicket = lottoTicket;
	}

	public static LottoTicket makeLottoTicketByAuto() {
		temp.clear();
		while (temp.size() != LOTTO_TICKET_NUMBER_CNT) {
			temp.add(LottoBall.of((int)(Math.random() * MAX_LOTTO_BALL + MIN_LOTTO_BALL)));
		}
		return new LottoTicket(temp);
	}

	public static LottoTicket makeLottoTicketByManual(ArrayList<String> inputNumbers) {
		temp.clear();
		checkParameterCntIsCorrect(inputNumbers);
		checkParametersAreNumber(inputNumbers);
		checkParameterMakeLottoBall(inputNumbers);
		return new LottoTicket(temp);
	}

	private static void checkParameterMakeLottoBall(ArrayList<String> inputNumbers) {
		inputNumbers.stream().forEach(number -> temp.add(LottoBall.of(Integer.parseInt(number))));
		if (temp.size() != LOTTO_TICKET_NUMBER_CNT) {
			throw new IllegalArgumentException("티켓에 중복되지 않는 6자리 숫자를 입력해주세요.");
		}
	}

	private static void checkParametersAreNumber(ArrayList<String> inputNumbers) {
		inputNumbers.stream().forEach(inputNumber -> {
			if (!inputNumber.matches(NUMBER_REGEX)) {
				throw new IllegalArgumentException("티켓에 6개의 숫자를 입력해주세요.");
			}
		});
	}

	private static void checkParameterCntIsCorrect(ArrayList<String> inputNumbers) {
		if (inputNumbers.size() != LOTTO_TICKET_NUMBER_CNT) {
			throw new IllegalArgumentException("티켓에 6개의 숫자를 입력해주세요.");
		}
	}
}