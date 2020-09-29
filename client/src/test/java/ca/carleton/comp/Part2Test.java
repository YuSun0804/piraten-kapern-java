package ca.carleton.comp;

import ca.carleton.comp.game.Constant;
import ca.carleton.comp.game.Dice;
import ca.carleton.comp.game.FortuneCard;
import ca.carleton.comp.game.PiratenKapern;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class Part2Test {
    private PiratenKapern piratenKapern = new PiratenKapern();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void sorceress80Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.sorceress);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        //first roll result
        diceSideMap.put(0, Dice.DiceSide.skull);
        diceSideMap.put(1, Dice.DiceSide.skull);
        diceSideMap.put(2, Dice.DiceSide.parrot);
        diceSideMap.put(3, Dice.DiceSide.monkey);
        diceSideMap.put(4, Dice.DiceSide.monkey);
        diceSideMap.put(5, Dice.DiceSide.parrot);
        diceSideMap.put(6, Dice.DiceSide.monkey);
        diceSideMap.put(7, Dice.DiceSide.parrot);
        // re-roll for sorceress
        boolean result = piratenKapern.reRollForSorceress(diceSideMap);
        assertEquals(true, result);

        int countSkull = piratenKapern.countSkull(diceSideMap, fortuneCard);
        assertEquals(1, countSkull);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(5, 6, 7));
        boolean reRoll = piratenKapern.reRoll(indexes, diceSideMap);
        assertEquals(true, reRoll);

    }

    @Test
    public void sorceress81Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.sorceress);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        //first roll result
        diceSideMap.put(0, Dice.DiceSide.monkey);
        diceSideMap.put(1, Dice.DiceSide.monkey);
        diceSideMap.put(2, Dice.DiceSide.parrot);
        diceSideMap.put(3, Dice.DiceSide.monkey);
        diceSideMap.put(4, Dice.DiceSide.monkey);
        diceSideMap.put(5, Dice.DiceSide.parrot);
        diceSideMap.put(6, Dice.DiceSide.monkey);
        diceSideMap.put(7, Dice.DiceSide.parrot);
        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(5, 6, 7));
        piratenKapern.reRoll(indexes, diceSideMap);
        // change the random dice to fixed one
        diceSideMap.put(5, Dice.DiceSide.skull);
        diceSideMap.put(6, Dice.DiceSide.sword);
        diceSideMap.put(7, Dice.DiceSide.sword);

        // re-roll for sorceress
        boolean result = piratenKapern.reRollForSorceress(diceSideMap);
        assertEquals(true, result);

        int countSkull = piratenKapern.countSkull(diceSideMap, fortuneCard);
        assertEquals(0, countSkull);
        int score = piratenKapern.computeScore(diceSideMap, fortuneCard, false, null);
        assertTrue(score > 0);
    }

    @Test
    public void sorceress82Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.sorceress);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        //first roll result
        diceSideMap.put(0, Dice.DiceSide.monkey);
        diceSideMap.put(1, Dice.DiceSide.monkey);
        diceSideMap.put(2, Dice.DiceSide.parrot);
        diceSideMap.put(3, Dice.DiceSide.monkey);
        diceSideMap.put(4, Dice.DiceSide.monkey);
        diceSideMap.put(5, Dice.DiceSide.parrot);
        diceSideMap.put(6, Dice.DiceSide.monkey);
        diceSideMap.put(7, Dice.DiceSide.parrot);
        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(5, 6, 7));
        piratenKapern.reRoll(indexes, diceSideMap);
        // change the random dice to fixed one
        diceSideMap.put(5, Dice.DiceSide.skull);
        diceSideMap.put(6, Dice.DiceSide.sword);
        diceSideMap.put(7, Dice.DiceSide.sword);

        // re-roll for sorceress
        boolean result = piratenKapern.reRollForSorceress(diceSideMap);
        assertEquals(true, result);

        int countSkull = piratenKapern.countSkull(diceSideMap, fortuneCard);
        assertEquals(0, countSkull);

        //re-roll
        indexes = new ArrayList<>(Arrays.asList(5, 6, 7));
        boolean reRoll = piratenKapern.reRoll(indexes, diceSideMap);
        assertEquals(true, reRoll);
    }

    @Test
    public void monkeyBusiness85Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.monkey_business);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        //first roll result
        diceSideMap.put(0, Dice.DiceSide.monkey);
        diceSideMap.put(1, Dice.DiceSide.monkey);
        diceSideMap.put(2, Dice.DiceSide.monkey);
        diceSideMap.put(3, Dice.DiceSide.parrot);
        diceSideMap.put(4, Dice.DiceSide.parrot);
        diceSideMap.put(5, Dice.DiceSide.parrot);
        diceSideMap.put(6, Dice.DiceSide.skull);
        diceSideMap.put(7, Dice.DiceSide.coin);

        int score = piratenKapern.computeScore(diceSideMap, fortuneCard, false, null);
        assertEquals(1100, score);
    }

    @Test
    public void monkeyBusiness86Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.monkey_business);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        //first roll result
        diceSideMap.put(0, Dice.DiceSide.monkey);
        diceSideMap.put(1, Dice.DiceSide.monkey);
        diceSideMap.put(2, Dice.DiceSide.parrot);
        diceSideMap.put(3, Dice.DiceSide.coin);
        diceSideMap.put(4, Dice.DiceSide.coin);
        diceSideMap.put(5, Dice.DiceSide.sword);
        diceSideMap.put(6, Dice.DiceSide.sword);
        diceSideMap.put(7, Dice.DiceSide.diamond);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(6, 7));
        piratenKapern.reRoll(indexes, diceSideMap);
        // change the random dice to fixed one
        diceSideMap.put(6, Dice.DiceSide.diamond);
        diceSideMap.put(7, Dice.DiceSide.sword);

        int score = piratenKapern.computeScore(diceSideMap, fortuneCard, false, null);
        assertEquals(400, score);
    }

    @Test
    public void monkeyBusiness87Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.monkey_business);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        //first roll result
        diceSideMap.put(0, Dice.DiceSide.monkey);
        diceSideMap.put(1, Dice.DiceSide.monkey);
        diceSideMap.put(2, Dice.DiceSide.monkey);
        diceSideMap.put(3, Dice.DiceSide.parrot);
        diceSideMap.put(4, Dice.DiceSide.parrot);
        diceSideMap.put(5, Dice.DiceSide.parrot);
        diceSideMap.put(6, Dice.DiceSide.sword);
        diceSideMap.put(7, Dice.DiceSide.sword);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(6, 7));
        piratenKapern.reRoll(indexes, diceSideMap);
        // change the random dice to fixed one
        diceSideMap.put(6, Dice.DiceSide.parrot);
        diceSideMap.put(7, Dice.DiceSide.sword);

        int score = piratenKapern.computeScore(diceSideMap, fortuneCard, false, null);
        assertEquals(2000, score);
    }

    @Test
    public void treasureChest90Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.treasure_chest);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        //first roll result
        diceSideMap.put(0, Dice.DiceSide.parrot);
        diceSideMap.put(1, Dice.DiceSide.parrot);
        diceSideMap.put(2, Dice.DiceSide.parrot);
        diceSideMap.put(3, Dice.DiceSide.sword);
        diceSideMap.put(4, Dice.DiceSide.sword);
        diceSideMap.put(5, Dice.DiceSide.diamond);
        diceSideMap.put(6, Dice.DiceSide.diamond);
        diceSideMap.put(7, Dice.DiceSide.coin);

        Map<Integer, Dice.DiceSide> reservedDiceMap = new HashMap<>();
        List<Integer> inList = new ArrayList<>(Arrays.asList(5, 6, 7));
        piratenKapern.changeTreasureChest(diceSideMap, fortuneCard, inList, new ArrayList<>(), reservedDiceMap);
        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(3, 4));
        piratenKapern.reRoll(indexes, diceSideMap);
        // change the random dice to fixed one
        diceSideMap.put(3, Dice.DiceSide.parrot);
        diceSideMap.put(4, Dice.DiceSide.parrot);

        inList = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        List<Integer> outList = new ArrayList<>(Arrays.asList(5, 6, 7));
        piratenKapern.changeTreasureChest(diceSideMap, fortuneCard, inList, outList, reservedDiceMap);

        //re-roll
        indexes = new ArrayList<>(Arrays.asList(5, 6, 7));
        piratenKapern.reRoll(indexes, diceSideMap);
        // change the random dice to fixed one
        diceSideMap.put(5, Dice.DiceSide.skull);
        diceSideMap.put(6, Dice.DiceSide.coin);
        diceSideMap.put(7, Dice.DiceSide.parrot);

        int score = piratenKapern.computeScore(diceSideMap, fortuneCard, false, null);
        assertEquals(1100, score);
    }

    @Test
    public void treasureChest95Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.treasure_chest);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        //first roll result
        diceSideMap.put(0, Dice.DiceSide.skull);
        diceSideMap.put(1, Dice.DiceSide.skull);
        diceSideMap.put(2, Dice.DiceSide.parrot);
        diceSideMap.put(3, Dice.DiceSide.parrot);
        diceSideMap.put(4, Dice.DiceSide.parrot);
        diceSideMap.put(5, Dice.DiceSide.coin);
        diceSideMap.put(6, Dice.DiceSide.coin);
        diceSideMap.put(7, Dice.DiceSide.coin);

        Map<Integer, Dice.DiceSide> treasureChest = new HashMap<>();
        List<Integer> inList = new ArrayList<>(Arrays.asList(5, 6, 7));
        piratenKapern.changeTreasureChest(diceSideMap, fortuneCard, inList, new ArrayList<>(), treasureChest);
        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(2, 3, 4));
        piratenKapern.reRoll(indexes, diceSideMap);
        // change the random dice to fixed one
        diceSideMap.put(2, Dice.DiceSide.coin);
        diceSideMap.put(3, Dice.DiceSide.diamond);
        diceSideMap.put(4, Dice.DiceSide.diamond);

        inList = new ArrayList<>(Arrays.asList(2));
        piratenKapern.changeTreasureChest(diceSideMap, fortuneCard, inList, new ArrayList<>(), treasureChest);

        //re-roll
        indexes = new ArrayList<>(Arrays.asList(3, 4));
        piratenKapern.reRoll(indexes, diceSideMap);
        // change the random dice to fixed one
        diceSideMap.put(3, Dice.DiceSide.skull);
        diceSideMap.put(4, Dice.DiceSide.coin);

        int score = piratenKapern.computeScore(diceSideMap, fortuneCard, false, treasureChest);
        assertEquals(600, score);
        assertEquals(Constant.DIE_WITH_SKULL + "\n", outContent.toString());

    }

    @Test
    public void fullChest101Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        //first roll result
        diceSideMap.put(0, Dice.DiceSide.monkey);
        diceSideMap.put(1, Dice.DiceSide.monkey);
        diceSideMap.put(2, Dice.DiceSide.monkey);
        diceSideMap.put(3, Dice.DiceSide.sword);
        diceSideMap.put(4, Dice.DiceSide.sword);
        diceSideMap.put(5, Dice.DiceSide.sword);
        diceSideMap.put(6, Dice.DiceSide.diamond);
        diceSideMap.put(7, Dice.DiceSide.parrot);

        int score = piratenKapern.computeScore(diceSideMap, fortuneCard, false, null);
        assertEquals(400, score);
    }

    @Test
    public void fullChest102Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.captain);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        //first roll result
        diceSideMap.put(0, Dice.DiceSide.monkey);
        diceSideMap.put(1, Dice.DiceSide.monkey);
        diceSideMap.put(2, Dice.DiceSide.monkey);
        diceSideMap.put(3, Dice.DiceSide.sword);
        diceSideMap.put(4, Dice.DiceSide.sword);
        diceSideMap.put(5, Dice.DiceSide.sword);
        diceSideMap.put(6, Dice.DiceSide.coin);
        diceSideMap.put(7, Dice.DiceSide.coin);

        int score = piratenKapern.computeScore(diceSideMap, fortuneCard, false, null);
        assertEquals(1800, score);
    }

    @Test
    public void fullChest103Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        //first roll result
        diceSideMap.put(0, Dice.DiceSide.monkey);
        diceSideMap.put(1, Dice.DiceSide.monkey);
        diceSideMap.put(2, Dice.DiceSide.monkey);
        diceSideMap.put(3, Dice.DiceSide.sword);
        diceSideMap.put(4, Dice.DiceSide.sword);
        diceSideMap.put(5, Dice.DiceSide.sword);
        diceSideMap.put(6, Dice.DiceSide.sword);
        diceSideMap.put(7, Dice.DiceSide.diamond);

        int score = piratenKapern.computeScore(diceSideMap, fortuneCard, false, null);
        assertEquals(1000, score);
    }

    @Test
    public void fullChest104Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.two_sabre);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        //first roll result
        diceSideMap.put(0, Dice.DiceSide.monkey);
        diceSideMap.put(1, Dice.DiceSide.monkey);
        diceSideMap.put(2, Dice.DiceSide.monkey);
        diceSideMap.put(3, Dice.DiceSide.monkey);
        diceSideMap.put(4, Dice.DiceSide.sword);
        diceSideMap.put(5, Dice.DiceSide.parrot);
        diceSideMap.put(6, Dice.DiceSide.parrot);
        diceSideMap.put(7, Dice.DiceSide.coin);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(5, 6));
        piratenKapern.reRoll(indexes, diceSideMap);
        // change the random dice to fixed one
        diceSideMap.put(5, Dice.DiceSide.coin);
        diceSideMap.put(6, Dice.DiceSide.sword);

        int score = piratenKapern.computeScore(diceSideMap, fortuneCard, false, null);
        assertEquals(1200, score);
    }

    @Test
    public void fullChest107Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.monkey_business);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        //first roll result
        diceSideMap.put(0, Dice.DiceSide.monkey);
        diceSideMap.put(1, Dice.DiceSide.monkey);
        diceSideMap.put(2, Dice.DiceSide.parrot);
        diceSideMap.put(3, Dice.DiceSide.coin);
        diceSideMap.put(4, Dice.DiceSide.coin);
        diceSideMap.put(5, Dice.DiceSide.diamond);
        diceSideMap.put(6, Dice.DiceSide.diamond);
        diceSideMap.put(7, Dice.DiceSide.diamond);

        int score = piratenKapern.computeScore(diceSideMap, fortuneCard, false, null);
        assertEquals(1200, score);
    }
}
