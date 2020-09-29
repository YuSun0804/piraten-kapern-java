package ca.carleton.comp.game;

import java.util.ArrayList;
import java.util.List;

public class ScorePad {
    private List<ScoreRecord> scoreRecordList;

    public ScorePad() {
        scoreRecordList = new ArrayList<>();
    }

    public List<ScoreRecord> getScoreRecordList() {
        return scoreRecordList;
    }

    public void addScoreRecord(ScoreRecord scoreRecord) {
        scoreRecordList.add(scoreRecord);
    }

    public int computeScore(int playerIndex) {
        for (ScoreRecord scoreRecord : scoreRecordList) {
            if (scoreRecord.getPlayerIndex() == playerIndex) {
                return scoreRecord.getFinalScore();
            }
        }
        return 0;
    }

    public ScoreRecord computeWinner() {
        updateFinalScore();
        ScoreRecord winner = new ScoreRecord();
        for (ScoreRecord scoreRecord : scoreRecordList) {
            if (scoreRecord.getFinalScore() > winner.getFinalScore()) {
                winner.setFinalScore(scoreRecord.getFinalScore());
                winner.setPlayerIndex(scoreRecord.getPlayerIndex());
                winner.setPlayerName(scoreRecord.getPlayerName());
            }
        }
        return winner;
    }

    private void updateFinalScore() {
        for (ScoreRecord deductionRecord : scoreRecordList) {
            if (deductionRecord.getDeduction() == 0) continue;

            for (ScoreRecord scoreRecord : scoreRecordList) {
                if (scoreRecord != deductionRecord) continue;

                int finalScore = scoreRecord.getFinalScore() + deductionRecord.getDeduction();
                finalScore = finalScore > 0 ? finalScore : 0;
                scoreRecord.setFinalScore(finalScore);
            }
        }
    }
}
