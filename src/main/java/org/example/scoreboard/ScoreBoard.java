package org.example.scoreboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 * Keep it simple. Follow the requirements and try to implement the simplest solution you can think of
 * that works. Do not forget about edge cases!
 * ✓ Use an in-memory store solution (for example just use
 *   collections to store the information you might require).
 * ✓ We don’t expect the solution to be a REST API, command line application,
 *   a Web Service, or Microservice. Just a simple library implementation.
 * ✓ Focus on Quality. Use Test-Driven Development (TDD), pay attention
 *   to OO design, Clean Code and adherence to SOLID principles.
 * ✓ Approach. Code the solution according to your standards.
 *   Please share your solution with a link to a source control
 *   repository (e.g. GitHub, GitLab, BitBucket) as we would like
 *   you to see your progress (your commit history is important)
 * ✓ Add a README.md file where beside the project documentation you can make notes of
 *   any assumption or things you would like to mention to us about your solution.
 *
 * The scoreboard supports the following operations:
 * 1. Start a new match, assuming initial score 0 – 0 and adding it the scoreboard.
 * This should capture following parameters:
 *   a. Home team
 *   b. Away team
 * 2. Update score.
 * This should receive a pair of absolute scores: home team score and away team score.
 * 3. Finish match currently in progress. This removes a match from the scoreboard.
 * 4. Get a summary of matches in progress ordered by their total score. The matches with the
 * same total score will be returned ordered by the most recently started match in the
 * scoreboard.
 */
public class ScoreBoard {
    List<Match> matches = new ArrayList<>();

    public void startMatch(String homeTeam, String awayTeam) {
        matches.add(new Match(homeTeam, awayTeam, 0, 0));
        //I removed the this.match because I need a list of matches and not a single match
    }

    public List<String> getSummary() {
        if (this.matches.isEmpty()) {
            return null;
        }
        List<String> stringMatches = new ArrayList<>();
        for (Match match : matches) {
            stringMatches.add(match.toString());
        }
        return stringMatches;
    }


}
