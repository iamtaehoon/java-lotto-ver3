package lotto.view;


import java.util.ArrayList;
import java.util.LinkedHashMap;

import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.domain.Result;

public class OutputView {
	static int totalPrizeMoney = 0;

	public static void getBeforeResult() {
		System.out.println("당첨 통계\n---------");
	}

	public static void showAllTickets(ArrayList<LottoTicket> allTickets) {
		allTickets.stream().forEach(System.out::println);
	}

	public static int getResult(LinkedHashMap<Rank, Integer> results) {
		results.remove(Rank.LOSE);
		results.forEach((rank,count) -> {
			System.out.println(rank.getMatch() + "개 일치 (" + rank.getPrize() + ")- " + count + " 개");
			totalPrizeMoney += rank.getPrize() * count;
		});
		return totalPrizeMoney;
	}

	public static void showRateOfReturn(double rate) {
		System.out.println(String.format("총 수익률은 %.2f%%입니다.", rate));
	}
}
