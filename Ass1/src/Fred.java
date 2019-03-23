
class Fred extends Person {

    private Person florist;

    Fred(String name) {
        super(name);
        florist = new Florist("Robin’s Florist");
    }

    @Override
    void sendFlowers(String flowers) {
        System.out.println(getName() + " forwards order to " + florist.getName());
        florist.sendFlowers(flowers);
    }

    @Override
    void sendBouquet(FlowersBouquet bouquet, Person person) {
    }

    @Override
    void receiveFlowers(String flowers, Person sender) {
    }

    @Override
    void receiveBouquet(FlowersBouquet bouquet, Person sender) {
    }
}