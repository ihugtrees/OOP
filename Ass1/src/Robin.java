
class Robin extends Person {

    Robin(String name) {
        super(name);
    }

    @Override
    void sendFlowers(String flowers) {
    }

    @Override
    void sendBouquet(FlowersBouquet bouquet, Person person) {
    }

    @Override
    void receiveFlowers(String flowers, Person sender) {
    }

    @Override
    void receiveBouquet(FlowersBouquet bouquet, Person sender) {
        System.out.println(getName() + " accepts the flowers: " + bouquet.getFlowers());
    }
}
