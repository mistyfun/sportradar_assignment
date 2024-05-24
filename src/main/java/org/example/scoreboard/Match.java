package org.example.scoreboard;

record Match(String homeTeam, String awayTeam, int homeScore, int awayScore) {

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(this.homeTeam())
                .append(" ")
                .append(this.homeScore())
                .append(" - ")
                .append(this.awayTeam())
                .append(" ")
                .append(this.awayScore());
        return str.toString();
    }

}