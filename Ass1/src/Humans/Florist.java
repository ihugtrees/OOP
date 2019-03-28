package Humans;

import Flowers.FlowersBouquet;

public class Florist extends Person {

    private DeliveryPerson delivery;
    private Arranger arranger;
    private Wholesaler saler;

    public Florist(String name, DeliveryPerson deliveryPerson, Arranger arranger, Wholesaler wholesaler) {
        super(name);
        this.delivery=deliveryPerson;
        this.arranger = arranger;
        this.saler = wholesaler;
    }


    public void sendFlowers(String flowers,Person to) {
        if(to.getFlorist().equals(this)) {
            System.out.println(getName() + " forwards request to " + saler.getName());
            FlowersBouquet flowersBouquet = saler.receiveOrder(flowers,this);
            System.out.println(getName() + " request flowers arrangement from " + arranger.getName());
            flowersBouquet = arranger.arrange(flowersBouquet,this);
            System.out.println(getName() + " forwards flowers to " + delivery.getName());
            delivery.sendBouquet(flowersBouquet, to);
        }
        else{
            System.out.println(this.getName() + " forwards order to "+to.getFlorist().getName());
            to.sendFlowers(flowers,to);
        }
    }
}