
public class Florist extends Person {

    private Person delivery;
    private Person arranger;
    private Person saler;

    Florist(String name) {
        super(name);
        delivery = new DeliveryPerson("Delivery Person");
        arranger = new Arranger("Flower Arranger");
        saler = new Wholesaler("Wholesaler");
    }

    @Override
    public void sendFlowers(String flowers) {
        System.out.println(getName() + " forwards request to " + saler.getName());
        saler.receiveFlowers(flowers, this);
    }

    @Override
    void sendBouquet(FlowersBouquet bouquet, Person person) {
        if (bouquet.isArranged()) {
            System.out.println(getName() + " forwards flowers to " + delivery.getName());
            delivery.receiveBouquet(bouquet, this);
        } else {
            System.out.println(getName() + " request flowers arrangement from " + arranger.getName());
            arranger.receiveBouquet(bouquet, this);
        }
    }

    @Override
    void receiveFlowers(String flowers, Person sender) {
        sendFlowers(flowers);
    }

    @Override
    void receiveBouquet(FlowersBouquet bouquet, Person sender) {
        sendBouquet(bouquet, arranger);
    }
}