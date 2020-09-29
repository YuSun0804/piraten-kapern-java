package ca.carleton.comp.game;

import java.util.*;

public class Player {
    private PiratenKapern piratenKapern;
    private Scanner scanner;

    private boolean onIsland;
    private int preSkullCount;

    private FortuneCard fortuneCard;
    private boolean fortuneCardUsed;

    private int score;
    private int deduction;

    private Map<Integer, Dice.DiceSide> treasureChest;

    public boolean isOnIsland() {
        return onIsland;
    }

    public void setOnIsland(boolean onIsland) {
        this.onIsland = onIsland;
    }

    public int getPreSkullCount() {
        return preSkullCount;
    }

    public void setPreSkullCount(int preSkullCount) {
        this.preSkullCount = preSkullCount;
    }

    public FortuneCard getFortuneCard() {
        return fortuneCard;
    }

    public void setFortuneCard(FortuneCard fortuneCard) {
        this.fortuneCard = fortuneCard;
    }

    public boolean isFortuneCardUsed() {
        return fortuneCardUsed;
    }

    public void setFortuneCardUsed(boolean fortuneCardUsed) {
        this.fortuneCardUsed = fortuneCardUsed;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getDeduction() {
        return deduction;
    }

    public void setDeduction(int deduction) {
        this.deduction = deduction;
    }

    public Map<Integer, Dice.DiceSide> getTreasureChest() {
        return treasureChest;
    }

    public void setTreasureChest(Map<Integer, Dice.DiceSide> treasureChest) {
        this.treasureChest = treasureChest;
    }

    public Map<Integer, Dice.DiceSide> getRollResult() {
        return rollResult;
    }

    public void setRollResult(Map<Integer, Dice.DiceSide> rollResult) {
        this.rollResult = rollResult;
    }

    private Map<Integer, Dice.DiceSide> rollResult;

    public Player(PiratenKapern piratenKapern) {
        this.piratenKapern = piratenKapern;
        this.scanner = new Scanner(System.in);
        this.treasureChest = new HashMap<>();
    }

    public void play() {
        System.out.println("Press f to draw a fortune card");
        scanner.next();
        fortuneCard = piratenKapern.drawFortuneCard();
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        System.out.println("Press r to start roll");
        scanner.next();
        rollResult = piratenKapern.roll();
        System.out.println("The roll result is " + rollResult);

        doAfterRoll();

        while (true) {
            System.out.println("Select an action: ");
            System.out.println("(1) Choose dice number to roll again");
            System.out.println("(2) Score this round");
            int act = scanner.nextInt();
            if (act == 2) break;

            System.out.println("Select the dice to re-roll, split with , ");
            String next = scanner.next();
            String[] indexes = next.split(",");
            reRoll(indexes);
            System.out.println("The re-roll result is  " + rollResult);

            doAfterRoll();
        }

        piratenKapern.computeScore(this);
        System.out.println("Score you get is " + score);
        System.out.println("Deduction you make is " + deduction);
    }

    private void doAfterRoll() {
        piratenKapern.checkOnIsland(this);
        if (!piratenKapern.canContinue(this)) {
            if (piratenKapern.canReRollSkull(this)) {
                System.out.println("One of the skull dice will re-roll, since you have a sorceress card");
                piratenKapern.reRollForSorceress(this);
                System.out.println("The result after sorceress card used is  " + rollResult);
            } else {
                piratenKapern.computeScore(this);
                System.out.println("Score you get is " + score);
                System.out.println("Deduction you make is " + deduction);
            }
        }

        if (fortuneCard.getType() == FortuneCard.FortuneCardType.treasure_chest) {
            changeTreasureChest();
        }
    }

    private void changeTreasureChest() {
        System.out.println("Select the dice to put in the Treasure Chest card, split with ,");
        String next = scanner.next();
        String[] indexes = next.split(",");
        List<Integer> inList = new ArrayList<>();
        for (String index : indexes) {
            inList.add(Integer.parseInt(index));
        }

        System.out.println("Select the dice to take out from the Treasure Chest card, split with ,");
        next = scanner.next();
        indexes = next.split(",");
        List<Integer> outList = new ArrayList<>();
        for (String index : indexes) {
            outList.add(Integer.parseInt(index));
        }
        piratenKapern.changeTreasureChest(this, inList, outList);

    }

    private void reRoll(String[] indexes) {
        List<Integer> indexList = new ArrayList<>();
        for (String index : indexes) {
            indexList.add(Integer.parseInt(index));
        }
        piratenKapern.reRoll(this, indexList);

    }
}
