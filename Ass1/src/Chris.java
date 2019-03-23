
class Chris extends Person {

    private Person fred;

    Chris(String name) {
        super(name);
        fred = new Fred("Fred");
    }

    @Override
    void sendFlowers(String flowers) {
        System.out.println(getName() + " orders flowers from " + fred.getName() + ": " + flowers);
        fred.sendFlowers(flowers);
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