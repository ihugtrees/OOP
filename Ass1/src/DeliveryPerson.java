
class DeliveryPerson extends Person {


    DeliveryPerson(String name) {
        super(name);

    }

    void sendBouquet(FlowersBouquet bouquet, Person reciever) {
        System.out.println(getName() + " delivers flowers to " + reciever.getName());
        reciever.receiveBouquet(bouquet, this);
    }

}