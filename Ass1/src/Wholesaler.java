
class Wholesaler extends Person {

    private Person grower;
    private Person florist;

    Wholesaler(String name) {
        super(name);
        grower = new Grower("Grower");
    }

    @Override
    void sendFlowers(String flowers) {
        System.out.println(getName() + " forwards request to " + grower.getName());
        grower.receiveFlowers(flowers, this);
    }

    @Override
    void sendBouquet(FlowersBouquet bouquet, Person person) {
        System.out.println(getName() + " returns flowers to " + florist.getName());
        florist.receiveBouquet(bouquet, this);
    }

    @Override
    void receiveFlowers(String flowers, Person sender) {
        florist = sender;
        sendFlowers(flowers);
    }

    @Override
    void receiveBouquet(FlowersBouquet bouquet, Person sender) {
        sendBouquet(bouquet, florist);
    }
}