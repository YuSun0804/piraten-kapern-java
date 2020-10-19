
package ca.carleton.comp;

import ca.carleton.comp.game.Dice;
import ca.carleton.comp.game.FortuneCard;
import ca.carleton.comp.game.PiratenKapern;
import ca.carleton.comp.game.Player;
import ca.carleton.comp.network.ClientChannel;
import ca.carleton.comp.network.WinnerResponse;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.regex.Matcher;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CucumberLevel2Step {

    private Player player1;
    private Player player2;
    private Player player3;
    private PiratenKapern piratenKapern = new PiratenKapern();
    private ExecutorService playerThreadPool = Executors.newFixedThreadPool(5);
    private Future<WinnerResponse> winnerResponseFuture1;
    private Future<WinnerResponse> winnerResponseFuture2;
    private Future<WinnerResponse> winnerResponseFuture3;

    @Given("^Start Game Server$")
    public void startGameServer() {
        new Thread(() -> new GameServer(3, true)).start();
    }

    @When("Player {int} start")
    public void createPlayer(int playerId) {
        ClientChannel clientChannel = new ClientChannel();
        switch (playerId % 10) {
            case 1:
                player1 = new Player(piratenKapern, clientChannel);
                player1.initPlayer(playerId + "");
                break;
            case 2:
                player2 = new Player(piratenKapern, clientChannel);
                player2.initPlayer(playerId + "");
                break;
            case 3:
                player3 = new Player(piratenKapern, clientChannel);
                player3.initPlayer(playerId + "");
                break;
        }

    }

    @And("Player {int} draw fortuneCard")
    public void drawFortuneCard(int playerId) {
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        if (playerId == 1253 || playerId == 1272) {
            fortuneCard.setType(FortuneCard.FortuneCardType.captain);
        } else {
            fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        }
        switch (playerId % 10) {
            case 1:
                player1.setFortuneCard(fortuneCard);
                break;
            case 2:
                player2.setFortuneCard(fortuneCard);
                break;
            case 3:
                player3.setFortuneCard(fortuneCard);
                break;
        }
        System.out.println("The fortune card player " + playerId + " draw is \"" + fortuneCard.getType().getType() + "\"");
    }

    @And("Player {int} start next turn")
    public void startNextTurn(int playerId) {
        switch (playerId % 10) {
            case 1:
                player1.setTurnNums(player1.getTurnNums() + 1);
                break;
            case 2:
                player2.setTurnNums(player2.getTurnNums() + 1);
                break;
            case 3:
                player3.setTurnNums(player3.getTurnNums() + 1);
                break;
        }
        System.out.println("Player " + playerId + " start next turn");
    }

    @And("Player {int} roll dice")
    public void rollDice(int playerId) {
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();

        if (playerId == 1251) {
            rollResult.put(0, Dice.DiceSide.skull);
            rollResult.put(1, Dice.DiceSide.skull);
            rollResult.put(2, Dice.DiceSide.skull);
            rollResult.put(3, Dice.DiceSide.monkey);
            rollResult.put(4, Dice.DiceSide.monkey);
            rollResult.put(5, Dice.DiceSide.monkey);
            rollResult.put(6, Dice.DiceSide.monkey);
            rollResult.put(7, Dice.DiceSide.monkey);
        } else if (playerId == 1252) {
            rollResult.put(0, Dice.DiceSide.parrot);
            rollResult.put(1, Dice.DiceSide.parrot);
            rollResult.put(2, Dice.DiceSide.skull);
            rollResult.put(3, Dice.DiceSide.skull);
            rollResult.put(4, Dice.DiceSide.parrot);
            rollResult.put(5, Dice.DiceSide.sword);
            rollResult.put(6, Dice.DiceSide.monkey);
            rollResult.put(7, Dice.DiceSide.monkey);
        } else if (playerId == 1253) {
            rollResult.put(0, Dice.DiceSide.sword);
            rollResult.put(1, Dice.DiceSide.sword);
            rollResult.put(2, Dice.DiceSide.sword);
            rollResult.put(3, Dice.DiceSide.sword);
            rollResult.put(4, Dice.DiceSide.sword);
            rollResult.put(5, Dice.DiceSide.sword);
            rollResult.put(6, Dice.DiceSide.sword);
            rollResult.put(7, Dice.DiceSide.sword);
        } else if (playerId == 1271 && player1.getTurnNums() == 1) {
            rollResult.put(0, Dice.DiceSide.parrot);
            rollResult.put(1, Dice.DiceSide.parrot);
            rollResult.put(2, Dice.DiceSide.parrot);
            rollResult.put(3, Dice.DiceSide.skull);
            rollResult.put(4, Dice.DiceSide.parrot);
            rollResult.put(5, Dice.DiceSide.sword);
            rollResult.put(6, Dice.DiceSide.monkey);
            rollResult.put(7, Dice.DiceSide.monkey);
        } else if (playerId == 1272 && player2.getTurnNums() == 1) {
            rollResult.put(0, Dice.DiceSide.parrot);
            rollResult.put(1, Dice.DiceSide.parrot);
            rollResult.put(2, Dice.DiceSide.parrot);
            rollResult.put(3, Dice.DiceSide.parrot);
            rollResult.put(4, Dice.DiceSide.parrot);
            rollResult.put(5, Dice.DiceSide.parrot);
            rollResult.put(6, Dice.DiceSide.monkey);
            rollResult.put(7, Dice.DiceSide.monkey);
        } else if (playerId == 1273 && player3.getTurnNums() == 1) {
            rollResult.put(0, Dice.DiceSide.skull);
            rollResult.put(1, Dice.DiceSide.parrot);
            rollResult.put(2, Dice.DiceSide.skull);
            rollResult.put(3, Dice.DiceSide.monkey);
            rollResult.put(4, Dice.DiceSide.monkey);
            rollResult.put(5, Dice.DiceSide.monkey);
            rollResult.put(6, Dice.DiceSide.monkey);
            rollResult.put(7, Dice.DiceSide.monkey);
        } else if (playerId == 1271 && player1.getTurnNums() == 2) {
            rollResult.put(0, Dice.DiceSide.parrot);
            rollResult.put(1, Dice.DiceSide.parrot);
            rollResult.put(2, Dice.DiceSide.parrot);
            rollResult.put(3, Dice.DiceSide.skull);
            rollResult.put(4, Dice.DiceSide.skull);
            rollResult.put(5, Dice.DiceSide.sword);
            rollResult.put(6, Dice.DiceSide.monkey);
            rollResult.put(7, Dice.DiceSide.monkey);
        } else if (playerId == 1272 && player2.getTurnNums() == 2) {
            rollResult.put(0, Dice.DiceSide.diamond);
            rollResult.put(1, Dice.DiceSide.diamond);
            rollResult.put(2, Dice.DiceSide.diamond);
            rollResult.put(3, Dice.DiceSide.diamond);
            rollResult.put(4, Dice.DiceSide.diamond);
            rollResult.put(5, Dice.DiceSide.diamond);
            rollResult.put(6, Dice.DiceSide.diamond);
            rollResult.put(7, Dice.DiceSide.monkey);
        } else if (playerId == 1273 && player3.getTurnNums() == 2) {
            rollResult.put(0, Dice.DiceSide.parrot);
            rollResult.put(1, Dice.DiceSide.parrot);
            rollResult.put(2, Dice.DiceSide.parrot);
            rollResult.put(3, Dice.DiceSide.parrot);
            rollResult.put(4, Dice.DiceSide.skull);
            rollResult.put(5, Dice.DiceSide.sword);
            rollResult.put(6, Dice.DiceSide.monkey);
            rollResult.put(7, Dice.DiceSide.monkey);
        }

        switch (playerId % 10) {
            case 1:
                player1.setRollResult(rollResult);
                break;
            case 2:
                player2.setRollResult(rollResult);
                break;
            case 3:
                player3.setRollResult(rollResult);
                break;
        }

        System.out.println("The roll result player " + playerId + " is " + rollResult);
    }

    @And("Player {int} send score")
    public void sendScore(int playerId) {
        switch (playerId % 10) {
            case 1:
                piratenKapern.computeScore(player1);
                winnerResponseFuture1 = playerThreadPool.submit(() -> player1.sendPlayerResult());
                break;
            case 2:
                piratenKapern.computeScore(player2);
                winnerResponseFuture2 = playerThreadPool.submit(() -> player2.sendPlayerResult());
                break;
            case 3:
                piratenKapern.computeScore(player3);
                winnerResponseFuture3 = playerThreadPool.submit(() -> player3.sendPlayerResult());
                break;
        }
    }

    @Then("Compute Winner {int} {int}")
    public void computeWinner(int expectedWinnerId, int expectedWinnerScore) {
        try {
            WinnerResponse winnerResponse1 = winnerResponseFuture1.get();
            WinnerResponse winnerResponse2 = winnerResponseFuture2.get();
            WinnerResponse winnerResponse3 = winnerResponseFuture3.get();

            System.out.println("The score player " + player1.getName() + " get in turn " + player1.getTurnNums() + " is " + winnerResponse1.getPlayerScore());
            System.out.println("The score player " + player2.getName() + " get in turn " + player2.getTurnNums() + " is " + winnerResponse2.getPlayerScore());
            System.out.println("The score player " + player3.getName() + " get in turn " + player3.getTurnNums() + " is " + winnerResponse3.getPlayerScore());
            String expectedWinnerName = expectedWinnerId + "";
            if (expectedWinnerId == 0) {
                expectedWinnerName = null;
            }
            assertEquals(expectedWinnerName, winnerResponse1.getWinnerName());
            assertEquals(expectedWinnerName, winnerResponse2.getWinnerName());
            assertEquals(expectedWinnerName, winnerResponse3.getWinnerName());
            assertEquals(expectedWinnerScore, winnerResponse1.getWinnerScore());
            assertEquals(expectedWinnerScore, winnerResponse2.getWinnerScore());
            assertEquals(expectedWinnerScore, winnerResponse3.getWinnerScore());

            System.out.println("The winner is player " + winnerResponse1.getWinnerName() + " , with score " + winnerResponse1.getWinnerScore() + " in all turns");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}


