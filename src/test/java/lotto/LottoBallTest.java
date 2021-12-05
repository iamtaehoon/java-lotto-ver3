package lotto;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoBallTest {

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 10, 34, 44, 45})
	void 로또공_생성_범위안(int ballNum) {
		LottoBall of = LottoBall.of(ballNum);
		System.out.println(of.toString());

		//문제가 안일어난다. 어떻게 검증을 할까
	}

	@ParameterizedTest
	@ValueSource(ints = {0,-1,-10,46,50,62,100})
	void 로또공_생성_범위밖_오류_발생(int ballNum) {
		LottoBall of = LottoBall.of(ballNum);
		Assertions.assertThatThrownBy(() -> of.toString()).isInstanceOf(NullPointerException.class);
		//문제가 안일어난다. 어떻게 검증을 할까
	}
}