package lotto;

import java.util.ArrayList;

public class LottoMachine {
	private ArrayList<LottoTicket> allTickets;

	public void showAllTickets() {
		allTickets.stream().forEach(OutputView::makeTicketToString);

	}
}
