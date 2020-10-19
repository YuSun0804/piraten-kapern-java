package ca.carleton.comp.game;

import ca.carleton.comp.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class Dice {
    private int index;
    private int status;
    private List<DiceSide> diceSideList;

    public Dice(int index) {
        this.index = index;
        this.status = 1;
        diceSideList = new ArrayList<>();
        diceSideList.add(DiceSide.skull);
        diceSideList.add(DiceSide.monkey);
        diceSideList.add(DiceSide.parrot);
        diceSideList.add(DiceSide.sword);
        diceSideList.add(DiceSide.coin);
        diceSideList.add(DiceSide.diamond);
    }

    public DiceSide roll() {
        int i = RandomUtil.randInt(0, 5);
        return DiceSide.getByIndex(i);
    }


    public List<DiceSide> getDiceSideList() {
        return diceSideList;
    }

    public int getIndex() {
        return index;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public enum DiceSide {

        skull(0, "skull"),
        monkey(1, "monkey"),
        parrot(2, "parrot"),
        sword(3, "sword"),
        coin(4, "coin"),
        diamond(5, "diamond"),
        unknown(6, "unknown");

        private int index;
        private String name;

        DiceSide(int index, String name) {
            this.index = index;
            this.name = name;
        }

        public static DiceSide getByIndex(int index) {
            for (DiceSide diceSide : DiceSide.values()) {
                if (diceSide.index == index) {
                    return diceSide;
                }
            }
            return unknown;
        }

        public static DiceSide getByName(String name) {
            for (DiceSide diceSide : DiceSide.values()) {
                if (diceSide.name.equals(name)) {
                    return diceSide;
                }
            }
            return unknown;
        }

        public int getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "\'" + name + '\'';
        }
    }
}
