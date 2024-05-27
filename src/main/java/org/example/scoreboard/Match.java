package org.example.scoreboard;

import java.util.Comparator;

class Match implements Comparable<Match> {

    static int matchesStarted = 0;

    String homeTeam;
    String awayTeam;
    int homeScore;
    int awayScore;
    int matchNumber;

    public Match(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = 0;
        this.awayScore = 0;
        this.matchNumber = Match.matchesStarted++;
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
    public int compareTo(Match other) {
        // https://stackoverflow.com/a/25501226
        return Comparator.comparingInt((Match match) -> match.homeScore + match.awayScore)
                .thenComparingInt((Match match) -> match.matchNumber)
                .compare(other, this);
    }
}
