
class Arranger extends Person {

    Arranger(String name) {
        super(name);
    }

    @Override
    void sendFlowers(String flowers) {

    }

    @Override
    void sendBouquet(FlowersBouquet bouquet, Person person) {
        System.out.println(getName() + " returns arranged flowers to " + person.getName());
        person.receiveBouquet(bouquet, this);
    }

    @Override
    void receiveFlowers(String flowers, Person sender) {

    }

    @Override
    void receiveBouquet(FlowersBouquet bouquet, Person sender) {
        System.out.println(getName() + " arranges flowers");
        bouquet.arrangeBouquet();
        sendBouquet(bouquet, sender);
    }
}
