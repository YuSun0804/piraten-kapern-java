package ca.carleton.comp;


import ca.carleton.comp.game.ScorePad;
import ca.carleton.comp.game.ScoreRecord;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ScoreTest {

    private ScorePad scorePad = new ScorePad();

    @Test
    public void computeWinner1() {
        ScoreRecord scoreRecord1 = new ScoreRecord(1, "p1", 0, -100);
        ScoreRecord scoreRecord2 = new ScoreRecord(2, "p2", 100, 0);
        ScoreRecord scoreRecord3 = new ScoreRecord(3, "p3", 6000, 0);
        scorePad.addScoreRecord(scoreRecord1);
        scorePad.addScoreRecord(scoreRecord2);
        scorePad.addScoreRecord(scoreRecord3);
        ScoreRecord winner = scorePad.computeWinner();
        assertEquals(3, winner.getPlayerIndex());
        assertEquals(5900, winner.getFinalScore());

        int score = scorePad.computeScore(2);
        assertEquals(0, score);
    }

    @Test
    public void computeWinner2() {
        ScoreRecord scoreRecord1 = new ScoreRecord(1, "p1", 0, -100);
        ScoreRecord scoreRecord2 = new ScoreRecord(2, "p2", 0, -1000);
        ScoreRecord scoreRecord3 = new ScoreRecord(3, "p3", 6000, 0);
        ScoreRecord scoreRecord4 = new ScoreRecord(4, "p4", 3000, 0);

        scorePad.addScoreRecord(scoreRecord1);
        scorePad.addScoreRecord(scoreRecord2);
        scorePad.addScoreRecord(scoreRecord3);
        scorePad.addScoreRecord(scoreRecord4);

        ScoreRecord winner = scorePad.computeWinner();
        assertEquals(3, winner.getPlayerIndex());
        assertEquals(4900, winner.getFinalScore());

        int score = scorePad.computeScore(4);
        assertEquals(1900, score);
    }

    @Test
    public void computeWinner3() {
        ScoreRecord scoreRecord1 = new ScoreRecord(1, "p1", 0, -100);
        ScoreRecord scoreRecord2 = new ScoreRecord(2, "p2", 100, 0);
        ScoreRecord scoreRecord3 = new ScoreRecord(3, "p3", 3000, 0);
        scorePad.addScoreRecord(scoreRecord1);
        scorePad.addScoreRecord(scoreRecord2);
        scorePad.addScoreRecord(scoreRecord3);
        ScoreRecord winner = scorePad.computeWinner();
        assertEquals(3, winner.getPlayerIndex());
        assertEquals(2900, winner.getFinalScore());

        scoreRecord1.setClientScore(0);
        scoreRecord2.setClientScore(100);
        scoreRecord3.setClientScore(3500);

        winner = scorePad.computeWinner();
        assertEquals(3, winner.getPlayerIndex());
        assertEquals(6300, winner.getFinalScore());
    }
}
