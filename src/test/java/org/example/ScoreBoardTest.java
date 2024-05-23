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
    public void summary_returns_correct_countries_for_a_started_match(){
        String homeTeam = "Korea";
        String awayTeam = "China";
        ScoreBoard scoreBoard = new ScoreBoard();
        scoreBoard.getSummary();
        scoreBoard.startMatch(homeTeam, awayTeam);
        assertThat(scoreBoard.getSummary()).isEqualTo(List.of("Korea 0 - China 0"));
    }

}
