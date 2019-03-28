package Humans;

import Flowers.FlowersBouquet;

public class Wholesaler extends Person {

    private Grower grower;


    public Wholesaler(String name, Grower grower) {
        super(name);
        this.grower = grower;
    }


    public FlowersBouquet receiveOrder(String flowers, Person sender) {
        System.out.println(getName() + " forwards request to " + grower.getName());
        FlowersBouquet flowersBouquet = grower.receiveOrder(flowers, this);
        System.out.println(getName() + " returns flowers to " + sender.getName());
        return flowersBouquet;
    }
}