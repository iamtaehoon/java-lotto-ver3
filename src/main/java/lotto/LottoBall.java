package lotto;

import static lotto.Constant.*;

import java.util.HashMap;
import java.util.Map;

public class LottoBall {
	private static Map<Integer, LottoBall> lottoBallCache = new HashMap<>();

	static {
		for (int ballNum = MIN_LOTTO_BALL; ballNum < MAX_LOTTO_BALL + 1; ballNum++) {
			lottoBallCache.put(ballNum, new LottoBall(ballNum));
		}
	}

	private int ballNum;

	private LottoBall(int ballNum) {
		this.ballNum = ballNum;
	}

	public static LottoBall of(int ballNum) {
		return lottoBallCache.get(ballNum);
	}

}
