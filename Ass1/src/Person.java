
public abstract class Person {

    private String name;

    Person(String name) {
        this.name = name;
    }

    /**
     * @return - persons name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param flowers - flowers to be delivered
     */
    abstract void sendFlowers(String flowers);

    /**
     * @param bouquet - bouquet to be delivered
     * @param person  - the person to deliver to
     */
    abstract void sendBouquet(FlowersBouquet bouquet, Person person);

    /**
     * @param flowers - the flowers that has been received.
     */
    abstract void receiveFlowers(String flowers, Person sender);

    /**
     * @param bouquet - the bouquet that has been received.
     */
    abstract void receiveBouquet(FlowersBouquet bouquet, Person sender);
}