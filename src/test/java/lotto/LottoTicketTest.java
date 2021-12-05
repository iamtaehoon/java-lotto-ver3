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

	@Test
	void 수동_티켓_생성_로또번호_범위_벗어난_경우() {
		ArrayList<String> inputNumbers = new ArrayList<>(Arrays.asList("-1", "2", "3", "4", "5", "6"));
		Assertions.assertThatThrownBy(() -> LottoTicket.makeLottoTicketByManual(inputNumbers))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("로또 공은 1~45까지의 숫자만 가능합니다.");
	}

	@Test
	void 수동_티켓_생성_로또번호_6개_아닌_경우() {
		ArrayList<String> inputNumbers = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "6"));
		Assertions.assertThatThrownBy(() -> LottoTicket.makeLottoTicketByManual(inputNumbers))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("티켓에 6개의 숫자를 입력해주세요.");
	}

	@Test
	void 수동_티켓_생성_로또번호_중복_입력한_경우() {
		ArrayList<String> inputNumbers = new ArrayList<>(Arrays.asList("1", "2", "3", "1", "6","45"));
		Assertions.assertThatThrownBy(() -> LottoTicket.makeLottoTicketByManual(inputNumbers))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("티켓에 중복되지 않는 6자리 숫자를 입력해주세요.");
	}

}