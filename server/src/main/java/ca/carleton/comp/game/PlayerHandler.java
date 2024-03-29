package ca.carleton.comp.game;

import ca.carleton.comp.GameServer;
import ca.carleton.comp.network.ServerChannel;

import java.io.IOException;
import java.util.List;

public class PlayerHandler implements Runnable {

    private int playerIndex;
    private String playerName;
    private ServerChannel serverChannel;
    private GameServer gameServer;
    private boolean greeting;
    private boolean silence;


    public PlayerHandler(GameServer gameServer, int playerIndex, ServerChannel serverChannel, boolean silence) {
        this.serverChannel = serverChannel;
        this.gameServer = gameServer;
        this.playerIndex = playerIndex;
        this.greeting = true;
        this.silence = silence;
    }

    private void sendGreetingMessage(String playerName) throws IOException {
        this.serverChannel.write("Hi, " + playerName + ". You can start to play the game");
    }

    @Override
    public void run() {
        try {
            if (greeting) {
                String message = this.serverChannel.read();
                gameServer.getScorePad().getByPlayerIndex(playerIndex).setPlayerName(message);
                sendGreetingMessage(message);
                if (!silence) {
                    System.out.println(message + " joined the game.");
                }
                playerName = message;
                greeting = false;
            }

            String message = this.serverChannel.read();
            System.out.println(playerName + " finished the turn " + gameServer.getTurnNum());
            setPlayerScore(message);
            gameServer.getCountDownLatch().countDown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setPlayerScore(String scoreAndDeduction) {
        String[] split = scoreAndDeduction.split(",");
        ScoreRecord scoreRecord = gameServer.getScorePad().getByPlayerIndex(playerIndex);
        scoreRecord.setClientScore(Integer.parseInt(split[0]));
        scoreRecord.setDeduction(Integer.parseInt(split[1]));

        if (scoreRecord.getClientScore() + scoreRecord.getFinalScore() > 6000) {
            System.out.println("Player " + playerName + " get more than 6000, waiting other players complete current turn.");
        }

    }

    public void sendScore() throws IOException {
        int score = gameServer.getScorePad().computeScore(playerIndex);
        serverChannel.write(score + "");
    }

    public void sendWinner(ScoreRecord winnerScore) throws IOException {
        int score = gameServer.getScorePad().computeScore(playerIndex);
        serverChannel.write(score + "," + winnerScore.getPlayerName() + "," + winnerScore.getFinalScore());
    }
}
