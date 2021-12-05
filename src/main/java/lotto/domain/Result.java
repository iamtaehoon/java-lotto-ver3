package lotto.domain;

import java.util.LinkedHashMap;

public class Result {
	private LinkedHashMap<Rank, Integer> results = new LinkedHashMap<>();

	public Result() {
		results.put(Rank.LOSE, 0);
		results.put(Rank.FIFTH, 0);
		results.put(Rank.FOURTH, 0);
		results.put(Rank.THIRD, 0);
		results.put(Rank.SECOND, 0);
		results.put(Rank.FIRST, 0);
	}

	public void addResult(Rank thisTicketRank) {
		results.put(thisTicketRank, results.get(thisTicketRank) + 1);
	}

	public LinkedHashMap<Rank, Integer> getResults() {
		return results;
	}
}

