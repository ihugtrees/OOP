package Humans;

import Flowers.FlowersBouquet;

public class Grower extends Person {

    private Gardner gardener;


    public Grower(String name, Gardner gardener) {
        super(name);
        this.gardener = gardener;
    }


    public FlowersBouquet receiveOrder(String flowers, Person sender) {
        System.out.println(getName() + " forwards request to " + gardener.getName());
        FlowersBouquet flowersBouquet = gardener.processOrder(flowers, this);
        System.out.println(getName() + " returns flowers to " + sender.getName());
        return flowersBouquet;
    }
}