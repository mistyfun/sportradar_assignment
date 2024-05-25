package org.example.scoreboard;

import java.util.Comparator;

class Match implements Comparable {

    String homeTeam;
    String awayTeam;
    int homeScore;
    int awayScore;

    public Match(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(this.homeTeam)
                .append(" ")
                .append(this.homeScore)
                .append(" - ")
                .append(this.awayTeam)
                .append(" ")
                .append(this.awayScore);
        return str.toString();
    }

    @Override
    public int compareTo(Object obj) {
        // https://stackoverflow.com/a/25501226
        if (obj == null || this.getClass() != obj.getClass()) {
            throw new IllegalArgumentException("Object must be a non-null Match");
        }
        Match other = (Match) obj;
        return Comparator.comparingInt((Match match) -> match.homeScore + match.awayScore)
                .compare(other, this);
    }

}
