package ca.carleton.comp.game;

import java.util.ArrayList;
import java.util.List;

public class FortuneCard {

    private int index;
    private FortuneCardType type;
    private int status;

    public FortuneCard(int index, FortuneCardType type) {
        this.index = index;
        this.type = type;
        this.status = 1;
    }

    public FortuneCard(FortuneCardType type) {
        this.type = type;
        this.status = 1;
    }

    public int getIndex() {
        return index;
    }

    public static List<FortuneCard> getFortuneList() {
        List<FortuneCard> fortuneCardList = new ArrayList<>(35);

        int fortuneCardIndex = 0;
        for (FortuneCardType fortuneCardType : FortuneCardType.values()) {
            if (fortuneCardType == FortuneCardType.unknown) {
                continue;
            }

            int size = fortuneCardType.getSize();
            for (int i = 0; i < size; i++) {
                fortuneCardList.add(new FortuneCard(fortuneCardIndex++, fortuneCardType));
            }
        }
        return fortuneCardList;
    }

    public FortuneCardType getType() {
        return type;
    }

    public void setType(FortuneCardType type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    /*
        - 4 'gold coin'
        - 4 diamonds
        - 4 sorceress
        - 4 captain
        - 4 treasure chest
        - 4 monkey business (ie parrot-monkey card)
        - 3 1-skull cards
        - 2 2-skull cards
        - 2 2-sabre sea battle cards
        - 2 3-sabre sea battle cards
        - 2 4-sabre sea battle cards
         */
    public enum FortuneCardType {
        gold_coin(1, "gold coin", 4),
        diamonds(2, "diamonds", 4),
        sorceress(3, "sorceress", 4),
        captain(4, "captain", 4),
        treasure_chest(5, "treasure chest", 4),
        monkey_business(6, "monkey business", 4),
        one_skull(7, "1-skull", 3),
        two_skull(8, "2-skull ", 2),
        two_sabre(9, "2-sabre sea battle cards", 2),
        three_sabre(10, "3-sabre sea battle cards", 2),
        four_sabre(11, "4-sabre sea battle cards", 2),
        unknown(12, "unknown", 0);;

        private int index;
        private String type;
        private int size;

        FortuneCardType(int index, String type, int size) {
            this.index = index;
            this.type = type;
            this.size = size;
        }

        public int getSize() {
            return size;
        }

        public String getType() {
            return type;
        }

        public int getIndex() {
            return index;
        }

        public static FortuneCardType getByIndex(int index) {
            for (FortuneCardType fortuneCardType : FortuneCardType.values()) {
                if (fortuneCardType.getIndex() == index) {
                    return fortuneCardType;
                }
            }
            return unknown;
        }
    }


}
