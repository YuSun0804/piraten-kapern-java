package ca.carleton.comp;

import org.junit.Test;

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

}
