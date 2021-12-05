package lotto;


import java.util.ArrayList;

public class OutputView {

	public static void getBeforeResult() {
		System.out.println("당첨 통계\n---------");
	}

	public static void showAllTickets(ArrayList<LottoTicket> allTickets) {
		allTickets.stream().forEach(System.out::println);
	}

	public static int getResult(ArrayList<Result> results) {
		int totalPrizeMoney = 0;
		results.stream()
			.filter(x -> !x.getRank().equals(Rank.LOSE))
			.forEach(x -> System.out.println(x.getRank().getMatch() + "개 일치 ("+x.getRank().getPrize()+")- " + x.getCountThisRank()+" 개"));
		for (Result result : results) {
			totalPrizeMoney += result.getRank().getPrize() * result.getCountThisRank();
		}
		return totalPrizeMoney;
	}

	public static void showRateOfReturn(double rate) {
		System.out.println(String.format("총 수익률은 %.2f%%입니다.", rate));
	}
}
