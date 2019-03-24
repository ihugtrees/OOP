
class Grower extends Person {

    private Gardner gardener;


    Grower(String name,Gardner gardener) {
        super(name);
        this.gardener = gardener;
    }


    FlowersBouquet receiveOrder(String flowers,Person sender) {
        System.out.println(getName()+ " forwards request to " + gardener.getName());
        FlowersBouquet flowersBouquet =  gardener.processOrder(flowers,this);
        System.out.println(getName() + " returns flowers to " + sender.getName());
        return flowersBouquet;
    }

//
//    void sendBouquet(FlowersBouquet bouquet, Person person) {
//
//        saler.receiveBouquet(bouquet,this);
//    }
//
//
//    void receiveFlowers(String flowers, Person sender) {
//        saler = sender;
//        sendFlowers(flowers);
//    }
//
//    @Override
//    void receiveBouquet(FlowersBouquet bouquet, Person sender) {
//        sendBouquet(bouquet,saler);
//    }
}