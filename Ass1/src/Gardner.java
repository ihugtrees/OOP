
class Gardner extends Person {


    Gardner(String name) {
        super(name);
    }


    FlowersBouquet processOrder(String flowers, Person sender) {
        System.out.println(getName() + " prepares flowers");
        FlowersBouquet flowersBouquet = new FlowersBouquet(flowers);
        System.out.println(getName() + " returns flowers to " + sender.getName());
        return flowersBouquet;
    }

//    @Override
//    void sendBouquet(FlowersBouquet bouquet, Person person) {
//
//        grower.receiveBouquet(bouquet, this);
//    }
//
//    @Override
//    void receiveFlowers(String flowers, Person sender) {
//
//        grower = sender;
//        sendBouquet(new FlowersBouquet(flowers), grower);
//    }
//
//    @Override
//    void receiveBouquet(FlowersBouquet bouquet, Person sender) {
//    }
}