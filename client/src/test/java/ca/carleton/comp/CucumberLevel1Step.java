
package ca.carleton.comp;

import ca.carleton.comp.game.Dice;
import ca.carleton.comp.game.FortuneCard;
import ca.carleton.comp.game.PiratenKapern;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CucumberLevel1Step {

    private PiratenKapern piratenKapern;
    private FortuneCard fortuneCard;
    private Map<Integer, Dice.DiceSide> rollResult;
    private Map<Integer, Dice.DiceSide> treasureChest;
    private boolean reRoll;
    private String rollResultRegEx = "([0-9]d*)=([a-z1-9]+)";
    private Pattern pattern = Pattern.compile(rollResultRegEx);


    @Given("^Start Game$")
    public void startGame() {
        piratenKapern = new PiratenKapern();
        treasureChest = new HashMap<>();
        System.out.println(" ");
    }

    @When("Draw fortuneCard, and get \"(.*)\"$")
    public void drawFortuneCard(FortuneCard.FortuneCardType cardType) {
        fortuneCard = piratenKapern.drawFortuneCard();
        fortuneCard.setType(cardType);
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");
    }

    @And("Roll dice, and get {string}")
    public void roll(String rollRes) {
        rollResult = piratenKapern.roll();
        Matcher matcher = pattern.matcher(rollRes);
        while (matcher.find()) {
            int index = Integer.parseInt(matcher.group(1));
            Dice.DiceSide diceSide = Dice.DiceSide.getByName(matcher.group(2));
            rollResult.put(index, diceSide);
        }
        System.out.println("The roll result is " + rollResult);
    }

    @And("Re-Roll dice due to sorceress")
    public void reRollForSorceress() {
        System.out.println("Re-roll due to sorceress.");
        reRoll = piratenKapern.reRollForSorceress(rollResult);
        System.out.println("The result after using the sorceress card is " + rollResult);
    }

    @And("Re-Roll dice {string}, and get {string}")
    public void reRoll(String indexes, String rollRes) {
        List<Integer> indexList = transformIndex(indexes);
        System.out.println("Re-roll " + indexList);
        reRoll = piratenKapern.reRoll(indexList, rollResult);
        Matcher matcher = pattern.matcher(rollRes);
        while (matcher.find()) {
            int index = Integer.parseInt(matcher.group(1));
            Dice.DiceSide diceSide = Dice.DiceSide.getByName(matcher.group(2));
            rollResult.put(index, diceSide);
        }
        if (!rollRes.equals("")) {
            System.out.println("The result after re-roll is " + rollResult);
        }
    }

    @And("put {string} in chest, take {string} out")
    public void changeTreasureChest(String in, String out) {
        List<Integer> inList = transformIndex(in);
        List<Integer> outList = transformIndex(out);
        System.out.println("put " + inList + " in chest, take " + outList + " out.");
        piratenKapern.changeTreasureChest(rollResult, fortuneCard, inList, outList, treasureChest);
        System.out.println("The chest result is " + treasureChest);
    }


    @And("put {string} in chest")
    public void changeTreasureChest(String in) {
        List<Integer> inList = transformIndex(in);
        System.out.println("put " + inList + " in chest.");
        piratenKapern.changeTreasureChest(rollResult, fortuneCard, inList, new ArrayList<>(), treasureChest);
        System.out.println("The chest result is " + treasureChest);
    }

    private List<Integer> transformIndex(String indexes) {
        String[] split = indexes.split(",");
        List<Integer> result = new ArrayList<>();
        for (String s : split) {
            result.add(Integer.parseInt(s));
        }

        return result;
    }

    @Then("Player get {int}")
    public void computeScore(int expectedScore) {
        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, treasureChest);
        System.out.println("The score is " + score);
        assertEquals(expectedScore, score);
    }

    @Then("Player score more than {int}")
    public void computeScore2(int expectedScore) {
        int score = piratenKapern.computeScore(rollResult, fortuneCard, false, treasureChest);
        System.out.println("The score is " + score);
        assertTrue(score > expectedScore);
    }

    @Then("Player re-roll {}")
    public void reRollSuccess(boolean expectedSuccess) {
        if (reRoll) {
            System.out.println("The player re-roll success");
        } else {
            System.out.println("The player re-roll fail");
        }
        assertEquals(expectedSuccess, this.reRoll);
    }

    @Then("Player get {int} skull\\(s)")
    public void countSkull(int expectedCount) {
        int countSkull = piratenKapern.countSkull(rollResult, fortuneCard);
        System.out.println("The player get " + countSkull + " skull(s)");
        assertEquals(expectedCount, countSkull);
    }

    @Then("Player make {int} deduction to all other players")
    public void computeDeduction(int expectedDeduction) {
        int deductionOnIsland = piratenKapern.computeDeductionOnIsland(rollResult, fortuneCard);
        System.out.println("The deduction is " + deductionOnIsland);
        assertEquals(expectedDeduction, deductionOnIsland);
    }

    @Then("Player lose {int}")
    public void computeDeduction2(int expectedDeduction) {
        boolean isAlive = piratenKapern.canContinue(rollResult, fortuneCard);
        int deductionOnIsland = piratenKapern.computeSeaBattle(rollResult, fortuneCard, isAlive);
        System.out.println("The deduction is " + deductionOnIsland);
        assertEquals(expectedDeduction, deductionOnIsland);
    }

    @And("Player can go to next round {}")
    public void countSkull(boolean expectedCan) {
        List<Integer> indexes = new ArrayList<>(Arrays.asList(5, 6, 7));
        System.out.println("Re-roll 5, 6, 7.");
        boolean reRoll = piratenKapern.reRoll(indexes, rollResult);
        if (reRoll) {
            System.out.println("Re-roll success(player can go to next round). ");
            System.out.println("The result after re-roll is " + rollResult);
        } else {
            System.out.println("Player cannot go to next round");
        }
        assertEquals(expectedCan, reRoll);
    }
}


