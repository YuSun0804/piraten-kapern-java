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
        // re-roll for sorceress
        boolean result = piratenKapern.reRollForSorceress(rollResult);
        assertEquals(true, result);

        int countSkull = piratenKapern.countSkull(rollResult, fortuneCard);
        assertEquals(1, countSkull);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(5, 6, 7));
        boolean reRoll = piratenKapern.reRoll(indexes, rollResult);
        assertEquals(true, reRoll);

    }

    @Test
    public void sorceress81Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.sorceress);
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
        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(5, 6, 7));
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(5, Dice.DiceSide.skull);
        rollResult.put(6, Dice.DiceSide.sword);
        rollResult.put(7, Dice.DiceSide.sword);

        // re-roll for sorceress
        boolean result = piratenKapern.reRollForSorceress(rollResult);
        assertEquals(true, result);

        int countSkull = piratenKapern.countSkull(rollResult, fortuneCard);
        assertEquals(0, countSkull);
        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        assertTrue(score > 0);
    }

    @Test
    public void sorceress82Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.sorceress);
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
        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(5, 6, 7));
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(5, Dice.DiceSide.skull);
        rollResult.put(6, Dice.DiceSide.sword);
        rollResult.put(7, Dice.DiceSide.sword);

        // re-roll for sorceress
        boolean result = piratenKapern.reRollForSorceress(rollResult);
        assertEquals(true, result);

        int countSkull = piratenKapern.countSkull(rollResult, fortuneCard);
        assertEquals(0, countSkull);

        //re-roll
        indexes = new ArrayList<>(Arrays.asList(5, 6, 7));
        boolean reRoll = piratenKapern.reRoll(indexes, rollResult);
        assertEquals(true, reRoll);
    }

    @Test
    public void monkeyBusiness85Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.monkey_business);
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

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        assertEquals(1100, score);
    }

    @Test
    public void monkeyBusiness86Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.monkey_business);
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

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(6, 7));
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(6, Dice.DiceSide.diamond);
        rollResult.put(7, Dice.DiceSide.sword);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        assertEquals(400, score);
    }

    @Test
    public void monkeyBusiness87Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.monkey_business);
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

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(6, 7));
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(6, Dice.DiceSide.parrot);
        rollResult.put(7, Dice.DiceSide.sword);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        assertEquals(2000, score);
    }

    @Test
    public void treasureChest90Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.treasure_chest);
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

        Map<Integer, Dice.DiceSide> reservedDiceMap = new HashMap<>();
        List<Integer> inList = new ArrayList<>(Arrays.asList(5, 6, 7));
        piratenKapern.changeTreasureChest(rollResult, fortuneCard, inList, new ArrayList<>(), reservedDiceMap);
        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(3, 4));
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(3, Dice.DiceSide.parrot);
        rollResult.put(4, Dice.DiceSide.parrot);

        inList = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        List<Integer> outList = new ArrayList<>(Arrays.asList(5, 6, 7));
        piratenKapern.changeTreasureChest(rollResult, fortuneCard, inList, outList, reservedDiceMap);

        //re-roll
        indexes = new ArrayList<>(Arrays.asList(5, 6, 7));
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(5, Dice.DiceSide.skull);
        rollResult.put(6, Dice.DiceSide.coin);
        rollResult.put(7, Dice.DiceSide.parrot);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        assertEquals(1100, score);
    }

    @Test
    public void treasureChest95Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.treasure_chest);
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

        Map<Integer, Dice.DiceSide> treasureChest = new HashMap<>();
        List<Integer> inList = new ArrayList<>(Arrays.asList(5, 6, 7));
        piratenKapern.changeTreasureChest(rollResult, fortuneCard, inList, new ArrayList<>(), treasureChest);
        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(2, 3, 4));
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(2, Dice.DiceSide.coin);
        rollResult.put(3, Dice.DiceSide.diamond);
        rollResult.put(4, Dice.DiceSide.diamond);

        inList = new ArrayList<>(Arrays.asList(2));
        piratenKapern.changeTreasureChest(rollResult, fortuneCard, inList, new ArrayList<>(), treasureChest);

        //re-roll
        indexes = new ArrayList<>(Arrays.asList(3, 4));
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(3, Dice.DiceSide.skull);
        rollResult.put(4, Dice.DiceSide.coin);

        boolean canContinue = piratenKapern.canContinue(rollResult, fortuneCard);
        assertEquals(false, canContinue);
        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, treasureChest);
        assertEquals(600, score);
    }

    @Test
    public void fullChest101Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
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

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        assertEquals(400, score);
    }

    @Test
    public void fullChest102Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.captain);
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

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        assertEquals(1800, score);
    }

    @Test
    public void fullChest103Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
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

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        assertEquals(1000, score);
    }

    @Test
    public void fullChest104Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.two_sabre);
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

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(5, 6));
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(5, Dice.DiceSide.coin);
        rollResult.put(6, Dice.DiceSide.sword);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        assertEquals(1200, score);
    }

    @Test
    public void fullChest107Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.monkey_business);
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

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        assertEquals(1200, score);
    }

    @Test
    public void skull110Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.two_skull);
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

        boolean canContinue = piratenKapern.canContinue(rollResult, fortuneCard);
        assertEquals(false, canContinue);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        assertEquals(0, score);
    }

    @Test
    public void skull111Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.one_skull);
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

        boolean canContinue = piratenKapern.canContinue(rollResult, fortuneCard);
        assertEquals(false, canContinue);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        assertEquals(0, score);
    }

    @Test
    public void skull112Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.two_skull);
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

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(3, 4));
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(3, Dice.DiceSide.skull);
        rollResult.put(4, Dice.DiceSide.skull);

        //re-roll
        indexes = new ArrayList<>(Arrays.asList(5));
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(5, Dice.DiceSide.skull);

        int deduction = piratenKapern.computeDeductionOnIsland(rollResult, fortuneCard);
        assertEquals(-700, deduction);
    }

    @Test
    public void skull113Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.two_skull);
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

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(3, 4));
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(3, Dice.DiceSide.monkey);
        rollResult.put(4, Dice.DiceSide.monkey);


        int deduction = piratenKapern.computeDeductionOnIsland(rollResult, fortuneCard);
        assertEquals(-500, deduction);
    }

    @Test
    public void skull114Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.one_skull);
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

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(3, 4));
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(3, Dice.DiceSide.skull);
        rollResult.put(4, Dice.DiceSide.monkey);

        //re-roll
        indexes = new ArrayList<>(Arrays.asList(5, 6));
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(5, Dice.DiceSide.monkey);
        rollResult.put(6, Dice.DiceSide.monkey);

        int deduction = piratenKapern.computeDeductionOnIsland(rollResult, fortuneCard);
        assertEquals(-500, deduction);
    }

    @Test
    public void seaBattle118Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.two_sabre);
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

        boolean canContinue = piratenKapern.canContinue(rollResult, fortuneCard);
        assertEquals(false, canContinue);
        int deduction = piratenKapern.computeSeaBattle(rollResult, fortuneCard, canContinue);
        assertEquals(-300, deduction);
    }

    @Test
    public void seaBattle119Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.three_sabre);
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

        boolean canContinue = piratenKapern.canContinue(rollResult, fortuneCard);
        assertEquals(false, canContinue);
        int deduction = piratenKapern.computeSeaBattle(rollResult, fortuneCard, canContinue);
        assertEquals(-500, deduction);
    }

    @Test
    public void seaBattle120Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.four_sabre);
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

        boolean canContinue = piratenKapern.canContinue(rollResult, fortuneCard);
        assertEquals(false, canContinue);
        int deduction = piratenKapern.computeSeaBattle(rollResult, fortuneCard, canContinue);
        assertEquals(-1000, deduction);
    }

    @Test
    public void seaBattle122Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.two_sabre);
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

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        assertEquals(500, score);
    }

    @Test
    public void seaBattle123Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.two_sabre);
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

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(6, 7));
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(6, Dice.DiceSide.skull);
        rollResult.put(7, Dice.DiceSide.sword);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        assertEquals(500, score);
    }

    @Test
    public void seaBattle125Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.three_sabre);
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

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        assertEquals(800, score);
    }

    @Test
    public void seaBattle126Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.three_sabre);
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

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(1, Dice.DiceSide.skull);
        rollResult.put(2, Dice.DiceSide.skull);
        rollResult.put(3, Dice.DiceSide.sword);
        rollResult.put(4, Dice.DiceSide.sword);

        boolean canContinue = piratenKapern.canContinue(rollResult, fortuneCard);
        assertEquals(false, canContinue);
    }

    @Test
    public void seaBattle128Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.four_sabre);
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

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        assertEquals(1300, score);
    }

    @Test
    public void seaBattle129Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.four_sabre);
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

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(6, 7));
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(6, Dice.DiceSide.sword);
        rollResult.put(7, Dice.DiceSide.sword);

        //re-roll
        indexes = new ArrayList<>(Arrays.asList(0, 1, 2));
        piratenKapern.reRoll(indexes, rollResult);
        // change the random dice to fixed one
        rollResult.put(0, Dice.DiceSide.sword);
        rollResult.put(1, Dice.DiceSide.parrot);
        rollResult.put(2, Dice.DiceSide.parrot);

        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, null);
        assertEquals(1300, score);
    }
}
