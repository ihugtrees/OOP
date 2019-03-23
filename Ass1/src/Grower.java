
class Grower extends Person {

    private Person gardener;
    private Person saler;

    Grower(String name) {
        super(name);
        gardener = new Gardner("Gardener");
    }

    @Override
    void sendFlowers(String flowers) {
        System.out.println(getName()+ " forwards request to " + gardener.getName());
        gardener.receiveFlowers(flowers,this);
    }

    @Override
    void sendBouquet(FlowersBouquet bouquet, Person person) {
        System.out.println(getName() + " returns flowers to " + saler.getName());
        saler.receiveBouquet(bouquet,this);
    }

    @Override
    void receiveFlowers(String flowers, Person sender) {
        saler = sender;
        sendFlowers(flowers);
    }

    @Override
    void receiveBouquet(FlowersBouquet bouquet, Person sender) {
        sendBouquet(bouquet,saler);
    }
}