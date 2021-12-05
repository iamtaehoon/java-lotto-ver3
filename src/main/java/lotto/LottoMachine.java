package lotto;

import static lotto.Constant.*;
import static lotto.LottoTicket.*;

import java.util.ArrayList;
import java.util.Arrays;

public class LottoMachine {
	private ArrayList<LottoTicket> allTickets;
	private ArrayList<String> winningTicket;
	private String bonusBall;
	private int answer;
	private ArrayList<Result> results = new ArrayList<>(
		Arrays.asList(new Result(Rank.LOSE), new Result(Rank.FIFTH), new Result(Rank.FOURTH), new Result(Rank.THIRD),
			new Result(Rank.SECOND), new Result(Rank.FIRST)));

	public void showAllTickets() {
		allTickets.stream().forEach(System.out::println);
	}

	public void inputWinningNumAndBonusBall() {
		winningTicket = StringUtil.makeTicket(InputView.inputWinningNum());
		bonusBall = InputView.inputBonusBall();
		validate(winningTicket, bonusBall);
	}

	private void validate(ArrayList<String> winningTicket, String bonusBall) {
		makeLottoTicketByManual(winningTicket);
		LottoBall.of(Integer.parseInt(bonusBall));
		for (String number : winningTicket) {
			if (number.equals(bonusBall)) {
				throw new IllegalArgumentException("보너스 볼은 당첨 숫자와 다른 숫자여야 합니다.");
			}
		}
	}

	public void receiveTickets(ArrayList<LottoTicket> tickets) {
		allTickets = tickets;
	}

	public void makeAutoTickets(int autoTicketCnt) {
		for (int i = 0; i < autoTicketCnt; i++) {
			allTickets.add(makeLottoTicketByAuto());
		}
	}

	public void getResult() {
		OutputView.getBeforeResult();
		ArrayList<Integer> winningNumber = new ArrayList<>();
		winningTicket.stream().forEach(x -> winningNumber.add(Integer.parseInt(x)));

		for (LottoTicket purchasedTicket : allTickets) {
			int match = purchasedTicket.matchNumberCnt(winningNumber);
			boolean hasBonusBall = purchasedTicket.isMatchBonusBall(Integer.parseInt(bonusBall));
			Rank rank = Rank.valueOf(match, hasBonusBall);
			results.get(results.indexOf(new Result(rank))).addCountThisRank();
		}
		results.stream()
			.filter(x -> !x.getRank().equals(Rank.LOSE))
			.forEach(x -> System.out.println(x.getRank().getMatch() + "개 일치 ("+x.getRank().getPrize()+")- " + x.getCountThisRank()+" 개"));
		for (Result result : results) {
			answer += result.getRank().getPrize() * result.getCountThisRank();
		}
		System.out.println(String.format("총 수익률은 %.2f%%입니다.", (double)answer/(allTickets.size()*LOTTO_TICKET_COST)));
	}
}
