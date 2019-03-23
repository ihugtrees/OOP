
class Gardner extends Person {

    private Person grower;

    Gardner(String name) {
        super(name);
    }

    @Override
    void sendFlowers(String flowers) {
    }

    @Override
    void sendBouquet(FlowersBouquet bouquet, Person person) {
        System.out.println(getName() + " returns flowers to " + grower.getName());
        grower.receiveBouquet(bouquet, this);
    }

    @Override
    void receiveFlowers(String flowers, Person sender) {
        System.out.println(getName() + " prepares flowers");
        grower = sender;
        sendBouquet(new FlowersBouquet(flowers), grower);
    }

    @Override
    void receiveBouquet(FlowersBouquet bouquet, Person sender) {
    }
}