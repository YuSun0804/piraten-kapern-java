package ca.carleton.comp.game;

import ca.carleton.comp.util.RandomUtil;

import java.util.*;

public class PiratenKapern {

    private List<Dice> diceList;
    private List<FortuneCard> fortuneCardList;


    public PiratenKapern() {
        diceList = new ArrayList<>(8);
        fortuneCardList = FortuneCard.getFortuneList();

        for (int i = 0; i < 8; i++) {
            Dice dice = new Dice(i);
            diceList.add(dice);
        }
    }


    public FortuneCard drawFortuneCard() {
        while (true) {
            int i = RandomUtil.randInt(0, 34);
            FortuneCard fortuneCard = fortuneCardList.get(i);
            if (fortuneCard.getStatus() == 1) {
                return fortuneCard;
            }
        }
    }

    public Map<Integer, Dice.DiceSide> roll() {
        Map<Integer, Dice.DiceSide> map = new HashMap<>();
        for (Dice dice : diceList) {
            Dice.DiceSide diceSide = dice.roll();
            map.put(dice.getIndex(), diceSide);
        }
        return map;
    }


    public boolean reRoll(Player player, List<Integer> indexList) {
        return reRoll(indexList, player.getRollResult());
    }

    public boolean reRoll(List<Integer> indexes, Map<Integer, Dice.DiceSide> rollResult) {
        if (indexes.size() < 2) {
            System.out.println(Constant.RE_ROLL_COUNT_CONSTRAINT);
            return false;
        }
        for (Integer index : indexes) {
            Dice dice = diceList.get(index);
            Dice.DiceSide diceSide = dice.roll();
            rollResult.put(index, diceSide);
        }

        return true;
    }

    public boolean saveOneSkull(Player player) {
        saveOneSkull(player.getRollResult());
        player.setFortuneCardUsed(true);
        return true;
    }

    public boolean saveOneSkull(Map<Integer, Dice.DiceSide> rollResult) {
        Dice oneSkull = getOneSkull(rollResult);
        Dice.DiceSide diceSide = oneSkull.roll();
        while (diceSide == Dice.DiceSide.skull) {
            diceSide = oneSkull.roll();
        }
        rollResult.put(oneSkull.getIndex(), diceSide);
        return true;
    }

    private Dice getOneSkull(Map<Integer, Dice.DiceSide> rollResult) {
        Set<Map.Entry<Integer, Dice.DiceSide>> entries = rollResult.entrySet();
        for (Map.Entry<Integer, Dice.DiceSide> entry : entries) {
            if (entry.getValue() == Dice.DiceSide.skull) {
                Dice dice = diceList.get(entry.getKey());
                return dice;
            }
        }
        return null;
    }

    public void computeScore(Player player) {
        int scoreOrDeduction = computeScore(player.getRollResult(), player.getFortuneCard(), player.isOnIsland(), player.getTreasureChest());
        if (scoreOrDeduction < 0) {
            player.setDeduction(scoreOrDeduction);
            player.setScore(0);
        } else {
            player.setDeduction(0);
            player.setScore(scoreOrDeduction);
        }

    }

    public int computeDeductionOnIsland(Map<Integer, Dice.DiceSide> rollResult, FortuneCard fortuneCard) {
        int skullCount = countSkull(rollResult, fortuneCard);
        return 0 - skullCount * 100;

    }

    public int computeSeaBattle(Map<Integer, Dice.DiceSide> rollResult, FortuneCard fortuneCard, boolean isAlive) {
        if (fortuneCard.getType() == FortuneCard.FortuneCardType.two_sabre) {
            int swordCount = countSword(rollResult);
            if (swordCount >= 2 && isAlive) {
                return 300;
            } else {
                return -300;
            }
        }

        if (fortuneCard.getType() == FortuneCard.FortuneCardType.three_sabre) {
            int swordCount = countSword(rollResult);
            if (swordCount >= 3 && isAlive) {
                return 500;
            } else {
                return -500;
            }
        }

        if (fortuneCard.getType() == FortuneCard.FortuneCardType.four_sabre) {
            int swordCount = countSword(rollResult);
            if (swordCount >= 4 && isAlive) {
                return 1000;
            } else {
                return -1000;
            }
        }
        return 0;
    }

    public int computeScoreOnIsland(Map<Integer, Dice.DiceSide> rollResult, FortuneCard fortuneCard, Map<Integer, Dice.DiceSide> treasureChest) {
        int skullCount = countSkull(rollResult, fortuneCard);

        if (skullCount >= 4) {
            return 0;
        }
        return computeScore(rollResult, fortuneCard, treasureChest, skullCount);
    }

    public int computeScore(Map<Integer, Dice.DiceSide> rollResult, FortuneCard fortuneCard, Map<Integer, Dice.DiceSide> treasureChest, int skullCount) {
        if (skullCount >= 3) {
            System.out.println(Constant.DIE_WITH_SKULL);
            if (fortuneCard.getType() == FortuneCard.FortuneCardType.treasure_chest) {
                rollResult = treasureChest;
            } else {
                return 0;
            }
        }

        int score = 0;

        score += computeSeaBattle(rollResult, fortuneCard, true);

        int[] counts = countOnlyDice(rollResult, fortuneCard);
        score += fullChest(counts, score);

        countWithCard(counts, fortuneCard);
        score += computeBaseScore(counts);

        int countDiamondAndCoin = countDiamondAndCoin(rollResult, fortuneCard);
        score += countDiamondAndCoin * 100;

        if (fortuneCard.getType() == FortuneCard.FortuneCardType.captain) {
            score = score * 2;
        }

        if (score < 0) score = 0;
        return score;
    }

    public int computeScore(Map<Integer, Dice.DiceSide> rollResult, FortuneCard fortuneCard, boolean onIsland, Map<Integer, Dice.DiceSide> treasureChest) {
        int skullCount = countSkull(rollResult, fortuneCard);

        if (onIsland && skullCount >= 4) {
            return computeDeductionOnIsland(rollResult, fortuneCard);
        }

        return computeScore(rollResult, fortuneCard, treasureChest, skullCount);
    }

    private int computeBaseScore(int[] counts) {
        int score = 0;
        for (int count : counts) {
            if (count == 3) {
                score += 100;
            } else if (count == 4) {
                score += 200;
            } else if (count == 5) {
                score += 500;
            } else if (count == 6) {
                score += 1000;
            } else if (count == 7) {
                score += 2000;
            } else if (count >= 8) {
                score += 4000;
            }
        }
        return score;
    }

    private int fullChest(int[] counts, int seaBattleScore) {
        int used = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] >= 3 || Dice.DiceSide.getByIndex(i) == Dice.DiceSide.coin ||
                    Dice.DiceSide.getByIndex(i) == Dice.DiceSide.diamond ||
                    (Dice.DiceSide.getByIndex(i) == Dice.DiceSide.sword && seaBattleScore > 0)) {
                used += counts[i];
            }
        }
        if (used == 8) {
            return 500;
        }
        return 0;
    }

    private int[] countWithCard(int[] counts, FortuneCard fortuneCard) {

        if (fortuneCard.getType() == FortuneCard.FortuneCardType.diamonds) {
            int index = Dice.DiceSide.diamond.getIndex();
            counts[index]++;
        }

        if (fortuneCard.getType() == FortuneCard.FortuneCardType.gold_coin) {
            int index = Dice.DiceSide.coin.getIndex();
            counts[index]++;
        }

        return counts;
    }

    private int[] countOnlyDice(Map<Integer, Dice.DiceSide> rollResult, FortuneCard fortuneCard) {
        int[] counts = new int[6];

        Set<Map.Entry<Integer, Dice.DiceSide>> entries = rollResult.entrySet();
        for (Map.Entry<Integer, Dice.DiceSide> entry : entries) {
            int index = entry.getValue().getIndex();
            counts[index]++;
        }

        if (fortuneCard.getType() == FortuneCard.FortuneCardType.monkey_business) {
            int index = Dice.DiceSide.monkey.getIndex();
            int index1 = Dice.DiceSide.parrot.getIndex();
            counts[index] = counts[index] + counts[index1];
            counts[index1] = 0;
        }
        return counts;
    }

    private int countDiamondAndCoin(Map<Integer, Dice.DiceSide> rollResult, FortuneCard fortuneCard) {
        int count = 0;
        Set<Map.Entry<Integer, Dice.DiceSide>> entries = rollResult.entrySet();
        for (Map.Entry<Integer, Dice.DiceSide> entry : entries) {
            if (entry.getValue() == Dice.DiceSide.diamond || entry.getValue() == Dice.DiceSide.coin) {
                count++;
            }
        }

        if (fortuneCard.getType() == FortuneCard.FortuneCardType.diamonds ||
                fortuneCard.getType() == FortuneCard.FortuneCardType.gold_coin) {
            count++;
        }
        return count;
    }

    private int countSword(Map<Integer, Dice.DiceSide> rollResult) {
        int count = 0;
        Set<Map.Entry<Integer, Dice.DiceSide>> entries = rollResult.entrySet();
        for (Map.Entry<Integer, Dice.DiceSide> entry : entries) {
            if (entry.getValue() == Dice.DiceSide.sword) {
                count++;
            }
        }

        return count;
    }

    public int countSkull(Map<Integer, Dice.DiceSide> diceSideMap, FortuneCard fortuneCard) {
        int count = 0;
        Set<Map.Entry<Integer, Dice.DiceSide>> entries = diceSideMap.entrySet();
        for (Map.Entry<Integer, Dice.DiceSide> entry : entries) {
            if (entry.getValue() == Dice.DiceSide.skull) {
                diceList.get(entry.getKey()).setStatus(0);
                count++;
            }
        }

        if (fortuneCard.getType() == FortuneCard.FortuneCardType.one_skull) {
            count++;
        } else if (fortuneCard.getType() == FortuneCard.FortuneCardType.two_skull) {
            count += 2;
        }

        return count;
    }

    public boolean canContinue(Player player) {
        if (player.isOnIsland()) {
            int count = canContinueOnIsland(player.getRollResult(), player.getFortuneCard(), player.getPreSkullCount());
            if (count > 0) {
                player.setOnIsland(true);
                player.setPreSkullCount(count);
                return true;
            } else {
                return false;
            }
        }
        return canContinue(player.getRollResult(), player.getFortuneCard());
    }

    public boolean canContinue(Map<Integer, Dice.DiceSide> rollResult, FortuneCard fortuneCard) {
        int count = countSkull(rollResult, fortuneCard);
        return count < 3;
    }

    public int canContinueOnIsland(Map<Integer, Dice.DiceSide> rollResult, FortuneCard fortuneCard, int preSkullCount) {
        int count = countSkull(rollResult, fortuneCard);
        if (count > preSkullCount) {
            return count;
        }
        return 0;
    }

    public void checkOnIsland(Player player) {
        int count = countSkull(player.getRollResult(), player.getFortuneCard());
        if (count >= 4) {
            player.setOnIsland(true);
        }
    }

    public boolean canSaveSkull(Player player) {
        if (player.getFortuneCard().getType() == FortuneCard.FortuneCardType.sorceress &&
                !player.isFortuneCardUsed() && !player.isOnIsland()) {
            return true;
        }
        return false;
    }

    public void changeTreasureChest(Player player, List<Integer> inIndexes, List<Integer> outIndexes) {
        this.changeTreasureChest(player.getRollResult(), player.getFortuneCard(), inIndexes, outIndexes, player.getTreasureChest());
    }

    public void changeTreasureChest(Map<Integer, Dice.DiceSide> rollResult, FortuneCard fortuneCard,
                                    List<Integer> inIndexes, List<Integer> outIndexes, Map<Integer, Dice.DiceSide> treasureChest) {
        if (fortuneCard.getType() == FortuneCard.FortuneCardType.treasure_chest) {
            for (int index : inIndexes) {
                Dice.DiceSide diceSide = rollResult.get(index);
                treasureChest.put(index, diceSide);
            }

            for (int index : outIndexes) {
                treasureChest.remove(index);
            }
        }
    }

}
