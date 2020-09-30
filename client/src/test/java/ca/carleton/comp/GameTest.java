package ca.carleton.comp;

import ca.carleton.comp.game.Dice;
import ca.carleton.comp.game.FortuneCard;
import ca.carleton.comp.game.PiratenKapern;
import ca.carleton.comp.game.Player;
import ca.carleton.comp.network.ClientChannel;
import ca.carleton.comp.network.WinnerResponse;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.*;

import static org.junit.Assert.assertEquals;

public class GameTest {
    /**
     * These Tests should run with server started
     */
    PiratenKapern piratenKapern = new PiratenKapern();

    private ExecutorService playerThreadPool = Executors.newFixedThreadPool(5);

    @Test
    public void game40Test() {
        try {
            new Thread(() -> new GameServer(3)).start();
            //make sure server is started
            Thread.sleep(1000);

            Player player1 = playerScore0();
            Player player2 = playerSetOf3();
            Player player3 = player8SwordWithCaptain();
            Future<WinnerResponse> submit1 = playerThreadPool.submit(() -> player1.sendPlayerResult());
            Future<WinnerResponse> submit2 = playerThreadPool.submit(() -> player2.sendPlayerResult());
            Future<WinnerResponse> submit3 = playerThreadPool.submit(() -> player3.sendPlayerResult());
            WinnerResponse winnerResponse1 = submit1.get();
            WinnerResponse winnerResponse2 = submit2.get();
            WinnerResponse winnerResponse3 = submit3.get();

            assertEquals("player3", winnerResponse1.getWinnerName());
            assertEquals("player3", winnerResponse2.getWinnerName());
            assertEquals("player3", winnerResponse3.getWinnerName());
            assertEquals(9000, winnerResponse1.getWinnerScore());
            assertEquals(9000, winnerResponse2.getWinnerScore());
            assertEquals(9000, winnerResponse3.getWinnerScore());
        } catch (Exception e) {
            System.out.println("please start server first");
        }
    }

    @Test
    public void game43Test() {
        try {
            new Thread(() -> new GameServer(3)).start();
            //make sure server is started
            Thread.sleep(1000);

            Player player1 = playerSetOf4();
            Player player2 = playerSetOf5();
            Player player3 = playerSetOf6();
            Future<WinnerResponse> submit1 = playerThreadPool.submit(() -> player1.sendPlayerResult());
            Future<WinnerResponse> submit2 = playerThreadPool.submit(() -> player2.sendPlayerResult());
            Future<WinnerResponse> submit3 = playerThreadPool.submit(() -> player3.sendPlayerResult());
            WinnerResponse winnerResponse1 = submit1.get();
            WinnerResponse winnerResponse2 = submit2.get();
            WinnerResponse winnerResponse3 = submit3.get();

            assertEquals(null, winnerResponse1.getWinnerName());
            assertEquals(null, winnerResponse2.getWinnerName());
            assertEquals(null, winnerResponse3.getWinnerName());
            assertEquals(0, winnerResponse1.getWinnerScore());
            assertEquals(0, winnerResponse2.getWinnerScore());
            assertEquals(0, winnerResponse3.getWinnerScore());

            System.out.println("Player1 start next turn");
            player1.setScore(scoreSetOf3());
            System.out.println("Player2 start next turn");
            player2.setScore(scoreSetOf7());
            System.out.println("Player3 start next turn");
            player3.setScore(scoreSetOf4());
            submit1 = playerThreadPool.submit(() -> player1.sendPlayerResult());
            submit2 = playerThreadPool.submit(() -> player2.sendPlayerResult());
            submit3 = playerThreadPool.submit(() -> player3.sendPlayerResult());
            winnerResponse1 = submit1.get();
            winnerResponse2 = submit2.get();
            winnerResponse3 = submit3.get();

            assertEquals("player2", winnerResponse1.getWinnerName());
            assertEquals("player2", winnerResponse2.getWinnerName());
            assertEquals("player2", winnerResponse3.getWinnerName());
            assertEquals(6500, winnerResponse1.getWinnerScore());
            assertEquals(6500, winnerResponse2.getWinnerScore());
            assertEquals(6500, winnerResponse3.getWinnerScore());

        } catch (Exception e) {
            System.out.println("please start server first");
        }

    }

    public Player playerScore0() {
        ClientChannel clientChannel = new ClientChannel();
        Player player = new Player(piratenKapern, clientChannel);
        player.initPlayer("player1");

        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        //first roll result
        rollResult.put(0, Dice.DiceSide.skull);
        rollResult.put(1, Dice.DiceSide.skull);
        rollResult.put(2, Dice.DiceSide.skull);
        rollResult.put(3, Dice.DiceSide.monkey);
        rollResult.put(4, Dice.DiceSide.monkey);
        rollResult.put(5, Dice.DiceSide.monkey);
        rollResult.put(6, Dice.DiceSide.monkey);
        rollResult.put(7, Dice.DiceSide.monkey);
        System.out.println("The roll result is " + rollResult);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score in current turn is " + score);
        player.setScore(score);
        return player;
    }

    public Player player8SwordWithCaptain() {
        ClientChannel clientChannel = new ClientChannel();
        Player player = new Player(piratenKapern, clientChannel);
        player.initPlayer("player3");

        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.captain);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        //first roll result
        rollResult.put(0, Dice.DiceSide.sword);
        rollResult.put(1, Dice.DiceSide.sword);
        rollResult.put(2, Dice.DiceSide.sword);
        rollResult.put(3, Dice.DiceSide.sword);
        rollResult.put(4, Dice.DiceSide.sword);
        rollResult.put(5, Dice.DiceSide.sword);
        rollResult.put(6, Dice.DiceSide.sword);
        rollResult.put(7, Dice.DiceSide.sword);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score in current turn is " + score);
        player.setScore(score);
        return player;
    }

    public Player playerSetOf3() {
        ClientChannel clientChannel = new ClientChannel();
        Player player = new Player(piratenKapern, clientChannel);
        player.initPlayer("player2");

        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        //first roll result
        rollResult.put(0, Dice.DiceSide.parrot);
        rollResult.put(1, Dice.DiceSide.parrot);
        rollResult.put(2, Dice.DiceSide.skull);
        rollResult.put(3, Dice.DiceSide.skull);
        rollResult.put(4, Dice.DiceSide.parrot);
        rollResult.put(5, Dice.DiceSide.sword);
        rollResult.put(6, Dice.DiceSide.monkey);
        rollResult.put(7, Dice.DiceSide.monkey);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score in current turn is " + score);
        player.setScore(score);
        return player;
    }

    public Player playerSetOf4() {
        ClientChannel clientChannel = new ClientChannel();
        Player player = new Player(piratenKapern, clientChannel);
        player.initPlayer("player1");

        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        //first roll result
        rollResult.put(0, Dice.DiceSide.parrot);
        rollResult.put(1, Dice.DiceSide.parrot);
        rollResult.put(2, Dice.DiceSide.parrot);
        rollResult.put(3, Dice.DiceSide.skull);
        rollResult.put(4, Dice.DiceSide.parrot);
        rollResult.put(5, Dice.DiceSide.sword);
        rollResult.put(6, Dice.DiceSide.monkey);
        rollResult.put(7, Dice.DiceSide.monkey);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score in current turn is " + score);
        player.setScore(score);
        return player;
    }


    public Player playerSetOf5() {
        ClientChannel clientChannel = new ClientChannel();
        Player player = new Player(piratenKapern, clientChannel);
        player.initPlayer("player2");

        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        //first roll result
        rollResult.put(0, Dice.DiceSide.parrot);
        rollResult.put(1, Dice.DiceSide.parrot);
        rollResult.put(2, Dice.DiceSide.parrot);
        rollResult.put(3, Dice.DiceSide.parrot);
        rollResult.put(4, Dice.DiceSide.parrot);
        rollResult.put(5, Dice.DiceSide.parrot);
        rollResult.put(6, Dice.DiceSide.monkey);
        rollResult.put(7, Dice.DiceSide.monkey);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score in current turn is " + score);
        player.setScore(score);
        return player;
    }

    public Player playerSetOf6() {
        ClientChannel clientChannel = new ClientChannel();
        Player player = new Player(piratenKapern, clientChannel);
        player.initPlayer("player1");

        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        //first roll result
        rollResult.put(0, Dice.DiceSide.skull);
        rollResult.put(1, Dice.DiceSide.parrot);
        rollResult.put(2, Dice.DiceSide.skull);
        rollResult.put(3, Dice.DiceSide.monkey);
        rollResult.put(4, Dice.DiceSide.monkey);
        rollResult.put(5, Dice.DiceSide.monkey);
        rollResult.put(6, Dice.DiceSide.monkey);
        rollResult.put(7, Dice.DiceSide.monkey);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score in current turn is " + score);
        player.setScore(score);
        return player;
    }

    public int scoreSetOf3() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        //first roll result
        rollResult.put(0, Dice.DiceSide.parrot);
        rollResult.put(1, Dice.DiceSide.parrot);
        rollResult.put(2, Dice.DiceSide.parrot);
        rollResult.put(3, Dice.DiceSide.skull);
        rollResult.put(4, Dice.DiceSide.skull);
        rollResult.put(5, Dice.DiceSide.sword);
        rollResult.put(6, Dice.DiceSide.monkey);
        rollResult.put(7, Dice.DiceSide.monkey);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score in current turn is " + score);
        return score;
    }

    public int scoreSetOf4() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        //first roll result
        rollResult.put(0, Dice.DiceSide.parrot);
        rollResult.put(1, Dice.DiceSide.parrot);
        rollResult.put(2, Dice.DiceSide.parrot);
        rollResult.put(3, Dice.DiceSide.parrot);
        rollResult.put(4, Dice.DiceSide.skull);
        rollResult.put(5, Dice.DiceSide.sword);
        rollResult.put(6, Dice.DiceSide.monkey);
        rollResult.put(7, Dice.DiceSide.monkey);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score in current turn is " + score);
        return score;
    }

    public int scoreSetOf7() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.captain);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        //first roll result
        rollResult.put(0, Dice.DiceSide.diamond);
        rollResult.put(1, Dice.DiceSide.diamond);
        rollResult.put(2, Dice.DiceSide.diamond);
        rollResult.put(3, Dice.DiceSide.diamond);
        rollResult.put(4, Dice.DiceSide.diamond);
        rollResult.put(5, Dice.DiceSide.diamond);
        rollResult.put(6, Dice.DiceSide.diamond);
        rollResult.put(7, Dice.DiceSide.monkey);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score in current turn is " + score);
        return score;
    }

}
