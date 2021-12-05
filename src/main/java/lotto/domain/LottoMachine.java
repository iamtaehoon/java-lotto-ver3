package lotto.domain;

import static lotto.domain.LottoTicket.*;

import java.util.ArrayList;

import lotto.StringUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachine {
	private ArrayList<LottoTicket> allTickets;
	private ArrayList<Integer> winningTicket;
	private int bonusBall;
	// private LinkedHashMap<Rank, Integer> results = new LinkedHashMap<>();
	private Result results = new Result();

	public void showAllTickets() {
		OutputView.showAllTickets(allTickets);
	}

	public void determineWinningTicketAndBonusBall() {
		ArrayList<String> inputWinningTicket = StringUtil.splitUsingComma(InputView.inputWinningNum());
		String inputBonusBall = InputView.inputBonusBall();
		validate(inputWinningTicket, inputBonusBall);
	}

	private void validate(ArrayList<String> inputWinningTicket, String inputBonusBall) {
		winningTicket = validateWinningTicket(inputWinningTicket);
		bonusBall = validateBonusBall(inputBonusBall);
		validateNoBonusBallInWinningNumber(winningTicket, bonusBall);
	}

	private ArrayList<Integer> validateWinningTicket(ArrayList<String> inputWinningTicket) {
		ArrayList<Integer> winningNumber = new ArrayList<>();
		makeLottoTicketByManual(inputWinningTicket);
		inputWinningTicket.stream().forEach(x -> winningNumber.add(Integer.parseInt(x)));
		return winningNumber;
	}

	private int validateBonusBall(String inputBonusBall) {
		int bonusBall = Integer.parseInt(inputBonusBall);
		LottoBall.of(bonusBall);
		return bonusBall;
	}

	private void validateNoBonusBallInWinningNumber(ArrayList<Integer> winningTicket, int bonusBall) {
		if (winningTicket.stream().filter(eachDigit -> eachDigit == bonusBall).findAny().isPresent()) {
			throw new IllegalArgumentException("보너스 볼은 당첨 숫자와 다른 숫자여야 합니다.");
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

	public int getResult() {
		OutputView.getBeforeResult();
		countRanksCnt();
		return OutputView.getResult(results.getResults());
	}

	private void countRanksCnt() {
		for (LottoTicket purchasedTicket : allTickets) {
			int matchingCnt = purchasedTicket.compare(winningTicket);
			boolean hasBonusBall = purchasedTicket.isMatchBonusBall(bonusBall);
			Rank thisTicketRank = Rank.valueOf(matchingCnt, hasBonusBall);
			results.addResult(thisTicketRank);
		}
	}
}
