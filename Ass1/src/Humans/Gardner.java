package Humans;

import Flowers.FlowersBouquet;

public class Gardner extends Person {


    public Gardner(String name) {
        super(name);
    }


    public FlowersBouquet processOrder(String flowers, Person sender) {
        System.out.println(getName() + " prepares flowers");
        FlowersBouquet flowersBouquet = new FlowersBouquet(flowers);
        System.out.println(getName() + " returns flowers to " + sender.getName());
        return flowersBouquet;
    }
}