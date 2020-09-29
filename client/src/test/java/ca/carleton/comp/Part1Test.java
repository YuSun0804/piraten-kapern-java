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
        int score = piratenKapern.computeScoreOrDeduction(diceSideMap, fortuneCard, false);
        assertEquals(0, score);
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
        int score = piratenKapern.computeScoreOrDeduction(diceSideMap, fortuneCard, false);
        assertEquals(0, score);
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

        int score = piratenKapern.computeScoreOrDeduction(diceSideMap, fortuneCard, false);
        assertEquals(0, score);
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

        int score = piratenKapern.computeScoreOrDeduction(diceSideMap, fortuneCard, false);
        assertEquals(0, score);
    }

}
