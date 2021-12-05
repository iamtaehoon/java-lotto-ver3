package lotto;

public class Result {
	Rank rank;
	int countThisRank;

	public Result(Rank rank) {
		this.rank = rank;
		this.countThisRank = 0;
	}
	public void addCountThisRank() {
		this.countThisRank += 1;
	}

	public Rank getRank() {
		return rank;
	}

	public int getCountThisRank() {
		return countThisRank;
	}

	@Override
	public String toString() {
		return "Result{" +
			"rank=" + rank +
			", countThisRank=" + countThisRank +
			'}';
	}


	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Result result = (Result)o;
		return rank == result.rank;
	}

}

