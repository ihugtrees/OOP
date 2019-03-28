package Humans;

import Flowers.FlowersBouquet;

public class Person {

    private String name;
    private Florist florist;

    public Person(String name) {
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
    public void sendFlowers(String flowers, Person to) {
        System.out.println(getName() + " orders flowers from " + florist.getName() + ": " + flowers);
        florist.sendFlowers(flowers, to);
    }

    /**
     * @param bouquet - the bouquet that has been received.
     */
    public void receiveBouquet(FlowersBouquet bouquet, Person sender) {
        System.out.println(getName() + " accepts the flowers: " + bouquet.getFlowers());
    }

    public Florist getFlorist() {
        return florist;
    }

    public void setFlorist(Florist florist) {
        this.florist = florist;
    }
}