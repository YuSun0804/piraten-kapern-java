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

    public int computeDeductionOnIsland(Map<Integer, Dice.DiceSide> rollResult, FortuneCard fortuneCard) {
        int skullCount = countSkull(rollResult, fortuneCard);
        return 0 - skullCount * 100;
    }

    public int computeScoreOrDeduction(Map<Integer, Dice.DiceSide> rollResult, FortuneCard fortuneCard, boolean onIsland) {
        int skullCount = countSkull(rollResult, fortuneCard);

        if (onIsland && skullCount >= 4) {
            return computeDeductionOnIsland(rollResult, fortuneCard);
        }

        if (skullCount >= 3) {
            System.out.println(Constant.DIE_WITH_SKULL);
            return 0;
        }

        int score = 0;


        int[] counts = countSameSides(rollResult, fortuneCard);
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

        score += fullChest(rollResult);

        int countDiamondAndCoin = countDiamondAndCoin(rollResult, fortuneCard);
        score += countDiamondAndCoin * 100;

        if (fortuneCard.getType() == FortuneCard.FortuneCardType.captain) {
            score = score * 2;
        }

        if (score < 0) score = 0;
        return score;
    }

    private int fullChest(Map<Integer, Dice.DiceSide> rollResult) {
        int[] counts = countOnlyDice(rollResult);
        for (int count : counts) {
            if (count < 3) {
                return 0;
            }
        }
        return 500;
    }

    private int[] countSameSides(Map<Integer, Dice.DiceSide> rollResult, FortuneCard fortuneCard) {
        int[] counts = countOnlyDice(rollResult);

        if (fortuneCard.getType() == FortuneCard.FortuneCardType.monkey_business) {
            int index = Dice.DiceSide.monkey.getIndex();
            int index1 = Dice.DiceSide.parrot.getIndex();
            counts[index] = counts[index] + counts[index1];
            counts[index1] = 0;
        }

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

    private int[] countOnlyDice(Map<Integer, Dice.DiceSide> rollResult) {
        int[] counts = new int[6];

        Set<Map.Entry<Integer, Dice.DiceSide>> entries = rollResult.entrySet();
        for (Map.Entry<Integer, Dice.DiceSide> entry : entries) {
            int index = entry.getValue().getIndex();
            counts[index]++;
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

}
