package lotto;

public class LottoGame {
	Player player = new Player();
	LottoMachine machine = new LottoMachine();
	public void start() {
		int totalTicketCnt = player.inputMoney(InputView.inputMoney());
		int manualTicketCnt = player.inputManualTicketCnt(InputView.inputManualLottoCnt());
		player.inputManualTickets();
		player.giveTickets(machine);
		machine.makeAutoTickets(totalTicketCnt - manualTicketCnt);
		machine.showAllTickets();
	}
}
