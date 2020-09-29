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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class Part1Test {

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
    public void score48Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        //first roll result
        diceSideMap.put(0, Dice.DiceSide.skull);
        diceSideMap.put(1, Dice.DiceSide.skull);
        diceSideMap.put(2, Dice.DiceSide.skull);
        diceSideMap.put(3, Dice.DiceSide.monkey);
        diceSideMap.put(4, Dice.DiceSide.monkey);
        diceSideMap.put(5, Dice.DiceSide.monkey);
        diceSideMap.put(6, Dice.DiceSide.monkey);
        diceSideMap.put(7, Dice.DiceSide.monkey);
        int score = piratenKapern.computeScore(diceSideMap, fortuneCard, false, null);
        assertEquals(0, score);
        assertEquals(Constant.DIE_WITH_SKULL + "\n", outContent.toString());
    }

    @Test
    public void score49Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        // change the random dice to fixed one
        diceSideMap.put(0, Dice.DiceSide.skull);
        diceSideMap.put(1, Dice.DiceSide.parrot);
        diceSideMap.put(2, Dice.DiceSide.parrot);
        diceSideMap.put(3, Dice.DiceSide.parrot);
        diceSideMap.put(4, Dice.DiceSide.parrot);
        diceSideMap.put(5, Dice.DiceSide.sword);
        diceSideMap.put(6, Dice.DiceSide.sword);
        diceSideMap.put(7, Dice.DiceSide.sword);
        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(5, 6, 7));
        piratenKapern.reRoll(indexes, diceSideMap);
        // change the random dice to fixed one
        diceSideMap.put(5, Dice.DiceSide.skull);
        diceSideMap.put(6, Dice.DiceSide.skull);
        diceSideMap.put(7, Dice.DiceSide.sword);
        int score = piratenKapern.computeScore(diceSideMap, fortuneCard, false, null);
        assertEquals(0, score);
        assertEquals(Constant.DIE_WITH_SKULL + "\n", outContent.toString());
    }

    @Test
    public void score50Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        // change the random dice to fixed one
        diceSideMap.put(0, Dice.DiceSide.skull);
        diceSideMap.put(1, Dice.DiceSide.skull);
        diceSideMap.put(2, Dice.DiceSide.parrot);
        diceSideMap.put(3, Dice.DiceSide.parrot);
        diceSideMap.put(4, Dice.DiceSide.parrot);
        diceSideMap.put(5, Dice.DiceSide.parrot);
        diceSideMap.put(6, Dice.DiceSide.sword);
        diceSideMap.put(7, Dice.DiceSide.sword);
        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(6, 7));
        piratenKapern.reRoll(indexes, diceSideMap);
        // change the random dice to fixed one
        diceSideMap.put(6, Dice.DiceSide.skull);
        diceSideMap.put(7, Dice.DiceSide.sword);

        int score = piratenKapern.computeScore(diceSideMap, fortuneCard, false, null);
        assertEquals(0, score);
        assertEquals(Constant.DIE_WITH_SKULL + "\n", outContent.toString());
    }

    @Test
    public void score51Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        // change the random dice to fixed one
        diceSideMap.put(0, Dice.DiceSide.skull);
        diceSideMap.put(1, Dice.DiceSide.parrot);
        diceSideMap.put(2, Dice.DiceSide.parrot);
        diceSideMap.put(3, Dice.DiceSide.parrot);
        diceSideMap.put(4, Dice.DiceSide.parrot);
        diceSideMap.put(5, Dice.DiceSide.sword);
        diceSideMap.put(6, Dice.DiceSide.sword);
        diceSideMap.put(7, Dice.DiceSide.sword);
        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(5, 6, 7));
        piratenKapern.reRoll(indexes, diceSideMap);
        // change the random dice to fixed one
        diceSideMap.put(5, Dice.DiceSide.skull);
        diceSideMap.put(6, Dice.DiceSide.monkey);
        diceSideMap.put(7, Dice.DiceSide.monkey);

        //re-roll
        indexes = new ArrayList<>(Arrays.asList(6, 7));
        piratenKapern.reRoll(indexes, diceSideMap);
        // change the random dice to fixed one
        diceSideMap.put(6, Dice.DiceSide.skull);
        diceSideMap.put(7, Dice.DiceSide.monkey);

        int score = piratenKapern.computeScore(diceSideMap, fortuneCard, false, null);
        assertEquals(0, score);
        assertEquals(Constant.DIE_WITH_SKULL + "\n", outContent.toString());
    }

    @Test
    public void score53Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.captain);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        // change the random dice to fixed one
        diceSideMap.put(0, Dice.DiceSide.skull);
        diceSideMap.put(1, Dice.DiceSide.parrot);
        diceSideMap.put(2, Dice.DiceSide.monkey);
        diceSideMap.put(3, Dice.DiceSide.sword);
        diceSideMap.put(4, Dice.DiceSide.diamond);
        diceSideMap.put(5, Dice.DiceSide.diamond);
        diceSideMap.put(6, Dice.DiceSide.coin);
        diceSideMap.put(7, Dice.DiceSide.coin);

        int score = piratenKapern.computeScore(diceSideMap, fortuneCard, false, null);
        assertEquals(800, score);
    }

    @Test
    public void score54Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        // change the random dice to fixed one
        diceSideMap.put(0, Dice.DiceSide.skull);
        diceSideMap.put(1, Dice.DiceSide.skull);
        diceSideMap.put(2, Dice.DiceSide.monkey);
        diceSideMap.put(3, Dice.DiceSide.monkey);
        diceSideMap.put(4, Dice.DiceSide.parrot);
        diceSideMap.put(5, Dice.DiceSide.parrot);
        diceSideMap.put(6, Dice.DiceSide.sword);
        diceSideMap.put(7, Dice.DiceSide.sword);
        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(6, 7));
        piratenKapern.reRoll(indexes, diceSideMap);
        // change the random dice to fixed one
        diceSideMap.put(6, Dice.DiceSide.sword);
        diceSideMap.put(7, Dice.DiceSide.monkey);

        int score = piratenKapern.computeScore(diceSideMap, fortuneCard, false, null);
        assertEquals(200, score);
    }

    @Test
    public void score55Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        // change the random dice to fixed one
        diceSideMap.put(0, Dice.DiceSide.skull);
        diceSideMap.put(1, Dice.DiceSide.monkey);
        diceSideMap.put(2, Dice.DiceSide.monkey);
        diceSideMap.put(3, Dice.DiceSide.monkey);
        diceSideMap.put(4, Dice.DiceSide.parrot);
        diceSideMap.put(5, Dice.DiceSide.sword);
        diceSideMap.put(6, Dice.DiceSide.sword);
        diceSideMap.put(7, Dice.DiceSide.sword);

        int score = piratenKapern.computeScore(diceSideMap, fortuneCard, false, null);
        assertEquals(300, score);
    }

    @Test
    public void score56Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        // change the random dice to fixed one
        diceSideMap.put(0, Dice.DiceSide.skull);
        diceSideMap.put(1, Dice.DiceSide.monkey);
        diceSideMap.put(2, Dice.DiceSide.monkey);
        diceSideMap.put(3, Dice.DiceSide.monkey);
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
        assertEquals(300, score);
    }

    @Test
    public void score57Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        // change the random dice to fixed one
        diceSideMap.put(0, Dice.DiceSide.skull);
        diceSideMap.put(1, Dice.DiceSide.diamond);
        diceSideMap.put(2, Dice.DiceSide.diamond);
        diceSideMap.put(3, Dice.DiceSide.diamond);
        diceSideMap.put(4, Dice.DiceSide.parrot);
        diceSideMap.put(5, Dice.DiceSide.parrot);
        diceSideMap.put(6, Dice.DiceSide.sword);
        diceSideMap.put(7, Dice.DiceSide.sword);

        int score = piratenKapern.computeScore(diceSideMap, fortuneCard, false, null);
        assertEquals(500, score);
    }

    @Test
    public void score58Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.diamonds);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        // change the random dice to fixed one
        diceSideMap.put(0, Dice.DiceSide.skull);
        diceSideMap.put(1, Dice.DiceSide.coin);
        diceSideMap.put(2, Dice.DiceSide.coin);
        diceSideMap.put(3, Dice.DiceSide.coin);
        diceSideMap.put(4, Dice.DiceSide.coin);
        diceSideMap.put(5, Dice.DiceSide.parrot);
        diceSideMap.put(6, Dice.DiceSide.sword);
        diceSideMap.put(7, Dice.DiceSide.sword);

        int score = piratenKapern.computeScore(diceSideMap, fortuneCard, false, null);
        assertEquals(700, score);
    }

    @Test
    public void score59Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        // change the random dice to fixed one
        diceSideMap.put(0, Dice.DiceSide.skull);
        diceSideMap.put(1, Dice.DiceSide.parrot);
        diceSideMap.put(2, Dice.DiceSide.parrot);
        diceSideMap.put(3, Dice.DiceSide.parrot);
        diceSideMap.put(4, Dice.DiceSide.parrot);
        diceSideMap.put(5, Dice.DiceSide.sword);
        diceSideMap.put(6, Dice.DiceSide.sword);
        diceSideMap.put(7, Dice.DiceSide.sword);

        int score = piratenKapern.computeScore(diceSideMap, fortuneCard, false, null);
        assertEquals(400, score);
    }

    @Test
    public void score60Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        // change the random dice to fixed one
        diceSideMap.put(0, Dice.DiceSide.skull);
        diceSideMap.put(1, Dice.DiceSide.coin);
        diceSideMap.put(2, Dice.DiceSide.coin);
        diceSideMap.put(3, Dice.DiceSide.coin);
        diceSideMap.put(4, Dice.DiceSide.sword);
        diceSideMap.put(5, Dice.DiceSide.sword);
        diceSideMap.put(6, Dice.DiceSide.parrot);
        diceSideMap.put(7, Dice.DiceSide.parrot);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(6, 7));
        piratenKapern.reRoll(indexes, diceSideMap);
        // change the random dice to fixed one
        diceSideMap.put(6, Dice.DiceSide.sword);
        diceSideMap.put(7, Dice.DiceSide.sword);

        int score = piratenKapern.computeScore(diceSideMap, fortuneCard, false, null);
        assertEquals(800, score);
    }

    @Test
    public void score61Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.captain);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        // change the random dice to fixed one
        diceSideMap.put(0, Dice.DiceSide.skull);
        diceSideMap.put(1, Dice.DiceSide.coin);
        diceSideMap.put(2, Dice.DiceSide.coin);
        diceSideMap.put(3, Dice.DiceSide.coin);
        diceSideMap.put(4, Dice.DiceSide.sword);
        diceSideMap.put(5, Dice.DiceSide.sword);
        diceSideMap.put(6, Dice.DiceSide.parrot);
        diceSideMap.put(7, Dice.DiceSide.parrot);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(6, 7));
        piratenKapern.reRoll(indexes, diceSideMap);
        // change the random dice to fixed one
        diceSideMap.put(6, Dice.DiceSide.sword);
        diceSideMap.put(7, Dice.DiceSide.sword);

        int score = piratenKapern.computeScore(diceSideMap, fortuneCard, false, null);
        assertEquals(1200, score);
    }

    @Test
    public void score62Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        // change the random dice to fixed one
        diceSideMap.put(0, Dice.DiceSide.skull);
        diceSideMap.put(1, Dice.DiceSide.skull);
        diceSideMap.put(2, Dice.DiceSide.monkey);
        diceSideMap.put(3, Dice.DiceSide.monkey);
        diceSideMap.put(4, Dice.DiceSide.sword);
        diceSideMap.put(5, Dice.DiceSide.sword);
        diceSideMap.put(6, Dice.DiceSide.parrot);
        diceSideMap.put(7, Dice.DiceSide.parrot);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(6, 7));
        piratenKapern.reRoll(indexes, diceSideMap);
        // change the random dice to fixed one
        diceSideMap.put(6, Dice.DiceSide.sword);
        diceSideMap.put(7, Dice.DiceSide.sword);

        //re-roll
        indexes = new ArrayList<>(Arrays.asList(2, 3));
        piratenKapern.reRoll(indexes, diceSideMap);
        // change the random dice to fixed one
        diceSideMap.put(2, Dice.DiceSide.sword);
        diceSideMap.put(3, Dice.DiceSide.parrot);

        int score = piratenKapern.computeScore(diceSideMap, fortuneCard, false, null);
        assertEquals(600, score);
    }

    @Test
    public void score63Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        // change the random dice to fixed one
        diceSideMap.put(0, Dice.DiceSide.skull);
        diceSideMap.put(1, Dice.DiceSide.skull);
        diceSideMap.put(2, Dice.DiceSide.monkey);
        diceSideMap.put(3, Dice.DiceSide.monkey);
        diceSideMap.put(4, Dice.DiceSide.monkey);
        diceSideMap.put(5, Dice.DiceSide.monkey);
        diceSideMap.put(6, Dice.DiceSide.monkey);
        diceSideMap.put(7, Dice.DiceSide.monkey);

        int score = piratenKapern.computeScore(diceSideMap, fortuneCard, false, null);
        assertEquals(1100, score);
    }

    @Test
    public void score64Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        // change the random dice to fixed one
        diceSideMap.put(0, Dice.DiceSide.skull);
        diceSideMap.put(1, Dice.DiceSide.parrot);
        diceSideMap.put(2, Dice.DiceSide.parrot);
        diceSideMap.put(3, Dice.DiceSide.parrot);
        diceSideMap.put(4, Dice.DiceSide.parrot);
        diceSideMap.put(5, Dice.DiceSide.parrot);
        diceSideMap.put(6, Dice.DiceSide.parrot);
        diceSideMap.put(7, Dice.DiceSide.parrot);

        int score = piratenKapern.computeScore(diceSideMap, fortuneCard, false, null);
        assertEquals(2100, score);
    }

    @Test
    public void score65Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        // change the random dice to fixed one
        diceSideMap.put(0, Dice.DiceSide.coin);
        diceSideMap.put(1, Dice.DiceSide.coin);
        diceSideMap.put(2, Dice.DiceSide.coin);
        diceSideMap.put(3, Dice.DiceSide.coin);
        diceSideMap.put(4, Dice.DiceSide.coin);
        diceSideMap.put(5, Dice.DiceSide.coin);
        diceSideMap.put(6, Dice.DiceSide.coin);
        diceSideMap.put(7, Dice.DiceSide.coin);

        int score = piratenKapern.computeScore(diceSideMap, fortuneCard, false, null);
        assertEquals(5400, score);
    }

    @Test
    public void score66Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.diamonds);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        // change the random dice to fixed one
        diceSideMap.put(0, Dice.DiceSide.coin);
        diceSideMap.put(1, Dice.DiceSide.coin);
        diceSideMap.put(2, Dice.DiceSide.coin);
        diceSideMap.put(3, Dice.DiceSide.coin);
        diceSideMap.put(4, Dice.DiceSide.coin);
        diceSideMap.put(5, Dice.DiceSide.coin);
        diceSideMap.put(6, Dice.DiceSide.coin);
        diceSideMap.put(7, Dice.DiceSide.coin);

        int score = piratenKapern.computeScore(diceSideMap, fortuneCard, false, null);
        assertEquals(5400, score);
    }

    @Test
    public void score67Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.captain);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        // change the random dice to fixed one
        diceSideMap.put(0, Dice.DiceSide.sword);
        diceSideMap.put(1, Dice.DiceSide.sword);
        diceSideMap.put(2, Dice.DiceSide.sword);
        diceSideMap.put(3, Dice.DiceSide.sword);
        diceSideMap.put(4, Dice.DiceSide.sword);
        diceSideMap.put(5, Dice.DiceSide.sword);
        diceSideMap.put(6, Dice.DiceSide.sword);
        diceSideMap.put(7, Dice.DiceSide.sword);

        int score = piratenKapern.computeScore(diceSideMap, fortuneCard, false, null);
        assertEquals(9000, score);
    }

    @Test
    public void score68Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        // change the random dice to fixed one
        diceSideMap.put(0, Dice.DiceSide.monkey);
        diceSideMap.put(1, Dice.DiceSide.monkey);
        diceSideMap.put(2, Dice.DiceSide.monkey);
        diceSideMap.put(3, Dice.DiceSide.monkey);
        diceSideMap.put(4, Dice.DiceSide.monkey);
        diceSideMap.put(5, Dice.DiceSide.monkey);
        diceSideMap.put(6, Dice.DiceSide.sword);
        diceSideMap.put(7, Dice.DiceSide.sword);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(6, 7));
        piratenKapern.reRoll(indexes, diceSideMap);
        // change the random dice to fixed one
        diceSideMap.put(6, Dice.DiceSide.monkey);
        diceSideMap.put(7, Dice.DiceSide.monkey);

        int score = piratenKapern.computeScore(diceSideMap, fortuneCard, false, null);
        assertEquals(4600, score);
    }

    @Test
    public void score69Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.diamonds);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        // change the random dice to fixed one
        diceSideMap.put(0, Dice.DiceSide.skull);
        diceSideMap.put(1, Dice.DiceSide.skull);
        diceSideMap.put(2, Dice.DiceSide.monkey);
        diceSideMap.put(3, Dice.DiceSide.monkey);
        diceSideMap.put(4, Dice.DiceSide.parrot);
        diceSideMap.put(5, Dice.DiceSide.parrot);
        diceSideMap.put(6, Dice.DiceSide.sword);
        diceSideMap.put(7, Dice.DiceSide.sword);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(6, 7));
        piratenKapern.reRoll(indexes, diceSideMap);
        // change the random dice to fixed one
        diceSideMap.put(6, Dice.DiceSide.diamond);
        diceSideMap.put(7, Dice.DiceSide.diamond);

        int score = piratenKapern.computeScore(diceSideMap, fortuneCard, false, null);
        assertEquals(400, score);
    }

    @Test
    public void score70Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        // change the random dice to fixed one
        diceSideMap.put(0, Dice.DiceSide.skull);
        diceSideMap.put(1, Dice.DiceSide.skull);
        diceSideMap.put(2, Dice.DiceSide.monkey);
        diceSideMap.put(3, Dice.DiceSide.monkey);
        diceSideMap.put(4, Dice.DiceSide.parrot);
        diceSideMap.put(5, Dice.DiceSide.diamond);
        diceSideMap.put(6, Dice.DiceSide.sword);
        diceSideMap.put(7, Dice.DiceSide.sword);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(6, 7));
        piratenKapern.reRoll(indexes, diceSideMap);
        // change the random dice to fixed one
        diceSideMap.put(6, Dice.DiceSide.diamond);
        diceSideMap.put(7, Dice.DiceSide.diamond);

        int score = piratenKapern.computeScore(diceSideMap, fortuneCard, false, null);
        assertEquals(500, score);
    }

    @Test
    public void score71Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        // change the random dice to fixed one
        diceSideMap.put(0, Dice.DiceSide.skull);
        diceSideMap.put(1, Dice.DiceSide.skull);
        diceSideMap.put(2, Dice.DiceSide.monkey);
        diceSideMap.put(3, Dice.DiceSide.monkey);
        diceSideMap.put(4, Dice.DiceSide.parrot);
        diceSideMap.put(5, Dice.DiceSide.coin);
        diceSideMap.put(6, Dice.DiceSide.sword);
        diceSideMap.put(7, Dice.DiceSide.sword);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(6, 7));
        piratenKapern.reRoll(indexes, diceSideMap);
        // change the random dice to fixed one
        diceSideMap.put(6, Dice.DiceSide.coin);
        diceSideMap.put(7, Dice.DiceSide.coin);

        int score = piratenKapern.computeScore(diceSideMap, fortuneCard, false, null);
        assertEquals(600, score);
    }

    @Test
    public void score72Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.diamonds);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        // change the random dice to fixed one
        diceSideMap.put(0, Dice.DiceSide.skull);
        diceSideMap.put(1, Dice.DiceSide.skull);
        diceSideMap.put(2, Dice.DiceSide.monkey);
        diceSideMap.put(3, Dice.DiceSide.monkey);
        diceSideMap.put(4, Dice.DiceSide.parrot);
        diceSideMap.put(5, Dice.DiceSide.coin);
        diceSideMap.put(6, Dice.DiceSide.sword);
        diceSideMap.put(7, Dice.DiceSide.sword);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(6, 7));
        piratenKapern.reRoll(indexes, diceSideMap);
        // change the random dice to fixed one
        diceSideMap.put(6, Dice.DiceSide.coin);
        diceSideMap.put(7, Dice.DiceSide.coin);

        int score = piratenKapern.computeScore(diceSideMap, fortuneCard, false, null);
        assertEquals(500, score);
    }

    @Test
    public void score73Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        // change the random dice to fixed one
        diceSideMap.put(0, Dice.DiceSide.skull);
        diceSideMap.put(1, Dice.DiceSide.monkey);
        diceSideMap.put(2, Dice.DiceSide.monkey);
        diceSideMap.put(3, Dice.DiceSide.monkey);
        diceSideMap.put(4, Dice.DiceSide.monkey);
        diceSideMap.put(5, Dice.DiceSide.parrot);
        diceSideMap.put(6, Dice.DiceSide.sword);
        diceSideMap.put(7, Dice.DiceSide.sword);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(6, 7));
        piratenKapern.reRoll(indexes, diceSideMap);
        // change the random dice to fixed one
        diceSideMap.put(6, Dice.DiceSide.coin);
        diceSideMap.put(7, Dice.DiceSide.coin);

        int score = piratenKapern.computeScore(diceSideMap, fortuneCard, false, null);
        assertEquals(600, score);
    }

    @Test
    public void score75Test() {
        // draw fortune card
        FortuneCard fortuneCard = piratenKapern.drawFortuneCard();
        // change the random card to fixed one
        fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        // first roll
        Map<Integer, Dice.DiceSide> diceSideMap = piratenKapern.roll();
        // change the random dice to fixed one
        diceSideMap.put(0, Dice.DiceSide.sword);
        diceSideMap.put(1, Dice.DiceSide.sword);
        diceSideMap.put(2, Dice.DiceSide.sword);
        diceSideMap.put(3, Dice.DiceSide.sword);
        diceSideMap.put(4, Dice.DiceSide.sword);
        diceSideMap.put(5, Dice.DiceSide.sword);
        diceSideMap.put(6, Dice.DiceSide.sword);
        diceSideMap.put(7, Dice.DiceSide.monkey);

        //re-roll
        List<Integer> indexes = new ArrayList<>(Arrays.asList(7));
        boolean reRoll = piratenKapern.reRoll(indexes, diceSideMap);
        assertEquals(false, reRoll);
        assertEquals(Constant.RE_ROLL_COUNT_CONSTRAINT + "\n", outContent.toString());

    }
}
