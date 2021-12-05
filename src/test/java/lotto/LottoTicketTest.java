package lotto;

import java.util.ArrayList;
import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import lotto.domain.LottoTicket;

class LottoTicketTest {

	@Test
	void 수동_방식으로_티켓_생성_정상_로직() { // 테스트를 어떻게 하지? get 없애는 게 맞는거같음.
		ArrayList<String> inputNumbers = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6"));
		LottoTicket lottoTicket = LottoTicket.makeLottoTicketByManual(inputNumbers);
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

	@Test
	void 자동_티켓_생성_정상() { // 테스트를 어떻게 하지? get 없애는 게 맞는거같음.
		LottoTicket lottoTicket = LottoTicket.makeLottoTicketByAuto();
	}

}