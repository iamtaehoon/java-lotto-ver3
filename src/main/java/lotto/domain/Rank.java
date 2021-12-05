package lotto.domain;

import java.util.Arrays;

public enum Rank {
	LOSE(0, 0),
	FIFTH(3,5_000),
	FOURTH(4,50_000),
	THIRD(5,1_500_000),
	SECOND(5,30_000_000),
	FIRST(6,2_000_000_000);

	private int match;
	private int prize;

	Rank(int match, int prize) {
		this.match = match;
		this.prize = prize;
	}

	public int getMatch() {
		return match;
	}

	public int getPrize() {
		return prize;
	}

	public static Rank valueOf(int match, boolean hasBonusNumber) {
		if (match == 5) {
			return hasBonusNumber ? Rank.SECOND : Rank.THIRD;
		}
		return Arrays.stream(values())
			.filter(rank -> rank.getMatch() == match)
			.findFirst()
			.orElse(LOSE);
	}
}
