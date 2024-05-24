package org.example.scoreboard;

class Match {

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

}
