package Humans;

import Flowers.*;

public class Arranger extends Person {

    public Arranger(String name) {
        super(name);
    }


    public void sendFlowers(String flowers) {

    }

    FlowersBouquet arrange(FlowersBouquet flowersBouquet, Person sender) {
        System.out.println(getName() + " arranges flowers");
        flowersBouquet.arrangeBouquet();
        System.out.println(getName() + " returns arranged flowers to " + sender.getName());
        return flowersBouquet;

    }
}
