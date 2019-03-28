package Humans;

import Flowers.FlowersBouquet;

public class DeliveryPerson extends Person {


    public DeliveryPerson(String name) {
        super(name);

    }

    public void sendBouquet(FlowersBouquet bouquet, Person reciever) {
        System.out.println(getName() + " delivers flowers to " + reciever.getName());
        reciever.receiveBouquet(bouquet, this);
    }

}