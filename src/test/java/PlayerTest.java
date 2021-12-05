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

	@ParameterizedTest
	@ValueSource(strings = {"999","500","1","0","-1","-100","-10000"})
	void 입력금액이_티켓금액보다_작을때_false(String input) {
		Player player = new Player();
		assertThatThrownBy(() -> player.inputMoney(input)).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("입력 금액이 부족합니다.");
	}

	@ParameterizedTest
	@ValueSource(strings = {"ㅃㅂ","sq","dq1","123d","[[]","-"})
	void 입력금액이_숫자가_아닐때_false(String input) {
		Player player = new Player();
		assertThatThrownBy(() -> player.inputMoney(input)).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("입력받은 금액은 숫자가 아닙니다.");
	}
}