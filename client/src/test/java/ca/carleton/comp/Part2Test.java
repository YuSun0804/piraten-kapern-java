package ca.carleton.comp;

import ca.carleton.comp.game.Dice;
import ca.carleton.comp.game.FortuneCard;
import ca.carleton.comp.game.PiratenKapern;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class Part2Test {
    private PiratenKapern piratenKapern = new PiratenKapern();

    @Test
    public void sorceress80Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.sorceress);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        //first roll result
        rollResult.put(0, Dice.DiceSide.skull);
        rollResult.put(1, Dice.DiceSide.skull);
        rollResult.put(2, Dice.DiceSide.parrot);
        rollResult.put(3, Dice.DiceSide.monkey);
        rollResult.put(4, Dice.DiceSide.monkey);
        rollResult.put(5, Dice.DiceSide.parrot);
        rollResult.put(6, Dice.DiceSide.monkey);
        rollResult.put(7, Dice.DiceSide.parrot);
        System.out.println("The roll result is " + rollResult);

        // re-roll for sorceress
        boolean result = piratenKapern.reRollForSorceress(rollResult);
        System.out.println("Re-roll 0 due to sorceress.");
        assertEquals(true, result);
        System.out.println("The re-roll result is " + rollResult);

        int countSkull = piratenKapern.countSkull(rollResult, fortuneCard);
        assertEquals(1, countSkull);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(5, 6, 7));
        System.out.println("Re-roll 5, 6, 7.");
        boolean reRoll = piratenKapern.reRoll(indexes, rollResult);
        assertEquals(true, reRoll);
        System.out.println("The re-roll result is " + rollResult);

    }

    @Test
    public void sorceress81Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.sorceress);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        //first roll result
        rollResult.put(0, Dice.DiceSide.monkey);
        rollResult.put(1, Dice.DiceSide.monkey);
        rollResult.put(2, Dice.DiceSide.parrot);
        rollResult.put(3, Dice.DiceSide.monkey);
        rollResult.put(4, Dice.DiceSide.monkey);
        rollResult.put(5, Dice.DiceSide.parrot);
        rollResult.put(6, Dice.DiceSide.monkey);
        rollResult.put(7, Dice.DiceSide.parrot);
        System.out.println("The roll result is " + rollResult);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(5, 6, 7));
        System.out.println("Re-roll 5, 6, 7.");
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(5, Dice.DiceSide.skull);
        rollResult.put(6, Dice.DiceSide.sword);
        rollResult.put(7, Dice.DiceSide.sword);
        System.out.println("The re-roll result is " + rollResult);

        // re-roll for sorceress
        boolean result = piratenKapern.reRollForSorceress(rollResult);
        System.out.println("Re-roll 5 due to sorceress.");
        assertEquals(true, result);
        System.out.println("The re-roll result is " + rollResult);

        int countSkull = piratenKapern.countSkull(rollResult, fortuneCard);
        assertEquals(0, countSkull);
        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        assertTrue(score > 0);
        System.out.println("The score is " + score);

    }

    @Test
    public void sorceress82Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.sorceress);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        //first roll result
        rollResult.put(0, Dice.DiceSide.monkey);
        rollResult.put(1, Dice.DiceSide.monkey);
        rollResult.put(2, Dice.DiceSide.parrot);
        rollResult.put(3, Dice.DiceSide.monkey);
        rollResult.put(4, Dice.DiceSide.monkey);
        rollResult.put(5, Dice.DiceSide.parrot);
        rollResult.put(6, Dice.DiceSide.monkey);
        rollResult.put(7, Dice.DiceSide.parrot);
        System.out.println("The roll result is " + rollResult);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(5, 6, 7));
        System.out.println("Re-roll 5, 6, 7.");
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(5, Dice.DiceSide.skull);
        rollResult.put(6, Dice.DiceSide.sword);
        rollResult.put(7, Dice.DiceSide.sword);
        System.out.println("The re-roll result is " + rollResult);

        // re-roll for sorceress
        boolean result = piratenKapern.reRollForSorceress(rollResult);
        System.out.println("Re-roll 5 due to sorceress.");
        assertEquals(true, result);
        System.out.println("The re-roll result is " + rollResult);

        int countSkull = piratenKapern.countSkull(rollResult, fortuneCard);
        assertEquals(0, countSkull);

        //re-roll
        indexes = new ArrayList<>(Arrays.asList(5, 6, 7));
        System.out.println("Re-roll 5, 6, 7.");
        boolean reRoll = piratenKapern.reRoll(indexes, rollResult);
        assertEquals(true, reRoll);
        System.out.println("The re-roll result is " + rollResult);

    }

    @Test
    public void monkeyBusiness85Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.monkey_business);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        //first roll result
        rollResult.put(0, Dice.DiceSide.monkey);
        rollResult.put(1, Dice.DiceSide.monkey);
        rollResult.put(2, Dice.DiceSide.monkey);
        rollResult.put(3, Dice.DiceSide.parrot);
        rollResult.put(4, Dice.DiceSide.parrot);
        rollResult.put(5, Dice.DiceSide.parrot);
        rollResult.put(6, Dice.DiceSide.skull);
        rollResult.put(7, Dice.DiceSide.coin);
        System.out.println("The roll result is " + rollResult);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(1100, score);
    }

    @Test
    public void monkeyBusiness86Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.monkey_business);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        //first roll result
        rollResult.put(0, Dice.DiceSide.monkey);
        rollResult.put(1, Dice.DiceSide.monkey);
        rollResult.put(2, Dice.DiceSide.parrot);
        rollResult.put(3, Dice.DiceSide.coin);
        rollResult.put(4, Dice.DiceSide.coin);
        rollResult.put(5, Dice.DiceSide.sword);
        rollResult.put(6, Dice.DiceSide.sword);
        rollResult.put(7, Dice.DiceSide.diamond);
        System.out.println("The roll result is " + rollResult);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(6, 7));
        System.out.println("Re-roll 6, 7.");
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(6, Dice.DiceSide.diamond);
        rollResult.put(7, Dice.DiceSide.sword);
        System.out.println("The re-roll result is " + rollResult);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(400, score);
    }

    @Test
    public void monkeyBusiness87Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.monkey_business);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        //first roll result
        rollResult.put(0, Dice.DiceSide.monkey);
        rollResult.put(1, Dice.DiceSide.monkey);
        rollResult.put(2, Dice.DiceSide.monkey);
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
        rollResult.put(6, Dice.DiceSide.parrot);
        rollResult.put(7, Dice.DiceSide.sword);
        System.out.println("The re-roll result is " + rollResult);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(2000, score);
    }

    @Test
    public void treasureChest90Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.treasure_chest);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        //first roll result
        rollResult.put(0, Dice.DiceSide.parrot);
        rollResult.put(1, Dice.DiceSide.parrot);
        rollResult.put(2, Dice.DiceSide.parrot);
        rollResult.put(3, Dice.DiceSide.sword);
        rollResult.put(4, Dice.DiceSide.sword);
        rollResult.put(5, Dice.DiceSide.diamond);
        rollResult.put(6, Dice.DiceSide.diamond);
        rollResult.put(7, Dice.DiceSide.coin);
        System.out.println("The roll result is " + rollResult);

        Map<Integer, Dice.DiceSide> treasureChest = new HashMap<>();
        List<Integer> inList = new ArrayList<>(Arrays.asList(5, 6, 7));
        System.out.println("put 5, 6, 7 in chest.");
        piratenKapern.changeTreasureChest(rollResult, fortuneCard, inList, new ArrayList<>(), treasureChest);
        System.out.println("The chest result is " + treasureChest);
        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(3, 4));
        System.out.println("Re-roll 3, 4.");
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(3, Dice.DiceSide.parrot);
        rollResult.put(4, Dice.DiceSide.parrot);
        System.out.println("The re-roll result is " + rollResult);

        inList = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        List<Integer> outList = new ArrayList<>(Arrays.asList(5, 6, 7));
        System.out.println("put 0, 1, 2, 3, 4 in chest, take 5, 6, 7 out.");
        piratenKapern.changeTreasureChest(rollResult, fortuneCard, inList, outList, treasureChest);
        System.out.println("The chest result is " + treasureChest);
        //re-roll
        indexes = new ArrayList<>(Arrays.asList(5, 6, 7));
        System.out.println("Re-roll 5, 6, 7.");
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(5, Dice.DiceSide.skull);
        rollResult.put(6, Dice.DiceSide.coin);
        rollResult.put(7, Dice.DiceSide.parrot);
        System.out.println("The re-roll result is " + rollResult);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(1100, score);
    }

    @Test
    public void treasureChest95Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.treasure_chest);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        //first roll result
        rollResult.put(0, Dice.DiceSide.skull);
        rollResult.put(1, Dice.DiceSide.skull);
        rollResult.put(2, Dice.DiceSide.parrot);
        rollResult.put(3, Dice.DiceSide.parrot);
        rollResult.put(4, Dice.DiceSide.parrot);
        rollResult.put(5, Dice.DiceSide.coin);
        rollResult.put(6, Dice.DiceSide.coin);
        rollResult.put(7, Dice.DiceSide.coin);
        System.out.println("The roll result is " + rollResult);

        Map<Integer, Dice.DiceSide> treasureChest = new HashMap<>();
        List<Integer> inList = new ArrayList<>(Arrays.asList(5, 6, 7));
        System.out.println("put 5, 6, 7 in chest.");
        piratenKapern.changeTreasureChest(rollResult, fortuneCard, inList, new ArrayList<>(), treasureChest);
        System.out.println("The chest result is " + treasureChest);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(2, 3, 4));
        System.out.println("Re-roll 2, 3, 4.");
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(2, Dice.DiceSide.coin);
        rollResult.put(3, Dice.DiceSide.diamond);
        rollResult.put(4, Dice.DiceSide.diamond);
        System.out.println("The re-roll result is " + rollResult);

        System.out.println("put 2 in chest.");
        inList = new ArrayList<>(Arrays.asList(2));
        piratenKapern.changeTreasureChest(rollResult, fortuneCard, inList, new ArrayList<>(), treasureChest);
        System.out.println("The chest result is " + treasureChest);

        //re-roll
        indexes = new ArrayList<>(Arrays.asList(3, 4));
        System.out.println("Re-roll 3, 4.");
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(3, Dice.DiceSide.skull);
        rollResult.put(4, Dice.DiceSide.coin);
        System.out.println("The re-roll result is " + rollResult);

        boolean canContinue = piratenKapern.canContinue(rollResult, fortuneCard);
        assertEquals(false, canContinue);
        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, treasureChest);
        System.out.println("The score is " + score);
        assertEquals(600, score);
    }

    @Test
    public void fullChest101Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        //first roll result
        rollResult.put(0, Dice.DiceSide.monkey);
        rollResult.put(1, Dice.DiceSide.monkey);
        rollResult.put(2, Dice.DiceSide.monkey);
        rollResult.put(3, Dice.DiceSide.sword);
        rollResult.put(4, Dice.DiceSide.sword);
        rollResult.put(5, Dice.DiceSide.sword);
        rollResult.put(6, Dice.DiceSide.diamond);
        rollResult.put(7, Dice.DiceSide.parrot);
        System.out.println("The roll result is " + rollResult);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(400, score);
    }

    @Test
    public void fullChest102Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.captain);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        //first roll result
        rollResult.put(0, Dice.DiceSide.monkey);
        rollResult.put(1, Dice.DiceSide.monkey);
        rollResult.put(2, Dice.DiceSide.monkey);
        rollResult.put(3, Dice.DiceSide.sword);
        rollResult.put(4, Dice.DiceSide.sword);
        rollResult.put(5, Dice.DiceSide.sword);
        rollResult.put(6, Dice.DiceSide.coin);
        rollResult.put(7, Dice.DiceSide.coin);
        System.out.println("The roll result is " + rollResult);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(1800, score);
    }

    @Test
    public void fullChest103Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        //first roll result
        rollResult.put(0, Dice.DiceSide.monkey);
        rollResult.put(1, Dice.DiceSide.monkey);
        rollResult.put(2, Dice.DiceSide.monkey);
        rollResult.put(3, Dice.DiceSide.sword);
        rollResult.put(4, Dice.DiceSide.sword);
        rollResult.put(5, Dice.DiceSide.sword);
        rollResult.put(6, Dice.DiceSide.sword);
        rollResult.put(7, Dice.DiceSide.diamond);
        System.out.println("The roll result is " + rollResult);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(1000, score);
    }

    @Test
    public void fullChest104Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.two_sabre);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        //first roll result
        rollResult.put(0, Dice.DiceSide.monkey);
        rollResult.put(1, Dice.DiceSide.monkey);
        rollResult.put(2, Dice.DiceSide.monkey);
        rollResult.put(3, Dice.DiceSide.monkey);
        rollResult.put(4, Dice.DiceSide.sword);
        rollResult.put(5, Dice.DiceSide.parrot);
        rollResult.put(6, Dice.DiceSide.parrot);
        rollResult.put(7, Dice.DiceSide.coin);
        System.out.println("The roll result is " + rollResult);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(5, 6));
        System.out.println("Re-roll 5, 6.");
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(5, Dice.DiceSide.coin);
        rollResult.put(6, Dice.DiceSide.sword);
        System.out.println("The re-roll result is " + rollResult);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(1200, score);
    }

    @Test
    public void fullChest107Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.monkey_business);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        //first roll result
        rollResult.put(0, Dice.DiceSide.monkey);
        rollResult.put(1, Dice.DiceSide.monkey);
        rollResult.put(2, Dice.DiceSide.parrot);
        rollResult.put(3, Dice.DiceSide.coin);
        rollResult.put(4, Dice.DiceSide.coin);
        rollResult.put(5, Dice.DiceSide.diamond);
        rollResult.put(6, Dice.DiceSide.diamond);
        rollResult.put(7, Dice.DiceSide.diamond);
        System.out.println("The roll result is " + rollResult);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(1200, score);
    }

    @Test
    public void skull110Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.two_skull);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        //first roll result
        rollResult.put(0, Dice.DiceSide.skull);
        rollResult.put(1, Dice.DiceSide.monkey);
        rollResult.put(2, Dice.DiceSide.monkey);
        rollResult.put(3, Dice.DiceSide.sword);
        rollResult.put(4, Dice.DiceSide.sword);
        rollResult.put(5, Dice.DiceSide.sword);
        rollResult.put(6, Dice.DiceSide.coin);
        rollResult.put(7, Dice.DiceSide.coin);
        System.out.println("The roll result is " + rollResult);

        boolean canContinue = piratenKapern.canContinue(rollResult, fortuneCard);
        assertEquals(false, canContinue);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(0, score);
    }

    @Test
    public void skull111Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.one_skull);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        //first roll result
        rollResult.put(0, Dice.DiceSide.skull);
        rollResult.put(1, Dice.DiceSide.skull);
        rollResult.put(2, Dice.DiceSide.monkey);
        rollResult.put(3, Dice.DiceSide.sword);
        rollResult.put(4, Dice.DiceSide.sword);
        rollResult.put(5, Dice.DiceSide.sword);
        rollResult.put(6, Dice.DiceSide.coin);
        rollResult.put(7, Dice.DiceSide.coin);
        System.out.println("The roll result is " + rollResult);

        boolean canContinue = piratenKapern.canContinue(rollResult, fortuneCard);
        assertEquals(false, canContinue);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(0, score);
    }

    @Test
    public void skull112Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.two_skull);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        //first roll result
        rollResult.put(0, Dice.DiceSide.skull);
        rollResult.put(1, Dice.DiceSide.skull);
        rollResult.put(2, Dice.DiceSide.monkey);
        rollResult.put(3, Dice.DiceSide.sword);
        rollResult.put(4, Dice.DiceSide.sword);
        rollResult.put(5, Dice.DiceSide.sword);
        rollResult.put(6, Dice.DiceSide.coin);
        rollResult.put(7, Dice.DiceSide.coin);
        System.out.println("The roll result is " + rollResult);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(3, 4));
        System.out.println("Re-roll 3, 4.");
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(3, Dice.DiceSide.skull);
        rollResult.put(4, Dice.DiceSide.skull);
        System.out.println("The re-roll result is " + rollResult);

        //re-roll
        indexes = new ArrayList<>(Arrays.asList(5, 6));
        System.out.println("Re-roll 5, 6.");
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(5, Dice.DiceSide.coin);
        rollResult.put(6, Dice.DiceSide.skull);
        System.out.println("The re-roll result is " + rollResult);

        int deduction = piratenKapern.computeDeductionOnIsland(rollResult, fortuneCard);
        System.out.println("The deduction is " + deduction);
        assertEquals(-700, deduction);
    }

    @Test
    public void skull113Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.two_skull);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        //first roll result
        rollResult.put(0, Dice.DiceSide.skull);
        rollResult.put(1, Dice.DiceSide.skull);
        rollResult.put(2, Dice.DiceSide.skull);
        rollResult.put(3, Dice.DiceSide.sword);
        rollResult.put(4, Dice.DiceSide.sword);
        rollResult.put(5, Dice.DiceSide.sword);
        rollResult.put(6, Dice.DiceSide.coin);
        rollResult.put(7, Dice.DiceSide.coin);
        System.out.println("The roll result is " + rollResult);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(3, 4));
        System.out.println("Re-roll 3, 4.");
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(3, Dice.DiceSide.monkey);
        rollResult.put(4, Dice.DiceSide.monkey);
        System.out.println("The re-roll result is " + rollResult);

        int deduction = piratenKapern.computeDeductionOnIsland(rollResult, fortuneCard);
        System.out.println("The deduction is " + deduction);
        assertEquals(-500, deduction);
    }

    @Test
    public void skull114Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.one_skull);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        //first roll result
        rollResult.put(0, Dice.DiceSide.skull);
        rollResult.put(1, Dice.DiceSide.skull);
        rollResult.put(2, Dice.DiceSide.skull);
        rollResult.put(3, Dice.DiceSide.sword);
        rollResult.put(4, Dice.DiceSide.sword);
        rollResult.put(5, Dice.DiceSide.sword);
        rollResult.put(6, Dice.DiceSide.coin);
        rollResult.put(7, Dice.DiceSide.coin);
        System.out.println("The roll result is " + rollResult);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(3, 4));
        System.out.println("Re-roll 3, 4.");
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(3, Dice.DiceSide.skull);
        rollResult.put(4, Dice.DiceSide.monkey);
        System.out.println("The re-roll result is " + rollResult);

        //re-roll
        indexes = new ArrayList<>(Arrays.asList(5, 6));
        System.out.println("Re-roll 5, 6.");
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(5, Dice.DiceSide.monkey);
        rollResult.put(6, Dice.DiceSide.monkey);
        System.out.println("The re-roll result is " + rollResult);

        int deduction = piratenKapern.computeDeductionOnIsland(rollResult, fortuneCard);
        System.out.println("The deduction is " + deduction);
        assertEquals(-500, deduction);
    }

    @Test
    public void seaBattle118Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.two_sabre);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        //first roll result
        rollResult.put(0, Dice.DiceSide.skull);
        rollResult.put(1, Dice.DiceSide.skull);
        rollResult.put(2, Dice.DiceSide.skull);
        rollResult.put(3, Dice.DiceSide.sword);
        rollResult.put(4, Dice.DiceSide.sword);
        rollResult.put(5, Dice.DiceSide.sword);
        rollResult.put(6, Dice.DiceSide.coin);
        rollResult.put(7, Dice.DiceSide.coin);
        System.out.println("The roll result is " + rollResult);

        boolean canContinue = piratenKapern.canContinue(rollResult, fortuneCard);
        assertEquals(false, canContinue);
        int deduction = piratenKapern.computeSeaBattle(rollResult, fortuneCard, canContinue);
        System.out.println("The deduction is " + deduction);
        assertEquals(-300, deduction);
    }

    @Test
    public void seaBattle119Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.three_sabre);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        //first roll result
        rollResult.put(0, Dice.DiceSide.skull);
        rollResult.put(1, Dice.DiceSide.skull);
        rollResult.put(2, Dice.DiceSide.skull);
        rollResult.put(3, Dice.DiceSide.sword);
        rollResult.put(4, Dice.DiceSide.sword);
        rollResult.put(5, Dice.DiceSide.coin);
        rollResult.put(6, Dice.DiceSide.coin);
        rollResult.put(7, Dice.DiceSide.coin);
        System.out.println("The roll result is " + rollResult);

        boolean canContinue = piratenKapern.canContinue(rollResult, fortuneCard);
        assertEquals(false, canContinue);
        int deduction = piratenKapern.computeSeaBattle(rollResult, fortuneCard, canContinue);
        System.out.println("The deduction is " + deduction);
        assertEquals(-500, deduction);
    }

    @Test
    public void seaBattle120Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.four_sabre);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        //first roll result
        rollResult.put(0, Dice.DiceSide.skull);
        rollResult.put(1, Dice.DiceSide.skull);
        rollResult.put(2, Dice.DiceSide.skull);
        rollResult.put(3, Dice.DiceSide.sword);
        rollResult.put(4, Dice.DiceSide.sword);
        rollResult.put(5, Dice.DiceSide.coin);
        rollResult.put(6, Dice.DiceSide.coin);
        rollResult.put(7, Dice.DiceSide.coin);
        System.out.println("The roll result is " + rollResult);

        boolean canContinue = piratenKapern.canContinue(rollResult, fortuneCard);
        assertEquals(false, canContinue);
        int deduction = piratenKapern.computeSeaBattle(rollResult, fortuneCard, canContinue);
        System.out.println("The deduction is " + deduction);
        assertEquals(-1000, deduction);
    }

    @Test
    public void seaBattle122Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.two_sabre);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        //first roll result
        rollResult.put(0, Dice.DiceSide.monkey);
        rollResult.put(1, Dice.DiceSide.monkey);
        rollResult.put(2, Dice.DiceSide.monkey);
        rollResult.put(3, Dice.DiceSide.sword);
        rollResult.put(4, Dice.DiceSide.sword);
        rollResult.put(5, Dice.DiceSide.coin);
        rollResult.put(6, Dice.DiceSide.parrot);
        rollResult.put(7, Dice.DiceSide.parrot);
        System.out.println("The roll result is " + rollResult);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(500, score);
    }

    @Test
    public void seaBattle123Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.two_sabre);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        //first roll result
        rollResult.put(0, Dice.DiceSide.monkey);
        rollResult.put(1, Dice.DiceSide.monkey);
        rollResult.put(2, Dice.DiceSide.monkey);
        rollResult.put(3, Dice.DiceSide.monkey);
        rollResult.put(4, Dice.DiceSide.sword);
        rollResult.put(5, Dice.DiceSide.skull);
        rollResult.put(6, Dice.DiceSide.parrot);
        rollResult.put(7, Dice.DiceSide.parrot);
        System.out.println("The roll result is " + rollResult);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(6, 7));
        System.out.println("Re-roll 6, 7.");
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(6, Dice.DiceSide.skull);
        rollResult.put(7, Dice.DiceSide.sword);
        System.out.println("The re-roll result is " + rollResult);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(500, score);
    }

    @Test
    public void seaBattle125Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.three_sabre);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        //first roll result
        rollResult.put(0, Dice.DiceSide.monkey);
        rollResult.put(1, Dice.DiceSide.monkey);
        rollResult.put(2, Dice.DiceSide.monkey);
        rollResult.put(3, Dice.DiceSide.sword);
        rollResult.put(4, Dice.DiceSide.sword);
        rollResult.put(5, Dice.DiceSide.sword);
        rollResult.put(6, Dice.DiceSide.sword);
        rollResult.put(7, Dice.DiceSide.parrot);
        System.out.println("The roll result is " + rollResult);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(800, score);
    }

    @Test
    public void seaBattle126Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.three_sabre);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        //first roll result
        rollResult.put(0, Dice.DiceSide.monkey);
        rollResult.put(1, Dice.DiceSide.monkey);
        rollResult.put(2, Dice.DiceSide.monkey);
        rollResult.put(3, Dice.DiceSide.monkey);
        rollResult.put(4, Dice.DiceSide.sword);
        rollResult.put(5, Dice.DiceSide.sword);
        rollResult.put(6, Dice.DiceSide.skull);
        rollResult.put(7, Dice.DiceSide.skull);
        System.out.println("The roll result is " + rollResult);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        System.out.println("Re-roll 1, 2, 3, 4.");
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(1, Dice.DiceSide.skull);
        rollResult.put(2, Dice.DiceSide.skull);
        rollResult.put(3, Dice.DiceSide.sword);
        rollResult.put(4, Dice.DiceSide.sword);
        System.out.println("The re-roll result is " + rollResult);

        boolean canContinue = piratenKapern.canContinue(rollResult, fortuneCard);
        assertEquals(false, canContinue);
    }

    @Test
    public void seaBattle128Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.four_sabre);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        //first roll result
        rollResult.put(0, Dice.DiceSide.monkey);
        rollResult.put(1, Dice.DiceSide.monkey);
        rollResult.put(2, Dice.DiceSide.monkey);
        rollResult.put(3, Dice.DiceSide.sword);
        rollResult.put(4, Dice.DiceSide.sword);
        rollResult.put(5, Dice.DiceSide.sword);
        rollResult.put(6, Dice.DiceSide.sword);
        rollResult.put(7, Dice.DiceSide.skull);
        System.out.println("The roll result is " + rollResult);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        assertEquals(1300, score);
    }

    @Test
    public void seaBattle129Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.four_sabre);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        // first roll
        Map<Integer, Dice.DiceSide> rollResult = piratenKapern.roll();
        //first roll result
        rollResult.put(0, Dice.DiceSide.monkey);
        rollResult.put(1, Dice.DiceSide.monkey);
        rollResult.put(2, Dice.DiceSide.monkey);
        rollResult.put(3, Dice.DiceSide.sword);
        rollResult.put(4, Dice.DiceSide.skull);
        rollResult.put(5, Dice.DiceSide.diamond);
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
        indexes = new ArrayList<>(Arrays.asList(0, 1, 2));
        System.out.println("Re-roll 0, 1, 2.");
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(0, Dice.DiceSide.sword);
        rollResult.put(1, Dice.DiceSide.parrot);
        rollResult.put(2, Dice.DiceSide.parrot);
        System.out.println("The re-roll result is " + rollResult);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        System.out.println("The score is " + score);
        assertEquals(1300, score);
    }
}
