package lotto;

import java.util.TreeSet;

public class OutputView {
	public static void makeTicketToString(LottoTicket lottoTicket) {
		TreeSet<LottoBall> lotto = lottoTicket.getLottoTicket();
		// StringBuffer sb = new StringBuffer("[");
		// for (LottoBall lottoBall : lottoTicket) {
		// 	sb.append(lottoBall.getBallNum());
		// 	if (lottoBall != lottoTicket.last()) {
		// 		sb.append(", ");
		// 	}
		// }
		// sb.append("]");
		// System.out.println(sb);
	}
}
