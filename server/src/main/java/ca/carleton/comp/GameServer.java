package ca.carleton.comp;


import ca.carleton.comp.game.PlayerHandler;
import ca.carleton.comp.game.ScorePad;
import ca.carleton.comp.game.ScoreRecord;
import ca.carleton.comp.network.ServerChannel;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class GameServer {
    private ServerSocket serverSocket;
    private List<ServerChannel> serverChannelList;
    private List<PlayerHandler> playerHandlerList;
    private ExecutorService handlerThreadPool = Executors.newFixedThreadPool(5);
    private CountDownLatch countDownLatch;
    private ScorePad scorePad;

    public ScorePad getScorePad() {
        return scorePad;
    }

    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }

    public GameServer(int playerNums) {
        System.out.println("Starting game server");
        serverChannelList = new ArrayList<>();
        playerHandlerList = new ArrayList<>();
        scorePad = new ScorePad();
        countDownLatch = new CountDownLatch(playerNums);

        int playerIndex = 0;
        try {
            serverSocket = new ServerSocket(3333);
            System.out.println("Game server started");

            while (playerIndex < playerNums) {
                Socket socket = serverSocket.accept();

                playerIndex++;
                scorePad.addScoreRecord(new ScoreRecord(playerIndex));

                ServerChannel serverChannel = new ServerChannel(playerIndex, socket);
                serverChannelList.add(serverChannel);

                PlayerHandler playerHandler = new PlayerHandler(this, playerIndex, serverChannel);
                playerHandlerList.add(playerHandler);

                handlerThreadPool.submit(playerHandler);
            }

            countDownLatch.await();

            ScoreRecord winnerScore = scorePad.computeWinner();

            while (winnerScore.getFinalScore() < 6000) {
                for (PlayerHandler playerHandler : playerHandlerList) {
                    playerHandler.sendScore();
                    handlerThreadPool.submit(playerHandler);
                }
                countDownLatch = new CountDownLatch(playerNums);
                countDownLatch.await();
                winnerScore = scorePad.computeWinner();
            }

            System.out.println("The winner is " + winnerScore.getPlayerName() + " , with score " + winnerScore.getFinalScore());
            for (PlayerHandler playerHandler : playerHandlerList) {
                playerHandler.sendWinner(winnerScore);
            }

            serverSocket.close();
            handlerThreadPool.shutdown();
        } catch (IOException ex) {
            System.out.println("Server Failed to open");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new GameServer(3);
    }
}