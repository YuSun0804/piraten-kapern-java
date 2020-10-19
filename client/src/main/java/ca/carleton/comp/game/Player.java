package ca.carleton.comp.game;

import ca.carleton.comp.network.ClientChannel;
import ca.carleton.comp.network.WinnerResponse;

import java.io.IOException;
import java.util.*;

public class Player {
    protected PiratenKapern piratenKapern;
    protected Scanner scanner;

    protected boolean onIsland;
    protected int preSkullCount;

    protected FortuneCard fortuneCard;
    protected boolean fortuneCardUsed;

    protected int score;
    protected int deduction;

    protected Map<Integer, Dice.DiceSide> treasureChest;

    protected String name;
    protected ClientChannel clientChannel;

    public int getTurnNums() {
        return turnNums;
    }

    public void setTurnNums(int turnNums) {
        this.turnNums = turnNums;
    }

    protected int turnNums = 1;

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

    protected Map<Integer, Dice.DiceSide> rollResult;

    public Player(PiratenKapern piratenKapern, ClientChannel clientChannel) {
        this.piratenKapern = piratenKapern;
        this.scanner = new Scanner(System.in);
        this.treasureChest = new HashMap<>();
        this.clientChannel = clientChannel;
    }

    public String sendPlayerName(String name) throws IOException {
        clientChannel.write(name);
        return clientChannel.read();
    }

    public WinnerResponse sendPlayerResult() {
        try {
            clientChannel.write(score + "," + deduction);
            String result = clientChannel.read();
            String[] split = result.split(",");

            if (split.length == 1) {
                return new WinnerResponse(null, 0, Integer.parseInt(split[0]));
            } else {
                return new WinnerResponse(split[1], Integer.parseInt(split[2]), Integer.parseInt(split[0]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void initPlayer() {
        System.out.print("What is your name ? ");
        Scanner scanner = new Scanner(System.in);
        initPlayer(scanner.next());
    }

    public void initPlayer(String name) {
        this.name = name;
        try {
            String response = sendPlayerName(name);
            System.out.println(response);

        } catch (IOException e) {
            e.printStackTrace();
        }
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

        piratenKapern.checkOnIsland(this);
        if (!doAfterRoll()) {
            afterCompute();
            return;
        }

        while (true) {
            System.out.println("Select an action: ");
            System.out.println("(1) Choose dice number to roll again");
            System.out.println("(2) Score this turn");
            int act = scanner.nextInt();
            if (act == 2) break;

            System.out.println("Select the dice to re-roll, split with , ");
            String next = scanner.next();
            String[] indexes = next.split(",");
            if (reRoll(indexes)) {
                System.out.println("The re-roll result is  " + rollResult);
            }

            if (!doAfterRoll()) {
                return;
            }
        }
        piratenKapern.computeScore(this);
        afterCompute();
    }

    protected void afterCompute() {
        System.out.println("The score you get in turn " + turnNums + " is " + score);
        if (deduction < 0) {
            System.out.println("Skull of island causes deduction: " + deduction);
        }

        WinnerResponse winnerResponse = sendPlayerResult();

        if (winnerResponse.getWinnerName() == null) {
            System.out.println("The score you get in all turns is " + winnerResponse.getPlayerScore());
            System.out.println("No one reached 6000, start turn " + ++turnNums);
            this.playAgain();
        } else {
            System.out.println("The score you get in all turns is " + winnerResponse.getPlayerScore());
            System.out.println("The winner is " + winnerResponse.getWinnerName() + " with score " + winnerResponse.getWinnerScore() + " in all turns");
            System.out.println("The game is over, press e to exit");
            scanner.next();
        }
    }

    public void playAgain() {
        this.onIsland = false;
        this.preSkullCount = 0;
        this.fortuneCardUsed = false;
        this.score = 0;
        this.deduction = 0;
        this.treasureChest.clear();
        play();
    }

    protected boolean doAfterRoll() {
        if (!piratenKapern.canContinue(this)) {
            if (piratenKapern.canSaveSkull(this)) {
                System.out.println("One of the skull dice will re-roll, since you have a sorceress card");
                piratenKapern.saveOneSkull(this);
                System.out.println("The result after sorceress card used is  " + rollResult);
            } else {
                piratenKapern.computeScore(this);
                return false;
            }
        }

        if (fortuneCard.getType() == FortuneCard.FortuneCardType.treasure_chest) {
            changeTreasureChest();
        }
        return true;
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

    protected boolean reRoll(String[] indexes) {
        List<Integer> indexList = new ArrayList<>();
        for (String index : indexes) {
            indexList.add(Integer.parseInt(index));
        }
        return piratenKapern.reRoll(this, indexList);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
