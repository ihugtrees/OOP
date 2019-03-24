
class Person {

    private String name;
    private Florist florist;

    Person(String name) {
        this.name = name;

    }

    /**
     * @return - persons name
     */
    String getName() {
        return this.name;
    }

    /**
     * @param flowers - flowers to be delivered
     */
    void sendFlowers(String flowers, Person to) {
        System.out.println(getName() + " orders flowers from " + florist.getName() + ": " + flowers);
        florist.sendFlowers(flowers, to);
    }

    /**
     * @param bouquet - the bouquet that has been received.
     */
    void receiveBouquet(FlowersBouquet bouquet, Person sender) {
        System.out.println(getName() + " accepts the flowers: " + bouquet.getFlowers());
    }

    Florist getFlorist() {
        return florist;
    }

    void setFlorist(Florist florist) {
        this.florist = florist;
    }
}