package lotto;

import java.util.ArrayList;

public class LottoTicket {
	private ArrayList<LottoBall> lottoTicket;

	private LottoTicket(ArrayList<LottoBall> lottoTicket) {
		this.lottoTicket = lottoTicket;
	}

	// public static LottoTicket makeLottoTicketByManual(ArrayList<String> lottoBalls) {
	// 	// 1. 입력값이 6개로 나눠지는가를 확인한다.
	// 	// 2. String을 모두 Ball로 만든다. -> Ball로 안만들어지면 예외를 낸다.
	// 	// 3. 하나씩 로또 티켓에 넣는다. 근데 중복이면 예외를 낸다.
	// 	// 4. 만들어진 값이 6개인가 체크하고 결과를 만든다.
	//
	// 	return null;
	// }

	//자동 방식으로 생성
}
