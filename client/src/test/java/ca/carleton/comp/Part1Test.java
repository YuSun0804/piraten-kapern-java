package ca.carleton.comp;

import ca.carleton.comp.game.Dice;
import ca.carleton.comp.game.FortuneCard;
import ca.carleton.comp.game.PiratenKapern;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class Part1Test {

    private PiratenKapern piratenKapern = new PiratenKapern();

    @Test
    public void score48Test() {
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

        boolean canContinue = piratenKapern.canContinue(rollResult, fortuneCard);
        assertEquals(false, canContinue);
        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(0, score);

    }

    @Test
    public void score49Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        // change the random dice to fixed one
        rollResult.put(0, Dice.DiceSide.skull);
        rollResult.put(1, Dice.DiceSide.parrot);
        rollResult.put(2, Dice.DiceSide.parrot);
        rollResult.put(3, Dice.DiceSide.parrot);
        rollResult.put(4, Dice.DiceSide.parrot);
        rollResult.put(5, Dice.DiceSide.sword);
        rollResult.put(6, Dice.DiceSide.sword);
        rollResult.put(7, Dice.DiceSide.sword);
        System.out.println("The roll result is " + rollResult);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(5, 6, 7));
        System.out.println("Re-roll 5, 6, 7.");
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(5, Dice.DiceSide.skull);
        rollResult.put(6, Dice.DiceSide.skull);
        rollResult.put(7, Dice.DiceSide.sword);
        System.out.println("The re-roll result is " + rollResult);

        boolean canContinue = piratenKapern.canContinue(rollResult, fortuneCard);
        assertEquals(false, canContinue);
        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(0, score);
    }

    @Test
    public void score50Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        // change the random dice to fixed one
        rollResult.put(0, Dice.DiceSide.skull);
        rollResult.put(1, Dice.DiceSide.skull);
        rollResult.put(2, Dice.DiceSide.parrot);
        rollResult.put(3, Dice.DiceSide.parrot);
        rollResult.put(4, Dice.DiceSide.parrot);
        rollResult.put(5, Dice.DiceSide.parrot);
        rollResult.put(6, Dice.DiceSide.sword);
        rollResult.put(7, Dice.DiceSide.sword);
        System.out.println("The roll result is " + rollResult);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(6, 7));
        System.out.println("Re-roll 6, 7.");
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(6, Dice.DiceSide.skull);
        rollResult.put(7, Dice.DiceSide.sword);
        System.out.println("The re-roll result is " + rollResult);

        boolean canContinue = piratenKapern.canContinue(rollResult, fortuneCard);
        assertEquals(false, canContinue);
        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(0, score);
    }

    @Test
    public void score51Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        // change the random dice to fixed one
        rollResult.put(0, Dice.DiceSide.skull);
        rollResult.put(1, Dice.DiceSide.parrot);
        rollResult.put(2, Dice.DiceSide.parrot);
        rollResult.put(3, Dice.DiceSide.parrot);
        rollResult.put(4, Dice.DiceSide.parrot);
        rollResult.put(5, Dice.DiceSide.sword);
        rollResult.put(6, Dice.DiceSide.sword);
        rollResult.put(7, Dice.DiceSide.sword);
        System.out.println("The roll result is " + rollResult);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(5, 6, 7));
        System.out.println("Re-roll 5, 6, 7.");
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(5, Dice.DiceSide.skull);
        rollResult.put(6, Dice.DiceSide.monkey);
        rollResult.put(7, Dice.DiceSide.monkey);
        System.out.println("The re-roll result is " + rollResult);

        //re-roll
        indexes = new ArrayList<>(Arrays.asList(6, 7));
        System.out.println("Re-roll 6, 7.");
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(6, Dice.DiceSide.skull);
        rollResult.put(7, Dice.DiceSide.monkey);
        System.out.println("The re-roll result is " + rollResult);

        boolean canContinue = piratenKapern.canContinue(rollResult, fortuneCard);
        assertEquals(false, canContinue);
        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(0, score);
    }

    @Test
    public void score53Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.captain);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        // change the random dice to fixed one
        rollResult.put(0, Dice.DiceSide.skull);
        rollResult.put(1, Dice.DiceSide.parrot);
        rollResult.put(2, Dice.DiceSide.monkey);
        rollResult.put(3, Dice.DiceSide.sword);
        rollResult.put(4, Dice.DiceSide.diamond);
        rollResult.put(5, Dice.DiceSide.diamond);
        rollResult.put(6, Dice.DiceSide.coin);
        rollResult.put(7, Dice.DiceSide.coin);
        System.out.println("The roll result is " + rollResult);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(800, score);
    }

    @Test
    public void score54Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        // change the random dice to fixed one
        rollResult.put(0, Dice.DiceSide.skull);
        rollResult.put(1, Dice.DiceSide.skull);
        rollResult.put(2, Dice.DiceSide.monkey);
        rollResult.put(3, Dice.DiceSide.monkey);
        rollResult.put(4, Dice.DiceSide.parrot);
        rollResult.put(5, Dice.DiceSide.parrot);
        rollResult.put(6, Dice.DiceSide.sword);
        rollResult.put(7, Dice.DiceSide.sword);
        System.out.println("The roll result is " + rollResult);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(6, 7));
        System.out.println("Re-roll 6, 7.");
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(6, Dice.DiceSide.sword);
        rollResult.put(7, Dice.DiceSide.monkey);
        System.out.println("The re-roll result is " + rollResult);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(200, score);
    }

    @Test
    public void score55Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        // change the random dice to fixed one
        rollResult.put(0, Dice.DiceSide.skull);
        rollResult.put(1, Dice.DiceSide.monkey);
        rollResult.put(2, Dice.DiceSide.monkey);
        rollResult.put(3, Dice.DiceSide.monkey);
        rollResult.put(4, Dice.DiceSide.parrot);
        rollResult.put(5, Dice.DiceSide.sword);
        rollResult.put(6, Dice.DiceSide.sword);
        rollResult.put(7, Dice.DiceSide.sword);
        System.out.println("The roll result is " + rollResult);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(300, score);
    }

    @Test
    public void score56Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        // change the random dice to fixed one
        rollResult.put(0, Dice.DiceSide.skull);
        rollResult.put(1, Dice.DiceSide.monkey);
        rollResult.put(2, Dice.DiceSide.monkey);
        rollResult.put(3, Dice.DiceSide.monkey);
        rollResult.put(4, Dice.DiceSide.parrot);
        rollResult.put(5, Dice.DiceSide.parrot);
        rollResult.put(6, Dice.DiceSide.sword);
        rollResult.put(7, Dice.DiceSide.sword);
        System.out.println("The roll result is " + rollResult);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(6, 7));
        System.out.println("Re-roll 6, 7.");
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(6, Dice.DiceSide.parrot);
        rollResult.put(7, Dice.DiceSide.sword);
        System.out.println("The re-roll result is " + rollResult);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(300, score);
    }

    @Test
    public void score57Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        // change the random dice to fixed one
        rollResult.put(0, Dice.DiceSide.skull);
        rollResult.put(1, Dice.DiceSide.diamond);
        rollResult.put(2, Dice.DiceSide.diamond);
        rollResult.put(3, Dice.DiceSide.diamond);
        rollResult.put(4, Dice.DiceSide.parrot);
        rollResult.put(5, Dice.DiceSide.parrot);
        rollResult.put(6, Dice.DiceSide.sword);
        rollResult.put(7, Dice.DiceSide.sword);
        System.out.println("The roll result is " + rollResult);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(500, score);
    }

    @Test
    public void score58Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.diamonds);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        // change the random dice to fixed one
        rollResult.put(0, Dice.DiceSide.skull);
        rollResult.put(1, Dice.DiceSide.coin);
        rollResult.put(2, Dice.DiceSide.coin);
        rollResult.put(3, Dice.DiceSide.coin);
        rollResult.put(4, Dice.DiceSide.coin);
        rollResult.put(5, Dice.DiceSide.parrot);
        rollResult.put(6, Dice.DiceSide.sword);
        rollResult.put(7, Dice.DiceSide.sword);
        System.out.println("The roll result is " + rollResult);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(700, score);
    }

    @Test
    public void score59Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        // change the random dice to fixed one
        rollResult.put(0, Dice.DiceSide.skull);
        rollResult.put(1, Dice.DiceSide.parrot);
        rollResult.put(2, Dice.DiceSide.parrot);
        rollResult.put(3, Dice.DiceSide.parrot);
        rollResult.put(4, Dice.DiceSide.parrot);
        rollResult.put(5, Dice.DiceSide.sword);
        rollResult.put(6, Dice.DiceSide.sword);
        rollResult.put(7, Dice.DiceSide.sword);
        System.out.println("The roll result is " + rollResult);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(400, score);
    }

    @Test
    public void score60Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        // change the random dice to fixed one
        rollResult.put(0, Dice.DiceSide.skull);
        rollResult.put(1, Dice.DiceSide.coin);
        rollResult.put(2, Dice.DiceSide.coin);
        rollResult.put(3, Dice.DiceSide.coin);
        rollResult.put(4, Dice.DiceSide.sword);
        rollResult.put(5, Dice.DiceSide.sword);
        rollResult.put(6, Dice.DiceSide.parrot);
        rollResult.put(7, Dice.DiceSide.parrot);
        System.out.println("The roll result is " + rollResult);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(6, 7));
        System.out.println("Re-roll 6, 7.");
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(6, Dice.DiceSide.monkey);
        rollResult.put(7, Dice.DiceSide.monkey);
        System.out.println("The re-roll result is " + rollResult);

        //re-roll
        indexes = new ArrayList<>(Arrays.asList(6, 7));
        System.out.println("Re-roll 6, 7.");
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(6, Dice.DiceSide.sword);
        rollResult.put(7, Dice.DiceSide.sword);
        System.out.println("The re-roll result is " + rollResult);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(800, score);
    }

    @Test
    public void score61Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.captain);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        // change the random dice to fixed one
        rollResult.put(0, Dice.DiceSide.skull);
        rollResult.put(1, Dice.DiceSide.coin);
        rollResult.put(2, Dice.DiceSide.coin);
        rollResult.put(3, Dice.DiceSide.coin);
        rollResult.put(4, Dice.DiceSide.sword);
        rollResult.put(5, Dice.DiceSide.sword);
        rollResult.put(6, Dice.DiceSide.parrot);
        rollResult.put(7, Dice.DiceSide.parrot);
        System.out.println("The roll result is " + rollResult);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(6, 7));
        System.out.println("Re-roll 6, 7.");
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(6, Dice.DiceSide.monkey);
        rollResult.put(7, Dice.DiceSide.monkey);
        System.out.println("The re-roll result is " + rollResult);

        //re-roll
        indexes = new ArrayList<>(Arrays.asList(6, 7));
        System.out.println("Re-roll 6, 7.");
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(6, Dice.DiceSide.sword);
        rollResult.put(7, Dice.DiceSide.sword);
        System.out.println("The re-roll result is " + rollResult);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(1200, score);
    }

    @Test
    public void score62Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        // change the random dice to fixed one
        rollResult.put(0, Dice.DiceSide.skull);
        rollResult.put(1, Dice.DiceSide.skull);
        rollResult.put(2, Dice.DiceSide.monkey);
        rollResult.put(3, Dice.DiceSide.monkey);
        rollResult.put(4, Dice.DiceSide.sword);
        rollResult.put(5, Dice.DiceSide.sword);
        rollResult.put(6, Dice.DiceSide.parrot);
        rollResult.put(7, Dice.DiceSide.parrot);
        System.out.println("The roll result is " + rollResult);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(6, 7));
        System.out.println("Re-roll 6, 7.");
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(6, Dice.DiceSide.sword);
        rollResult.put(7, Dice.DiceSide.sword);
        System.out.println("The re-roll result is " + rollResult);

        //re-roll
        indexes = new ArrayList<>(Arrays.asList(2, 3));
        System.out.println("Re-roll 2, 3.");
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(2, Dice.DiceSide.sword);
        rollResult.put(3, Dice.DiceSide.parrot);
        System.out.println("The re-roll result is " + rollResult);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(600, score);
    }

    @Test
    public void score63Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        // change the random dice to fixed one
        rollResult.put(0, Dice.DiceSide.skull);
        rollResult.put(1, Dice.DiceSide.skull);
        rollResult.put(2, Dice.DiceSide.monkey);
        rollResult.put(3, Dice.DiceSide.monkey);
        rollResult.put(4, Dice.DiceSide.monkey);
        rollResult.put(5, Dice.DiceSide.monkey);
        rollResult.put(6, Dice.DiceSide.monkey);
        rollResult.put(7, Dice.DiceSide.monkey);
        System.out.println("The roll result is " + rollResult);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(1100, score);
    }

    @Test
    public void score64Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        // change the random dice to fixed one
        rollResult.put(0, Dice.DiceSide.skull);
        rollResult.put(1, Dice.DiceSide.parrot);
        rollResult.put(2, Dice.DiceSide.parrot);
        rollResult.put(3, Dice.DiceSide.parrot);
        rollResult.put(4, Dice.DiceSide.parrot);
        rollResult.put(5, Dice.DiceSide.parrot);
        rollResult.put(6, Dice.DiceSide.parrot);
        rollResult.put(7, Dice.DiceSide.parrot);
        System.out.println("The roll result is " + rollResult);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(2100, score);
    }

    @Test
    public void score65Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        // change the random dice to fixed one
        rollResult.put(0, Dice.DiceSide.coin);
        rollResult.put(1, Dice.DiceSide.coin);
        rollResult.put(2, Dice.DiceSide.coin);
        rollResult.put(3, Dice.DiceSide.coin);
        rollResult.put(4, Dice.DiceSide.coin);
        rollResult.put(5, Dice.DiceSide.coin);
        rollResult.put(6, Dice.DiceSide.coin);
        rollResult.put(7, Dice.DiceSide.coin);
        System.out.println("The roll result is " + rollResult);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(5400, score);
    }

    @Test
    public void score66Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.diamonds);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        // change the random dice to fixed one
        rollResult.put(0, Dice.DiceSide.coin);
        rollResult.put(1, Dice.DiceSide.coin);
        rollResult.put(2, Dice.DiceSide.coin);
        rollResult.put(3, Dice.DiceSide.coin);
        rollResult.put(4, Dice.DiceSide.coin);
        rollResult.put(5, Dice.DiceSide.coin);
        rollResult.put(6, Dice.DiceSide.coin);
        rollResult.put(7, Dice.DiceSide.coin);
        System.out.println("The roll result is " + rollResult);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(5400, score);
    }

    @Test
    public void score67Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.captain);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        // change the random dice to fixed one
        rollResult.put(0, Dice.DiceSide.sword);
        rollResult.put(1, Dice.DiceSide.sword);
        rollResult.put(2, Dice.DiceSide.sword);
        rollResult.put(3, Dice.DiceSide.sword);
        rollResult.put(4, Dice.DiceSide.sword);
        rollResult.put(5, Dice.DiceSide.sword);
        rollResult.put(6, Dice.DiceSide.sword);
        rollResult.put(7, Dice.DiceSide.sword);
        System.out.println("The roll result is " + rollResult);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(9000, score);
    }

    @Test
    public void score68Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        // change the random dice to fixed one
        rollResult.put(0, Dice.DiceSide.monkey);
        rollResult.put(1, Dice.DiceSide.monkey);
        rollResult.put(2, Dice.DiceSide.monkey);
        rollResult.put(3, Dice.DiceSide.monkey);
        rollResult.put(4, Dice.DiceSide.monkey);
        rollResult.put(5, Dice.DiceSide.monkey);
        rollResult.put(6, Dice.DiceSide.sword);
        rollResult.put(7, Dice.DiceSide.sword);
        System.out.println("The roll result is " + rollResult);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(6, 7));
        System.out.println("Re-roll 6, 7.");
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(6, Dice.DiceSide.parrot);
        rollResult.put(7, Dice.DiceSide.parrot);
        System.out.println("The re-roll result is " + rollResult);

        //re-roll
        indexes = new ArrayList<>(Arrays.asList(6, 7));
        System.out.println("Re-roll 6, 7.");
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(6, Dice.DiceSide.monkey);
        rollResult.put(7, Dice.DiceSide.monkey);
        System.out.println("The re-roll result is " + rollResult);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(4600, score);
    }

    @Test
    public void score69Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.diamonds);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        // change the random dice to fixed one
        rollResult.put(0, Dice.DiceSide.skull);
        rollResult.put(1, Dice.DiceSide.skull);
        rollResult.put(2, Dice.DiceSide.monkey);
        rollResult.put(3, Dice.DiceSide.monkey);
        rollResult.put(4, Dice.DiceSide.parrot);
        rollResult.put(5, Dice.DiceSide.parrot);
        rollResult.put(6, Dice.DiceSide.sword);
        rollResult.put(7, Dice.DiceSide.sword);
        System.out.println("The roll result is " + rollResult);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(6, 7));
        System.out.println("Re-roll 6, 7.");
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(6, Dice.DiceSide.diamond);
        rollResult.put(7, Dice.DiceSide.diamond);
        System.out.println("The re-roll result is " + rollResult);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(400, score);
    }

    @Test
    public void score70Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        // change the random dice to fixed one
        rollResult.put(0, Dice.DiceSide.skull);
        rollResult.put(1, Dice.DiceSide.skull);
        rollResult.put(2, Dice.DiceSide.monkey);
        rollResult.put(3, Dice.DiceSide.monkey);
        rollResult.put(4, Dice.DiceSide.parrot);
        rollResult.put(5, Dice.DiceSide.diamond);
        rollResult.put(6, Dice.DiceSide.sword);
        rollResult.put(7, Dice.DiceSide.sword);
        System.out.println("The roll result is " + rollResult);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(6, 7));
        System.out.println("Re-roll 6, 7.");
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(6, Dice.DiceSide.diamond);
        rollResult.put(7, Dice.DiceSide.diamond);
        System.out.println("The re-roll result is " + rollResult);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(500, score);
    }

    @Test
    public void score71Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        // change the random dice to fixed one
        rollResult.put(0, Dice.DiceSide.skull);
        rollResult.put(1, Dice.DiceSide.skull);
        rollResult.put(2, Dice.DiceSide.monkey);
        rollResult.put(3, Dice.DiceSide.monkey);
        rollResult.put(4, Dice.DiceSide.parrot);
        rollResult.put(5, Dice.DiceSide.coin);
        rollResult.put(6, Dice.DiceSide.sword);
        rollResult.put(7, Dice.DiceSide.sword);
        System.out.println("The roll result is " + rollResult);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(6, 7));
        System.out.println("Re-roll 6, 7.");
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(6, Dice.DiceSide.coin);
        rollResult.put(7, Dice.DiceSide.coin);
        System.out.println("The re-roll result is " + rollResult);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(600, score);
    }

    @Test
    public void score72Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.diamonds);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        // change the random dice to fixed one
        rollResult.put(0, Dice.DiceSide.skull);
        rollResult.put(1, Dice.DiceSide.skull);
        rollResult.put(2, Dice.DiceSide.monkey);
        rollResult.put(3, Dice.DiceSide.monkey);
        rollResult.put(4, Dice.DiceSide.parrot);
        rollResult.put(5, Dice.DiceSide.coin);
        rollResult.put(6, Dice.DiceSide.sword);
        rollResult.put(7, Dice.DiceSide.sword);
        System.out.println("The roll result is " + rollResult);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(6, 7));
        System.out.println("Re-roll 6, 7.");
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(6, Dice.DiceSide.coin);
        rollResult.put(7, Dice.DiceSide.coin);
        System.out.println("The re-roll result is " + rollResult);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(500, score);
    }

    @Test
    public void score73Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        // change the random dice to fixed one
        rollResult.put(0, Dice.DiceSide.skull);
        rollResult.put(1, Dice.DiceSide.monkey);
        rollResult.put(2, Dice.DiceSide.monkey);
        rollResult.put(3, Dice.DiceSide.monkey);
        rollResult.put(4, Dice.DiceSide.monkey);
        rollResult.put(5, Dice.DiceSide.coin);
        rollResult.put(6, Dice.DiceSide.coin);
        rollResult.put(7, Dice.DiceSide.sword);
        System.out.println("The roll result is " + rollResult);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(600, score);
    }

    @Test
    public void score75Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        // change the random dice to fixed one
        rollResult.put(0, Dice.DiceSide.sword);
        rollResult.put(1, Dice.DiceSide.sword);
        rollResult.put(2, Dice.DiceSide.sword);
        rollResult.put(3, Dice.DiceSide.sword);
        rollResult.put(4, Dice.DiceSide.sword);
        rollResult.put(5, Dice.DiceSide.sword);
        rollResult.put(6, Dice.DiceSide.sword);
        rollResult.put(7, Dice.DiceSide.monkey);
        System.out.println("The roll result is " + rollResult);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(7));
        System.out.println("Re-roll 7.");
        boolean reRoll = piratenKapern.reRoll(indexes, rollResult);
        assertEquals(false, reRoll);

    }
}
