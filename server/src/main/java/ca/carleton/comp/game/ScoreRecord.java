package ca.carleton.comp.game;

public class ScoreRecord {

    private int playerIndex;
    private String playerName;
    private int finalScore;
    private int clientScore;
    private int deduction;

    public ScoreRecord() {
    }

    public ScoreRecord(int playerIndex, String playerName, int clientScore, int deduction) {
        this.playerIndex = playerIndex;
        this.playerName = playerName;
        this.clientScore = clientScore;
        this.deduction = deduction;
        this.finalScore = clientScore;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerIndex() {
        return playerIndex;
    }

    public void setPlayerIndex(int playerIndex) {
        this.playerIndex = playerIndex;
    }

    public int getClientScore() {
        return clientScore;
    }

    public void setClientScore(int clientScore) {
        this.clientScore = clientScore;
    }

    public int getDeduction() {
        return deduction;
    }

    public void setDeduction(int deduction) {
        this.deduction = deduction;
    }

    public int getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }
}
