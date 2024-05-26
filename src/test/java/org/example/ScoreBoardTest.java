package org.example;

import org.example.scoreboard.ScoreBoard;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class ScoreBoardTest {

    @Test
    public void empty_scoreboard_returns_null_summary() {
        ScoreBoard scoreBoard = new ScoreBoard();
        assertThat(scoreBoard.getSummary()).isEqualTo(null);
    }

    @Test
    public void starting_a_match_in_empty_board_gives_a_zero_zero_summary() {
        String homeTeam = "Japan";
        String awayTeam = "Taiwan";
        ScoreBoard scoreBoard = new ScoreBoard();
        scoreBoard.startMatch(homeTeam, awayTeam);
        assertThat(scoreBoard.getSummary()).isEqualTo(List.of("Japan 0 - Taiwan 0"));
    }

    @Test
    public void summary_returns_correct_countries_for_a_started_match() {
        String homeTeam = "Korea";
        String awayTeam = "China";
        ScoreBoard scoreBoard = new ScoreBoard();
        scoreBoard.getSummary();
        scoreBoard.startMatch(homeTeam, awayTeam);
        assertThat(scoreBoard.getSummary()).isEqualTo(List.of("Korea 0 - China 0"));
    }

    @Test
    public void summary_returns_the_correct_number_of_newly_started_matches() {
        ScoreBoard scoreBoard = new ScoreBoard();
        String homeTeam1 = "Korea";
        String awayTeam1 = "China";
        scoreBoard.startMatch(homeTeam1, awayTeam1);
        assertThat(scoreBoard.getSummary().size()).isEqualTo(1);
        String homeTeam2 = "Japan";
        String awayTeam2 = "Taiwan";
        scoreBoard.startMatch(homeTeam2, awayTeam2);
        assertThat(scoreBoard.getSummary().size()).isEqualTo(2);
    }

    @Test
    public void updateScore_updates_the_score() {
        ScoreBoard scoreBoard = new ScoreBoard();
        String homeTeam = "Japan";
        String awayTeam = "Taiwan";
        int homeScore = 0;
        int awayScore = 0;
        scoreBoard.startMatch(homeTeam, awayTeam);
        scoreBoard.updateScore(homeTeam, awayTeam, homeScore, awayScore + 1);
        assertThat(scoreBoard.getSummary()).isEqualTo(List.of("Japan 0 - Taiwan 1"));
    }

    @Test
    public void matches_in_summary_are_sorted_by_total_goals() {
        ScoreBoard scoreBoard = new ScoreBoard();
        startMatchAndSetScore(scoreBoard, "Norway", "Sweden", 1, 1);
        startMatchAndSetScore(scoreBoard, "China", "Korea", 0, 1);
        startMatchAndSetScore(scoreBoard, "Japan", "Taiwan", 0, 3);

        assertThat(scoreBoard.getSummary().get(0)).isEqualTo("Japan 0 - Taiwan 3");
        assertThat(scoreBoard.getSummary().get(1)).isEqualTo("Norway 1 - Sweden 1");
        assertThat(scoreBoard.getSummary().get(2)).isEqualTo("China 0 - Korea 1");
    }

    @Test
    public void matches_in_summary_are_sorted_by_started_time_if_total_goals_are_the_same() {
        ScoreBoard scoreBoard = new ScoreBoard();
        startMatchAndSetScore(scoreBoard, "Norway", "Sweden", 1, 1);
        startMatchAndSetScore(scoreBoard, "China", "Korea", 0, 1);
        startMatchAndSetScore(scoreBoard, "Spain", "Italy", 3, 0);
        startMatchAndSetScore(scoreBoard, "Japan", "Taiwan", 0, 3);

        assertThat(scoreBoard.getSummary().get(0)).isEqualTo("Japan 0 - Taiwan 3");
        assertThat(scoreBoard.getSummary().get(1)).isEqualTo("Spain 3 - Italy 0");
        assertThat(scoreBoard.getSummary().get(2)).isEqualTo("Norway 1 - Sweden 1");
        assertThat(scoreBoard.getSummary().get(3)).isEqualTo("China 0 - Korea 1");
    }

    @Test
    public void finishing_a_match_removes_it_from_the_scoreboard() {
        ScoreBoard scoreBoard = new ScoreBoard();
        startMatchAndSetScore(scoreBoard, "Spain", "Italy", 2, 0);
        startMatchAndSetScore(scoreBoard, "Japan", "Taiwan", 0, 1);
        // first assert that there are 2, then remove 1,
        assertThat(scoreBoard.getSummary().get(0)).isEqualTo("Spain 2 - Italy 0");
        assertThat(scoreBoard.getSummary().get(1)).isEqualTo("Japan 0 - Taiwan 1");
        scoreBoard.finishMatch("Spain");
        // then assert that there is 1 (and that it`s the right one),
        assertThat(scoreBoard.getSummary().get(0)).isEqualTo("Japan 0 - Taiwan 1");
        // then remove 1 and assert that the summary is null
        scoreBoard.finishMatch("Japan");
        assertThat(scoreBoard.getSummary()).isEqualTo(null);
    }

    private void startMatchAndSetScore(ScoreBoard scoreBoard, String homeTeam, String awayTeam, int homeScore, int awayScore) {
        scoreBoard.startMatch(homeTeam, awayTeam);
        scoreBoard.updateScore(homeTeam, awayTeam, homeScore, awayScore);
    }

}
