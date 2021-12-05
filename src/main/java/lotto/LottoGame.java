package lotto;

import static lotto.Constant.*;

import java.util.ArrayList;

public class LottoGame {
	private Player player = new Player();
	private LottoMachine machine = new LottoMachine();
	private ArrayList<LottoTicket> lottoTickets;
	private int totalTicketCnt;
	private int manualTicketCnt;
	private int autoTicketCnt;

	public void start() {
		initializeGame();
		showResult();
	}

	private void showResult() {
		machine.showAllTickets();
		machine.determineWinningTicketAndBonusBall();
		int totalPrizeMoney = machine.getResult();
		double rateOfReturn = (double) totalPrizeMoney / (LOTTO_TICKET_COST * lottoTickets.size());
		OutputView.showRateOfReturn(rateOfReturn);
	}

	private void initializeGame() {
		determineTicketsCnt();
		makeManulTickets();
		machine.makeAutoTickets(autoTicketCnt);
	}

	private void makeManulTickets() {
		lottoTickets = player.inputManualTickets();
		machine.receiveTickets(lottoTickets);
	}

	private void determineTicketsCnt() {
		totalTicketCnt = player.calculateTotalTicketCnt(InputView.inputMoney());
		manualTicketCnt = player.inputManualTicketCnt(InputView.inputManualLottoCnt());
		autoTicketCnt = totalTicketCnt - manualTicketCnt;
	}
}
