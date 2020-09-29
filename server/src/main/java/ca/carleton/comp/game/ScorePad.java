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

    public ScoreRecord getByPlayerIndex(int playerIndex) {
        for (ScoreRecord scoreRecord : scoreRecordList) {
            if (scoreRecord.getPlayerIndex() == playerIndex) {
                return scoreRecord;
            }
        }
        return null;
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
            if (scoreRecord.getFinalScore() >= winner.getFinalScore()) {
                winner.setFinalScore(scoreRecord.getFinalScore());
                winner.setPlayerIndex(scoreRecord.getPlayerIndex());
                winner.setPlayerName(scoreRecord.getPlayerName());
            }
        }
        return winner;
    }

    private void updateFinalScore() {
        for (ScoreRecord scoreRecord : scoreRecordList) {
            int deduction = 0;
            for (ScoreRecord otherRecord : scoreRecordList) {
                if (otherRecord.getDeduction() < 0) {
                    deduction += otherRecord.getDeduction();
                }
            }
            int score = scoreRecord.getFinalScore() + scoreRecord.getClientScore() + deduction;
            scoreRecord.setFinalScore(score);
        }
    }
}
