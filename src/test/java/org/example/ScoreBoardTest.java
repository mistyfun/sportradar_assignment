package org.example;

import org.example.scoreboard.ScoreBoard;
import org.junit.jupiter.api.Test;

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
        assertThat(scoreBoard.getSummary()).isEqualTo("Japan 0 - Taiwan 0");
    }

}
