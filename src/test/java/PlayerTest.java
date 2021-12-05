import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.Player;

class PlayerTest {
	//메서드명_테스트상태_기대행위

	@ParameterizedTest
	@ValueSource(strings = {"1000","2000","10000","30000"})
	void 입력금액이_로또_1장_30장_사이일때_true(String input) {
		Player player = new Player();
		int allTicketCnt = player.inputMoney(input);
		assertThat(allTicketCnt).isEqualTo(Integer.parseInt(input) / 1000);//구입금액
	}
}