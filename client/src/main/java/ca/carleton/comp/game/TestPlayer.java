package ca.carleton.comp.game;

import ca.carleton.comp.network.ClientChannel;

import java.io.IOException;

public class TestPlayer extends Player {

    public TestPlayer(PiratenKapern piratenKapern, ClientChannel clientChannel) {
        super(piratenKapern, clientChannel);
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
        if (name.equals("40player3") || (turnNums == 2 && name.equals("43player2"))) {
            fortuneCard.setType(FortuneCard.FortuneCardType.captain);
        } else {
            fortuneCard.setType(FortuneCard.FortuneCardType.gold_coin);
        }
        System.out.println("The fortune card you draw is \"" + fortuneCard.getType().getType() + "\"");

        System.out.println("Press r to start roll");
        scanner.next();
        rollResult = piratenKapern.roll();

        if (name.equals("40player1") && turnNums == 1) {
            rollResult.put(0, Dice.DiceSide.skull);
            rollResult.put(1, Dice.DiceSide.skull);
            rollResult.put(2, Dice.DiceSide.skull);
            rollResult.put(3, Dice.DiceSide.monkey);
            rollResult.put(4, Dice.DiceSide.monkey);
            rollResult.put(5, Dice.DiceSide.monkey);
            rollResult.put(6, Dice.DiceSide.monkey);
            rollResult.put(7, Dice.DiceSide.monkey);
        } else if (name.equals("40player2") && turnNums == 1) {
            rollResult.put(0, Dice.DiceSide.parrot);
            rollResult.put(1, Dice.DiceSide.parrot);
            rollResult.put(2, Dice.DiceSide.skull);
            rollResult.put(3, Dice.DiceSide.skull);
            rollResult.put(4, Dice.DiceSide.parrot);
            rollResult.put(5, Dice.DiceSide.sword);
            rollResult.put(6, Dice.DiceSide.monkey);
            rollResult.put(7, Dice.DiceSide.monkey);
        } else if (name.equals("40player3") && turnNums == 1) {
            rollResult.put(0, Dice.DiceSide.sword);
            rollResult.put(1, Dice.DiceSide.sword);
            rollResult.put(2, Dice.DiceSide.sword);
            rollResult.put(3, Dice.DiceSide.sword);
            rollResult.put(4, Dice.DiceSide.sword);
            rollResult.put(5, Dice.DiceSide.sword);
            rollResult.put(6, Dice.DiceSide.sword);
            rollResult.put(7, Dice.DiceSide.sword);
        } else if (name.equals("43player1") && turnNums == 1) {
            rollResult.put(0, Dice.DiceSide.parrot);
            rollResult.put(1, Dice.DiceSide.parrot);
            rollResult.put(2, Dice.DiceSide.parrot);
            rollResult.put(3, Dice.DiceSide.skull);
            rollResult.put(4, Dice.DiceSide.parrot);
            rollResult.put(5, Dice.DiceSide.sword);
            rollResult.put(6, Dice.DiceSide.monkey);
            rollResult.put(7, Dice.DiceSide.monkey);
        } else if (name.equals("43player2") && turnNums == 1) {
            rollResult.put(0, Dice.DiceSide.parrot);
            rollResult.put(1, Dice.DiceSide.parrot);
            rollResult.put(2, Dice.DiceSide.parrot);
            rollResult.put(3, Dice.DiceSide.parrot);
            rollResult.put(4, Dice.DiceSide.parrot);
            rollResult.put(5, Dice.DiceSide.parrot);
            rollResult.put(6, Dice.DiceSide.monkey);
            rollResult.put(7, Dice.DiceSide.monkey);
        } else if (name.equals("43player3") && turnNums == 1) {
            rollResult.put(0, Dice.DiceSide.skull);
            rollResult.put(1, Dice.DiceSide.parrot);
            rollResult.put(2, Dice.DiceSide.skull);
            rollResult.put(3, Dice.DiceSide.monkey);
            rollResult.put(4, Dice.DiceSide.monkey);
            rollResult.put(5, Dice.DiceSide.monkey);
            rollResult.put(6, Dice.DiceSide.monkey);
            rollResult.put(7, Dice.DiceSide.monkey);
        } else if (name.equals("43player1") && turnNums == 2) {
            rollResult.put(0, Dice.DiceSide.parrot);
            rollResult.put(1, Dice.DiceSide.parrot);
            rollResult.put(2, Dice.DiceSide.parrot);
            rollResult.put(3, Dice.DiceSide.skull);
            rollResult.put(4, Dice.DiceSide.skull);
            rollResult.put(5, Dice.DiceSide.sword);
            rollResult.put(6, Dice.DiceSide.monkey);
            rollResult.put(7, Dice.DiceSide.monkey);
        } else if (name.equals("43player2") && turnNums == 2) {
            rollResult.put(0, Dice.DiceSide.diamond);
            rollResult.put(1, Dice.DiceSide.diamond);
            rollResult.put(2, Dice.DiceSide.diamond);
            rollResult.put(3, Dice.DiceSide.diamond);
            rollResult.put(4, Dice.DiceSide.diamond);
            rollResult.put(5, Dice.DiceSide.diamond);
            rollResult.put(6, Dice.DiceSide.diamond);
            rollResult.put(7, Dice.DiceSide.monkey);
        } else if (name.equals("43player3") && turnNums == 2) {
            rollResult.put(0, Dice.DiceSide.parrot);
            rollResult.put(1, Dice.DiceSide.parrot);
            rollResult.put(2, Dice.DiceSide.parrot);
            rollResult.put(3, Dice.DiceSide.parrot);
            rollResult.put(4, Dice.DiceSide.skull);
            rollResult.put(5, Dice.DiceSide.sword);
            rollResult.put(6, Dice.DiceSide.monkey);
            rollResult.put(7, Dice.DiceSide.monkey);
        }
        System.out.println("The roll result is " + rollResult);

        piratenKapern.checkOnIsland(this);
        if (!doAfterRoll()) {
            afterCompute();
            return;
        }

        while (true) {
            System.out.println("Select an action: ");
            System.out.println("(1) Choose dice number to roll again");
            System.out.println("(2) Score this round");
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
}
