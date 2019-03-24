
class Wholesaler extends Person {

    private Grower grower;


    Wholesaler(String name, Grower grower) {
        super(name);
        this.grower = grower;
    }


    FlowersBouquet receiveOrder(String flowers, Person sender) {
        System.out.println(getName() + " forwards request to " + grower.getName());
        FlowersBouquet flowersBouquet = grower.receiveOrder(flowers, this);
        System.out.println(getName() + " returns flowers to " + sender.getName());
        return flowersBouquet;
    }

//    @Override
//    void sendBouquet(FlowersBouquet bouquet, Person person) {
//
//        florist.receiveBouquet(bouquet, this);
//    }
//
//    @Override
//    void receiveFlowers(String flowers, Person sender) {
//        florist = sender;
//        sendFlowers(flowers);
//    }
//
//    @Override
//    void receiveBouquet(FlowersBouquet bouquet, Person sender) {
//        sendBouquet(bouquet, florist);
//    }
}