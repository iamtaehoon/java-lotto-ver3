package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

	@Test
	void 수동_방식으로_티켓_생성_정상_로직() {
		ArrayList<String> inputNumbers = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6"));
		LottoTicket lottoTicket = LottoTicket.makeLottoTicketByManual(inputNumbers);
		Assertions.assertThat(lottoTicket.getLottoTicket())
			.isEqualTo(new TreeSet<>(
				Arrays.asList(LottoBall.of(6), LottoBall.of(2), LottoBall.of(3), LottoBall.of(4), LottoBall.of(5),
					LottoBall.of(1))));
	}
}