package ca.carleton.comp.network;

public class WinnerResponse {


    private String winnerName;
    private int winnerScore;
    private int playerScore;

    public WinnerResponse(String winnerName, int winnerScore, int playerScore) {
        this.winnerName = winnerName;
        this.winnerScore = winnerScore;
        this.playerScore = playerScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public int getWinnerScore() {
        return winnerScore;
    }

    public void setWinnerScore(int winnerScore) {
        this.winnerScore = winnerScore;
    }

    public String getWinnerName() {
        return winnerName;
    }

    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }
}
