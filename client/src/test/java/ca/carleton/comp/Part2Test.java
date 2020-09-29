package ca.carleton.comp;

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


}
