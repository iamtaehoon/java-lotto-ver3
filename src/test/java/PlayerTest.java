import static lotto.Constant.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.domain.Player;

class PlayerTest {
	//메서드명_테스트상태_기대행위
	@ParameterizedTest
	@ValueSource(strings = {"1000","2000","10000","30000"})
	void 입력금액이_로또_1장_30장_사이일때_true(String input) {
		Player player = new Player();
		int allTicketCnt = player.calculateTotalTicketCnt(input);
		assertThat(allTicketCnt).isEqualTo(Integer.parseInt(input) / LOTTO_TICKET_COST);//구입금액
	}

	@ParameterizedTest
	@ValueSource(strings = {"999","500","1","0","-1","-100","-10000"})
	void 입력금액이_티켓금액보다_작을때_false(String input) {
		Player player = new Player();
		assertThatThrownBy(() -> player.calculateTotalTicketCnt(input)).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("입력 금액이 부족합니다.");
	}

	@ParameterizedTest
	@ValueSource(strings = {"ㅃㅂ","sq","dq1","123d","[[]","-"})
	void 입력금액이_숫자가_아닐때_false(String input) {
		Player player = new Player();
		assertThatThrownBy(() -> player.calculateTotalTicketCnt(input)).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("입력받은 금액은 숫자가 아닙니다.");
	}

	@ParameterizedTest
	@ValueSource(strings = {"30001","40000","100000","2131333"})
	void 입력금액이_티켓개수_제한_넘어갈때(String input) {
		Player player = new Player();
		int allTicketCnt = player.calculateTotalTicketCnt(input);
		assertThat(allTicketCnt).isEqualTo(LIMIT_TICKET_CNT);
	}

	@ParameterizedTest
	@ValueSource(strings = {"0","1","10","30"})
	void 수동_티켓_개수_입력이_정상(String input) {
		Player player = new Player();
		int allTicketCnt = player.calculateTotalTicketCnt("30000");
		int manualTicketCnt = player.inputManualTicketCnt(input);
		assertThat(manualTicketCnt <= allTicketCnt).isTrue();
	}

	@ParameterizedTest
	@ValueSource(strings = {"-1","-2","-10","-30"})
	void 수동_티켓_개수_입력이_음수(String input) {
		Player player = new Player();
		player.calculateTotalTicketCnt("30000");
		assertThatThrownBy(() -> player.inputManualTicketCnt(input)).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("수동으로 구매할 로또의 수는 음수가 될 수 없습니다");
	}

	@ParameterizedTest
	@ValueSource(strings = {"11","12","31","32","40","330"})
	void 수동_티켓_개수_입력이_전체_티켓_개수보다_많음(String input) {
		Player player = new Player();
		player.calculateTotalTicketCnt("10000");
		assertThatThrownBy(() -> player.inputManualTicketCnt(input)).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("수동으로 구매할 로또의 수는 전체 로또의 수보다 클 수 없습니다.");
	}

}