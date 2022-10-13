package cw.learn.poker;

public class Card {
    String suite;
    String rank;

    public Card(String suite, String rank) {
        this.suite = suite;
        this.rank = rank;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int toNumber(){
        return switch (rank) {
            case "A" -> 1;
            case "J" -> 11;
            case "Q" -> 12;
            case "K" -> 13;
            default -> Integer.parseInt(rank);
        };
    }

    @Override
    public String toString() {
        return "suite: " + suite + "  rank: " + rank;
    }
}
